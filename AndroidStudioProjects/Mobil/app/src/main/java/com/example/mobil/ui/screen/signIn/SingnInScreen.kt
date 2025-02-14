package com.example.mobil.ui.screen.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mobil.R
import com.example.mobil.ui.theme.MatuleTheme

@Composable
fun SignInScreen() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
            }
        },
        bottomBar = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.sign_up),
                    style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.subTextDark),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable {

                        }
                )
            }
        }
    ) { paddingValues ->
        SignInContent(paddingValues)
    }
}

@Composable
fun SignInContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.hello),
            subTitle = stringResource(R.string.sign_in_subtitle)
        )

        // Поле Email
        val email = remember { mutableStateOf("") }
        AuthTextField(
            labelText = stringResource(R.string.email),
            placeholder = stringResource(R.string.template_email),
            value = email.value,
            onChangeValue = {
                email.value = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }
        AuthTextField(
            labelText = stringResource(R.string.password),
            placeholder = stringResource(R.string.template_password),
            value = password.value,
            onChangeValue = {
                password.value = it
            },
            isPassword = true,
            passwordVisible = passwordVisible
        )

        Text(
            text = stringResource(R.string.restore_password),
            style = MatuleTheme.typography.bodyRegular12.copy(color = MatuleTheme.colors.subTextDark),
            modifier = Modifier
                .padding(end = 20.dp, top = 8.dp)
                .align(Alignment.End)
                .clickable {
                }
        )

        Spacer(modifier = Modifier.height(32.dp))
        CommonButton(
            modifier = Modifier.padding(top = 10.dp),
            buttonLabel = stringResource(R.string.sign_in)
        ) {
        }
    }
}

@Composable
fun TitleWithSubtitleText(title: String, subTitle: String) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = MatuleTheme.typography.headingBold32.copy(color = MatuleTheme.colors.text),
            textAlign = TextAlign.Center
        )
        Text(
            text = subTitle,
            maxLines = 2,
            style = MatuleTheme.typography.subTitleRegular16.copy(color = MatuleTheme.colors.subTextDark),
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    value: String,
    onChangeValue: (String) -> Unit,
    placeholder: String? = null,
    labelText: String? = null,
    isPassword: Boolean = false,
    passwordVisible: MutableState<Boolean> = mutableStateOf(false)
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (labelText != null) {
            Text(
                text = labelText,
                style = MatuleTheme.typography.bodyRegular16.copy(MatuleTheme.colors.text),
                textAlign = TextAlign.Right
            )
        }
        val interaction = remember { MutableInteractionSource() }
        BasicTextField(
            value = value,
            onValueChange = { onChangeValue(it) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(MatuleTheme.colors.background),
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                singleLine = true,
                innerTextField = innerTextField,
                enabled = true,
                visualTransformation = if (isPassword && !passwordVisible.value) PasswordVisualTransformation() else VisualTransformation.None,
                interactionSource = interaction,
                trailingIcon = {
                    if (isPassword) {
                        IconButton(onClick = {
                            passwordVisible.value = !passwordVisible.value
                        }) {
                            val icon = if (passwordVisible.value) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                            Icon(
                                painter = painterResource(icon),
                                contentDescription = null
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MatuleTheme.colors.background,
                    unfocusedContainerColor = MatuleTheme.colors.background,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    if (placeholder != null) {
                        Text(
                            text = placeholder,
                            style = MatuleTheme.typography.bodyRegular14.copy(color = MatuleTheme.colors.hint)
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun CommonButton(modifier: Modifier, buttonLabel: String, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(14.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = MatuleTheme.colors.accent),
        onClick = onClick
    ) {
        Text(
            text = buttonLabel,
            style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.background),
            textAlign = TextAlign.Center
        )
    }
}