package com.rns.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.rns.chat.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    var launcher: ActivityResultLauncher<Intent>? = null
    private lateinit var auth: FirebaseAuth

    private lateinit var EdtName: EditText
    private lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        EdtEmail = binding.edtEmail
        EdtPass = binding.edtPassword
        EdtName = binding.edtName
        btnSignUp = binding.sign

        btnSignUp.setOnClickListener{
            val name = EdtName.text.toString().trim()
            val email = EdtEmail.text.toString().trim()
            val pass = EdtPass.text.toString().trim()

            SignUp(name, email, pass)
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

    }

    private fun SignUp(name:String, email:String, pass:String){

        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    launcher?.launch(Intent(this, MainActivity::class.java))
                } else {
                    Log.d("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "email"+email+" pass"+ pass, Toast.LENGTH_SHORT).show()
                }
            }
    }
}