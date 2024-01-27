package com.example.congress.data.network

sealed interface ApiResult<out T> {
    data class Success<T>(val value: T) : ApiResult<T>

    sealed interface Failure : ApiResult<Nothing> {
        data class HttpError(val code: Int, val message: String, val body: String) : Failure
        data class Exception(val throwable: Throwable) : Failure

        fun safeThrowable(): Throwable = when (this) {
            is HttpError -> IllegalStateException("$message $body")
            is Exception -> throwable
        }
    }

    fun isSuccess(): Boolean = this is Success
    fun isFailure(): Boolean = this is Failure

    fun getOrThrow(): T {
        throwOnFailure()
        return (this as Success).value
    }

    fun failureOrThrow(): Failure {
        throwOnSuccess()
        return this as Failure
    }

    fun exceptionOrNull(): Throwable? =
        when (this) {
            is Failure -> safeThrowable()
            else -> null
        }
}


internal fun ApiResult<*>.throwOnFailure() {
    if (this is ApiResult.Failure) throw safeThrowable()
}

internal fun ApiResult<*>.throwOnSuccess() {
    if (this is ApiResult.Success) throw IllegalStateException()
}
