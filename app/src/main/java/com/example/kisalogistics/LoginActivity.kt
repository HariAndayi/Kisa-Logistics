@file:Suppress("DEPRECATION")

package com.example.kisalogistics

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    lateinit var tvRegister: TextView
    lateinit var tvReset: TextView
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtEmail = findViewById(R.id.edt2email)
        edtPassword = findViewById(R.id.edt2password)
        btnLogin = findViewById(R.id.btnlogin2)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        btnLogin.setOnClickListener {
            var email = edtEmail.text.toString().trim()
            var password = edtPassword.text.toString().trim()
            if (email.isEmpty()) {
                edtEmail.setError("Please fill this input")
                edtEmail.requestFocus()
            } else if (password.isEmpty()){
                edtPassword.setError("Please fill in this input")
                edtPassword.requestFocus()
            } else {
                progress.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        mAuth.signOut()
                        startActivity(Intent(this,HomeActivity::class.java))
                        finish()
                    }

                }
            }
        }

    }
}