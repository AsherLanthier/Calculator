package com.example.calculator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

val equation = "1 + 2 + 3 * 2 - 3"
val opperators = arrayOf("+", "-", "*", "/")

@Preview
@Composable
fun test() {
    var opperatorsStack = ArrayDeque<String>()
    var outputStack = ArrayDeque<String>()
    var infix = ""

    for (char in equation){
        var item = char.toString()

        if (item in opperators) {
            if (opperatorsStack.isEmpty()) {
                opperatorsStack.addLast(item)
            }
            else {
                if(findPrecedence(item, opperatorsStack.last())) {
                    opperatorsStack.addLast(item)
                }
                else {
                    infix += opperatorsStack.last()
                    opperatorsStack.removeLast()
                    opperatorsStack.addLast(item)
                }
            }
        }
        else {
            infix += item
        }
    }

    for (opperator in 0 until (opperatorsStack.size)) {
        infix += " " + opperatorsStack.last()
        opperatorsStack.removeLast()
    }

    Text(text = infix, color = Color.White)
}

fun findPrecedence(newOpperator: String, lastOpperator: String): Boolean {
    val opperators = arrayOf(newOpperator, lastOpperator)
    var opperatorsPrecedence = arrayOf(0, 0)

    for (i in 0 until 2) {
        var precedence = 0

        if (opperators[i] == "+" || opperators[i] == "-") {
            precedence = 1
        }

        else if (opperators[i] == "*" || opperators [i] == "/") {
            precedence = 2
        }

        opperatorsPrecedence[i] = precedence
    }

    var isHigherPrecedence: Boolean = false

    if (opperatorsPrecedence[0] > opperatorsPrecedence[1]) {
        isHigherPrecedence = true
    }

    return isHigherPrecedence
}