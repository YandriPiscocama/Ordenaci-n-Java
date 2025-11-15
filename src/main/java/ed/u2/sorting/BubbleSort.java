package ed.u2.sorting;


public class BubbleSort {

    /**
     * Ordena el arreglo usando BubbleSort con corte temprano.
     * Modifica el arreglo original (in-place).
     */
    public static void sort(int[] a) {
        // Validar casos especiales
        if (a == null || a.length < 2) {
            return;
        }

        int n = a.length;
        boolean huboIntercambio;

        // Realizar pasadas sobre el arreglo
        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;

            // Comparar elementos adyacentes
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    // Intercambiar elementos adyacentes
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    huboIntercambio = true;
                }
            }

            // CORTE TEMPRANO: Si no hubo intercambios, el arreglo ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }
    }

    /**
     * Ordena el arreglo usando Bubble Sort con traza de ejecución.
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

        System.out.println("=== Bubble Sort - Traza de Ejecución ===");
        System.out.println("Arreglo inicial: " + SortingUtils.arregloATexto(a));
        System.out.println();

        int n = a.length;
        boolean huboIntercambio;
        int totalSwaps = 0;  // Contador de intercambios

        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;
            int swapsEnPasada = 0;

            System.out.println("Pasada " + (i + 1) + ":");
            System.out.println("  Estado antes: " + SortingUtils.arregloATexto(a));

            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    System.out.println("    Comparando a[" + j + "]=" + a[j] +
                            " y a[" + (j+1) + "]=" + a[j+1] + " -> Intercambiar");

                    // Intercambiar
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    huboIntercambio = true;
                    swapsEnPasada++;
                    totalSwaps++;
                }
            }

            System.out.println("  Intercambios en esta pasada: " + swapsEnPasada);
            System.out.println("  Estado después: " + SortingUtils.arregloATexto(a));

            // CORTE TEMPRANO
            if (!huboIntercambio) {
                System.out.println("  *** CORTE TEMPRANO: No hubo intercambios, arreglo ya ordenado ***");
                System.out.println();
                break;
            }
            System.out.println();
        }

        System.out.println("Arreglo ordenado final: " + SortingUtils.arregloATexto(a));
        System.out.println("Total de intercambios (swaps): " + totalSwaps);
        System.out.println("===========================================\n");
    }
}