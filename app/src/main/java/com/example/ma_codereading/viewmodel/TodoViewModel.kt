package com.example.ma_codereading.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ma_codereading.data.Todo
import com.example.ma_codereading.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel : ViewModel() {
    private var repository: TodoRepository? = null
    
    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos.asStateFlow()
    
    init {
        loadTodos()
    }
    
    private fun loadTodos() {
        _todos.value = repository!!.getTodos()
    }
}