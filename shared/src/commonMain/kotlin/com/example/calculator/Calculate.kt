package com.example.calculator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

//val equation = "1 + 2 * 7"
val opperators = arrayOf("+", "-", "*", "/")

fun calculate(equation: String) : String {
    val postfix = infixToPostfix(equation)
    val items = postfix.split("\\s+".toRegex())
    var values = ArrayDeque<Int>()

    for (item in items) {
        if (item in opperators) {
            var answer = 0

            var num2 = values.last()
            values.removeLast()

            var num1 = values.last()
            values.removeLast()

            if (item == "+") {
                answer = num1 + num2
            }
            else if (item == "-") {
                answer = num1 - num2
            }
            else if (item == "*") {
                answer = num1 * num2
            }
            else if (item == "/") {
                answer = num1 / num2
            }

            values.addLast(answer)
        }

        else {
            values.addLast(item.toInt())
        }
    }
    
    val finalValue = values.last().toString()

    return finalValue
}

fun infixToPostfix(equation: String) : String {
    var opperatorsStack = ArrayDeque<String>()
    var postfix = ""

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
                    postfix += "  " + opperatorsStack.last()
                    opperatorsStack.removeLast()
                    opperatorsStack.addLast(item)
                }
            }
        }
        else {
            postfix += item
        }
    }

    for (opperator in 0 until (opperatorsStack.size)) {
        postfix += "  " + opperatorsStack.last()
        opperatorsStack.removeLast()
    }

    return postfix
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

    var isHigherPrecedence = false

    if (opperatorsPrecedence[0] > opperatorsPrecedence[1]) {
        isHigherPrecedence = true
    }

    return isHigherPrecedence
}