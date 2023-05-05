package com.richardbeletatti.beletatti.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.richardbeletatti.beletatti.R

class LoginScreen {
    @Composable
    fun loginScreen(navController: NavController) {
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
                    navController.navigate("mainScreen")
                },
                modifier = Modifier
                    .padding(8.dp)
                    .width(200.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                content = {
                    Text(
                        text = stringResource(R.string.go).toUpperCase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            )
            Spacer(Modifier.height(24.dp))

            Text(
                text = "Faça login com: ",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp),
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Google Icon",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Google",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            )
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp),
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "Facebook Icon",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Facebook",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            )
        }
    }
}