/*  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author chuchu
 */
public class ImprimirArbol {
    private Graph graph;
    public ImprimirArbol() {
        graph = new SingleGraph("Árbol Binario");
        graph.setAttribute("ui.stylesheet", "node { fill-color: lightblue; } edge { fill-color: black; }");
    }

    public void agregarNodo(String id, String label) {
        Node node = graph.addNode(id);
        node.setAttribute("ui.label", label);
    }
    public void agregarArista(String id, String from, String to) {
        graph.addEdge(id, from, to);
    }

public void mostrar() {
    if (graph.getNodeCount() == 0) {
        System.out.println("El gráfico está vacío. Asegúrate de agregar nodos y aristas.");
        return;
    }
    
    Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD) {};
    viewer.enableAutoLayout();
    viewer.show();
}
    public static void main(String[] args) {
        ImprimirArbol arbol = new ImprimirArbol();

        
        //nodos
        arbol.agregarNodo("Raíz", "Raíz");
        arbol.agregarNodo("Izquierda", "Izquierda");
        arbol.agregarNodo("Derecha", "Derecha");
        arbol.agregarNodo("Izquierda Izquierda", "Izquierda Izquierda");
        arbol.agregarNodo("Izquierda Derecha", "Izquierda Derecha");
        
        
        // aristas
        arbol.agregarArista("1", "Raíz", "Izquierda");
        arbol.agregarArista("2", "Raíz", "Derecha");
        arbol.agregarArista("3", "Izquierda", "Izquierda Izquierda");
        arbol.agregarArista("4", "Izquierda", "Izquierda Derecha");

        // Mostrar el árbol
        arbol.mostrar();
    }
}