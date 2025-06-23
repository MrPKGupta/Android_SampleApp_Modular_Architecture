package com.pkgupta.sampleapp.presentation.ui.base

/**
 * Represents the different states of a UI.
 *
 * @param T The type of data associated with the [Success] state.
 */
sealed class UIState<out T> {
    data object Initial : UIState<Nothing>()
    data object Loading : UIState<Nothing>()
    data class Success<T>(val data: T) : UIState<T>()
    data class Error(val message: String) : UIState<Nothing>()


    fun <T> success(data: T) = Success(data)
    fun error(message: String) = Error(message)
}
