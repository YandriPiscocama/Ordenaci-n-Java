# Ordenación Básica en Java


## Descripción

Este proyecto implementa tres algoritmos de ordenación básicos en Java: **Insertion Sort**, **Selection Sort** y **Bubble Sort**. Cada algoritmo ordena arreglos de forma in-place (modificando el arreglo original) y genera trazas detalladas que muestran paso a paso cómo funcionan.

---

## Decisiones de Diseño

### 1. Estructura del Proyecto
Se organizó el código en el paquete `ed.u2.sorting` con las siguientes clases:
- **InsertionSort, SelectionSort, BubbleSort:** Contienen la lógica de cada algoritmo
- **SortingUtils:** Funciones auxiliares para copiar arreglos, convertir a texto y validar ordenamiento
- **SortingDemo:** Clase principal que ejecuta los tres algoritmos sobre los cinco datasets

### 2. Métodos de Ordenación
Cada clase de ordenación tiene dos métodos:
- `sort(int[] a)`: Ordena el arreglo sin mostrar información adicional
- `sort(int[] a, boolean trace)`: Ordena el arreglo y genera una traza detallada cuando `trace = true`

Esta decisión permite ejecutar los algoritmos de forma silenciosa cuando solo se necesita ordenar, o con trazas completas para propósitos educativos.

### 3. Optimización en Bubble Sort
Se implementó el **corte temprano** usando una variable booleana `huboIntercambio`. Si en una pasada completa no se realiza ningún intercambio, el algoritmo termina porque el arreglo ya está ordenado. Esto mejora el mejor caso de O(n²) a O(n).

### 4. Validación Automática
Después de ordenar cada arreglo, se verifica automáticamente con `SortingUtils.estaOrdenado()` que el resultado esté correcto. Esto ayuda a detectar errores en la implementación.

---

## Casos Borde Manejados

Todos los algoritmos manejan correctamente los siguientes casos especiales:

1. **Arreglo null:** Se valida al inicio y se retorna sin hacer nada
2. **Arreglo vacío `[]`:** No requiere ordenación
3. **Arreglo de un elemento `[x]`:** Ya está ordenado por definición
4. **Todos elementos iguales `[2,2,2,2]`:** Se maneja correctamente sin intercambios innecesarios
5. **Arreglo ya ordenado `[1,2,3,4,5]`:** Bubble Sort activa corte temprano; Insertion Sort es O(n)
6. **Orden inverso `[5,4,3,2,1]`:** Peor caso, se manejan todos los intercambios necesarios

Estos casos se validan con:
```java
if (a == null || a.length < 2) {
    return;
}
```

---

## Cómo Ejecutar

### Requisitos
- JDK 11 o superior
- Terminal/línea de comandos

### Pasos de Compilación

1. Abrir terminal en la carpeta donde está la carpeta `ed/`

2. Compilar todos los archivos:
```bash
javac ed/u2/sorting/*.java
```

3. Ejecutar el programa:
```bash
java ed.u2.sorting.SortingDemo
```

### Salida Esperada
El programa mostrará:
- Las trazas detalladas de cada algoritmo para los 5 datasets (A, B, C, D, E)
- Verificación automática de que cada ordenamiento es correcto
- Mensajes indicando qué dataset se está procesando

---

## Datasets Utilizados

Según la guía de la práctica, se probaron los siguientes datasets:

| Dataset | Arreglo Original | Resultado Esperado | Propósito |
|---------|------------------|-------------------|-----------|
| A | [8, 3, 6, 3, 9] | [3, 3, 6, 8, 9] | Caso general con duplicados |
| B | [5, 4, 3, 2, 1] | [1, 2, 3, 4, 5] | Peor caso (orden inverso) |
| C | [1, 2, 3, 4, 5] | [1, 2, 3, 4, 5] | Mejor caso (ya ordenado) |
| D | [2, 2, 2, 2] | [2, 2, 2, 2] | Todos duplicados |
| E | [9, 1, 8, 2] | [1, 2, 8, 9] | Caso mixto |

---

## Características de los Algoritmos

### Insertion Sort
- **Estabilidad:** Estable (mantiene orden de elementos iguales)
- **Complejidad:** O(n²) peor caso, O(n) mejor caso
- **Mejor para:** Datos casi ordenados o arreglos pequeños

### Selection Sort
- **Estabilidad:** NO estable
- **Complejidad:** O(n²) en todos los casos
- **Mejor para:** Minimizar el número de intercambios (máximo n-1 swaps)

### Bubble Sort
- **Estabilidad:** Estable
- **Complejidad:** O(n²) peor caso, O(n) mejor caso con corte temprano
- **Mejor para:** Detectar rápidamente si un arreglo ya está ordenado

---
