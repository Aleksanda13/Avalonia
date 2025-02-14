package com.example.mobil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mobil.ui.screen.signIn.ForgotPasswordScreen
import com.example.mobil.ui.screen.signIn.SignInScreen
import com.example.mobil.ui.screen.signIn.SignUpScreen
import com.example.mobil.ui.theme.MatuleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme{
                ForgotPasswordScreen()
            }
        }
    }
}

