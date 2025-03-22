/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author aleja
 */
public class Preguntas {
    private String pregunta;
    private boolean respuesta;

    public Preguntas(String pregunta, boolean respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the respuesta
     */
    public boolean isRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
            
}
