package com.example.mobil.ui.screen.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobil.R

@Composable
fun ForgotPasswordScreen() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Логика возврата назад */ }) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Top,
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                buttonLabel = stringResource(R.string.send),
                onClick = {
                }
            )
        }
    }
}