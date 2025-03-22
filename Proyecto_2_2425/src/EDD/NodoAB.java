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
    private String nombre;
    private NodoAB si;
    private NodoAB no;
    private ListaSimple<Preguntas>camino;

    public NodoAB(String nombre) {
        this.nombre = nombre;
        this.si = null;
        this.no = null;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the si
     */
    public NodoAB getSi() {
        return si;
    }

    /**
     * @param si the si to set
     */
    public void setSi(NodoAB si) {
        this.si = si;
    }

    /**
     * @return the no
     */
    public NodoAB getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(NodoAB no) {
        this.no = no;
    }

    /**
     * @return the camino
     */
    public ListaSimple<Preguntas> getCamino() {
        return camino;
    }

    /**
     * @param camino the camino to set
     */
    public void setCamino(ListaSimple<Preguntas> camino) {
        this.camino = camino;
    }

}
