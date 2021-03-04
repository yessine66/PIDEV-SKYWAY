/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

/**
 *
 * @author User-DELL
 */

  import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;

/**
 *
 * @author User-DELL
 */
public class Certificat  extends RecursiveTreeObject<Certificat> implements Serializable {
   private int id_certif;
    private String titre_certif;
    private date date_certif;
    


    public Certificat() {
    }

    public Certificat( int id_certif,String titre_certif, int date_certif) {
        this.id_certif = id_certif;
        this.titre_certif = titre_certif;
        this.date_certif = date_certif;
    }
     public Certificat(String titre_certif, int date_certif) {
        this.titre_certif = titre_certif;
        this.date_certif = date_certif;
    }
     

    public int getId_q() {
        return id_certif;
    }

   
    public String getText_q() {
        return titre_certif;
    }
public void setId_q(int id_certif) {
        this.id_certif = id_certif;
    }
    public void setText_q(String titre_certif) {
        this.titre_certif = titre_certif;
    }

    public int getNbr_point() {
        return date_certif;
    }

    public void setNbr_point(int date_certif) {
        this.date_certif = date_certif;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id_certif + ", titre_certif=" + titre_certif + ", nombre de points=" + date_certif + '}';
    }

    
    
    
}

}
