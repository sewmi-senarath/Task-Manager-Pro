package com.example.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge layout if applicable
        enableEdgeToEdge()

        // Set the content view to the layout file
        setContentView(R.layout.activity_alarm)

        // Find the main layout by its ID
        val mainView = findViewById<View>(R.id.main)

        // Ensure the main view is not null before applying window insets listener
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        } else {
            // Log an error message if the main view is not found
            Log.e("AlarmActivity", "View with ID 'main' was not found!")
        }
    }
}
