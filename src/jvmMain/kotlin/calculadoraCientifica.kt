import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun App2() {
    var valor1 by remember { mutableStateOf(("")) }
    Column {
        OutlinedTextField(
            value = valor1,
            onValueChange = { valor1 = it }
        )
        Row {
            Button(onClick = {
                valor1 += "0"
            }) {
                Text("0")
            }
            Button(onClick = {
                valor1 += "1"
            }) {
                Text("1")
            }
            Button(onClick = { valor1 += "2" }) {
                Text("2")
            }
            Button(onClick = { valor1 += "3" }) {
                Text("3")
            }
        }

        Row {
            Button(onClick = { valor1 += "4" }) {
                Text("4")
            }
            Button(onClick = { valor1 += "5" }) {
                Text("5")
            }
            Button(onClick = { valor1 += "6" }) {
                Text("6")
            }
        }

        Row {
            Button(onClick = { valor1 += "7" }) {
                Text("7")
            }
            Button(onClick = { valor1 += "8" }) {
                Text("8")
            }
            Button(onClick = { valor1 += "9" }) {
                Text("9")
            }
        }

        Row {
            Button(onClick = {
                valor1 += "+"
            }) {
                Text("+")
            }
            Button(onClick = {
                valor1 += "-"
            }) {
                Text("-")
            }
            Button(onClick = {
                valor1 += "x"
            }) {
                Text("x")
            }
            Button(onClick = {
                valor1 += "/"
            }) {
                Text("/")
            }
            Button(onClick = {
                val resultado = valor1.split("+","-","x","/")
                val operadores = "+-*/"
                var numeros = 0
                for (item in resultado){
                    if (item !in operadores){
                        //numeros + item
                    }
                }
            }) {
                Text("=")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App2()
    }
}