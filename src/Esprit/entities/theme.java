/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.util.Objects;
import javafx.scene.image.ImageView;

/**
 *
 * @author simop
 */
public class theme {
    
    private int id_t;
    private String nom_t;
    private String image ;
    private ImageView photo;
    private int id;
    
    
     public theme() {
    }

    public theme(int id_t, String nom_t,String image, ImageView photo, int id) {
        this.id_t = id_t;
        this.nom_t = nom_t;
        this.image = image;
        this.photo = photo;
        this.id = id;
    }

    public theme(int id_t, String nom_t,String image, ImageView photo) {
        this.id_t = id_t;
        this.nom_t = nom_t;
         this.image = image;
        this.photo = photo;
    }

    public theme(String nom_t,String image, ImageView photo) {
        this.nom_t = nom_t;
        this.image = image;
        this.photo = photo;
    }

    public theme(int id_t, String nom_t, String image,int id) {
        this.id_t = id_t;
        this.nom_t = nom_t;
        this.image = image;
        this.id = id;
       }

    public theme(String nom_t, String image) {
        this.nom_t = nom_t;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
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
       // return "theme{" + "id_t=" + id_t + ", nom_t=" + nom_t + ", id=" + id + '}';
       return "titre de théme : " + nom_t ;

    }
    
    
    

   
    
}
