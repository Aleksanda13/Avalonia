package com.example.mobil.ui.screen.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobil.R

@Composable
fun ForgotPasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.forgot_password),
            subTitle = stringResource(R.string.reset_password_subtitle)
        )

        Spacer(modifier = Modifier.height(20.dp))

        val email = remember { mutableStateOf("") }

        AuthTextField(
            placeholder = stringResource(R.string.template_email),
            value = email.value,
            onChangeValue = {
                email.value = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        CommonButton(
            modifier = Modifier.padding(top = 50.dp),
            buttonLabel = stringResource(R.string.sign_in),
            onClick = {
                // Логика регистрации
            }
        )
    }
}
