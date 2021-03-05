/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author simop
 */
public class theme {
    
    private int id_t;
    private String nom_t;
    private int id;
    
    
     public theme() {
    }

    public theme(int id_t, String nom_t, int id) {
        this.id_t = id_t;
        this.nom_t = nom_t;
        this.id = id;
    }

    public theme(int id_t, String nom_t) {
        this.id_t = id_t;
        this.nom_t = nom_t;
    }

    public theme(String nom_t) {
        this.nom_t = nom_t;
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public String getNom_t() {
        return nom_t;
    }

    public void setNom_t(String nom_t) {
        this.nom_t = nom_t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_t;
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
        final theme other = (theme) obj;
        if (this.id_t != other.id_t) {
            return false;
        }
        if (!Objects.equals(this.nom_t, other.nom_t)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theme{" + "id_t=" + id_t + ", nom_t=" + nom_t + ", id=" + id + '}';
    }
    
    
    

   
    
}
