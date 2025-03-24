/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Miguel
 */
public class Nodo<T> {
    private T dato; //Variable donde se guardara el valor
    private Nodo pnext; //Variable para enlazar los nodos
    
    //Constructor vacio
    public Nodo(){
        
    }
    
    //Constructor de la clase nodo si le paso solo la info
    public Nodo(T dato) {
        this.dato = dato;
        this.pnext = null;
    }
    
   
    //Metodos get y set para los atrubutos

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the pnext
     */
    public Nodo getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }
   
    
}
