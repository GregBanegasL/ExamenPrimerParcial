package examenprimerparcial;

import java.util.Scanner;
import modelos.Producto;
import inventario.GestionProductos;
import utilidades.Validador;

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
            System.out.print("Seleccione una opcion: ");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Codigo: ");
                    String codigo = leer.nextLine();
                    if (!Validador.texto(codigo)) {
                        System.out.println("Codigo invalido");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();
                    if (!Validador.texto(nombre)) {
                        System.out.println("Nombre invalido");
                        break;
                    }

                    System.out.print("Categoria: ");
                    String categoria = leer.nextLine();
                    if (!Validador.texto(categoria)) {
                        System.out.println("Categoria invalida");
                        break;
                    }

                    System.out.print("Precio: ");
                    double precio = leer.nextDouble();
                    if (!Validador.positivo(precio)) {
                        System.out.println("Precio invalido");
                        break;
                    }

                    System.out.print("Cantidad: ");
                    int cantidad = leer.nextInt();
                    if (!Validador.positivo(cantidad)) {
                        System.out.println("Cantidad invalida");
                        break;
                    }

                    leer.nextLine();

                    gestion.agregarProducto(
                            new Producto(codigo, nombre, categoria, precio, cantidad));

                    System.out.println("Producto agregado.");
                    break;

                case 2:
                    gestion.mostrarProductos();
                    break;

                case 3:

                    System.out.print("Codigo a eliminar: ");
                    String eliminar = leer.nextLine();

                    if (!Validador.texto(eliminar)) {
                        System.out.println("Codigo invalido");
                        break;
                    }

                    if (gestion.eliminarProducto(eliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Codigo: ");
                    String cod = leer.nextLine();
                    if (!Validador.texto(cod)) {
                        System.out.println("Codigo invalido");
                        break;
                    }

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = leer.nextLine();
                    if (!Validador.texto(nuevoNombre)) {
                        System.out.println("Nombre invalido");
                        break;
                    }

                    System.out.print("Nueva categoria: ");
                    String nuevaCategoria = leer.nextLine();
                    if (!Validador.texto(nuevaCategoria)) {
                        System.out.println("Categoria invalida");
                        break;
                    }

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = leer.nextDouble();
                    if (!Validador.positivo(nuevoPrecio)) {
                        System.out.println("Precio invalido");
                        break;
                    }

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = leer.nextInt();
                    if (!Validador.positivo(nuevaCantidad)) {
                        System.out.println("Cantidad invalida");
                        break;
                    }

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

                    System.out.println("Total productos: " + gestion.contarProductos());

                    Producto caro = gestion.productoMasCaro();
                    Producto barato = gestion.productoMasBarato();

                    if (caro != null) {
                        System.out.println("Mas caro: " + caro.getNombre());
                    }

                    if (barato != null) {
                        System.out.println("Mas barato: " + barato.getNombre());
                    }

                    System.out.println("Valor inventario: L. " + gestion.valorInventario());

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