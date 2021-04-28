/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

public class Reponses  extends RecursiveTreeObject<Reponses> implements Serializable {
   private int id_r;
    private String text_r1;
   private String text_r2;
   private String text_r3;
   private String text_r4;
    private Questions id_q;
    private int id;


    public Reponses() {
    }
public Reponses(int id_r)
{ this.id_r=id_r;
    }
    public Reponses( int id_r,String text_r1, String text_r2,String text_r3,String text_r4, Questions id_q,int id) {
        this.id_r = id_r;
        this.text_r1 = text_r1;
       this.text_r2 = text_r2 ;
        this.text_r3 = text_r3;
        this.text_r4 = text_r4;
        this.id_q = id_q;
        this.id=id;
    }
     public Reponses(String text_r1, String text_r2,String text_r3,String text_r4, Questions id_q,int id) {
  this.text_r1 = text_r1;
       this.text_r2 = text_r2 ;
        this.text_r3 = text_r3;
        this.text_r4 = text_r4;
        this.id_q = id_q;
        this.id=id;
    }

    public void setText_r2(String text_r2) {
        this.text_r2 = text_r2;
    }

    public void setText_r3(String text_r3) {
        this.text_r3 = text_r3;
    }

    public void setText_r4(String text_r4) {
        this.text_r4 = text_r4;
    }
     

    public int getId_r() {
        return id_r;
    }
public Questions getId_q() {
        return id_q;
    }

   
    public String getText_r1() {
        return text_r1;
    }
     public String getText_r2() {
        return text_r2;
    }
      public String getText_r3() {
        return text_r3;
    }
     public String getText_r4() {
        return text_r4;
    }
public void setId_r(int id_r) {
        this.id_r = id_r;}
        
    public void setId_q(Questions id_q) {
        this.id_q = id_q;
    }
    public void setText_r1(String text_r1) {
        this.text_r1 = text_r1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

 
    @Override
    public String toString() {
        return "Person{" + "id=" + id_r + ", Réponse1 =" + text_r1 + ", Réponse2 =" + text_r2 + ", Réponse3 =" + text_r3 + ", Réponse3 =" + text_r3 + ", Réponse 4=" + text_r4 + ", id de la question associée=" + id_q + '}';
    }

    
    
    
}

