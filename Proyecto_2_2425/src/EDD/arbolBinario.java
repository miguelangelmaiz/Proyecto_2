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
    private NodoAB raiz;

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

    
}
