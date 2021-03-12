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
public class Apprenant extends Utilisateur {
       private int id;
    private int idApprenant;
 

    public Apprenant() {
    }

    
    public Apprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    public Apprenant( int id,int idApprenant) {
            this.id = id;
        this.idApprenant = idApprenant;
  
    }
    

    public Apprenant(int idApprenant, int id, int idUser, String nomUser, String prenomUser, String mailUser, int ageUser, int telUser, String genreUser, String dateDeNaissanceUser, String usernameUser, String passwordUser, String roleUser, String dateDeCreationCompteUser) {
        super(idUser, nomUser, prenomUser, mailUser, ageUser, telUser, genreUser, dateDeNaissanceUser, usernameUser, passwordUser, roleUser, dateDeCreationCompteUser);
        this.idApprenant = idApprenant;
        this.id = id;
    }

    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apprenant{" + "idApprenant=" + idApprenant + ", id=" + id +super.toString()+ '}';
    }
    
    
    
    
    
    
}
