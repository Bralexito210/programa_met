/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author david
 */
public class Pago {
   private double desc;
   private double subT;
   private double igv;
   private double Total;

    public Pago() {
    }

    public Pago(double desc, double pago) {
        this.desc = vista(desc);
        this.subT = vista(pago*0.82);
        this.igv = vista(pago*0.18);
        this.Total = (this.subT+this.igv)-this.desc;
    }
    
   
    private double vista(double num){
        BigDecimal formatNumber = new BigDecimal(num);
       formatNumber = formatNumber.setScale(4, RoundingMode.DOWN);
       return formatNumber.doubleValue();
   }

    @Override
    public String toString() {
        return "Pago{ desc=" + desc + ", subT=" + subT + ", igv=" + igv + ", Total=" + Total + '}';
    }
   
}
