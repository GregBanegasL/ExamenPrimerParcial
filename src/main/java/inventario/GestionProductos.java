package inventario;

import java.util.ArrayList;
import modelos.Producto;

public class GestionProductos {

    private ArrayList<Producto> productos;

    public GestionProductos() {
        productos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto producto) {

        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(producto.getCodigo())) {
                return false; // ya existe
            }
        }

        productos.add(producto);
        return true;
    }

    public boolean eliminarProducto(String codigo) {

        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                productos.remove(i);
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

            System.out.println("=============================================\n");
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Categoria: " + p.getCategoria());
            System.out.println("Precio: " + p.getPrecio()+" LPS");
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