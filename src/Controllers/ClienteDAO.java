/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Cliente;
import Models.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author david
 */
public class ClienteDAO {
    private ArrayList<Persona>clie;
    private String Archivo;//Nombre del archivo
    
    public ClienteDAO(String Archivo){
        clie=new ArrayList<Persona>();
        this.Archivo=Archivo;
        cargar();
    }
    public void adicionar (Persona c){
        clie.add(c);
    }
    public Persona obtener(int i){
        return clie.get(i);
    }
    //Eliminar un objeto
    public void eliminar(Persona c){
        clie.remove(c);
    }
    public int tamaño(){
        return clie.size();
    }
    
    public Persona buscarCliente(int dni){
        for(int i=0;i<tamaño();i++){
            if(clie.get(i).getDNI()== dni)
                return clie.get(i);
        }
        return null;
    }
    public int buscarDNI(int dni){
        for(int i=0;i<tamaño();i++){
            if(clie.get(i).getDNI()== dni)
                return i;
        }
        return -1;
    }
    public int getCorrelativo(){
        //Arraylist vacio
        if (tamaño()==0)
            return 1;
        else{
            return tamaño()+1;
        }
    }
    public void grabar(){
        try{
            PrintWriter pw;
            String linea ;
            pw = new PrintWriter(new FileWriter(Archivo));
            
            for(int i=0;i<tamaño();i++){
                linea=(obtener(i).getDNI()+ ";" +
                       obtener(i).getNombre()+ ";" + 
                        obtener(i).getApellido()+ ";" +
                        obtener(i).getAnio()+ ";" +
                        ((Cliente)obtener(i)).getDirreccion()+ ";" +
                        ((Cliente)obtener(i)).getSexo()
                        );
                pw.println(linea);
            }
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void cargar(){
        try{
            BufferedReader br;
            String linea=null;
            String[] array=null;
            br = new BufferedReader(new FileReader (Archivo));
            while((linea= br.readLine())!=null){
                array=linea.split(";");
                Persona c= new Cliente(Integer.parseInt(array[0].trim()),
                array[1].trim(),
                array[2].trim(),
                array[3].trim(),
                array[4].trim(),
                array[5].trim());
                adicionar(c);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
