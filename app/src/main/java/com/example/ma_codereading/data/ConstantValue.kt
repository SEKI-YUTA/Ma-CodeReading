package com.example.ma_codereading.data

object ConstantValue {
    val sampleTodos = List(1000) {
        Todo(it, "title${it + 1}", it % 3 == 0)
    }
}