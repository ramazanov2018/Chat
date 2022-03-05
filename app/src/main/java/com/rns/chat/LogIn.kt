package com.rns.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    var launcher: ActivityResultLauncher<Intent>? = null
    private lateinit var auth: FirebaseAuth

    private lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    private lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        EdtEmail = binding.edtEmail
        EdtPass = binding.edtPassword
        btnLogIn = binding.logIn


        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }


        binding.signUp.setOnClickListener{

            /*auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }*/


            Toast.makeText(this, "Страница регистрации", Toast.LENGTH_SHORT).show()
            Log.d("MyLog", "Страница регистрации")
            launcher?.launch(Intent(this, SignUp::class.java))
        }

        // Write a message to the database
        // Write a message to the database
        /*val database = Firebase.database
        val myRef = database.getReference("  ")

        myRef.setValue("Hello, World!")*/
    }
}