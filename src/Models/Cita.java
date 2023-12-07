/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author david
 */
public class Cita extends Persona {
    //id, id_empleado, id_cliente, nombre, apellido, motivo, fecha, hora.
    private int idCita;
    private int dniE;
    private String motivo;
    private String fecha;
    private String hora;

    public Cita() {
    }

    public Cita(int idCita, int dniE,int DNI, String nombre, String apellido, String motivo, String fecha, String hora) {
        super(DNI, nombre, apellido);
        this.idCita = idCita;
        this.dniE = dniE;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String anio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(super.getAnio(), formatter);
        return localDate+"";
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getDniE() {
        return dniE;
    }

    public void setDniE(int dniE) {
        this.dniE = dniE;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", dniE=" + dniE + ", motivo=" + motivo + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
    
    
    
}
