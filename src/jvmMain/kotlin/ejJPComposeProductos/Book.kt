package ejercicios_Clase.practica.archivos.ejFileProductos

/*
Escribir Book.
Book es un Product
Tiene dos atributos, publisher de tipo cadena e yearPublished de tipo entero
Un constructor por parámetros Book(double regularPrice, String Publisher, int yearPublished)
Sale Price El cálculo del precio de venta es el precio regular * 0,5.
 */

class Book(regularPrice: Double, var publisher: String, var yearPublished: Int, IVA: Int) : Produt(regularPrice, IVA){
    override fun computeSalePrice() = regularPrice * 0.5


    //Para Book, restar 2 al precio de venta
    override fun computeSpecialCustomerPrice() = computeSalePrice() - 2.0
    override fun toString(): String {
        return "Book,$regularPrice,$publisher,$yearPublished,$IVA"
    }
}
