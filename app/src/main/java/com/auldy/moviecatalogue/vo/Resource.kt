package com.auldy.moviecatalogue.vo

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
data class Resource<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)

        fun <T> error(msg: String?, data: T?): Resource<T> = Resource(Status.ERROR, data, msg)

        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
    }
}