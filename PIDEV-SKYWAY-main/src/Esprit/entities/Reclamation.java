/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.util.Objects;

public class Reclamation {
      private int id ,id_rec;
    private String text;
    private String objet;
    private String date_env;

    public Reclamation() {
    }

    public Reclamation(int id_rec, String objet, String text) {
        this.id_rec = id_rec;
        this.text = text;
        this.objet = objet;
    }
    public Reclamation(String text, String objet) {
        this.text = text;
        this.objet = objet;
    }

    public Reclamation( int id_rec, String text, String objet,int id) {
        this.id = id;
        this.id_rec = id_rec;
        this.text = text;
        this.objet = objet;
    }

    public Reclamation( int id_rec, String text, String objet, String date_env,int id) {
        this.id = id;
        this.id_rec = id_rec;
        this.text = text;
        this.objet = objet;
        this.date_env = date_env;
    }

    public Reclamation( String text, String objet, String date_env,int id) {
        this.id = id;
        this.text = text;
        this.objet = objet;
        this.date_env = date_env;
    }

    public Reclamation(int id, String text, String objet, String date_env) {
        this.id = id;
        this.text = text;
        this.objet = objet;
        this.date_env = date_env;
    }

    public Reclamation(Integer valueOf, String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getDate_env() {
        return date_env;
    }

    public void setDate_env(String date_env) {
        this.date_env = date_env;
    }
    

   /* @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", text=" + text + ", objet=" + objet + '}';
    }*/
    

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", id_rec=" + id_rec + ", text=" + text + ", objet=" + objet + ", date_env=" + date_env + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Reclamation other = (Reclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        return true;
    }
 
   
}
