package ejercicios_Clase.practica.archivos.ejFileProductos

import javax.print.attribute.standard.PrinterMoreInfoManufacturer

/*
Escribir MP3Player.
MP3Player es un Electronics
Tiene un atributo color de tipo cadena
Un constructor por parámetros MP3Player (double regularPrice, String manufacturer, String color)
Sale Price El cálculo del precio de venta es el precio regular * 0,9.
 */

class MP3Player(regularPrice: Double, manufacturer: String, var color: String, IVA: Int): Electronics(regularPrice, manufacturer, IVA){
    override fun computeSalePrice() = regularPrice * 0.9

    //Para MP3Player, restar 15 al precio de venta
    override fun computeSpecialCustomerPrice() = computeSalePrice() - 15.0
    override fun toString(): String {
        return "MP3Player,$regularPrice,$manufacturer,$color,$IVA"
    }
}