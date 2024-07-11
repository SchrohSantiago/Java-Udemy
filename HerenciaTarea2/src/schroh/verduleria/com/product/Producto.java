package schroh.verduleria.com.product;

public class Producto {
    private String nombre;
    private Double precio;
    static Producto[] productos = new Producto[8];

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public static Producto[] getProductos() {
        return productos;
    }

    public static void addProducto(Producto... producto){
            int espacioDisponible = 0;
            for (Producto product : productos) {
                if (product == null) {
                    espacioDisponible++;
                }
            }

            if (producto.length > espacioDisponible) {
                throw new IllegalArgumentException("No hay suficiente espacio para agregar todos los productos.");
            }

            int j = 0;
            for (int i = 0; i < productos.length; i++){
                    if(productos[i] == null){
                        productos[i] = producto[j];
                        j++;
                        if(j == producto.length){
                            break;
                        }
                    }


        }
    }

    public static void showProductos(){
        for (Producto producto : productos) {
            if (producto != null) {
                System.out.println(producto);
            }
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Precio: " + getPrecio();
    }
}
