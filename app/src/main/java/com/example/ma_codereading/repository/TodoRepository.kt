package com.example.ma_codereading.repository

import com.example.ma_codereading.data.ConstantValue
import com.example.ma_codereading.data.Todo

class TodoRepository {
    private val sampleTodos: List<Todo> = ConstantValue.sampleTodos
    
    fun getTodos(): List<Todo> {
        return sampleTodos
    }
}