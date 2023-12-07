/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author david
 */
public class Tratamiento {
    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private String observaciones;
    private int dni_e;
    private String nombree;
    private List<Operaciones> operaciones;
    private Pago pago;

    public Tratamiento() {
    }

    public Tratamiento(int id, int dni, String nombre, String apellido, String observaciones, int dni_e, String nombree, List<Operaciones> operaciones, Pago pago) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.observaciones = observaciones;
        this.dni_e = dni_e;
        this.nombree = nombree;
        this.operaciones = operaciones;
        this.pago = pago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getDni_e() {
        return dni_e;
    }

    public void setDni_e(int dni_e) {
        this.dni_e = dni_e;
    }

    public String getNombree() {
        return nombree;
    }

    public void setNombree(String nombree) {
        this.nombree = nombree;
    }

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public Pago getPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", observaciones=" + observaciones + ", dni_e=" + dni_e + ", nombree=" + nombree + ", operaciones=" + operaciones + ", pago=" + pago + '}';
    }

    
    
}
