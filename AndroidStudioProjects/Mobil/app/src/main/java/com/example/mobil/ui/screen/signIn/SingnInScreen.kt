package com.example.mobil.ui.screen.signIn

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobil.R
import com.example.mobil.ui.theme.MatuleTheme
import org.w3c.dom.Text

@Composable
fun SignInScreen() {

    Scaffold(
        topBar = {
            Row (
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .height(40.dp)
            ){
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.back_arrow),
                        contentDescription =  null
                    )
                }
            }
        },
        bottomBar = {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ){
                Text(
                    text = stringResource(R.string.sign_up),
                    style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.text),
                    textAlign = TextAlign.Center
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
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.hello),
            subTitle = stringResource(R.string.sign_in_subtitle)
        )
        val email = remember { mutableStateOf("") }
        AuthTextFiled(
            labelText = stringResource(R.string.email),
            placeholder = stringResource(R.string.template_email),
            value = email.value,
            onChangeValue = {
                email.value = it
            }
        )
        CommonButton(
            modifier = Modifier.padding(top = 50.dp),
            buttonLabel = stringResource(R.string.sign_in)
        ){

        }
    }
}

@Composable
fun TitleWithSubtitleText(title: String, subTitle: String){
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
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
fun AuthTextFiled(value: String, onChangeValue: (String) -> Unit, placeholder: String? = null, labelText: String? = null){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if(labelText != null){
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
                visualTransformation = VisualTransformation.None,
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
fun CommonButton(modifier: Modifier, buttonLabel: String, onClick: ()-> Unit){
    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(MatuleTheme.colors.accent)
        ,
        colors = ButtonColors(
            contentColor = MatuleTheme.colors.accent,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = MatuleTheme.colors.accent,
            containerColor = Color.Transparent
        ),
        onClick = onClick
    ){
        Text(
            text = buttonLabel,
            style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.background),
            textAlign = TextAlign.Center
        )
    }

}