package com.planting.online.onlineplanting.Entity

/**
 * Created by eleven on 2017/9/1.
 */
class DataServiceResponse<T> {

    interface Listener<T> {
        fun onResponse(response: T)
    }

    interface  ErrorListener {
        fun onErrorResponse(error: Exception)
    }
}