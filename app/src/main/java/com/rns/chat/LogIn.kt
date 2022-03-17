package com.rns.chat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

import com.rns.chat.databinding.ActivityLogInBinding


class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    var launcherSignUp: ActivityResultLauncher<Intent>? = null
    var launcherMainActivity: ActivityResultLauncher<Intent>? = null
    private lateinit var auth: FirebaseAuth

    private lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    private lateinit var btnLogIn: Button
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        EdtEmail = binding.edtEmail
        EdtPass = binding.edtPassword
        btnLogIn = binding.logIn
        btnSignUp = binding.signUp


        launcherSignUp = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }
        launcherMainActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }


        btnSignUp.setOnClickListener{
            launcherSignUp?.launch(Intent(this, SignUp::class.java))
        }

        btnLogIn.setOnClickListener{
            val email = EdtEmail.text.toString();
            val pass = EdtPass.text.toString();
            LogIn(email, pass)
        }
    }

    private fun LogIn(email: String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    launcherMainActivity?.launch(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, "Неавторизовался", Toast.LENGTH_SHORT).show()
                }
            }
    }
}