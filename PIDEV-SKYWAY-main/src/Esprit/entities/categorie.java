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
public class categorie {
    private int id_categorie;
    private String nom_categorie;
    private String image ;
    private ImageView photo;
    private int id_t;

    public categorie(int id_categorie, String nom_categorie,String image, ImageView photo, int id_t) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.image = image;
        this.photo = photo;
        this.id_t = id_t;
    }
    public categorie(int id_categorie, String nom_categorie,String image, int id_t) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.image = image;
        this.id_t = id_t;
    }

    public categorie(int id_categorie, String nom_categorie,String image, ImageView photo) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.image = image;
        this.photo = photo;
    }

    public categorie(String nom_categorie,String image, ImageView photo) {
        this.nom_categorie = nom_categorie;
        this.image = image;
        this.photo = photo;
    }
    public categorie(String nom_categorie,String image) {
        this.nom_categorie = nom_categorie;
        this.image = image;
        
    }

    public categorie(String nom_categorie, String image, int id_t) {
        this.nom_categorie = nom_categorie;
        this.image = image;
        this.id_t = id_t;
    }
    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_categorie;
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
        final categorie other = (categorie) obj;
        if (this.id_categorie != other.id_categorie) {
            return false;
        }
        if (!Objects.equals(this.nom_categorie, other.nom_categorie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Titre de categorie=" + nom_categorie ; //", id_t=" + id_t + '}';
    }

    
}
