package utilidades;

public class Validador {

    public static boolean texto(String t) {
        return t != null && !t.trim().isEmpty();
    }

    public static boolean positivo(int n) {
        return n > 0;
    }

    public static boolean positivo(double n) {
        return n > 0;
    }
}