/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;


public class Empleado extends Persona {
    private int codigo;
    private String cargo;
    private int estado;
    private int codD;
    private String contraseña;

    public Empleado(int DNI, String nombre, String apellido,String anio, int codigo, String cargo, int estado,int codD, String contraseña) {
        super(DNI, nombre, apellido,anio);
        this.codigo = codigo;
        this.cargo = cargo;
        this.estado = estado;
        this.codD = codD;
        this.contraseña = contraseña;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCargo() {
        return cargo;
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


    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCodD() {
        return codD;
    }

    public void setCodD(int codD) {
        this.codD = codD;
    }

    @Override
    public String anio() {
        return super.getAnio();
    }
    
    
    
    
    
}
