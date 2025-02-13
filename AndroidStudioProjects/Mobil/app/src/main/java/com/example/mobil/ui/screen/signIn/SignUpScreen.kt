package com.example.mobil.ui.screen.signIn

import com.example.mobil.ui.screen.signIn.AuthTextField
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.mobil.R
import com.example.mobil.ui.theme.MatuleTheme

@Composable
fun SignUpScreen() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                IconButton(onClick = {
                    // Вернуться на экран входа
                }) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
            }
        },
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(
                    text = "Уже есть аккаунт?",
                    style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.text),
                )
                Text(
                    text = " Войти",
                    style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.accent),
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable {
                        }
                )
            }
        }
    ) { paddingValues ->
        SignUpContent(paddingValues)
    }
}

@Composable
fun SignUpContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.registration),
            subTitle = stringResource(R.string.sign_up_subtitle)
        )

        val name = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val isChecked = remember { mutableStateOf(false) }

        AuthTextField(
            labelText = stringResource(R.string.name),
            placeholder = stringResource(R.string.template_name),
            value = name.value,
            onChangeValue = {
                name.value = it
            }
        )

        AuthTextField(
            labelText = stringResource(R.string.email),
            placeholder = stringResource(R.string.template_email),
            value = email.value,
            onChangeValue = {
                email.value = it
            }
        )

        AuthTextField(
            labelText = stringResource(R.string.password),
            placeholder = stringResource(R.string.template_password),
            value = password.value,
            onChangeValue = {
                password.value = it
            }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable {
                    isChecked.value = !isChecked.value
                }
        ) {
            Icon(
                painter = if (isChecked.value) {
                    painterResource(R.drawable.ic_checked)
                } else {
                    painterResource(R.drawable.ic_checked)
                },
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(10.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Даю согласие на обработку\nперсональных данных",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        // Кнопка регистрации
        CommonButton(
            modifier = Modifier.padding(top = 50.dp),
            buttonLabel = "Зарегистрироваться",
            onClick = {
                // Логика регистрации
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthPasswordField(
    value: String,
    onChangeValue: (String) -> Unit,
    placeholder: String? = null,
    labelText: String? = null,
    passwordVisible: MutableState<Boolean>
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
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                singleLine = true,
                innerTextField = innerTextField,
                enabled = true,
                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                interactionSource = interaction,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MatuleTheme.colors.background,
                    unfocusedContainerColor = MatuleTheme.colors.background,
                    disabledContainerColor = MatuleTheme.colors.background,
                    errorContainerColor = MatuleTheme.colors.background,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible.value = !passwordVisible.value
                    }) {
                        Icon(
                            painter = painterResource(
                                if (passwordVisible.value) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                            ),
                            contentDescription = null
                        )
                    }
                },
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

