/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.util.Objects;

/**
 *
 * @author IBTIHEL
 */
public class Reclamation {
      private int id ,id_rec;
    private String text_r;
    private String objet;
    private String date_envoi;
    private String cours ;
    private String enseignant;

    public Reclamation() {
    }

    public Reclamation(int id_rec, String objet, String text_r) {
        this.id_rec = id_rec;
        this.text_r = text_r;
        this.objet = objet;
    }
    public Reclamation(String text_r, String objet) {
        this.text_r = text_r;
        this.objet = objet;
    }

    public Reclamation( int id_rec, String text_r, String objet,int id) {
        this.id = id;
        this.id_rec = id_rec;
        this.text_r = text_r;
        this.objet = objet;
    }

    public Reclamation( int id_rec, String text_r, String objet, String date_envoi,int id) {
        this.id = id;
        this.id_rec = id_rec;
        this.text_r = text_r;
        this.objet = objet;
        this.date_envoi = date_envoi;
    }

    public Reclamation( String text_r, String objet, String date_env,int id) {
        this.id = id;
        this.text_r = text_r;
        this.objet = objet;
        this.date_envoi = date_env;
    }

    public Reclamation(int id, String text_r, String objet, String date_env) {
        this.id = id;
        this.text_r = text_r;
        this.objet = objet;
        this.date_envoi = date_env;
    }

    public Reclamation( /*int id_rec,*/ String objet, String text_r, String date_env,int id, String cours, String enseignant) {
        this.id = id;
        this.id_rec = id_rec;
        this.text_r = text_r;
        this.objet = objet;
        this.date_envoi = date_env;
        this.cours = cours;
        this.enseignant = enseignant;
    }
     public Reclamation( int id_rec, String objet, String text_r, String date_env,int id, String cours, String enseignant) {
        this.id = id;
        this.id_rec = id_rec;
        this.text_r = text_r;
        this.objet = objet;
        this.date_envoi = date_env;
        this.cours = cours;
        this.enseignant = enseignant;
    }

    
    /*public Reclamation(Integer valueOf, String text_r, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText_r() {
        return text_r;
    }

    public void setText_r(String text_r) {
        this.text_r = text_r;
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

    public String getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(String date_envoi) {
        this.date_envoi = date_envoi;
    }
    

   /* @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", text_r=" + text_r + ", objet=" + objet + '}';
    }*/

    @Override
    public String toString() {
        return "Reclamation{, id_rec=" + id_rec + ", objet=" + objet +", text=" + text_r +  ", date_env=" + date_envoi +  "id=" + id +", cours=" + cours + ", enseignant=" + enseignant + '}';
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
        if (!Objects.equals(this.text_r, other.text_r)) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        return true;
    }
 
    
}
