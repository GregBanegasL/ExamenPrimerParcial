package inventario;

import java.util.ArrayList;
import modelos.Producto;

public class GestionProductos {

    private ArrayList<Producto> productos;

    public GestionProductos() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public boolean eliminarProducto(String codigo) {

        for (Producto p : productos) {

            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                productos.remove(p);
                return true;
            }
        }

        return false;
    }

    public boolean actualizarProducto(String codigo,
            String nombre,
            String categoria,
            double precio,
            int cantidad) {

        for (Producto p : productos) {

            if (p.getCodigo().equalsIgnoreCase(codigo)) {

                p.setNombre(nombre);
                p.setCategoria(categoria);
                p.setPrecio(precio);
                p.setCantidad(cantidad);

                return true;
            }
        }

        return false;
    }

    public void mostrarProductos() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto p : productos) {

            System.out.println("-------------------------");
            System.out.println("Código:  " + p.getCodigo());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Categoría: " + p.getCategoria());
            System.out.println("Precio: L. " + p.getPrecio());
            System.out.println("Cantidad: " + p.getCantidad());
        }
    }

    public int contarProductos() {
        return productos.size();
    }

    public double valorInventario() {

        double total = 0;

        for (Producto p : productos) {
            total += p.getPrecio() * p.getCantidad();
        }

        return total;
    }

    public Producto productoMasCaro() {

        if (productos.isEmpty()) {
            return null;
        }

        Producto caro = productos.get(0);

        for (Producto p : productos) {

            if (p.getPrecio() > caro.getPrecio()) {
                caro = p;
            }
        }

        return caro;
    }

    public Producto productoMasBarato() {

        if (productos.isEmpty()) {
            return null;
        }

        Producto barato = productos.get(0);

        for (Producto p : productos) {

            if (p.getPrecio() < barato.getPrecio()) {
                barato = p;
            }
        }

        return barato;
    }
}