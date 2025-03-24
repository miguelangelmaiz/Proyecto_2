/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraficarArbol;

/**
 *
 * @author chuchu
 */
import EDD.NodoAB;
import EDD.arbolBinario;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraficarArbolBinario {
    private Graph graph;

    public GraficarArbolBinario() {
        // Crear un nuevo grafo
        graph = new SingleGraph("Árbol Binario");
        graph.setAttribute("ui.stylesheet", "node { fill-color: green; } edge { fill-color: black; }");
    }

    public void agregarNodo(NodoAB nodo) {
        // Agregar nodo al grafo
        graph.addNode(nodo.getNombre()).setAttribute("ui.label", nodo.getNombre());
    }

    public void agregarArista(NodoAB padre, NodoAB hijo) {
        // Agregar arista al grafo
        graph.addEdge(padre.getNombre() + "-" + hijo.getNombre(), padre.getNombre(), hijo.getNombre());
    }

    public void mostrarRecorrido(arbolBinario arbol) {
        // Iniciar el recorrido (por ejemplo, en preorden)
        recorrer(arbol.raiz);
        // Mostrar el grafo
        graph.display();
    }
    private void recorrer(NodoAB nodo) {
    if (nodo == null) {
        return;
    }

    // Cambiar el color del nodo actual
    graph.getNode(nodo.getNombre()).setAttribute("ui.style", "fill-color: red;");

    // Si tiene un hijo izquierdo, cambiar el color de la arista y recorrer
    if (nodo.getSi() != null) {
        graph.getEdge(nodo.getNombre() + "-" + nodo.getSi().getNombre()).setAttribute("ui.style", "fill-color: blue;");
        recorrer(nodo.getSi());
    }

    // Si tiene un hijo derecho, cambiar el color de la arista y recorrer
    if (nodo.getNo() != null) {
        graph.getEdge(nodo.getNombre() + "-" + nodo.getNo().getNombre()).setAttribute("ui.style", "fill-color: blue;");
        recorrer(nodo.getNo());
    }
}
}