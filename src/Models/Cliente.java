/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author david
 */
public class Cliente extends Persona {
    private String dirreccion; // para realizar visitas si se planea ocmo politicas
    private String sexo;

    //{"Codigo","DNI","Nombres","Apellido","dirreccion","sexo"}
    public Cliente(int DNI, String nombre, String apellido,String anio, String dirreccion, String sexo) {
        super(DNI, nombre, apellido,anio);
        this.dirreccion = dirreccion;
        this.sexo = sexo;
    }
    public Cliente(int DNI, String nombre, String apellido) {
        super(DNI, nombre, apellido);
    }

    public Cliente() {
    }


    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String anio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(super.getAnio(), formatter);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(localDate, ahora);
        return periodo.getYears()+"";
    }
    
    
    
}
