package com.rns.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.rns.chat.databinding.ActivityLogInBinding


class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    var launcher: ActivityResultLauncher<Intent>? = null
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }
        binding.signUp.setOnClickListener{
            Log.d("MyLog", "Страница регистрации")
            launcher?.launch(Intent(this, SignUp::class.java))
        }

        // Write a message to the database
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
    }
}