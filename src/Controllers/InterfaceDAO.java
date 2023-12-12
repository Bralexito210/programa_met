/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers;

/**
 *
 * @author david
 */
public interface InterfaceDAO {
     public void adicionar (Object c);
     public Object obtener(int i);
     public void eliminar(Object c);
     public int tamaño();
     public Object buscarCliente(int i);
     public void grabar();
     public void cargar();
}
