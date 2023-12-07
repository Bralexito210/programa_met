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

    public Empleado( int DNI,String nombre,String apellido,String contraseña,String cargo) {
        super(DNI,nombre,apellido);
        this.contraseña = contraseña;
        this.cargo = cargo;
    }
    public Empleado() {
    }
    

    public int getCodigo() {
        return codigo;
    }

    public String getCargo() {
        return cargo;
    }
    public String getnombre() {
        return super.getNombre();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("codigo=").append(codigo);
        sb.append(", cargo=").append(cargo);
        sb.append(", estado=").append(estado);
        sb.append(", codD=").append(codD);
        sb.append(", contrase\u00f1a=").append(contraseña);
        sb.append('}');
        return sb.toString();
    }


    
    
    
    
    
}
