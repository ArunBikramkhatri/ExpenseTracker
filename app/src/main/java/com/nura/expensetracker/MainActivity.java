package com.nura.expensetracker;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}






//
//
//package com.example.googleauthentication
//
//import android.content.Context
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.ImageButton
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.compose.ui.platform.LocalContext
//import androidx.credentials.CredentialManager
//import androidx.credentials.CustomCredential
//import androidx.credentials.GetCredentialRequest
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.lifecycleScope
//import androidx.lifecycle.viewModelScope
//import com.google.android.libraries.identity.googleid.GetGoogleIdOption
//import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
//import com.google.firebase.auth.AuthResult
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.GoogleAuthCredential
//import com.google.firebase.auth.GoogleAuthProvider
//import kotlinx.coroutines.channels.awaitClose
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.callbackFlow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.tasks.await
//import kotlin.math.log
//
//class GoogleSignInTest() : ViewModel(){
//
//    val TAG = "GoogleSignInTest"
//    val WEB_CLIENT_ID = "673827147983-vcp25vhqfr8b469ekuhmgooetv3596p3.apps.googleusercontent.com"
//
////    lateinit var signInButton: ImageButton
////    override fun onCreate(savedInstanceState: Bundle?) {
////        try {
////            super.onCreate(savedInstanceState)
////            Log.d(TAG, "onCreate: Google SignInTest")
////            setContentView(R.layout.activity_main)
////
////            signInButton = findViewById(R.id.signIn)
////
////            signInButton.setOnClickListener {
////                handleGoogleSignIn(this)
////            }
////        } catch (e: Exception) {
////            Log.e(TAG, "onCreate: " + e.localizedMessage, e)
////        }
////
////    }
//
//    fun handleGoogleSignIn(context: Context) {
//        viewModelScope.launch {
//
//            signIn(context).collect { result ->
//                    result.fold(
//                            onSuccess = { authResult: AuthResult ->
//                    val currentUser = authResult.user
//                Log.d(TAG, "handleGoogleSignIn: " + currentUser.toString())
//                if (currentUser != null) {
//                    Log.d(TAG, "handleGoogleSignIn: success")
//                    Log.d(TAG, "handleGoogleSignIn: " + currentUser.email)
//                    Log.d(TAG, "handleGoogleSignIn: " + currentUser.uid)
//                    Log.d(TAG, "handleGoogleSignIn: " + currentUser.displayName)
//                    Log.d(TAG, "handleGoogleSignIn: " + currentUser.phoneNumber)
//                    Toast.makeText(context , "Success Sign in" , Toast.LENGTH_SHORT)
//                }else {
//                    Toast.makeText(context , "Success Sign in" , Toast.LENGTH_SHORT)
//                }
//                    },
//                onFailure = {
//                        Log.d(TAG, "handleGoogleSignIn: failure")
//                        Toast.makeText(context , "Sign in failed" , Toast.LENGTH_SHORT)
//                }
//                )
//            }
//        }
//    }
//
//    suspend fun signIn(context: Context): Flow<Result<AuthResult>> {
//
//        val firebaseAuth = FirebaseAuth.getInstance()
//        Log.d(TAG, "signIn: ")
//        return callbackFlow {
//            try {
//                Log.d(TAG, "signIn: 1")
//                val credentialManager = CredentialManager.create(context)
//                val googleIdOptions: GetGoogleIdOption = GetGoogleIdOption.Builder()
//                        .setFilterByAuthorizedAccounts(false)
//                        .setServerClientId(WEB_CLIENT_ID)
//                        .setAutoSelectEnabled(true)
//                        .build()
//
//                val request: GetCredentialRequest = GetCredentialRequest.Builder()
//                        .addCredentialOption(googleIdOptions)
//                        .build()
//
//                val result = credentialManager.getCredential(context, request)
//                val credential = result.credential
//
//
//                if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
//                    val googleIdTokenCredential =
//                            GoogleIdTokenCredential.createFrom(credential.data)
//
//                    val authCredential =
//                            GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)
//
//                    val authResult = firebaseAuth.signInWithCredential(authCredential).await()
//                    Log.d(TAG, "signIn: 2")
//                    trySend(Result.success(authResult))
//                } else {
//                    Log.e(TAG, "handleGoogleSignIn: ")
//                }
//            } catch (e: Exception) {
//                Log.e(TAG, "handleGoogleSignIn: " + e.localizedMessage, e)
//            }
//            awaitClose { }
//        }
//    }
//}
