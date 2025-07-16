package com.example.ma_codereading.data

data class Todo(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)