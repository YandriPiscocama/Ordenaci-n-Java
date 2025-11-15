package ed.u2.sorting;

/**
 * Clase de utilidades para los algoritmos de ordenación.
 */
public class SortingUtils {

    /**
     * Crea una copia de un arreglo de enteros.
     */
    public static int[] copiarArreglo(int[] arreglo) {
        if (arreglo == null) {
            return null;
        }
        int[] copia = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
        return copia;
    }

    /**
     * Convierte un arreglo a String con formato [a, b, c].
     */
    public static String arregloATexto(int[] arreglo) {
        if (arreglo == null) {
            return "null";
        }
        if (arreglo.length == 0) {
            return "[]";
        }

        String resultado = "[";
        for (int i = 0; i < arreglo.length; i++) {
            resultado += arreglo[i];
            if (i < arreglo.length - 1) {
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }

    /**
     * Verifica que el arreglo esté ordenado correctamente.
     */
    public static boolean estaOrdenado(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return true;
        }
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i - 1] > arreglo[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Imprime un arreglo en consola.
     */
    public static void imprimirArreglo(int[] arreglo) {
        System.out.println(arregloATexto(arreglo));
    }
}