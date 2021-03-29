/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.util.Objects;

/**
 *
 * @author khouja safa
 */
public class Actualite {
    private int id_ac;
    private String titre_ac;
    private String desc;
    private String image_ac;
    private String nom_ev;
    private int user;

    public Actualite(int id_ac, String titre_ac, String desc, String image_ac, int user) {
        this.id_ac = id_ac;
        this.titre_ac = titre_ac;
        this.desc = desc;
        this.image_ac = image_ac;
        this.user = user;
    }

    public int getId_ac() {
        return id_ac;
    }

    public void setId_ac(int id_ac) {
        this.id_ac = id_ac;
    }

    public String getTitre_ac() {
        return titre_ac;
    }

    public void setTitre_ac(String titre_ac) {
        this.titre_ac = titre_ac;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage_ac() {
        return image_ac;
    }

    public void setImage_ac(String image_ac) {
        this.image_ac = image_ac;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Actualite() {
    }

    public Actualite(int id_ac,String titre_ac, String desc) {
        this.id_ac = id_ac;
        this.titre_ac = titre_ac;
        this.desc = desc;
    }
    
    public Actualite(int id_ac,String titre_ac, String desc, String image_ac) {
        this.id_ac = id_ac;
        this.titre_ac = titre_ac;
        this.desc = desc;
        this.image_ac = image_ac;
    }

    public Actualite( String titre_ac, String desc, String image_ac, int user) {
        //this.id_ac = id_ac;
        this.titre_ac = titre_ac;
        this.desc = desc;
        this.image_ac = image_ac;
        this.user = user;
    }
    public Actualite(String titre_ac, String desc, String image_ac, String evenement,int user) {
        this.titre_ac = titre_ac;
        this.desc = desc;
        this.image_ac = image_ac;
        this.user = user;
    }

    public Actualite(int id_ac, String titre_ac, String desc, String image_ac, String evenement,int user) {
        this.id_ac = id_ac;
        this.titre_ac = titre_ac;
        this.desc = desc;
        this.image_ac = image_ac;
        this.nom_ev= evenement;
        this.user = user;
    }

    @Override
    public String toString() {
        return  titre_ac + " : " +
                desc + " " +
                image_ac + /*", nom_ev=" +
                nom_ev +*/ '}';
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
        final Actualite other = (Actualite) obj;
        if (this.id_ac != other.id_ac) {
            return false;
        }
        if (!Objects.equals(this.titre_ac, other.titre_ac)) {
            return false;
        }
        return true;
    }
    
   
}
