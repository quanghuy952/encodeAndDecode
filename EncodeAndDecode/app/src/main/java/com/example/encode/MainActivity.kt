package com.example.encode

import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var encodeButton: Button
    private lateinit var decodeButton: Button
    private lateinit var outputText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        inputText = findViewById(R.id.inputText)
        encodeButton = findViewById(R.id.encodeButton)
        decodeButton = findViewById(R.id.decodeButton)
        outputText = findViewById(R.id.outputText)

        // Set click listeners
        encodeButton.setOnClickListener { encodeText() }
        decodeButton.setOnClickListener { decodeText() }
    }

    private fun encodeText() {
        val inputString = inputText.text.toString()
        val encodedString = Base64.encodeToString(inputString.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT)
        outputText.text = encodedString
    }

    private fun decodeText() {
        val inputString = inputText.text.toString()
        val decodedBytes = Base64.decode(inputString, Base64.DEFAULT)
        val decodedString = decodedBytes.toString(StandardCharsets.UTF_8)
        outputText.text = decodedString
    }
}
