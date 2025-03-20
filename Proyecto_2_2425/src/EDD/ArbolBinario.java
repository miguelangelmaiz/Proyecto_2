/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Miguel
 */
public class ArbolBinario {
    private NodoAB nodoRaiz;
    
    public ArbolBinario() {
        this.nodoRaiz = null;
    }

    public NodoAB getNodoRaiz() {
        return nodoRaiz;
    }

    public void setNodoRaiz(NodoAB nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }
    
    public boolean esVacio() {
        return this.getNodoRaiz() == null;
    }
    
    public void vaciar() {
        this.setNodoRaiz(null);
    }
    
    public void insertNodo(NodoAB raiz,int element) {
        NodoAB node = new NodoAB(element);
        if (esVacio()) {
            setNodoRaiz(node);
        } else {
            if (element <= (int) raiz.getDato()) {
                if(raiz.getHijoIzq() == null) {
                    raiz.setHijoIzq(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getHijoIzq(),element);
                }
            } else {
                if(raiz.getHijoDer() == null) {
                    raiz.setHijoDer(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getHijoDer(),element);
                }
            }
        }
    }
    
    public NodoAB buscarNodo(int num, NodoAB root){
        if(esVacio()){
            return null;
        }else{
            if((int)root.getDato() == num){
                return root;
            }else{
                if(num < (int)root.getDato()){
                    return buscarNodo(num, root.getHijoIzq());
                }else{
                    return buscarNodo(num, root.getHijoIzq());
                }
            }
        }
    }
    
    public void preOrden(NodoAB root) {
        if (root != null) {
            System.out.println("{ "+root.getDato()+" }");
            preOrden(root.getHijoIzq());
            preOrden(root.getHijoDer());
        }
    }
    
    public String preOrden2 (NodoAB root, String cadena){
        if(root != null){
            cadena = cadena + root.getDato() + ",";
            cadena = preOrden2(root.getHijoIzq(), cadena);
            cadena = preOrden2(root.getHijoDer(), cadena);
        }
        
        return cadena;
    }
    
    public void Lista(NodoAB root, ListaSimple list) {
        list.InsertarFinal(root.getDato());
        
        if(root.getHijoIzq() != null){
            Lista(root.getHijoIzq(), list);
        }
        if(root.getHijoDer() != null){
            Lista(root.getHijoDer(), list);
        }   
    }
    
    public void inOrden(NodoAB root) {
        if (root != null) {
            preOrden(root.getHijoIzq());
            System.out.println("{ "+root.getDato()+" }");
            preOrden(root.getHijoDer());
        }
    }
    
    public void postOrden(NodoAB root) {
        if (root != null) {
            preOrden(root.getHijoIzq());
            preOrden(root.getHijoDer());
            System.out.println("{ "+root.getDato()+" }");
        }
    }
    
}
