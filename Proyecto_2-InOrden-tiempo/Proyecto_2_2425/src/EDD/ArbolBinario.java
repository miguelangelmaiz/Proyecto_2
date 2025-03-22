/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class arbolBinario {
    private NodoAB raiz;

    public arbolBinario() {
        this.raiz = raiz;
    }  

    
    
    public void contruirArbol(String nombreArbol,ListaSimple<Preguntas> camino){
        if(camino==null){
            System.out.println("El camino esta vacio");
        }
        if (this.raiz==null){
            this.raiz=new NodoAB(camino.validarIndice(0).getPregunta());
        }
        NodoAB actual=this.raiz;
        for(int i=0;i<camino.getSize();i++){
            Preguntas preguntas=camino.validarIndice(i);
            boolean respuesta=preguntas.isRespuesta();
            
            if(i==camino.getSize()-1){
                if(respuesta){
                    if(actual.getSi()==null){
                        actual.setSi(new NodoAB(null));
                    }
                    actual.getSi().setNombre(nombreArbol);
                }else{
                    if(actual.getNo()==null){
                    actual.setNo(new NodoAB(null));
                    }
                    actual.getNo().setNombre(nombreArbol);
                }
            }else{
                if(respuesta){
                if(actual.getSi()==null){
                    actual.setSi(new NodoAB(camino.validarIndice(i+1).getPregunta()));
                }
                actual=actual.getSi();
                }else{
                    if(actual.getNo()==null){
                    actual.setNo(new NodoAB(camino.validarIndice(i+1).getPregunta()));
                    }
                    actual=actual.getNo();
                }
                
            }
        }
      
    }
    
public void inOrden(String nombreNodo) {
    NodoAB nodo = buscarNodo(raiz, nombreNodo); // Buscar nodo por nombre
    if (nodo != null) {
        StringBuilder resultado = new StringBuilder();
        
        long Tiempoinicial = System.nanoTime();
        
        recorrerInOrden(nodo, resultado);
        long Tiempofinal = System.nanoTime();
                // Calcula el tiempo transcurrido
        long duration = Tiempofinal - Tiempoinicial;
        JOptionPane.showMessageDialog(null, resultado.toString() + "Tiempo de recorrido: " + duration + " nanosegundos", "Recorrido InOrden", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Nodo no encontrado: " + nombreNodo, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Método para recorrer el árbol en InOrden
private void recorrerInOrden(NodoAB nodo, StringBuilder resultado) {
    if (nodo != null) {
        recorrerInOrden(nodo.getSi(), resultado);
        resultado.append(nodo.getNombre()).append("\n"); // Acumula el nodo en el StringBuilder
        recorrerInOrden(nodo.getNo(), resultado);
    }
}

// Método para buscar un nodo por su nombre
private NodoAB buscarNodo(NodoAB nodo, String nombre) {
    if (nodo == null) {
        return null; // Si el nodo es nulo, retornar null
    }
    if (nombre.equals(nodo.getNombre())) {
        return nodo; // Si el nombre coincide, retornar el nodo
    }
    
    // Buscar en los subárboles izquierdo y derecho
    NodoAB encontrado = buscarNodo(nodo.getSi(), nombre);
    if (encontrado == null) {
        encontrado = buscarNodo(nodo.getNo(), nombre);
    }
    return encontrado;
}
    
    public void imprimirArbol() {
    if (raiz == null) {
        System.out.println("El árbol está vacío.");
    } else {
        imprimirRecursivo(raiz, "");
    }
}
    private void imprimirRecursivo(NodoAB nodo, String prefijo) {
        if (nodo != null) {
            // Imprimir el nombre del nodo actual
            System.out.println(prefijo + "- " + nodo.getNombre());

            // Llamadas recursivas para los nodos 'si' y 'no'
            imprimirRecursivo(nodo.getSi(), prefijo + "  ");
            imprimirRecursivo(nodo.getNo(), prefijo + "  ");
        }
    }
    
}
