/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author david
 */
public class Operaciones {
    private String cod;
    private String nombre;
    private int diente;
    private double pago;
    
    public Operaciones() {
    }

    public Operaciones(String cod, String nombre, int diente, double pago) {
        this.cod = cod;
        this.nombre = nombre;
        this.diente = diente;
        this.pago = pago;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiente() {
        return diente;
    }

    public void setDiente(int diente) {
        this.diente = diente;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Operaciones{" + "cod=" + cod + ", nombre=" + nombre + ", diente=" + diente + ", pago=" + pago + '}';
    }
    
    
}
