/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import org.json.JSONObject;  // Importar la clase para trabajar con objetos JSON



/**
 *
 * @author aleja
 */
public class JSON {
    
    
    
    
    
    
    
    
    
    
    
    
//    private JSONObject jsonData;

//    // Método para obtener el JSON desde una URL
//    public void obtenerJSON(String urlString) throws MalformedURLException {
//        try {
//            URL url = new URL(urlString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            // Verificar el código de estado HTTP
//            int status = conn.getResponseCode();
//            System.out.println("Código de estado: " + status);
//            if (status != 200) {
//                System.out.println("Error al obtener el JSON desde la URL.");
//                return;
//            }
//
//            // Verificar el tipo de contenido
//            String contentType = conn.getHeaderField("Content-Type");
//            System.out.println("Content-Type: " + contentType);
//
//            // Leer toda la respuesta (incluso si es HTML)
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder contenido = new StringBuilder();
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                contenido.append(linea);
//            }
//            br.close();
//
//            // Imprimir el contenido completo de la respuesta
//            System.out.println("Contenido recibido: " + contenido.toString());
//
//            // Si el tipo de contenido es JSON, intentar parsearlo
//            if (contentType.contains("application/json")) {
//                jsonData = new JSONObject(contenido.toString());
//            } else {
//                System.out.println("La respuesta no es un JSON válido.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error al cargar el JSON desde URL: " + e.getMessage());
//        }
//    }
//
//    // Método para imprimir el contenido del JSON
//    public void imprimirContenido() {
//        if (jsonData != null) {
//            System.out.println("Contenido del JSON:");
//            System.out.println(jsonData.toString(2)); // Imprime el JSON con formato
//        } else {
//            System.out.println("No se pudo cargar el JSON.");
//        }
//    }
}
    
