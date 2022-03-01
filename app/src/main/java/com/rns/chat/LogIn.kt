package com.rns.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.rns.chat.databinding.ActivityLogInBinding

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    var launcher: ActivityResultLauncher<Intent>? = null

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
    }
}