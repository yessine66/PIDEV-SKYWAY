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
    private String date_ev;
    private int id_ac;

    public int getId_ac() {
        return id_ac;
    }

    public void setId_ac(int id_ac) {
        this.id_ac = id_ac;
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

    public String getDate_ev() {
        return date_ev;
    }

    public void setDate_ev(String date_ev) {
        this.date_ev = date_ev;
    }

    public Evenement() {
    }

    public Evenement(int id_ev, String nom_ev, String date_ev, int id_ac) {
        this.id_ev = id_ev;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.id_ac = id_ac;
    }

    public Evenement( String nom_ev, String date_ev, int id_ac) {
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.id_ac = id_ac;
    }
    
    public Evenement(int id_ev, String nom_ev, String date_ev) {
        this.id_ev = id_ev;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
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
        return "Evenement{" + "id_ev=" + id_ev + ", nom_ev=" + nom_ev + ", date_ev=" + date_ev + ", id_ac=" + id_ac + '}';
    }
    
    
}
