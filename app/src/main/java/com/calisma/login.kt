package com.calisma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.calisma.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var control = ""
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth


        val currentUser = auth.currentUser
        if(currentUser != null){
            startActivity(Intent(this,Main::class.java))
            finish()
        }

        binding.forgotYourPassword.setOnClickListener {
            startActivity(Intent(this,forgot::class.java))
            finish()
        }

        binding.signupBtn.setOnClickListener {
            startActivity(Intent(this,register::class.java))
            finish()
        }
        binding.loginBtn.setOnClickListener {
            var email = binding.emailEditText.text.toString().trim()
            var pass = binding.passwordEdittext.text.toString().trim()
            if (email.isNotEmpty() && pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,pass)
                    .addOnSuccessListener {
                        startActivity(Intent(this,Main::class.java))
                        finish()

                    }.addOnFailureListener { exception ->
                        val message = exception.message.toString()
                        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
                    }
            }else {
                Toast.makeText(this,resources.getString(R.string.firebaseloginmessage1),Toast.LENGTH_SHORT).show()
            }

        }
        binding.loginBackBtn.setOnClickListener {
            control = "exit"
            alertShow("Exit","Are you sure?","Ok","Cancel")
        }
    }
    fun alertShow(title:String,message:String,positive:String,negative:String){
        val alert = AlertDialog.Builder(this)
        alert.setTitle(title)
        alert.setMessage(message)
        alert.setCancelable(false)
        alert.setPositiveButton(positive){_,_->
            if(control == "exit"){
                finishAffinity()
                control = ""
            }

        }
        alert.setNegativeButton(negative){_,_->
            control = ""
        }.show()
    }
}