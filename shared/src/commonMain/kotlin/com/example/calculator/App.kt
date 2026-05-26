package com.example.calculator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import calculator.shared.generated.resources.Res
import calculator.shared.generated.resources.compose_multiplatform


var equation by mutableStateOf("")

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column (verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = equation,
                modifier = Modifier
                    .weight(2f)
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(15.dp),
                fontSize = 50.sp,
                )

            Row (modifier = Modifier.weight(1f).fillMaxWidth()) {
                NumberButton(1)
                NumberButton(2)
                NumberButton(3)
                FunctionButton("+")
            }

            Row (modifier = Modifier.weight(1f).fillMaxWidth()) {
                NumberButton(3)
                NumberButton(4)
                NumberButton(5)
                FunctionButton("-")
            }

            Row (modifier = Modifier.weight(1f).fillMaxWidth()) {
                NumberButton(7)
                NumberButton(8)
                NumberButton(9)
                FunctionButton("*")
            }

            Row (modifier = Modifier.weight(1f).fillMaxWidth()) {
                ClearButton()
                NumberButton(0)
                EqualsButton()
                FunctionButton("/")
            }
        }
    }
}

@Composable
fun RowScope.NumberButton(id: Int) {
    Button(
        onClick = {equation += id.toString()},
        shape = RoundedCornerShape(0),
        modifier = Modifier.fillMaxHeight().weight(1f),
        colors = ButtonDefaults.buttonColors(
            Color(0xFFCCCCCC),
            Color.Black)
    ) {
        Text(text = id.toString(),
            fontSize = 50.sp)
    }
}

@Composable
fun RowScope.FunctionButton(functionType: String) {
    Button(
        onClick = {equation += " " + functionType + " "},
        shape = RoundedCornerShape(0),
        modifier = Modifier.fillMaxHeight().weight(1f),
        colors = ButtonDefaults.buttonColors(
            Color(0xFFA3A3A3),
            Color.Black)
    ) {
        Text(text = functionType,
            fontSize = 50.sp)
    }
}

@Composable
fun RowScope.EqualsButton() {
    Button(
        onClick = {equation = calculate(equation)},
        shape = RoundedCornerShape(0),
        modifier = Modifier.fillMaxHeight().weight(1f),
        colors = ButtonDefaults.buttonColors(
            Color(0xFFA3A3A3),
            Color.Black)
    ) {
        Text(text = "=",
            fontSize = 50.sp)
    }
}

@Composable
fun RowScope.ClearButton() {
    Button(
        onClick = {equation = ""},
        shape = RoundedCornerShape(0),
        modifier = Modifier.fillMaxHeight().weight(1f),
        colors = ButtonDefaults.buttonColors(
            Color(0xFFA3A3A3),
            Color.Black)
    ) {
        Text(text = "C",
            fontSize = 50.sp)
    }
}

