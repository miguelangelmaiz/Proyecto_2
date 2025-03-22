/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import EDD.arbolTransformado;
/**
 *
 * @author aleja
 */
public class arbolBinario {
    private NodoAB raiz;

    public arbolBinario() {
        this.raiz = raiz;
    }

    
public void contruirArbol(String nombreArbol,ListaSimple<Preguntas> camino){
        if(camino==null){
            System.out.println("El camino esta vacio");
        }
        if (this.raiz==null){
            this.raiz=new NodoAB(camino.validarIndice(0).getPregunta());
        }
        NodoAB actual=this.raiz;
        for(int i=0;i<camino.getSize();i++){
            Preguntas preguntas=camino.validarIndice(i);
            boolean respuesta=preguntas.isRespuesta();
            
            if(i==camino.getSize()-1){
                if(respuesta){
                    if(actual.getSi()==null){
                        actual.setSi(new NodoAB(null));
                    }
                    actual.getSi().setNombre(nombreArbol);
                }else{
                    if(actual.getNo()==null){
                    actual.setNo(new NodoAB(null));
                    }
                    actual.getNo().setNombre(nombreArbol);
                }
            }else{
                if(respuesta){
                if(actual.getSi()==null){
                    actual.setSi(new NodoAB(camino.validarIndice(i+1).getPregunta()));
                }
                actual=actual.getSi();
                }else{
                    if(actual.getNo()==null){
                    actual.setNo(new NodoAB(camino.validarIndice(i+1).getPregunta()));
                    }
                    actual=actual.getNo();
                }
                
            }
        }
      
    }
//Metodo para     
public void identificarEspecie(){
    if(raiz==null){
        System.out.println("El árbol está vacío.");
    }
    NodoAB actual=raiz;
    BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try{while(actual!=null){
            if(actual.getNombre()!=null){
                System.out.println("La especie identificada es:"+ actual.getNombre());
                return;
            }
            ListaSimple<Preguntas> camino=actual.getCamino();
            boolean validarCamino=true;

            for(int i=0;i<camino.getSize();i++){
               Preguntas pregunta=camino.getValor(i);
               System.out.println(pregunta.getPregunta()+"(si/no)");
               String respuesta=reader.readLine().trim().toLowerCase();

               boolean validarRespuesta=false;
                if(respuesta.equals("si")){
                   validarRespuesta=true;
                }else if (respuesta.equals("no")){
                    validarRespuesta=false;
                }else{
                   //mendaje de error para respuestas no validas
                   System.out.println("Dato invalido porfa responde 'si' o 'no'"+
                           "\nNota:no escriir ni puntos ni espacio");
                   i--;
                   continue;
                }

                if(validarRespuesta!=pregunta.isRespuesta()){
                   validarCamino=false;
                   break;
                }
            }
                if(validarCamino==true){
                    actual.getSi();
                }else{
                    actual=actual.getNo();
                }  
        }
        System.out.println("No se pudo encontrar un especie con esas "
                + "caracteristicas");
    }
    catch(IOException e){
        System.out.println("Error al leer la entrada del usuario"+e.getMessage());
    }
}
    
    
    public void imprimirArbol() {
    if (raiz == null) {
        System.out.println("El árbol está vacío.");
    } else {
        imprimirRecursivo(raiz, "");
    }
}
    private void imprimirRecursivo(NodoAB nodo, String prefijo) {
        if (nodo != null) {
            // Imprimir el nombre del nodo actual
            System.out.println(prefijo + "- " + nodo.getNombre());

            // Llamadas recursivas para los nodos 'si' y 'no'
            imprimirRecursivo(nodo.getSi(), prefijo + "  ");
            imprimirRecursivo(nodo.getNo(), prefijo + "  ");
        }
    }
}
