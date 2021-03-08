/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

/*import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
*/
public class Reponses  /*extends RecursiveTreeObject<Reponses> implements Serializable*/ {
   private int id_r;
    private String text_r;
    private int id_q;
    


    public Reponses() {
    }
public Reponses(int id_r) { this.id_r=id_r;
    }
    public Reponses( int id_r,String text_r, int id_q) {
        this.id_r = id_r;
        this.text_r = text_r;
        this.id_q = id_q;
    }
     public Reponses(String text_r, int id_q) {
        this.text_r = text_r;
        this.id_q = id_q;
    }
     

    public int getId_r() {
        return id_r;
    }
public int getId_q() {
        return id_q;
    }

   
    public String getText_r() {
        return text_r;
    }
public void setId_r(int id_r) {
        this.id_r = id_r;}
        
    public void setId_q(int id_q) {
        this.id_q = id_q;
    }
    public void setText_r(String text_r) {
        this.text_r = text_r;
    }

   

 
    @Override
    public String toString() {
        return "Person{" + "id=" + id_r + ", text_r=" + text_r + ", id de la question associée=" + id_q + '}';
    }

    
    
    
}

