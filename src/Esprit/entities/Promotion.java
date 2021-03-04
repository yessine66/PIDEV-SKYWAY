/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

/**
 *
 * @author Lenovo
 */
public class Promotion {
    
     private int id_prom;
    private String code_p;
    private int reduction;

    public Promotion() {
    }

    public Promotion(int id_prom, String code_p, int reduction) {
        this.id_prom = id_prom;
        this.code_p = code_p;
        this.reduction = reduction;
    }

    public Promotion(int id_prom) {
        this.id_prom = id_prom;
    }

    public int getId_prom() {
        return id_prom;
    }

    public String getCode_p() {
        return code_p;
    }

    public int getReduction() {
        return reduction;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_prom=" + id_prom + ", code_p=" + code_p + ", reduction=" + reduction + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
