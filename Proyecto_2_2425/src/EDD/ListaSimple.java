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
   private Nodo<T> pFirst;//primer nodo de la lista
    private Nodo<T> pLast;//ultimo nodo de la lista
    private int size;//tamano de la lista
    
    
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
            Nodo <T> aux = pFirst;
            while (aux.getPnext() != null){
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }
    
    //para mostrar la lista
     public String mostrar(String nodoNombre) {
    if (!EsVacio()) {
        Nodo<T> aux = pFirst;
        String expresion = "Árboles:\n";

        while (aux != null) {
            String dato = aux.getDato().toString();
            expresion = expresion + dato + "\n"; // Concatenación tradicional

            // Si encontramos el nodo buscado, detenemos el recorrido
            if (dato.equals(nodoNombre)) {
                break;
            }

            aux = aux.getPnext();
        }

        return expresion;
    } else {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
        return null;
    }
}
    
    //Para eliminar
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
    public T getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return (T) aux.getDato();
            }
        }
        return null;
    }
    
    // Funcion para buscar un elemento en la lista
    public boolean buscar(T referencia){
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
    //posicion del dato a buscar
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
     
    //validar el indice 
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
     
    //imprimir la lista 
    public void Imprimir(){
       if(!EsVacio()){
            Nodo <T> pAux = this.pFirst;
            for (int i=0 ;i<size;i++){
                System.out.println(pAux.getDato()+"");
                pAux=pAux.getPnext();
            }
    }else{ System.out.println("Lista vacia");}

    }
     
    //Destructor
    public void eliminar(){
        pFirst = null;
        size = 0;
    } 
    
}
