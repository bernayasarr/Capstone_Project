package com.calisma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.calisma.databinding.ActivityForgotBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class forgot : AppCompatActivity() {
    lateinit var binding: ActivityForgotBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.loginBackBtn.setOnClickListener {
            startActivity(Intent(this,login::class.java))
            finish()
        }

        binding.forgotSend.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            if(email.isNotEmpty()){
                auth.sendPasswordResetEmail(email)
                    .addOnSuccessListener {
                        Toast.makeText(this,resources.getString(R.string.firebaseforgotmessage1),Toast.LENGTH_SHORT).show()

                    }.addOnFailureListener {exception ->
                        val message = exception.message.toString()
                        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
                    }
            }else{
                Toast.makeText(this,resources.getString(R.string.firebaseforgotmessage2), Toast.LENGTH_SHORT).show()
            }
        }
    }
}