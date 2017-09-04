package com.planting.online.onlineplanting.Utils

import android.content.Context
import android.content.SharedPreferences.Editor
import android.util.Base64

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.StreamCorruptedException
import kotlin.collections.Map.Entry

/**
 * This class providers some methods to get access to sharedPrefrences
 */
object SharedPreferencesHelper {
    private val MODE = Context.MODE_PRIVATE

    /**
     * Save data to specific name of shared preferences
     *
     * @param context        context to get sharedPreferences
     * @param preferenceName name of sharedpreferences
     * @param data           data to be saved
     * @return whether saved successfully ,return true or false
     */
    fun saveData(context: Context?, preferenceName: String?, data: Map<String, Any>?): Boolean {
        var bCommitted = false
        var oEditor: Editor? = null
        while (true) {
            if (context == null || data == null || data.isEmpty() || preferenceName == null) {
                break // while (true)
            }
            oEditor = context.getSharedPreferences(preferenceName, MODE).edit()
            val keys = data.entries.iterator()
            var key: Entry<String, Any>? = null
            while (keys.hasNext()) {
                key = keys.next()
                val valueObject = data[key.key]
                val objType = validateObjectType(valueObject)
                when (objType) {
                    SharedPreferencesHelper.SimpleObjectTypeEnum.Integer -> oEditor!!.putInt(key.key, data[key.key] as Int)
                    SharedPreferencesHelper.SimpleObjectTypeEnum.Long -> oEditor!!.putLong(key.key, data[key.key] as Long)
                    SharedPreferencesHelper.SimpleObjectTypeEnum.Float -> oEditor!!.putFloat(key.key, data[key.key] as Float)
                    SharedPreferencesHelper.SimpleObjectTypeEnum.Boolean -> oEditor!!.putBoolean(key.key, data[key.key] as Boolean)
                    SharedPreferencesHelper.SimpleObjectTypeEnum.String -> oEditor!!.putString(key.key, data[key.key] as String)
                    SharedPreferencesHelper.SimpleObjectTypeEnum.Object -> oEditor!!.putString(key.key, saveObjectToString(data[key.key] as Any))
                    else -> {
                    }
                }
            }
            bCommitted = oEditor!!.commit()
            break
        }
        return bCommitted
    }

    /**
     * judge an object type
     *
     * @param obj object to be judged
     * @return an object of <class>SimpleObjectTypeEnum</class> class
     */
    private fun validateObjectType(obj: Any?): SimpleObjectTypeEnum {
        var flag = SimpleObjectTypeEnum.UNKNOWN
        if (obj is Int) {
            flag = SimpleObjectTypeEnum.Integer
        } else if (obj is Long) {
            flag = SimpleObjectTypeEnum.Long
        } else if (obj is Float) {
            flag = SimpleObjectTypeEnum.Float
        } else if (obj is Boolean) {
            flag = SimpleObjectTypeEnum.Boolean
        } else if (obj is String) {
            flag = SimpleObjectTypeEnum.String
        } else if (obj is Any) {
            flag = SimpleObjectTypeEnum.Object
        }
        return flag
    }

    fun saveData(context: Context?, preferenceName: String?, key: String?, value: Any?): Boolean {
        var bCommitted = false
        var oEditor: Editor? = null
        if (context != null && preferenceName != null && key != null) {
            val objType = validateObjectType(value)
            oEditor = context?.getSharedPreferences(preferenceName, MODE)?.edit()
            when (objType) {
                SharedPreferencesHelper.SimpleObjectTypeEnum.Integer -> oEditor?.putInt(key, (value as Int?)!!)
                SharedPreferencesHelper.SimpleObjectTypeEnum.Long -> oEditor?.putLong(key, (value as Long?)!!)
                SharedPreferencesHelper.SimpleObjectTypeEnum.Float -> oEditor?.putFloat(key, (value as Float?)!!)
                SharedPreferencesHelper.SimpleObjectTypeEnum.Boolean -> oEditor?.putBoolean(key, (value as Boolean?)!!)
                SharedPreferencesHelper.SimpleObjectTypeEnum.String -> oEditor?.putString(key, value as String?)
                SharedPreferencesHelper.SimpleObjectTypeEnum.Object -> if (value != null)
                    oEditor?.putString(key, saveObjectToString(value))
                else -> if (value != null)
                    oEditor?.putString(key, value.toString())
            }
            bCommitted = oEditor!!.commit()
        }
        return bCommitted
    }

    /**
     * get string value by given key from named shared preferences
     *
     * @param context
     * @param preferenceName
     * @param key            given key
     * @param defValue       default value
     * @return value found
     */
    fun getDataString(context: Context?, preferenceName: String?, key: String,
                      defValue: String?): String? {
        var zRetVal: String? = defValue
        if (context != null && preferenceName != null) {
            zRetVal = context.getSharedPreferences(preferenceName, MODE).getString(key, defValue)
        }
        return zRetVal
    }

