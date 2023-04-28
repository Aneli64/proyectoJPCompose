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
fun App() {
    var valorAnterior by remember { mutableStateOf(("")) }
    var valorActual by remember { mutableStateOf(("")) }
    var operacion by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(
            value = valorActual,
            onValueChange = { valorActual = it }
        )
        Row {
            Button(onClick = {
                valorActual += "0"
            }) {
                Text("0")
            }
            Button(onClick = {
                valorActual += "1"
            }) {
                Text("1")
            }
            Button(onClick = { valorActual += "2" }) {
                Text("2")
            }
            Button(onClick = { valorActual += "3" }) {
                Text("3")
            }
        }

        Row {
            Button(onClick = { valorActual += "4" }) {
                Text("4")
            }
            Button(onClick = { valorActual += "5" }) {
                Text("5")
            }
            Button(onClick = { valorActual += "6" }) {
                Text("6")
            }
        }

        Row {
            Button(onClick = { valorActual += "7" }) {
                Text("7")
            }
            Button(onClick = { valorActual += "8" }) {
                Text("8")
            }
            Button(onClick = { valorActual += "9" }) {
                Text("9")
            }
        }

        Row {
            Button(onClick = {
                valorAnterior = valorActual
                valorActual = ""
                operacion = "+"
            }) {
                Text("+")
            }
            Button(onClick = {
                valorAnterior = valorActual
                valorActual = ""
                operacion = "-"
            }) {
                Text("-")
            }
            Button(onClick = {
                valorAnterior = valorActual
                valorActual = ""
                operacion = "x"
            }) {
                Text("x")
            }
            Button(onClick = {
                valorAnterior = valorActual
                valorActual = ""
                operacion = "/"
            }) {
                Text("/")
            }
            Button(onClick = {
                when (operacion) {
                    "+" -> valorActual = (valorAnterior.toInt() + valorActual.toInt()).toString()
                    "-" -> valorActual = (valorAnterior.toInt() - valorActual.toInt()).toString()
                    "x" -> valorActual = (valorAnterior.toInt() * valorActual.toInt()).toString()
                    "/" -> valorActual = (valorAnterior.toInt() / valorActual.toInt()).toString()
                }
            }) {
                Text("=")
            }
        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}