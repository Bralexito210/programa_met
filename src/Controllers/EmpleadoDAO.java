/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Empleado;
import Models.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class EmpleadoDAO {
    private ArrayList<Persona>emp;
    private String Archivo;//Nombre del archivo
    public EmpleadoDAO(String Archivo){
        emp=new ArrayList<Persona>();
        this.Archivo=Archivo;
        cargar();
    }
    public EmpleadoDAO(int log){
        emp=new ArrayList<Persona>();
        this.Archivo="Empleado.txt";
        cargarlog();
    }
    

    public void adicionar (Persona c){
        emp.add(c);
    }
    public Persona obtener(int i){
        return emp.get(i);
    }
    //Eliminar un objeto
    public void eliminar(Persona c){
        emp.remove(c);
    }
    public int tamaño(){
        return emp.size();
    }
    
    public Persona buscarCliente(int dni){
        for(int i=0;i<tamaño();i++){
            if(emp.get(i).getDNI()== dni)
                return emp.get(i);
        }
        return null;
    }
    public int buscarDNI(int dni){
        for(int i=0;i<tamaño();i++){
            if(emp.get(i).getDNI()== dni)
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
                        ((Empleado)obtener(i)).getCodigo()+ ";" +
                        ((Empleado)obtener(i)).getCargo()+ ";" +
                        ((Empleado)obtener(i)).getEstado()+ ";" +
                        ((Empleado)obtener(i)).getCodD()+ ";" +
                        ((Empleado)obtener(i)).getContraseña()
                        );
                pw.println(linea);
            }
            pw.close();
        }catch(IOException e){
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
                Persona c= new Empleado(
                Integer.parseInt(array[0].trim()),
                array[1].trim(),
                array[2].trim(),
                array[3].trim(),
                Integer.parseInt(array[4].trim()),
                array[5].trim(),
                Integer.parseInt(array[6].trim()),
                Integer.parseInt(array[7].trim()),
                array[8].trim()       
                );
                adicionar(c);
            }
            br.close();
        }catch(IOException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
    public void cargarlog(){
        try{
            BufferedReader br;
            String linea=null;
            String[] array=null;
            br = new BufferedReader(new FileReader (Archivo));
            while((linea= br.readLine())!=null){
                array=linea.split(";");
                Persona c= new Empleado(
                Integer.parseInt(array[0].trim()),
                array[1].trim(),
                array[2].trim(),
                array[8].trim(),
                array[5].trim()
                );
                //dni, nombre, ape,contra,cargo
                adicionar(c);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
