package com.example.ma_codereading.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ma_codereading.data.Profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var profile by rememberSaveable {
        mutableStateOf(Profile(name = "山田太郎", age = 25))
    }
    
    var editingName by rememberSaveable { mutableStateOf(profile.name) }
    var editingAge by rememberSaveable { mutableStateOf(profile.age.toString()) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "プロフィール",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "現在のプロフィール",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(text = "名前: ${profile.name}")
                Text(text = "年齢: ${profile.age}歳")
            }
        }
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "プロフィール編集",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                
                OutlinedTextField(
                    value = editingName,
                    onValueChange = { editingName = it },
                    label = { Text("名前") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                OutlinedTextField(
                    value = editingAge,
                    onValueChange = { editingAge = it },
                    label = { Text("年齢") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                
                Button(
                    onClick = {
                        val age = editingAge.toIntOrNull()
                        if (age != null && age > 0 && editingName.isNotBlank()) {
                            profile = Profile(name = editingName, age = age)
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("プロフィールを更新")
                }
            }
        }
    }
}