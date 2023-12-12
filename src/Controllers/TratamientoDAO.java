/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Operaciones;
import Models.Pago;
import Models.Tratamiento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author david
 */
public class TratamientoDAO {
    private static String Archivo = "Tratamiento.json";
    private Tratamiento trata = new Tratamiento();
    private ArrayList<Operaciones> operaciones;
    private ArrayList<Tratamiento> tratamiento;
    private JsonArray ja;
    private Operaciones opera;
    private Pago pago;
    public TratamientoDAO() {
        
    }
    public int getCorr(){
        ja=leerJsonArrayDesdeArchivo(Archivo);
        int num= ja.size();
        ja=null;
        return num;
    }
    

    public TratamientoDAO(JsonObject objeto) {
        guardarSinSobrescribir(Archivo,objeto);

    }
    
    
    private static JsonArray convertirArray(List<Tratamiento> tratamiento) {
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonArray();
        for (Tratamiento trata : tratamiento) {
            // Convierte cada elemento de la lista a un JsonObject y agrega al JsonArray
            jsonArray.add(gson.toJsonTree(trata).getAsJsonObject());
        }
        return jsonArray;
    }
    
    private  JsonObject convertirObjecto(Object objeto) {
        Gson gson = new Gson();
        String json = gson.toJson(objeto);
        return gson.fromJson(json, JsonObject.class);
    }
    private Object convertirAtributo(JsonElement value) {
        if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isNumber()) {
            // Si el valor es un número, convertirlo al tipo numérico correspondiente
            return value.getAsNumber();
        } else {
            // De lo contrario, devolver el valor como está
            return value.getAsString();
        }
    }
    private static void guardarJsonArrayEnArchivo(JsonArray jsonArray, String rutaArchivo) {
        try (FileWriter fileWriter = new FileWriter(rutaArchivo)) {
            // Configurar Gson con formato legible
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convertir el JsonArray a una cadena JSON formateada
            String jsonString = gson.toJson(jsonArray);

            // Escribir la cadena JSON en el archivo
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static JsonArray leerJsonArrayDesdeArchivo(String rutaArchivo) {
        try (FileReader fileReader = new FileReader(rutaArchivo)) {
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            if (jsonElement.isJsonArray()) {
                return jsonElement.getAsJsonArray();
            } else {
                System.out.println("El archivo no contiene un JsonArray");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonArray(); // Devolver un JsonArray vacío si hay errores
    }
    
    private void guardarSinSobrescribir(String rutaArchivo, JsonObject nuevoObjeto) {
        try (FileReader fileReader = new FileReader(rutaArchivo)) {
            // Parsear el contenido actual del archivo a un JsonArray (manejar caso nulo)
            Optional<JsonArray> optionalJsonArray = parseJsonArray(fileReader);

            // Obtener el JsonArray desde el Optional
            JsonArray jsonArray = optionalJsonArray.orElseGet(JsonArray::new);

            // Agregar el nuevo JsonObject al JsonArray
            jsonArray.add(nuevoObjeto);

            // Configurar Gson con formato legible
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convertir el JsonArray a una cadena JSON formateada
            String jsonString = gson.toJson(jsonArray);

            // Guardar la cadena JSON en el archivo
            try (FileWriter fileWriter = new FileWriter(rutaArchivo)) {
                fileWriter.write(jsonString);
                System.out.println("Nuevo JsonObject agregado sin sobrescribir la información existente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Optional<JsonArray> parseJsonArray(FileReader fileReader) {
    try {
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        if (jsonElement.isJsonArray()) {
            return Optional.of(jsonElement.getAsJsonArray());
        }
    } catch (JsonSyntaxException e) {
        e.printStackTrace();
    }
    return Optional.empty();
}
}
