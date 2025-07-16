package com.example.ma_codereading.repository

import com.example.ma_codereading.data.Todo

class TodoRepository {
    private val sampleTodos = listOf(
        Todo(1, "Complete Android project"),
        Todo(2, "Review Kotlin code"),
        Todo(3, "Test the application", true),
        Todo(4, "Write documentation")
    )
    
    fun getTodos(): List<Todo> {
        return sampleTodos
    }
}