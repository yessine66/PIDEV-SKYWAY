/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
public class Questions  extends RecursiveTreeObject<Questions> implements Serializable {
   private int id_q;
    private String text_q;
    private int nbr_point;

    public Questions(String name_t) {
        this.name_t = name_t;
    }
  
    private String name_t;


    public String getName_t() {
        return name_t;
    }

    public void setName_t(String name_t) {
        this.name_t = name_t;
    }
    


    public Questions() {
    }

    public Questions(int id_q, String text_q, int nbr_point, String name_t) {
        this.id_q = id_q;
        this.text_q = text_q;
        this.nbr_point = nbr_point;
        this.name_t = name_t;
    }

    public Questions(String text_q, int nbr_point, String name_t) {
        this.text_q = text_q;
        this.nbr_point = nbr_point;
        this.name_t = name_t;
    }

    

    public Questions( int id_q,String text_q, int nbr_point) {
        this.id_q = id_q;
        this.text_q = text_q;
        this.nbr_point = nbr_point;
    }
    public Questions( int id_q) {
        this.id_q = id_q;
        
    }
     public Questions(String text_q, int nbr_point) {
        this.text_q = text_q;
        this.nbr_point = nbr_point;
    }
     

    public int getId_q() {
        return id_q;
    }

   
    public String getText_q() {
        return text_q;
    }
public void setId_q(int id_q) {
        this.id_q = id_q;
    }
    public void setText_q(String text_q) {
        this.text_q = text_q;
    }

    public int getNbr_point() {
        return nbr_point;
    }

    public void setNbr_point(int nbr_point) {
        this.nbr_point = nbr_point;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id_q + ", text_q=" + text_q + ", nombre de points=" + nbr_point + '}';
    }

   
    
    
    
}
