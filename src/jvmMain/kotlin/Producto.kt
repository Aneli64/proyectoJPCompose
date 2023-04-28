class Producto(
    private var tipoProducto: String, private var codigo: String, private var nombre: String,
    private var precio: Double
) {
    override fun toString(): String {
        return "Producto(tipoProducto='$tipoProducto', codigo='$codigo', nombre='$nombre', precio=$precio)"
    }
}