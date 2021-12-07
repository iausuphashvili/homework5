package com.example.iaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

private lateinit var email: EditText
private lateinit var pass: EditText
private lateinit var pass2: EditText
private lateinit var goButton : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        erti()
        gagzavna()


    }

    private fun erti() {
        email=findViewById(R.id.emailenter)
        pass=findViewById(R.id.passenter1)
        pass2=findViewById(R.id.passenter2)
        goButton=findViewById(R.id.bat1)

    }

    private fun gagzavna() {

        goButton.setOnClickListener {

            val email = email.text.toString()
            val pass = pass.text.toString()
            val pass1 = pass2.text.toString()


            if (email.isEmpty())
            {
                Toast.makeText(this, "Enter your E-mail", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (pass.isEmpty() || pass1.isEmpty()
                || pass1 != pass ||pass.length <9 || !pass.contains("[0-9]".toRegex()) || !pass.contains("[a-z]".toRegex()))
            {
                Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "You have been Registered", Toast.LENGTH_LONG).show()

                    }
                    else
                        Toast.makeText(this, "Please check E-mail", Toast.LENGTH_SHORT).show()

                }




        }

    }}
