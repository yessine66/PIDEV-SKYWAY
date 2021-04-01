/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author Lenovo
 */
public class partenaire {
    private int id_p;
    private String nom_p;
    private String domaine;
    private String date_p;
     private String mailP;
 private String logoP;
  private ImageView logoPi;
    
    
      public partenaire() {
    }

    public partenaire(int id_p) {
        this.id_p = id_p;
    }

    public partenaire(int id_p, String nom_p, String domaine) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
    }

    public partenaire(String nom_p, String domaine) {
        this.nom_p = nom_p;
        this.domaine = domaine;
    }

    /*public partenaire(int id_p, String nom_p, String domaine, String date_p, String mailP, String logoP) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
        this.mailP = mailP;
        this.logoP = logoP;
    }
*/
    
    

    public int getId_p() {
        return id_p;
    }

    public String getNom_p() {
        return nom_p;
    }

    public String getDomaine() {
        return domaine;
    }

    

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDate_p() {
        return date_p;
    }

    public String getMailP() {
        return mailP;
    }

   
    public void setDate_p(String date_p) {
        this.date_p = date_p;
    }

    public partenaire(int id_p, String nom_p, String domaine, String date_p) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
    }

    public partenaire(String nom_p, String domaine, String date_p) {
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
    }
   /* @Override
    public String toString() {
        return "partenaire{" + "id_p=" + id_p + ", nom_p=" + nom_p + ", domaine=" + domaine + '}';
    }
*/
    /*@Override
    public String toString() {
        return "partenaire{" + "id_p=" + id_p + ", nom_p=" + nom_p + ", domaine=" + domaine + ", date_p=" + date_p + '}';
    }
*/
    public partenaire(String nom_p) {
        this.nom_p = nom_p;
    }

    /*@Override
    public String toString() {
        return "partenaire{" + "nom_p=" + nom_p + ", domaine=" + domaine + ", date_p=" + date_p + '}';
    }
*/
   

    @Override
    public String toString() {
        return "partenaire{" + "id_p=" + id_p + ", nom_p=" + nom_p + ", domaine=" + domaine + ", date_p=" + date_p + ", mailP=" + mailP + '}';
    }

    public partenaire(int id_p, String nom_p, String domaine, String date_p, String mailP, String logoP, ImageView logoPi) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
        this.mailP = mailP;
        this.logoP = logoP;
        this.logoPi = logoPi;
    }

    public partenaire(int id_p, String nom_p, String domaine, String date_p, String mailP, ImageView logoPi) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
        this.mailP = mailP;
        this.logoPi = logoPi;
    }

    public partenaire(int id_p, String nom_p, String domaine, String date_p, String mailP, String logoP) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
        this.mailP = mailP;
        this.logoP = logoP;
    }

    public String getLogoP() {
        return logoP;
    }

    public ImageView getLogoPi() {
        return logoPi;
    }

    public void setMailP(String mailP) {
        this.mailP = mailP;
    }

    public void setLogoP(String logoP) {
        this.logoP = logoP;
    }

    public void setLogoPi(ImageView logoPi) {
        this.logoPi = logoPi;
    }

    public partenaire(String nom_p, String domaine, String date_p, String mailP, String logoP, ImageView logoPi) {
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
        this.mailP = mailP;
        this.logoP = logoP;
        this.logoPi = logoPi;
    }

    public partenaire(int id_p, String nom_p, String domaine, String date_p, String mailP) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.domaine = domaine;
        this.date_p = date_p;
        this.mailP = mailP;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
