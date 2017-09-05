package com.planting.online.onlineplanting.Entity

import com.planting.online.onlineplanting.App.PlantingApplication
import com.planting.online.onlineplanting.Constant.PlantingConstant
import com.planting.online.onlineplanting.Networking.PlantingRetrofitManager
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.planting.online.onlineplanting.Utils.LogUtils
import com.planting.online.onlineplanting.Utils.SharedPreferencesHelper
import org.json.JSONException
import com.google.gson.Gson
import com.planting.online.onlineplanting.Dao.*

/**
 * Created by eleven on 2017/9/1.
 */
class PlantingDataService {

    companion object {
        private var mDaoSession: DaoSession? = null
        private var mUser: User? = null

        fun getInstance(): PlantingDataService {
            return Holder.INSTANCE
        }

        fun getUser(): User? {
            return mUser
        }
    }

    init {
        val helper = DaoMaster.DevOpenHelper(PlantingApplication.getInstance().getContext(), "planting-data-db", null)
        val db = helper.getWritableDatabase()
        val daoMaster = DaoMaster(db)
        mDaoSession = daoMaster.newSession()
    }

    private object Holder {
        val INSTANCE = PlantingDataService()
    }

    // DB operation
    private fun insertOrReplace(user: User?): User? {
        if (user == null) {
            return null
        }

        val u = mDaoSession?.getUserDao()?.queryBuilder()
                ?.where(UserDao.Properties.Id.eq(user.id))
                ?.build()?.unique()
        if (u != null) {
            user.id = u?.getId()
        }

        mDaoSession?.getUserDao()?.insertOrReplace(user)
        val newUser = mDaoSession?.getUserDao()?.queryBuilder()
                ?.where(UserDao.Properties.Id.eq(user.id))
                ?.build()?.unique()
        mUser = newUser
        return newUser
    }

    private fun insertOrReplace(farm: Farm?): Farm? {
        if (farm == null) {
            return null
        }

        val f = mDaoSession?.getFarmDao()?.queryBuilder()
                ?.where(FarmDao.Properties.Id.eq(farm.id))
                ?.build()?.unique()
        if (f != null) {
            farm.id = f?.getId()
        }

        mDaoSession?.getFarmDao()?.insertOrReplace(farm)
        return mDaoSession?.getFarmDao()?.queryBuilder()
                ?.where(FarmDao.Properties.Id.eq(farm.id))
                ?.build()?.unique()
    }

    private fun insertOrReplace(comment: Comment?): Comment? {
        if (comment == null) {
            return null
        }

        val comm = mDaoSession?.getCommentDao()?.queryBuilder()
                ?.where(CommentDao.Properties.Id.eq(comment.id))
                ?.build()?.unique()
        if (comm != null) {
            comment.id = comm?.getId()
        }

        mDaoSession?.getCommentDao()?.insertOrReplace(comment)
        return mDaoSession?.getCommentDao()?.queryBuilder()
                ?.where(CommentDao.Properties.Id.eq(comment.id))
                ?.build()?.unique()
    }

    private fun insertOrReplace(imageGroup: ImageGroup?): ImageGroup? {
        if (imageGroup == null) {
            return null
        }

        val i = mDaoSession?.getImageGroupDao()?.queryBuilder()
                ?.where(ImageGroupDao.Properties.Id.eq(imageGroup.id))
                ?.build()?.unique()
        if (i != null) {
            imageGroup.id = i?.getId()
        }

        mDaoSession?.getImageGroupDao()?.insertOrReplace(imageGroup)
        return mDaoSession?.getImageGroupDao()?.queryBuilder()
                ?.where(ImageGroupDao.Properties.Id.eq(imageGroup.id))
                ?.build()?.unique()
    }

    fun registerUser(username: String, password: String, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().registerUser(username, password, object: Callback<ResponseBody> {

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                TODO("not implemented")
            }
        })
    }

    fun loginUser(username: String, password: String, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().loginUser(username, password, object : Callback<ResponseBody>{

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    var token = json.getString("token")
                    LogUtils.d("DataService",token)
                    SharedPreferencesHelper.saveData(PlantingApplication.getInstance().getContext(),PlantingConstant.VANTAGE_PREFERENCE,PlantingConstant.TOKEN,token)
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }
        })
    }

    fun getUserProfile(listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().getUserProfile(object : Callback<ResponseBody>{

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val gson = Gson()
                    val json = JSONObject(response?.body()?.string())
                    val data = json.getJSONObject("data")
                    var user = gson.fromJson(data.toString(),User::class.java)
                    insertOrReplace(user)
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }
        })
    }

    fun getFarmList(listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().getFarmList(object : Callback<ResponseBody>{

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    val farmArray = json.getJSONArray("data")
                    for (i in 0..(farmArray.length() - 1)) {
                        val farm = farmArray.getJSONObject(i)
                        var farmEntity = Gson().fromJson(farm.toString(),Farm::class.java)
                        insertOrReplace(farmEntity)
                    }
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }
        })
    }

    fun getComments(type: String, id: Long, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().getComments(type, id, object : Callback<ResponseBody>{

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    val commentsArray = json.getJSONArray("data")
                    for (i in 0..(commentsArray.length() - 1)) {
                        val comment = commentsArray.getJSONObject(i)
                        var commentEntity = Gson().fromJson(comment.toString(),Comment::class.java)
                        insertOrReplace(commentEntity)
                    }
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }
        })
    }

    fun getParentComments(id: Long, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().getParentComments(id, object : Callback<ResponseBody>{

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    val replyComments = json.getJSONObject("data")
                    var commentEntity = Gson().fromJson(replyComments.toString(),Comment::class.java)
                    insertOrReplace(commentEntity)
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }
        })
    }

    fun createComment(type: String, id: Long, parent_id: Long?, content: String, grade: String, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().createComment(type, id, parent_id, content, grade, object : Callback<ResponseBody>{

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    if (parent_id == null) {
                        getComments(type, id, object : DataServiceResponse.Listener<Boolean> {

                            override fun onResponse(response: Boolean) {
                                listener.onResponse(true)
                            }
                        }, object : DataServiceResponse.ErrorListener{

                            override fun onErrorResponse(error: Exception) {
                                errorListener.onErrorResponse(error)
                            }
                        })
                    } else {
                        getParentComments(parent_id,object : DataServiceResponse.Listener<Boolean> {

                            override fun onResponse(response: Boolean) {
                                listener.onResponse(true)
                            }
                        }, object : DataServiceResponse.ErrorListener{

                            override fun onErrorResponse(error: Exception) {
                                errorListener.onErrorResponse(error)
                            }
                        })
                    }
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }
        })
    }

    fun getImagesByGroup(id: Long, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().getImagesByGroup(id, object : Callback<ResponseBody>{

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    var imageGroupEntity = Gson().fromJson(json.toString(),ImageGroup::class.java)
                    insertOrReplace(imageGroupEntity)
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }
        })
    }

    fun getLandsInforById(id: Long, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().getLandsInforById(id, object : Callback<ResponseBody>{

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                try {
                    val json = JSONObject(response?.body()?.string())
                    val landData = json.getJSONObject("data")
                    var landEntity = Gson().fromJson(landData.toString(),Land::class.java)
                    //var entity = insertOrReplace(imageGroupEntity)
                    listener.onResponse(true)
                }catch (e: JSONException) {
                    errorListener.onErrorResponse(e)
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }
        })
    }
}
