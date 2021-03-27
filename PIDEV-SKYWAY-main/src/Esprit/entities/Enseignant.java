/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

/**
 *
 * @author mega-pc
 */
public class Enseignant extends Utilisateur{
   
    
    private String matier;
    private String text;
    private String specialite;
    private int idEnseignant;
private int id; 
    public Enseignant() {
        
    }

    public Enseignant(int id) {
        this.id = id;
    }
    
    

    public Enseignant(String matier, String text, String specialite) {
        this.matier = matier;
        this.text = text;
        this.specialite = specialite;
    }

    public Enseignant(String matier, String text, String specialite, int id) {
        this.matier = matier;
        this.text = text;
        this.specialite = specialite;
        this.id = id;
    }

    public Enseignant( String matier, String text, String specialite, int idEnseignant,int id ) {
       
        
        this.matier = matier;
        this.text = text;
        this.specialite = specialite;
        this.idEnseignant = idEnseignant;
        this.id = id;
    }

    public Enseignant(int idEnseignant, String text, String specialite, int id) {
        this.idEnseignant = idEnseignant;
        this.text = text;
        this.specialite = specialite;
        this.id = id;
    }

 /*   public Enseignant(int idEnseignant, String text, String specialite, int id, int idUser) {
        super(idUser);
        this.idEnseignant = idEnseignant;
        this.text = text;
        this.specialite = specialite;
        this.id = id;
    }
*/
    public Enseignant(int idEnseignant, String text, String specialite, int id, String nomUser, String prenomUser, String mailUser, int ageUser, int telUser, String genreUser, String dateDeNaissanceUser, String usernameUser, String passwordUser, String roleUser, String dateDeCreationCompteUser) {
        super(nomUser, prenomUser, mailUser, ageUser, telUser, genreUser, dateDeNaissanceUser, usernameUser, passwordUser, roleUser, dateDeCreationCompteUser);
        this.idEnseignant = idEnseignant;
        this.text = text;
        this.specialite = specialite;
        this.id = id;
    }

    public Enseignant(int idEnseignant, String text, String specialite, int id, int idUser, String nomUser, String prenomUser, String mailUser, int ageUser, int telUser, String genreUser, String dateDeNaissanceUser, String usernameUser, String passwordUser, String roleUser, String dateDeCreationCompteUser) {
        super(idUser, nomUser, prenomUser, mailUser, ageUser, telUser, genreUser, dateDeNaissanceUser, usernameUser, passwordUser, roleUser, dateDeCreationCompteUser);
        this.idEnseignant = idEnseignant;
        this.text = text;
        this.specialite = specialite;
        this.id = id;
    }

  /*  public Enseignant(String string, String string0, String string1, int aInt, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getMatier() {
        return matier;
    }

    public void setMatier(String matier) {
        this.matier = matier;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Enseignant{" + "idEnseignant=" + idEnseignant + ", matier=" + matier + ", text=" + text + ", specialite=" + specialite + ", id=" + id + super.toString()+'}';
    }
    
    
    
    
}
