/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

/**
 *
 * @author Lenovo
 */
public class partenaire {
    private int id_p;
    private String nom_p;
    private String domaine;
    private String date_p;
    
    
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

    @Override
    public String toString() {
        return "partenaire{" + "nom_p=" + nom_p + ", domaine=" + domaine + ", date_p=" + date_p + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}