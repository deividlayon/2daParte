/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import informacion.convertir;
import informacion.datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tesoem
 */
public class archivos {
    List<datos> contenido = new ArrayList<>();

    public List<datos> Leer(){
        String linea;
        datos Datos;
        try{
        FileReader archivo = new FileReader("Datos.txt");
        BufferedReader br = new BufferedReader(archivo);
        while ((linea = br.readLine()) != null){
            Datos = new datos();
            convertir convertir = new convertir();
            Datos = convertir.aclase(linea);
            contenido.add(Datos);
        }
    }catch (FileNotFoundException ex) {
                ex.printStackTrace();
           } catch (IOException ex) {
                ex.printStackTrace();
           }
            
        return contenido;
    }
    
    public boolean Grabar(datos cadena){
        convertir Convertir = new convertir();
        boolean estado = true;
        try {
        FileWriter archivo = new FileWriter("Datos.txt", true);
        BufferedWriter bw = new BufferedWriter(archivo);
        bw.write(Convertir.ajson(cadena)+"\n");
        bw.close();
        archivo.close();
        
        }catch (IOException ex) {
            ex.printStackTrace();
            estado = false;
        }
        return estado;
    }
}
