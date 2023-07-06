package com.example.kisalogistics

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException

class OurtrucksActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var progress: ProgressDialog
    val PICK_IMAGE_REQUEST = 100
    lateinit var filepath: Uri
    lateinit var firebaseStore: FirebaseStorage
    lateinit var storageReference: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ourtrucks)
        imageView = findViewById(R.id.imgphoto2)
        progress = ProgressDialog(this)
        progress.setTitle("Uploading")
        progress.setMessage("Please wait...")

        firebaseStore = FirebaseStorage.getInstance()
        storageReference = firebaseStore.getReference()
        var mAuth = FirebaseAuth.getInstance()
        imageView.setOnClickListener {
            startActivity(Intent(applicationContext, ViewtrucksActivity::class.java))
        }
    }
}