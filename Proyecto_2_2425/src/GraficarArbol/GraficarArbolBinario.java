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
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraficarArbolBinario {
    private Graph graph;

    public GraficarArbolBinario() {
        // Crear un nuevo grafo
        graph = new SingleGraph("Árbol Binario");
        graph.setAttribute("ui.stylesheet", "node { fill-color: green; } edge { fill-color: black; }");
    }
    public void graficar(NodoAB nodo) {
        // Limpiar el grafo antes de graficar
        graph.clear();
        // Graficar el árbol
        graficarNodo(nodo, null);
        // Mostrar el grafo
        graph.display();
//        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
//        viewer.enableAutoLayout();
    }

    private void graficarNodo(NodoAB nodo, String parentId) {
        if (nodo != null) {
            String nodeId = nodo.getNombre();
            // Agregar el nodo al grafo
            graph.addNode(nodeId).setAttribute("ui.label", nodeId);
            if (parentId != null) {
                graph.addEdge(parentId + "-" + nodeId, parentId, nodeId);
            }
            // Graficar los nodos hijos
            graficarNodo(nodo.getSi(), nodeId);
            graficarNodo(nodo.getNo(), nodeId);
        }
    }
}