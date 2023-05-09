package com.richardbeletatti.beletatti.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.richardbeletatti.beletatti.R

class MainScreen {
    @Composable
    fun mainScreen(navController: NavController) {

        var showDialog by remember { mutableStateOf(false) }
        var cardTitles by remember { mutableStateOf<List<String>>(emptyList()) }

        Column {
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.blue_800)),
            ) {
                Text(
                    text = stringResource(id = R.string.text_my_list),
                    color = colorResource(id = R.color.white),
                    fontSize = 32.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            // ABRINDO CAIXA DE DIALOGO PARA CRIAR NOVA LISTA
            if (showDialog) {

                var textFieldStateTitle by remember { mutableStateOf(TextFieldValue()) }

                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = {
                        Text("Criando uma nova Lista")
                    },
                    text = {
                        Column {
                            Text(
                                text = "Dê um título para sua Lista",
                                fontSize = 16.sp, fontStyle = FontStyle.Italic,
                            )
                            TextField(
                                value = textFieldStateTitle,
                                onValueChange = { textFieldStateTitle = it },
                                modifier = Modifier.height(48.dp)
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                cardTitles = cardTitles + listOf(textFieldStateTitle.text)
                                showDialog = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.green)
                            ),
                        ) {
                            Text(
                                text = stringResource(id = R.string.create),
                                color = colorResource(id = R.color.white)
                            )
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.red)
                            ),
                        ) {
                            Text(text = "Cancelar", color = colorResource(id = R.color.white))
                        }
                    }
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(cardTitles) { title ->
                    Card(
                        elevation = 16.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .border(
                                BorderStroke(
                                    width = 1.dp,
                                    color = colorResource(id = R.color.black)
                                )
                            )
                    ) {
                        Text(
                            text = title,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 68.dp, end = 24.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = { showDialog = true },
                backgroundColor = colorResource(id = R.color.blue_500),
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Adicionar",
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}