/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author chuchu
 */
public class Hash {
// Array de listas para manejar las colisiones en la tabla hash.
    private ListaSimple<NodoAB>[] table;
    
    // Tamaño de la tabla hash
    private int size;

    /**
     * Constructor que inicializa la tabla hash con un tamaño dado.
     * @param size Tamaño de la tabla hash.
     */
    public Hash(int size) {
        this.size = size;
        table = new ListaSimple[size];
        
        // Inicializa cada posición de la tabla con una lista vacía.
        for (int i = 0; i < size; i++) {
            table[i] = new ListaSimple<>();
        }
    }

    /**
     * Función de hash que convierte una clave (String) en un índice dentro del rango de la tabla.
     * @param key Clave a convertir.
     * @return Índice en la tabla hash.
     */
    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    /**
     * Inserta un nodo en la tabla hash.
     * @param nodo Nodo que se va a insertar.
     */
    public void insert(NodoAB nodo) {
        int index = hash(nodo.getNombre()); // Obtiene el índice correspondiente al hash
        table[index].InsertarFinal(nodo); // Inserta el nodo en la lista de ese índice
    }

    /**
     * Busca un nodo en la tabla hash por su nombre.
     * @param nombre Nombre del nodo a buscar.
     * @return Nodo encontrado o null si no se encuentra.
     */
    public NodoAB search(String nombre) {
        int index = hash(nombre); // Calcula el índice en la tabla
        ListaSimple<NodoAB> lista = table[index]; // Obtiene la lista de ese índice
        
        // Recorre la lista buscando el nodo con el nombre indicado
        for (int i = 0; i < lista.getSize(); i++) {
            NodoAB nodo = lista.getValor(i);
            if (nodo.getNombre().equals(nombre)) {
                return nodo; // Devuelve el nodo si lo encuentra
            }
        }
        return null; // Retorna null si el nodo no está en la tabla
    }

    /**
     * Imprime la tabla hash mostrando los elementos en cada índice.
     */
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            table[i].Imprimir(); // Llama a la función de impresión de la lista en ese índice
        }
    }
}
