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
fun App3() {
    var tipoProducto by remember { mutableStateOf(("")) }
    var codigo by remember { mutableStateOf(("")) }
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    val listaProductos = mutableListOf<Producto>()

    Column {
        TextField(value = tipoProducto,
            onValueChange = { tipoProducto = it },
            label = { Text(text = "Tipo Producto") }
        )

        TextField(value = codigo,
            onValueChange = { codigo = it },
            label = { Text(text = "Codigo") }
        )

        TextField(value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre") }
        )

        TextField(value = precio,
            onValueChange = { precio = it },
            label = { Text(text = "Precio") }
        )

        Row {
            Button(onClick = {
                val prod = Producto(tipoProducto, codigo, nombre, precio.toDouble())
                listaProductos.add(prod)

                tipoProducto = ""
                codigo = ""
                nombre = ""
                precio = ""

                println(listaProductos.toList())
            }) {
                Text("Add Product")
            }

            Button(onClick = {
                println(listaProductos.toList())
            }) {
                Text("Mostrar productos")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App3()
    }
}