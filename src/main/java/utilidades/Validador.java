package utilidades;

public class Validador {

    // Evita textos vacíos
    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    // Número positivo (precio o cantidad)
    public static boolean numeroPositivo(double valor) {
        return valor > 0;
    }

    // Entero positivo (cantidad)
    public static boolean enteroPositivo(int valor) {
        return valor > 0;
    }
}