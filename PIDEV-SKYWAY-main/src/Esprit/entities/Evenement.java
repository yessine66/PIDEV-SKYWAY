/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.sql.Date;

/**
 *
 * @author khouja safa
 */
public class Evenement {
    private int id_ev;
    private String nom_ev;
    private Date date_ev;
    private String espace;
    private int nombre_pl;
    private int id;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    public Date getDate_ev() {
        return date_ev;
    }

    public void setDate_ev(Date date_ev) {
        this.date_ev = date_ev;
    }

    public String getEspace() {
        return espace;
    }

    public void setEspace(String espace) {
        this.espace = espace;
    }

    public int getNombre_pl() {
        return nombre_pl;
    }

    public void setNombre_pl(int nombre_pl) {
        this.nombre_pl = nombre_pl;
    }

    public Evenement() {
    }

    public Evenement(int id_ev, String nom_ev, Date date_ev, int id_ac) {
        this.id_ev = id_ev;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.id = id_ac;
    }

    public Evenement( String nom_ev, Date date_ev, int id) {
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.id = id;
    }
    
    public Evenement(int id_ev, String nom_ev, Date date_ev) {
        this.id_ev = id_ev;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
    }

    public Evenement(int id_ev, String nom_ev, Date date_ev, String espace, int nombre_pl, int id) {
        this.id_ev = id_ev;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.espace = espace;
        this.nombre_pl = nombre_pl;
        this.id = id;
    }
    public Evenement(String nom_ev, Date date_ev, String espace, int nombre_pl, int id) {
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.espace = espace;
        this.nombre_pl = nombre_pl;
        this.id = id;
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
        final Evenement other = (Evenement) obj;
        if (this.id_ev != other.id_ev) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_ev=" + id_ev + ", nom_ev=" + nom_ev + ", date_ev=" + date_ev + ", espace=" + espace + ", nombre_pl=" + nombre_pl + ", id_ac=" + id + '}';
    }

    
    
    
}
