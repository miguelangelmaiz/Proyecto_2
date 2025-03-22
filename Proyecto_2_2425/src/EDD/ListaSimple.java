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
public class ListaSimple <T> {
   private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int size;
    
    
    //Constructor de la clase Lista
    public ListaSimple() {
        this.pFirst = null;
        this.pLast=null;
        this.size = 0; 
    }
    
    //Metodos get y set para los atrubutos

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Primitivas
    
    //Funcion para verificar si la lista es vacia
    public boolean EsVacio(){
        return this.pFirst == null;
    }
    
    //Metodo que vacia la lista
    public void vaciar(){
        this.pFirst = null;
        this.size = 0;   
    }

    //Metodo para insertar al final
    public void InsertarFinal(T dato){
        Nodo<T> pNew = new Nodo<>(dato);
        if(EsVacio()){
            pFirst = pNew;
        }else{
            Nodo aux = pFirst;
            while (aux.getPnext() != null){
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }
    
    public void mostrar(){
        if (!EsVacio()){
            Nodo <T> aux = pFirst;
            String expresion = "Arboles:" + "\n";
            while(aux != null){
               expresion = expresion + aux.getDato().toString() + "\n";
               aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    public void Eliminar_Final(){
        if(!EsVacio()){
            if (getSize()==1) {
                vaciar();
            }else{
                Nodo pointer = getpFirst();
                while(pointer.getPnext() != null && pointer.getPnext().getPnext()!= null){
                    pointer = pointer.getPnext();
                }
                pointer.setPnext(null);
            }
        }
        size --;
    }
    
    //Metodo para obtener el valor de un nodo en una determinada posición
    public Object getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
    
    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia){
        Nodo <T> aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
     public int posicionDato(T valorBuscado) {
        Nodo<T> actual = this.pFirst;
        int index = 0;

        while (actual != null) {
            if (actual.getDato().equals(valorBuscado)) {
                return index;
            }

            actual = actual.getPnext();
            index++;
        }

        return -1; // Si no se encuentra el valor, devolvemos -1
    }
    
     public T validarIndice(int indece) {
        Nodo <T> pAux = this.pFirst;
        int contador = 0;

        while (pAux != null && contador != indece) {
            pAux = pAux.getPnext();
            contador++;
        }

        if (pAux != null) {
            return pAux.getDato();
            
        } else {
            return null;
        }

    }
    
    //Destructor
    public void eliminar(){
        pFirst = null;
        size = 0;
    } 
    
}
