/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author david
 */
public class Empleado extends Persona {
    private int codigo;
    private String cargo;
    private Date fec_inil; //
    private int estado;
    private String contraseña;

    public Empleado(int DNI, String nombre, String apellido, int codigo, String cargo, Date fec_inil, int estado, String contraseña) {
        super(DNI, nombre, apellido);
        this.codigo = codigo;
        this.cargo = cargo;
        this.fec_inil = fec_inil;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public Date getFec_inil() {
        return fec_inil;
    }

    public int getEstado() {
        return estado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFec_inil(Date fec_inil) {
        this.fec_inil = fec_inil;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
}
