/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;


import java.sql.Date;
import java.util.Objects;
import javafx.scene.image.ImageView;




/**
 *
 * @author asus
 */
public class cours {
    private int id_c;
    private String nom_c ;
    private int numero;
    private String description ;
    private int duree;
    private String image ;
    private ImageView photo;
    private int id_t;
    private int id;

    public cours(int id_c, String nom_c, int numero, String description, int duree, String image, ImageView photo, int id_t, int id) {
        this.id_c = id_c;
        this.nom_c = nom_c;
        this.numero = numero;
        this.description = description;
        this.duree = duree;
        this.image = image;
        this.photo = photo;
        this.id_t = id_t;
        this.id = id;
    }

    public cours(String nom_c, int numero, String description, int duree, String image, ImageView photo, int id_t, int id) {
        this.nom_c = nom_c;
        this.numero = numero;
        this.description = description;
        this.duree = duree;
        this.image = image;
        this.photo = photo;
        this.id_t = id_t;
        this.id = id;
    }

    public cours(String nom_c, int numero, String description, int duree, String image, ImageView photo) {
        this.nom_c = nom_c;
        this.numero = numero;
        this.description = description;
        this.duree = duree;
        this.image = image;
        this.photo = photo;
    }

    public cours(int id_c, String nom_c, int numero, String description, int duree, String image, ImageView photo) {
        this.id_c = id_c;
        this.nom_c = nom_c;
        this.numero = numero;
        this.description = description;
        this.duree = duree;
        this.image = image;
        this.photo = photo;
    }

    public cours(int id_c, String nom_c, int numero, String description, int duree, String image, int id_t) {
        this.id_c = id_c;
        this.nom_c = nom_c;
        this.numero = numero;
        this.description = description;
        this.duree = duree;
        this.image = image;
        this.id_t = id_t;
    }

    public cours(String nom_c, int numero, String description, int duree, String image, int id_t) {
        this.nom_c = nom_c;
        this.numero = numero;
        this.description = description;
        this.duree = duree;
        this.image = image;
        this.id_t = id_t;
    }

  
    

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getNom_c() {
        return nom_c;
    }

    public void setNom_c(String nom_c) {
        this.nom_c = nom_c;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
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

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_c;
        hash = 89 * hash + Objects.hashCode(this.nom_c);
        hash = 89 * hash + this.numero;
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + this.duree;
        hash = 89 * hash + Objects.hashCode(this.image);
        hash = 89 * hash + Objects.hashCode(this.photo);
        hash = 89 * hash + this.id_t;
        hash = 89 * hash + this.id;
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
        final cours other = (cours) obj;
        if (this.id_c != other.id_c) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.duree != other.duree) {
            return false;
        }
        if (this.id_t != other.id_t) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom_c, other.nom_c)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "titre de cours=" + nom_c + ", numero=" + numero + ", description=" + description + ", duree=" + duree + ", photo=" + photo ; //+ ", id_t=" + id_t + ", id=" + id + '}';
    }
 
 
    
    
}
