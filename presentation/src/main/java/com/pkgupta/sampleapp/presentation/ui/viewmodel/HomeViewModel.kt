package com.pkgupta.sampleapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pkgupta.sampleapp.domain.usecases.GetUsers
import com.pkgupta.sampleapp.presentation.ui.base.UIState
import com.pkgupta.sampleapp.presentation.ui.mapper.toUserUiModel
import com.pkgupta.sampleapp.presentation.ui.models.UserUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUsers: GetUsers
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<List<UserUiModel>>>(UIState.Initial)
    val uiState: StateFlow<UIState<List<UserUiModel>>> = _uiState

    fun loadUsers() {
        viewModelScope.launch {
            _uiState.value = UIState.Loading
            try {
                getUsers().collect { users ->
                    _uiState.value = UIState.Success(users.map { it.toUserUiModel() })
                }
            } catch (e: Exception) {
                _uiState.value = UIState.Error(e.message ?: "Failed to load users")
            }
        }
    }
}
