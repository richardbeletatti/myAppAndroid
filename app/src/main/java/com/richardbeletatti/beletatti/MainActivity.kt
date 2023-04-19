package com.richardbeletatti.beletatti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richardbeletatti.beletatti.ui.theme.BeletattiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeletattiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loginScreen()
                }
            }
        }
    }
}

@Composable
fun loginScreen() {
    var textFieldStateEmail by remember { mutableStateOf(TextFieldValue()) }
    var textFieldStatePassword by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name).toUpperCase(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(50.dp, 10.dp)
        )
        TextField(
            value = textFieldStateEmail,
            onValueChange = { textFieldStateEmail = it },
            label = { Text(text = stringResource(R.string.email)) }
        )

        Spacer(Modifier.height(24.dp))

        TextField(
            value = textFieldStatePassword,
            onValueChange = { textFieldStatePassword = it },
            label = { Text(text = stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(8.dp)
                .width(200.dp)
                .height(48.dp),
            content = {
                Text(
                    text = stringResource(R.string.go).toUpperCase(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        )
    }
}

@Composable
fun mainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TELA PRINCIPAL =)")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BeletattiTheme {
        loginScreen()
    }
}