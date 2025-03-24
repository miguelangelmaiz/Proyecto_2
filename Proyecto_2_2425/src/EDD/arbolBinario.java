/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class arbolBinario {

    //Primer nodo del arbol
    public NodoAB raiz;

    //constructor de la clase
    public arbolBinario() {
        this.raiz = null;
    }

    //contruir el arbol
    public void contruirArbol(String nombreArbol, ListaSimple<Preguntas> camino) {
        //verifica que la lista de preguntas no esten vacias
        if (camino == null) {
            System.out.println("El camino esta vacio");
            return;
        }
        //si el arbol esta vacio lo inicializamos con la primera pregunta
        if (this.raiz == null) {
            this.raiz = new NodoAB(camino.validarIndice(0).getPregunta());
        }
        /*Le colocamos el conjunto de preguntas a camino  en 
        el nodo raiz si no tiene pregungtas asignas*/
        NodoAB actual = this.raiz;
        if (actual.getCamino() == null) {
            actual.setCamino(camino);
        }
        
        //Recorrer cada pregunta
        for (int i = 0; i < camino.getSize(); i++) {
            Preguntas preguntas = camino.validarIndice(i);
            //le asignamos la respuesta
            boolean respuesta = preguntas.isRespuesta();
            
            //Se procesa la ultima pregunta del camino
            if (i == camino.getSize() - 1) {
                //si la respuesta es true(si) va a la izquierda
                if (respuesta) {
                    if (actual.getSi() == null) {
                        //se crea nodo del arbol
                        actual.setSi(new NodoAB(nombreArbol));
                    }
                    //si la respuesta es false(no) va a la derecha
                } else {
                    if (actual.getNo() == null) {
                        //se crea nodo del arbol
                        actual.setNo(new NodoAB(nombreArbol));
                    }
                    
                }
            } else {
                //Si no es la ultima pregunta
                if (respuesta) {
                    //si la respuesta es true(si) va a la izquierda
                    if (actual.getSi() == null) {
                        //se crea nodo del arbol y accedemos a la proxima pregunta 
                        actual.setSi(new NodoAB(camino.validarIndice(i + 1).getPregunta()));
                        
                    }
                    //actual se mueve al hijo izquierdo
                    actual = actual.getSi();
                    //se le asigna camino(lista de preguntas) al nodo actual
                    actual.setCamino(camino);
            
                } else {
                    //si la respuesta es false(no) va a la derecha
                    if (actual.getNo() == null) {
                        //se crea nodo del arbol y accedemos a la proxima pregunta 
                        actual.setNo(new NodoAB(camino.validarIndice(i + 1).getPregunta()));
                    }
                    //actual se mueve al hijo derecho
                    actual = actual.getNo();
                }

            }
        }

    }
//Metodo para identificar la especie    
    public void identificarEspecie() {
        //verficamos si la raiz es null
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
            return;
        }
        
        //le asignamos a actual la raiz
        NodoAB actual = raiz;
        
        //recorremos hasta que actual no sea null
        while (actual != null) {
           //mostramos la pregunta al usario con un cuadro de dialogo
            String respuesta = JOptionPane.showInputDialog(null, actual.getNombre()
                        + "(si/no)");
            
             boolean validarRespuesta = false;
             //si la respuesta es "si" nos movemos a la izquierda
             if (respuesta.equals("si")) {
                    validarRespuesta = true;
                    actual=actual.getSi();
                 //si la respuesta es "no" nos movemos a la derecha   
                } else if (respuesta.equals("no")) {
                    validarRespuesta = false;
                    actual=actual.getNo();
                } else{
                      JOptionPane.showMessageDialog(null, "Dato erroneo");
                }
             
                //verifica que actual sea hoja
                if(actual.getSi()==null || actual.getNo()==null){
                    //le muestra la especie al usuario
                    JOptionPane.showMessageDialog(null, "La especie identificada es:"
                        + actual.getNombre());
                    break;
                }
    
           
    }}
    
    public void inOrden(String nombreNodo) {
    
    NodoAB nodo = buscarNodo(raiz, nombreNodo); // Buscar nodo por nombre
    if (nodo != null) {
        ListaSimple resultado = new ListaSimple();
        recorrerInOrden(raiz, resultado, nodo);
        
        JOptionPane.showMessageDialog(null, resultado.mostrar(nombreNodo));
        
    } else {
        JOptionPane.showMessageDialog(null, "Nodo no encontrado: " + nombreNodo);
        
        
    }
}

// Metodo para recorrer el árbol en InOrden
private void recorrerInOrden(NodoAB nodo, ListaSimple resultado, NodoAB nombreSrt) {
   if (nodo == null) {
        return; // Evita llamadas innecesarias
    }

    // Primero, recorrer el subarbol izquierdo si aun no hemos encontrado el nodo buscado
    if (nodo != nombreSrt) {
        recorrerInOrden(nodo.getSi(), resultado, nombreSrt);
    }

    // Agregar el nodo actual a la lista si aun no hemos alcanzado el nodo buscado
    resultado.InsertarFinal(nodo.getNombre());

    // Si hemos llegado al nodo buscado, detener el recorrido
    if (nodo == nombreSrt) {
        return;
    }

    // Luego, recorrer el subarbol derecho si aun no hemos encontrado el nodo buscado
    recorrerInOrden(nodo.getNo(), resultado, nombreSrt);
}

// Metodo para buscar un nodo por su nombre
private NodoAB buscarNodo(NodoAB nodo, String nombre) {
    if (nodo == null) {
        return null; // Si el nodo es nulo, retornar null
    }
    if (nombre.equals(nodo.getNombre())) {
        return nodo; // Si el nombre coincide, retornar el nodo
    }
    
    // Buscar en los subarboles izquierdo y derecho
    NodoAB encontrado = buscarNodo(nodo.getSi(), nombre);
    if (encontrado == null) {
        encontrado = buscarNodo(nodo.getNo(), nombre);
    }
    return encontrado;
}  
public void imprimirArbol() {
        imprimirArbolRecursivo(raiz, 0);
    }

    // Método recursivo para imprimir cada nodo y sus hijos
    private void imprimirArbolRecursivo(NodoAB nodo, int nivel) {
        if (nodo == null) {
            return; // Si el nodo es nulo, no hacemos nada
        }

        // Imprimir el nodo actual con su nivel en el árbol
        String indentacion = "  ".repeat(nivel); // Crear indentación según el nivel
        System.out.println(indentacion + "Nodo: " + nodo.getNombre());

        // Imprimir el hijo izquierdo
        if (nodo.getSi() != null) {
            System.out.println(indentacion + "  Hijo Izquierdo: " + nodo.getSi().getNombre());
        }

        // Imprimir el hijo derecho
        if (nodo.getNo() != null) {
            System.out.println(indentacion + "  Hijo Derecho: " + nodo.getNo().getNombre());
        }

        // Llamar recursivamente a los hijos
        imprimirArbolRecursivo(nodo.getSi(), nivel + 1);
        imprimirArbolRecursivo(nodo.getNo(), nivel + 1);
    }

    public NodoAB Raiz() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
