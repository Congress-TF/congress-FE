package com.example.congress.presentation.util

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseAuth{
    var auth: FirebaseAuth? = FirebaseAuth.getInstance()


    fun firebaseAuthWithGoogle(idToken: String){
        val credential = GoogleAuthProvider.getCredential(idToken,null)
        auth?.signInWithCredential(credential)?.addOnCompleteListener {
            if (it.isSuccessful){
                val user = auth!!.currentUser
            }
            else{
           Log.e("firebase","login failed")
            }
        }

    }

    fun logout(){
        Firebase.auth.signOut()

    }


}