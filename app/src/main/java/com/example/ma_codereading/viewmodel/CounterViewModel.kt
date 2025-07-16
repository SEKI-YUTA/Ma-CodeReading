package com.example.ma_codereading.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()
    
    fun increment() {
        _count.value += 1
    }
    
    fun decrement() {
        if (_count.value > 0) {
            _count.value -= 1
        }
    }
    
    fun incrementAfterDelay() {
        viewModelScope.launch {
            delay(5000L)
            _count.value += 1
        }
    }
}