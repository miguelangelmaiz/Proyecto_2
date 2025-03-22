/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author aleja
 */
public class arbolTransformado {
    private String nombre;
    private ListaSimple<Preguntas> camino;

    public arbolTransformado(String nombre, ListaSimple<Preguntas> camino) {
        this.nombre = nombre;
        this.camino = camino;
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
