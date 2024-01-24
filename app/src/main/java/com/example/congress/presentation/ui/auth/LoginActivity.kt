package com.example.congress.presentation.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.congress.R
import com.example.congress.databinding.ActivityLoginBinding
import com.example.congress.presentation.util.FirebaseAuth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val firebase = FirebaseAuth()
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var getResult: ActivityResultLauncher<Intent>

    companion object {
        const val TAG = "googleLogin"
    }

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    firebase.firebaseAuthWithGoogle(account!!.idToken!!)
                    Log.d("token","${task.result.idToken}")
                    Log.e("other","${task.result.email}")
                    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()

                    CoroutineScope(Dispatchers.IO).launch {
                        setResult(Activity.RESULT_OK,intent)
                        finish()
                    }
                } catch (e: ApiException) {
                    Toast.makeText(this,"api error",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"else",Toast.LENGTH_SHORT).show()
            }
        }
        binding.tvSignWithGoogle.setOnClickListener { googleLogin() }
        binding.ivSignWithGoogle.setOnClickListener { Log.e(TAG,"${firebase.auth!!.currentUser!!.uid}") }
    }

    private fun googleLogin() {
        setGoogleLogin()
        val signInIntent = googleSignInClient.signInIntent
        getResult.launch(signInIntent)
    }

    private fun setGoogleLogin() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

}
