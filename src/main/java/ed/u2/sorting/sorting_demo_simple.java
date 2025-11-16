package ed.u2.sorting;

/**
 * Clase principal de demostración de algoritmos de ordenación.
 * 
 * Ejecuta los tres algoritmos (Insertion, Selection, Bubble) sobre
 * los cinco datasets requeridos (A, B, C, D, E) y muestra las trazas.
 */
public class SortingDemo {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║   DEMOSTRACIÓN DE ALGORITMOS DE ORDENACIÓN EN JAVA    ║");
        System.out.println("║   Insertion Sort | Selection Sort | Bubble Sort       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        // Definir los cinco datasets según la guía
        int[] datasetA = {8, 3, 6, 3, 9};
        int[] datasetB = {5, 4, 3, 2, 1};  // Orden inverso
        int[] datasetC = {1, 2, 3, 4, 5};  // Ya ordenado
        int[] datasetD = {2, 2, 2, 2};     // Todos duplicados
        int[] datasetE = {9, 1, 8, 2};     // Caso mixto
        
        // Ejecutar pruebas para cada dataset
        ejecutarPruebas("A", datasetA);
        ejecutarPruebas("B", datasetB);
        ejecutarPruebas("C", datasetC);
        ejecutarPruebas("D", datasetD);
        ejecutarPruebas("E", datasetE);
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              EJECUCIÓN COMPLETADA                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    
    /**
     * Ejecuta los tres algoritmos sobre un dataset específico.
     */
    private static void ejecutarPruebas(String nombreDataset, int[] datasetOriginal) {
        System.out.println("\n");
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("  DATASET " + nombreDataset + ": " + SortingUtils.arregloATexto(datasetOriginal));
        System.out.println("════════════════════════════════════════════════════════\n");
        
        // INSERTION SORT
        int[] copiaInsertion = SortingUtils.copiarArreglo(datasetOriginal);
        System.out.println("--- INSERTION SORT ---");
        InsertionSort.sort(copiaInsertion, true);  // true = con traza
        verificarOrdenamiento("Insertion Sort", copiaInsertion);
        
        // SELECTION SORT
        int[] copiaSelection = SortingUtils.copiarArreglo(datasetOriginal);
        System.out.println("--- SELECTION SORT ---");
        SelectionSort.sort(copiaSelection, true);  // true = con traza
        verificarOrdenamiento("Selection Sort", copiaSelection);
        
        // BUBBLE SORT
        int[] copiaBubble = SortingUtils.copiarArreglo(datasetOriginal);
        System.out.println("--- BUBBLE SORT ---");
        BubbleSort.sort(copiaBubble, true);  // true = con traza
        verificarOrdenamiento("Bubble Sort", copiaBubble);
    }
    
    /**
     * Verifica que el arreglo esté correctamente ordenado.
     */
    private static void verificarOrdenamiento(String nombreAlgoritmo, int[] arreglo) {
        if (SortingUtils.estaOrdenado(arreglo)) {
            System.out.println("✓ " + nombreAlgoritmo + " - VERIFICACIÓN: Correcto\n");
        } else {
            System.out.println("✗ " + nombreAlgoritmo + " - VERIFICACIÓN: ERROR - No está ordenado\n");
        }
    }
}
