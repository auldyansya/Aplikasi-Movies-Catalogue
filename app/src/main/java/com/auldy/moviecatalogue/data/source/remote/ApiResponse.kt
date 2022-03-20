package com.auldy.moviecatalogue.data.source.remote

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class ApiResponse<T>(
    val status: StatusResponse,
    val body: T,
    val message: String?)
{

    companion object {

        fun <T> success(body: T): ApiResponse<T> =
            ApiResponse(
                StatusResponse.SUCCESS,
                body,
                null
            )

        fun <T> error(msg: String, body: T): ApiResponse<T> =
            ApiResponse(
                StatusResponse.ERROR,
                body,
                msg
            )
    }
}