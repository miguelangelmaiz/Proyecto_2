/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Miguel
 */
public class Cargar {
    public static void cargarClave(String rutaArchivo) {
        try {
            // Leer el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            JSONObject jsonObject = new JSONObject(contenido);
            procesarClaveDicotomica(jsonObject);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    public static void procesarClaveDicotomica(JSONObject jsonObject) {
        for (String clave : jsonObject.keySet()) {
            JSONArray especiesArray = jsonObject.getJSONArray(clave);
            System.out.println("Clave Dicotómica: " + clave);

            for (int i = 0; i < especiesArray.length(); i++) {
                JSONObject especieObj = especiesArray.getJSONObject(i);
                for (String nombreEspecie : especieObj.keySet()) {
                    JSONArray preguntas = especieObj.getJSONArray(nombreEspecie);
                    if (preguntas.length() < 1) { // Reglas mínimas para diferenciación
                        System.out.println("ERROR: La especie " + nombreEspecie + " no tiene preguntas suficientes para identificarla unívocamente.");
                        return;
                    }
                    System.out.println("  Especie: " + nombreEspecie);
                    for (int j = 0; j < preguntas.length(); j++) {
                        JSONObject preguntaObj = preguntas.getJSONObject(j);
                        for (String pregunta : preguntaObj.keySet()) {
                            System.out.println("    - " + pregunta + " : " + preguntaObj.getBoolean(pregunta));
                        }
                    }
                }
            }
        }
    }
    
}
