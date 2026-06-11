package examenprimerparcial;

import java.util.Scanner;
import modelos.Producto;
import inventario.GestionProductos;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        GestionProductos gestion = new GestionProductos();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE GESTION DE PRODUCTOS =====\n");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Mostrar estadisticas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: \n");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Codigo: ");
                    String codigo = leer.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = leer.nextLine();

                    System.out.print("Precio: ");
                    double precio = leer.nextDouble();

                    System.out.print("Cantidad: ");
                    int cantidad = leer.nextInt();
                    leer.nextLine();

                    gestion.agregarProducto(
                            new Producto(codigo, nombre,
                                    categoria, precio, cantidad));

                    System.out.println("Producto agregado.");
                    break;

                case 2:
                    gestion.mostrarProductos();
                    break;

                case 3:

                    System.out.print("Codigo a eliminar: ");
                    String eliminar = leer.nextLine();

                    if (gestion.eliminarProducto(eliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Codigo: ");
                    String cod = leer.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = leer.nextLine();

                    System.out.print("Nueva categoria: ");
                    String nuevaCategoria = leer.nextLine();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = leer.nextDouble();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = leer.nextInt();
                    leer.nextLine();

                    if (gestion.actualizarProducto(
                            cod,
                            nuevoNombre,
                            nuevaCategoria,
                            nuevoPrecio,
                            nuevaCantidad)) {

                        System.out.println("Producto actualizado.");

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 5:

                    System.out.println("Total productos: "
                            + gestion.contarProductos());

                    Producto caro = gestion.productoMasCaro();
                    Producto barato = gestion.productoMasBarato();

                    if (caro != null) {
                        System.out.println("Mas caro: "
                                + caro.getNombre());
                    }

                    if (barato != null) {
                        System.out.println("Mas barato: "
                                + barato.getNombre());
                    }

                    System.out.println("Valor inventario: L. "
                            + gestion.valorInventario());

                    break;

                case 6:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);
    }
}