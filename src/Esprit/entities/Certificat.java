/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.io.Serializable;

  import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 *
 * @author User-DELL
 */
public class Certificat  extends RecursiveTreeObject<Certificat> implements Serializable {
   private int id_certif;
    private String titre_certif;
    private String date_certif;
    
    public Certificat() {
    }

    public Certificat( int id_certif,String titre_certif, String date_certif) {
        this.id_certif = id_certif;
        this.titre_certif = titre_certif;
        this.date_certif = date_certif;
    }
     public Certificat(String titre_certif, String date_certif) {
        this.titre_certif = titre_certif;
        this.date_certif = date_certif;
    }
     

    public int getId_certif() {
        return id_certif;
    }

   
    public String getTitre_certif() {
        return titre_certif;
    }
public void setId_certif(int id_certif) {
        this.id_certif = id_certif;
    }
    public void setTitre_certif(String titre_certif) {
        this.titre_certif = titre_certif;
    }

    public String getDate_certif() {
        return date_certif;
    }

    public void setDate_certif(String date_certif) {
        this.date_certif = date_certif;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id_certif + ", titre_certif=" + titre_certif + ", date de certification=" + date_certif + '}';
    }

    
    
    
}


