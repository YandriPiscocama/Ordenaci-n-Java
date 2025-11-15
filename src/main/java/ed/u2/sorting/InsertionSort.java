package ed.u2.sorting;

/**
 * Implementación del algoritmo de ordenación por Inserción (Insertion Sort).
 *
 * Características:
 * - Estable: mantiene el orden relativo de elementos iguales
 * - In-place: ordena el arreglo sin crear uno nuevo
 * - Complejidad: O(n²) en peor caso, O(n) en mejor caso (arreglo ordenado)
 */
public class InsertionSort {

    /**
     * Ordena el arreglo usando Insertion Sort.
     * Modifica el arreglo original (in-place).
     */
    public static void sort(int[] a) {
        // Validar casos especiales
        if (a == null || a.length < 2) {
            return;
        }

        int n = a.length;

        // Comenzar desde el segundo elemento
        for (int i = 1; i < n; i++) {
            int key = a[i];  // Elemento a insertar
            int j = i - 1;

            // Desplazar elementos mayores que key hacia la derecha
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            // Insertar key en su posición correcta
            a[j + 1] = key;
        }
    }

    /**
     * Ordena el arreglo usando Insertion Sort con traza de ejecución.
     * Imprime cada paso del algoritmo en consola.
     */
    public static void sort(int[] a, boolean trace) {
        if (!trace) {
            sort(a);  // Si no se pide traza, llamar al método simple
            return;
        }

        if (a == null || a.length < 2) {
            System.out.println("Arreglo vacío o de un solo elemento, no requiere ordenación.");
            return;
        }

        System.out.println("=== Insertion Sort - Traza de Ejecución ===");
        System.out.println("Arreglo inicial: " + SortingUtils.arregloATexto(a));
        System.out.println();

        int n = a.length;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            System.out.println("Iteración " + i + ": Insertando elemento " + key);
            System.out.println("  Estado antes: " + SortingUtils.arregloATexto(a));

            // Contar cuántos desplazamientos se hacen
            int desplazamientos = 0;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                desplazamientos++;
                j--;
            }

            a[j + 1] = key;

            System.out.println("  Desplazamientos: " + desplazamientos);
            System.out.println("  Estado después: " + SortingUtils.arregloATexto(a));
            System.out.println();
        }

        System.out.println("Arreglo ordenado final: " + SortingUtils.arregloATexto(a));
        System.out.println("===========================================\n");
    }
}