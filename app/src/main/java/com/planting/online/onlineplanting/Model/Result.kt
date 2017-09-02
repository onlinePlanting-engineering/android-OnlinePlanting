package com.planting.online.onlineplanting.Model

/**
 * Created by eleven on 2017/8/30.
 */
open class Result<T> {
    open var code: Int = SUCCESS
    open var data: T? = null

     companion object {
        val SUCCESS = 0
        val FAILED = 1
    }
}