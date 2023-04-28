package ejercicios_Clase.practica.archivos.ejFileProductos


/*
añade a cada producto un atributo de tipo IVA, el IVA deberá ser valído para ello en
el set comprobaremos que esté en una lista de llamada  tramosIVA que está en companion object  0,4,10,21
 */

/*
añade a cada producto el número de producto que será un número que comience por 1 y se incremente cada vez que se cree un producto
Añade una función que devuelve el valor del último objeto
 */

abstract class Produt() : RelationInterface {
    companion object {
        val tiposIVA = listOf<Int>(0, 4, 10, 21)
        private var numeroProducto: Int = 1
        fun mostrarCod() = numeroProducto
    }

    var regularPrice: Double = 0.0
    var IVA: Int = 0
        set(value) {
            if (value in tiposIVA) field = value else println("IVA incorrecto")
        }

    constructor(regularInitialPrice: Double, IVA: Int) : this() {
        regularPrice = regularInitialPrice
        this.IVA = IVA
        numeroProducto++
    }

    override fun isGreater(a: Any): Boolean {
        a as Produt
        return a.regularPrice < this.regularPrice
    }
    override fun isLess(a: Any): Boolean {
        a as Produt
        return a.regularPrice > this.regularPrice
    }

    override fun isEqual(a: Any): Boolean {
        a as Produt
        return a.regularPrice == this.regularPrice
    }

    abstract fun computeSalePrice(): Double
    abstract fun computeSpecialCustomerPrice(): Double
}