    /**
     * get Object value by given key from named shared preferences
     *
     * @param context
     * @param preferenceName
     * @param key            given key
     * @param defValue       default value
     * @return value found
     */
    fun getDataObject(context: Context?, preferenceName: String?, key: String,
                      defValue: Any): Any? {
        var oRetVal: Any? = defValue
        if (context != null && preferenceName != null) {
            oRetVal = getObjectFromString(context.getSharedPreferences(preferenceName, MODE)
                    .getString(key, ""))
        }
        return oRetVal
    }

    /**
     * get boolean value by given key from named shared preferences
     *
     * @param context
     * @param preferenceName
     * @param key            key
     * @param defValue       default value
     * @return value found
     */
    fun getDataBoolean(context: Context?, preferenceName: String?, key: String,
                       defValue: Boolean): Boolean {
        var bRetVal = defValue
        if (context != null && preferenceName != null) {
            bRetVal = context.getSharedPreferences(preferenceName, MODE).getBoolean(key, defValue)
        }
        return bRetVal
    }

    /**
     * get long value by given key from named shared preferences
     *
     * @param context
     * @param preferenceName
     * @param key            key
     * @param defValue       default value
     * @return value found
     */
    fun getDataLong(context: Context?, preferenceName: String?, key: String, defValue: Long): Long {
        var lRetVal = defValue
        if (context != null && preferenceName != null) {
            lRetVal = context.getSharedPreferences(preferenceName, MODE).getLong(key, defValue)
        }

        return lRetVal
    }

    /**
     * get int value by given key from named shared preferences
     *
     * @param context
     * @param preferenceName
     * @param key            key
     * @param defValue       default value
     * @return value found
     */
    fun getDataInt(context: Context?, preferenceName: String?, key: String, defValue: Int): Int {
        var nRetVal = defValue
        if (context != null && preferenceName != null) {
            nRetVal = context.getSharedPreferences(preferenceName, MODE).getInt(key, defValue)
        }
        return nRetVal
    }


    fun getDataMap(context: Context?, preferenceName: String?): Map<String, Any>? {
        var mapRetVal: Map<String, Any>? = null
        if (context != null && preferenceName != null) {
            mapRetVal = context.getSharedPreferences(preferenceName, MODE)
                    .all as Map<String, Any>
        }
        return mapRetVal
    }

    /**
     * delData:del data from assigned preference by preferenceName
     */
    fun delData(context: Context?, preferenceName: String?, key: String): Boolean {
        var bCommitted = false
        var oEditor: Editor? = null
        if (context != null && preferenceName != null) {
            oEditor = context.getSharedPreferences(preferenceName, MODE).edit().remove(key)
        }
        if (oEditor != null) {
            bCommitted = oEditor.commit()
        }
        return bCommitted
    }

    /**
     * delData:del data from assigned preference by preferenceName
     */
    fun clearData(context: Context?, preferenceName: String?): Boolean {
        var bCommitted = false
        var oEditor: Editor? = null
        if (context != null && preferenceName != null) {
            oEditor = context.getSharedPreferences(preferenceName, MODE).edit().clear()
        }
        if (oEditor != null) {
            bCommitted = oEditor.commit()
        }
        return bCommitted
    }

    /**
     * inner class describing object type
     *
     * @version 1.0
     * @createDate Feb 15, 2011
     */
    private enum class SimpleObjectTypeEnum {
        Object, Integer, Long, Float, Boolean, String, UNKNOWN
    }

    private fun saveObjectToString(`object`: Any): String? {
        var zPersonBase64: String? = null
        val baos = ByteArrayOutputStream()
        val oos: ObjectOutputStream
        try {
            oos = ObjectOutputStream(baos)
            oos.writeObject(`object`)
            zPersonBase64 = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT)
            baos.close()
            oos.close()
        } catch (exIO: IOException) {
            exIO.printStackTrace()
        }

        return zPersonBase64
    }

    private fun getObjectFromString(objString: String?): Any? {
        var oRetVal: Any? = null
        while (true) {
            if ("".equals(objString!!, ignoreCase = true)) {
                break // while (true)
            }
            val base64Bytes = Base64.decode(objString.toByteArray(), Base64.DEFAULT)
            val bais = ByteArrayInputStream(base64Bytes)
            var ois: ObjectInputStream? = null
            try {
                ois = ObjectInputStream(bais)
                oRetVal = ois.readObject()
                bais.close()
                ois.close()
            } catch (exSC: StreamCorruptedException) {
                exSC.printStackTrace()
            } catch (exIO: IOException) {
                exIO.printStackTrace()
            } catch (exCNF: ClassNotFoundException) {
                exCNF.printStackTrace()
            }

            break
        }
        return oRetVal
    }
}