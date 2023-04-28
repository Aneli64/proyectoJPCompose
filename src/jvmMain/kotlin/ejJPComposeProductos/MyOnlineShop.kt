package ejercicios_Clase.practica.archivos.ejFileProductos
import java.io.File
import kotlin.math.max

/*
Escribir el método main de la clase MyOnlineShop
que cree dos tv una sony y otra Samsung
un MP3Player
y dos Book
introducelos en una lista
compute el total del Regular Price y de Sale Price
mostrando los datos de cada uno y al final los precios totales

En el método main de la clase MyOnlineShop inicializar dos objetos de la clase Camera
 */

/*
Modificar el código escrito hasta ahora para
Agregar el método double computeSpecialCustomerPrice()
Todos y cada uno de los productos debe tenerlo pero su código dependerá del tipo de producto
La lógica de cálculo debe ser como sigue:
Para TV, restar 100 al precio de venta
Para MP3Player, restar 15 al precio de venta
Para Book, restar 2 al precio de venta
PAra cámara restar 205 al precio de venta
En el método main de la clase MyOnlineShop mostrar Special Customer Price para cada artículo de los productos
 */

class MyOnlineShop {
    val listaObjetos = mutableListOf<Produt>()

    var file = File("C:\\Users\\Usuario\\Desktop\\ejemplos\\productosTienda.txt")

    /*fun tienda() {
        val sony = TV(560.0, "LED", 100, 0)
        val samsung = TV(854.0, "OLED", 120, 0)
        val mp3 = MP3Player(89.4, "Ipod", "Rojo",0)
        val libro1 = Book(24.8, "Leonardo", 1789, 0)
        val libro2 = Book(46.9, "Paco", 2008, 0)
        val camera1 = Camera(650.0, "Cine",0)
        val camera2 = Camera(650.0, "Foto",0)
        val listaProdut = listOf(sony, samsung, mp3, libro1, libro2, camera1, camera2)
        for (item in listaProdut) println("$item \n ººComputeSalePrice -> ${item.computeSalePrice()}ºº")
        for (item in listaProdut) println("Special Customer Price -> ${item.computeSpecialCustomerPrice()} \n ${("=".repeat(20))}")

        if (sony.isGreater(samsung)) println("Es mayor") else println("No es mayor")
        if (libro1.isLess(libro2)) println("Es menor") else println("No es menor")
        if (camera1.isEqual(camera2)) println("Es igual") else println("No es igual")
    }*/
    fun inicio() {
        obtenerObjetos(file, listaObjetos)
        println("Que tipo de producto desea ingresar: \n 1|Book \n 2|Camera \n 3|MP3Player \n 4|TV \n 5|Salir")
        var entrada = readln().toInt()
        while (entrada != 5) {
            when (entrada) {
                1 -> crearBook()
                2 -> crearCamera()
                3 -> crearMP3Player()
                4 -> crearTV()
            }
            println("Que tipo de producto desea ingresar: \n 1|Book \n 2|Camera \n 3|MP3Player \n 4|TV \n 5|Salir")
            entrada = readln().toInt()
        }
        addArticulosFile(file, listaObjetos)

        val fileOrd = File("C:\\Users\\Usuario\\Desktop\\ejemplos\\productosOrd.txt")
        //ordenarPor(fileOrd, listaObjetos) sin terminar
    }

    fun obtenerObjetos(archivo: File, listaObj: MutableList<Produt>){
        val lista = mutableListOf<List<String>>()
        archivo.forEachLine { lista.add(it.split(","))} //igual da fallo por esto MIRAR
        for (i in 0 until lista.size){
            for (j in 0 until lista[i].size) {
                when (lista[i][j]) {
                    "Book" -> listaObj.add(Book(lista[i][1].toDouble(), lista[i][2], lista[i][3].toInt(), lista[i][4].toInt()))
                    "Camera" -> listaObj.add(Camera(lista[i][1].toDouble(), lista[i][2], lista[i][3].trim().toInt()))
                    "MP3Player" -> listaObj.add(MP3Player(lista[i][1].toDouble(), lista[i][2],lista[i][3], lista[i][4].toInt()))
                    "TV" -> listaObj.add(TV(lista[i][1].toDouble(), lista[i][2], lista[i][3].toInt(), lista[i][4].trim().toInt()))
                }
            }
        }
    }
    fun mostrarListaProductos() = listaObjetos.toString()
    fun addArticulosFile(archivo: File, listaObj: MutableList<Produt>) {
        var texto = ""
        listaObj.forEach { texto += "$it\n" }
        archivo.writeText(texto)
    }


    fun crearBook() {
        print("Regular Price -> ")
        val regularPrice = readln().toDouble()
        print("publisher -> ")
        val publisher = readln()
        print("yearPublished -> ")
        val yearPublished = readln().toInt()
        print("IVA -> ")
        val IVA = readln().toInt()

        val book = Book(regularPrice, publisher, yearPublished, IVA)
        listaObjetos.add(book)
    }

    fun crearCamera() {
        print("Regular Price -> ")
        val regularPrice = readln().toDouble()
        print("manufacturer -> ")
        val manufacturer = readln()
        print("IVA -> ")
        val IVA = readln().toInt()

        val camera = Camera(regularPrice, manufacturer, IVA)
        listaObjetos.add(camera)
    }

    fun crearMP3Player() {
        print("Regular Price -> ")
        val regularPrice = readln().toDouble()
        print("manufacturer -> ")
        val manufacturer = readln()
        print("color -> ")
        val color = readln()
        print("IVA -> ")
        val IVA = readln().toInt()

        val mp3Player = MP3Player(regularPrice, manufacturer, color, IVA)
        listaObjetos.add(mp3Player)
    }

    fun crearTV() {
        print("Regular Price -> ")
        val regularPrice = readln().toDouble()
        print("manufacturer -> ")
        val manufacturer = readln()
        print("size -> ")
        val size = readln().toInt()
        print("IVA -> ")
        val IVA = readln().toInt()

        val tv = TV(regularPrice, manufacturer, size, IVA)
        listaObjetos.add(tv)
    }
    /*fun ordenarPor(archivo: File, productos: MutableList<Produt>){
        println("Por que campo desea ordenar su documento: \n Numero del campo: ")
        val entrada = readln().toInt()
        var productosOrd = ""
        when(entrada){
            1 -> productosOrd += productos.sortedBy { productos } }
        archivo.writeText(productosOrd)
    }*/

}

fun main() {
    val ej = MyOnlineShop()
    //ej.tienda()
    ej.inicio()
    //println(ej.mostrarListaProductos())


}

