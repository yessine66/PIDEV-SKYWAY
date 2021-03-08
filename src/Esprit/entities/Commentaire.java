/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;
import java.util.Objects;
import javafx.scene.control.TextField;

public class Commentaire {
    private int id_com ,id ;
    String text;
    String destinataire ,date_pub,image;

    public Commentaire(int id_com, String text, String destinataire, String date_pub, String image,int id) {
        this.id_com = id_com;
        this.id = id;
        this.text = text;
        this.destinataire = destinataire;
        this.date_pub = date_pub;
        this.image = image;
    }
    
    public Commentaire(int id_com, String text, String destinataire, String image,int id) {
        this.id_com = id_com;
        this.id = id;
        this.text = text;
        this.destinataire = destinataire;
        this.image = image;
    }

    public Commentaire() {
    }

    public Commentaire( String text, String destinataire,String image ,int id) {
        
        this.text = text;
        this.destinataire = destinataire;
        //this.date_pub = date_pub;
        this.image = image;
        this.id = id;
    }

    public Commentaire(int id, String text, String destinataire, String date_pub) {
        
        this.text = text;
        this.destinataire = destinataire;
        this.date_pub = date_pub;
    }

    public Commentaire(int id, String text, String destinataire) {
        this.id = id;
        this.text = text;
        this.destinataire = destinataire;
    }

    

    public Commentaire(String text, String date, String dest) {
        this.text = text ;
        this.date_pub = date;
        this.destinataire = dest;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Commentaire(String text, String des) {
        this.text = text ;
        this.destinataire = des;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public Commentaire(int idc, String text, String des, String im, int idu) {
       this.id_com = idc;
       this.text = text;
       this.destinataire=des;
       this.image = im ;
       this.id = idu ;
    }*/

    public Commentaire(TextField td_com) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_com=" + id_com + ", id=" + id + ", text=" + text + ", destinataire=" + destinataire + ", date_pub=" + date_pub + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commentaire other = (Commentaire) obj;
        if (this.id_com != other.id_com) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.destinataire, other.destinataire)) {
            return false;
        }
        if (!Objects.equals(this.date_pub, other.date_pub)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
