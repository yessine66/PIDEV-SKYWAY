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
       private String dateD;
         private String dateF;
        private String code_p;
    private int reduction;
    private int id_p;
      private String nom_p;
public Promotion() {
    }

   
    public int getId_p() {
        return id_p;
    }

    public Promotion(String code_p, int reduction, String dateD, String dateF ,int id_p) {
        this.code_p = code_p;
        this.reduction = reduction;
        this.dateD=dateD;
        this.dateF=dateF;
          this.id_p = id_p;
    }

    public Promotion(int id_prom, String code_p, int reduction, String dateD, String dateF  ,int id_p) {
        this.id_prom = id_prom;
        this.code_p = code_p;
        this.reduction = reduction;
           this.id_p = id_p;
        this.dateD=dateD;
          this.dateF=dateF;
        this.id_p = id_p;
    }

    public Promotion(int id_prom, String dateD, String dateF, String code_p, int reduction, int id_p, String nom_p) {
        this.id_prom = id_prom;
        this.dateD = dateD;
        this.dateF = dateF;
        this.code_p = code_p;
        this.reduction = reduction;
        this.id_p = id_p;
        this.nom_p = nom_p;
    }

    public Promotion(int id_prom, String dateD, String dateF, String code_p, int reduction, String nom_p) {
        this.id_prom = id_prom;
        this.dateD = dateD;
        this.dateF = dateF;
        this.code_p = code_p;
        this.reduction = reduction;
        this.nom_p = nom_p;
    }
   //22,rCodepro,rReduction,rdateD,rdateF,rIdpart
 public Promotion(int id_prom, String code_p,int reduction, String dateD, String dateF,  String nom_p) {
        this.id_prom = id_prom;
        this.dateD = dateD;
        this.dateF = dateF;
        this.code_p = code_p;
        this.reduction = reduction;
        this.nom_p = nom_p;
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

    public String getDateD() {
        return dateD;
    }

    public String getDateF() {
        return dateF;
    }

    public String getNom_p() {
        return nom_p;
    }

    
    

   /* @Override
    public String toString() {
        return "Promotion{" + "id_prom=" + id_prom + ", code_p=" + code_p + ", reduction=" + reduction + '}';
    }
    
    
    */

    /*@Override
    public String toString() {
        //return "Promotion{" + "id_prom=" + id_prom +  ", code_p=" + code_p + ", reduction=" + reduction + ", dateD=" + dateD + ", dateF=" + dateF + ", id_p=" + id_p + '}';
        return "Promotion\"              Code promotion="+ code_p +"              reduction="+ reduction +"              Date début promotion="+ dateD +"              Date fin promotion="+ dateF+"              Nom partenaire="+ nom_p;
    }
    */

    @Override
    public String toString() {
        return "Promotion{" + "id_prom=" + id_prom + ", dateD=" + dateD + ", dateF=" + dateF + ", code_p=" + code_p + ", reduction=" + reduction + ", id_p=" + id_p + ", nom_p=" + nom_p + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
