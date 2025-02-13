package com.example.mobil.ui.screen.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mobil.R

//@Composable
//fun CheckEmailScreen(onOkClick: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Icon(
//            imageVector = painterResource(id = R.drawable.email_icon),
//            contentDescription = null,
//            tint = Color(0xFF009EFF),
//            modifier = Modifier.size(80.dp)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = stringResource(R.string.check_email),
//            style = MaterialTheme.typography.,
//            textAlign = TextAlign.Center
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = stringResource(R.string.reset_code_sent),
//            style = MaterialTheme.typography.body1,
//            textAlign = TextAlign.Center,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        CommonButton(buttonLabel = stringResource(R.string.ok)) {
//            onOkClick()
//        }
//    }
//}
