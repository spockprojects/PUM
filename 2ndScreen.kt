package com.example.degreemanagment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
fun SecondScreen(navController: NavHostController) {

    val context = LocalContext.current
    var subjectText by remember { mutableStateOf("") }
    var degreeText by remember { mutableStateOf("") }

    // MAIN
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = "Add New",
            fontSize = 26.sp
        )
        // TEXT FIELDS
        TextField(
            modifier = Modifier
                .padding(10.dp)
                .padding(top = 80.dp),
            value = subjectText,
            onValueChange = { newText -> subjectText = newText },
            placeholder = { Text("subject") }
        )
        TextField(
            modifier = Modifier
                .padding(10.dp),
            value = degreeText,
            onValueChange = { newText -> degreeText = newText },
            placeholder = { Text("degree") }
        )

    }
    // BUTTON
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                saveDataToFile(context, subjectText, degreeText)
                navController.navigate("mainScreen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Add Degree",
                fontSize = 20.sp
            )
        }
    }
}
