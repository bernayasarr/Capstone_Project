package com.calisma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.calisma.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.loginBackBtn.setOnClickListener {
            startActivity(Intent(this,login::class.java))
            finish()
        }
        binding.forgotYourPassword.setOnClickListener {
            startActivity(Intent(this,forgot::class.java))
            finish()
        }
        binding.signupBtn.setOnClickListener {
            var name = binding.nameEditText.text.toString().trim()
            var email = binding.emailEditText.text.toString().trim()
            var pass = binding.passwordEdittext.text.toString().trim()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email, pass)
                    .addOnSuccessListener {
                        Toast.makeText(this,resources.getString(R.string.firebaseregistermessage1),Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,Main::class.java))
                        finish()
                    }.addOnFailureListener {exception ->
                        val message = exception.message.toString()
                        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

                    }
            }else {
                Toast.makeText(this,resources.getString(R.string.firebaseregistermessage2),Toast.LENGTH_SHORT).show()
            }
        }
    }
}