package ed.u2.sorting;

/**
 * Implementación del algoritmo de ordenación por Selección (Selection Sort).
 * 
 * Características:
 * - NO estable: puede cambiar el orden relativo de elementos iguales
 * - In-place: ordena el arreglo sin crear uno nuevo
 * - Complejidad: O(n²) en todos los casos
 * - Ventaja: Realiza pocos intercambios (máximo n-1)
 */
public class SelectionSort {
    
    /**
     * Ordena el arreglo usando Selection Sort.
     * Modifica el arreglo original (in-place).
     */
    public static void sort(int[] a) {
        // Validar casos especiales
        if (a == null || a.length < 2) {
            return;
        }
        
        int n = a.length;
        
        // Recorrer el arreglo buscando el mínimo en cada iteración
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;  // Asumir que el mínimo está en i
            
            // Buscar el índice del elemento mínimo en el resto del arreglo
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Intercambiar el mínimo encontrado con el elemento en posición i
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
    
    /**
     * Ordena el arreglo usando Selection Sort con traza de ejecución.
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
        
        System.out.println("=== Selection Sort - Traza de Ejecución ===");
        System.out.println("Arreglo inicial: " + SortingUtils.arregloATexto(a));
        System.out.println();
        
        int n = a.length;
        int totalSwaps = 0;  // Contador de intercambios
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            System.out.println("Iteración " + (i + 1) + ": Buscando mínimo desde posición " + i);
            System.out.println("  Estado antes: " + SortingUtils.arregloATexto(a));
            
            // Buscar el mínimo
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            
            System.out.println("  Mínimo encontrado: " + a[minIndex] + " en posición " + minIndex);
            
            // Intercambiar si es necesario
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
                totalSwaps++;
                System.out.println("  Intercambio realizado entre posiciones " + i + " y " + minIndex);
            } else {
                System.out.println("  No se requiere intercambio (mínimo ya en su lugar)");
            }
            
            System.out.println("  Estado después: " + SortingUtils.arregloATexto(a));
            System.out.println();
        }
        
        System.out.println("Arreglo ordenado final: " + SortingUtils.arregloATexto(a));
        System.out.println("Total de intercambios (swaps): " + totalSwaps);
        System.out.println("===========================================\n");
    }
}
