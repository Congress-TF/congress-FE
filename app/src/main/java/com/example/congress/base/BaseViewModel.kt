package com.example.congress.base

import androidx.lifecycle.ViewModel
import com.example.congress.data.network.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

open class BaseViewModel: ViewModel() {
    private var _networkError: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val networkError: StateFlow<Boolean>
        get() = _networkError

    fun setNetworkError(value: Boolean) {
        _networkError.value = value
    }

    fun <T : Any> receiveApiResult(result: ApiResult<T>): T? {
        when (result) {
            is ApiResult.Success -> {
                return result.value
            }
            is ApiResult.Failure.HttpError -> {
                setNetworkError(true)
                Timber.e("ApiResult Error : code = ${result.code}, msg = ${result.message}")
            }
            is ApiResult.Failure.Exception -> {
                setNetworkError(true)
                Timber.e("ApiResult Exception : ${result.throwable}")
            }
        }
        return null
    }
}