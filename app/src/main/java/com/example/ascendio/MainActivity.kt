package com.example.ascendio

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.example.ascendio.navigation.NavGraph
import com.example.ascendio.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            AppTheme {
                NavGraph(navHostController = navHostController)
            }
        }
    }
}