package com.example.kisalogistics

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnRegister: Button
    lateinit var tvLogin: TextView
    lateinit var progress: ProgressDialog
    lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtEmail = findViewById(R.id.edtemail)
        edtPassword = findViewById(R.id.edtpassword)
        btnRegister = findViewById(R.id.btnregister)
        tvLogin = findViewById(R.id.tvlogin)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        btnRegister.setOnClickListener {
            var email = edtEmail.text.toString().trim()
            var password = edtPassword.text.toString().trim()

            if (email.isEmpty()){
                edtEmail.setError("Please fill this input")
                edtEmail.requestFocus()}
            else if (password.isEmpty()){
                edtPassword.setError("Please fill in this input")
                edtPassword.requestFocus()}
            else if(password.length < 6){
                edtPassword.setError("Password is too short")
                edtPassword.requestFocus()
            }else{
                //proceed to register user
                progress.show()
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful){
                        Toast.makeText(this, "Registration successful",Toast.LENGTH_SHORT).show()
                        mAuth.signOut()
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    }else{
                        displayMessage("ERROR", it.exception!!.message.toString())
                    }
                }
            }

        }
        tvLogin.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()

        }
    }

    fun displayMessage(title:String, message:String){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok",null)
        alertDialog.create().show()
    }
}