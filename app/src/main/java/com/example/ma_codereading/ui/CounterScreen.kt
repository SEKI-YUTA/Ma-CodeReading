package com.example.ma_codereading.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ma_codereading.viewmodel.CounterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterScreen(
    viewModel: CounterViewModel = viewModel()
) {
    val count by viewModel.count.collectAsState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter: $count",
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Button(
                onClick = { viewModel.decrement() }
            ) {
                Text("-")
            }
            
            Button(
                onClick = { viewModel.increment() }
            ) {
                Text("+")
            }
        }
        
        Button(
            onClick = { viewModel.incrementAfterDelay() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Increment in 5 seconds")
        }
    }
}