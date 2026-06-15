package com.pdmcourse2026.RankeUca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmcourse2026.RankeUca.ui.theme.BasicTemplateTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      BasicTemplateTheme {
        Navigator()
      }
    }
  }
}