package ejercicios_Clase.practica.archivos.ejFileProductos

/*
Escribir Electronics.
Electronics es un Product y no provee la implementación del método abstracto computerSalePrice()
Tiene un atributo manufacturer de tipo cadena
Un constructor por parámetros Electronics(double regularPrice, String manufacturer)
 */

abstract class Electronics(regularPrice: Double, var manufacturer: String, IVA: Int): Produt(regularPrice, IVA)
{
}