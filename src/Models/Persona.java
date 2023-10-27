/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author david
 */
public abstract class Persona {
    private  int DNI;
    private  String nombre;
    private  String apellido;
    private  String anio;
  
    public Persona(int DNI, String nombre, String apellido,String anio) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anio = anio;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    public abstract String anio();
    
 }