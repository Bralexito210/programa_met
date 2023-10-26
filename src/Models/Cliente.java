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
public class Cliente extends Persona {
    private String dirreccion; // para realizar visitas si se planea ocmo politicas
    private Date fec_nac;
    private int sexo;


    public Cliente(int DNI, String nombre, String apellido, String dirreccion, Date fec_nac, int sexo) {
        super(DNI, nombre, apellido);
        this.dirreccion = dirreccion;
        this.fec_nac = fec_nac;
        this.sexo = sexo;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
    
    
    
}
