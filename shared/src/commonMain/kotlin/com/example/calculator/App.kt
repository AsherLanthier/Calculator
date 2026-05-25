package com.example.calculator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import calculator.shared.generated.resources.Res
import calculator.shared.generated.resources.compose_multiplatform


var words by mutableStateOf("")

@Composable
@Preview
fun App() {
    MaterialTheme {
        main()
        /*
        var numberButtons = arrayOf<NumberButton>()
        for (i in 0 until 5) {
            numberButtons[i] = NumberButton(i)
        }
        */





        Column {
            Text(text = words)

            Row {
                NumberButton(1)
                NumberButton(2)
                NumberButton(3)

            }

            Row {


            }

            Row {

            }
        }
    }
}

@Composable
fun NumberButton(id: Int) {
    Button(
        onClick = {words += id.toString()},
        shape = RoundedCornerShape(0),
        colors = ButtonDefaults.buttonColors(
            Color(0xe3e3e3),
            Color(0x080808))
    ) {
        Text(text = id.toString())
    }
}

