package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val ref = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.login_email)
        val password = findViewById<EditText>(R.id.login_password)
        val registerButton = findViewById<Button>(R.id.register_button)


        registerButton.setOnClickListener {
            ref.createUserWithEmailAndPassword(
                    email.text.toString().trim(),
                    password.text.toString().trim()
            )
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}