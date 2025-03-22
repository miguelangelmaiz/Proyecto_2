/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Miguel
 */
public class NodoAB {
    private Object dato;
    private NodoAB HijoIzq;
    private NodoAB HijoDer;
    private NodoAB father;

    public NodoAB(Object dato) {
        this.dato = dato;
        this.HijoDer = this.HijoIzq = this.father = null;
    }
    
    public NodoAB() {
        this.dato = null;
        this.HijoDer = this.HijoIzq = this.father = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoAB getHijoIzq() {
        return HijoIzq;
    }

    public void setHijoIzq(NodoAB HijoIzq) {
        this.HijoIzq = HijoIzq;
    }

    public NodoAB getHijoDer() {
        return HijoDer;
    }

    public void setHijoDer(NodoAB HijoDer) {
        this.HijoDer = HijoDer;
    }

    public NodoAB getFather() {
        return father;
    }

    public void setFather(NodoAB father) {
        this.father = father;
    }
}
    
    

