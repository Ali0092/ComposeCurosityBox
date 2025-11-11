package com.example.lesson_responsiveness.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lesson_responsiveness.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CuriosityBoxViewModel: ViewModel() {

    private var _checkListItem: MutableStateFlow<Todo> = MutableStateFlow(Todo())
    val checkListItem: StateFlow<Todo> = _checkListItem.asStateFlow()

    fun setValueToUnChecked() {
        _checkListItem.update { it.copy(isChecked = !it.isChecked) }
    }

}