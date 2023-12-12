/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Cita;
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
public final class CitaDao {
    private Cita cit = new Cita();
    private ArrayList<Persona>cita;
    private String Archivo;//Nombre del archivo
    public CitaDao(String Archivo){
        cita=new ArrayList<Persona>();
        this.Archivo=Archivo;
        cargar();
    }
    
    
    public void grabar(){
        try{
            PrintWriter pw;
            String linea ;
            pw = new PrintWriter(new FileWriter(Archivo));
            //id, id_empleado, id_cliente, nombre, apellido, motivo, fecha, hora.
            //int idCita, int dniE,int DNI, String nombre, String apellido, String motivo, String fecha, String hora
            for(int i=0;i<tamaño();i++){
                linea=(
                       ((Cita)obtener(i)).getIdCita()+";"+
                       ((Cita)obtener(i)).getDniE()+ ";" +
                       obtener(i).getDNI()+ ";" +
                       obtener(i).getNombre()+ ";" + 
                       obtener(i).getApellido()+ ";" +
                       ((Cita)obtener(i)).getMotivo()+ ";" +
                       ((Cita)obtener(i)).getFecha()+ ";" +
                       ((Cita)obtener(i)).getHora()
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
                Persona c= new Cita(Integer.parseInt(array[0].trim()),
                Integer.parseInt(array[1].trim()),
                Integer.parseInt(array[2].trim()),
                array[3].trim(),
                array[4].trim(),
                array[5].trim(),
                array[6].trim(),
                array[7].trim());
                adicionar(c);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void adicionar (Persona c){
        cita.add(c);
    }
    public Persona obtener(int i){
        return cita.get(i);
    }
    //Eliminar un objeto
    public void eliminar(Persona c){
        cita.remove(c);
    }
    public int tamaño(){
        return cita.size();
    }

    public Persona buscarCita(int idcita){
        for(int i=0;i<tamaño();i++){
            if( ((Cita)obtener(i)).getIdCita()  == idcita)
                return cita.get(i);
        }
        return null;
    }
    public int getCorrelativo(){
        //Arraylist vacio
        if (tamaño()==0)
            return 1;
        else{
            Persona cita=obtener(tamaño() - 1);
            int tam = new Integer(((Cita)cita).getIdCita());
            return tam+1;
        }
    }
}
