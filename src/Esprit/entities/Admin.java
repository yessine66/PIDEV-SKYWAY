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
public class Admin extends Utilisateur{
    
    private int idu;
    private int idAdmin;

    public Admin() {
    }

    public Admin(int idu) {
        this.idu = idu;
    }

    public Admin(int idu, int idAdmin) {
        this.idu = idu;
        this.idAdmin = idAdmin;
    }

    public Admin(int idu, int idAdmin, int idUser, String nomUser, String prenomUser, String mailUser, int ageUser, int telUser, String genreUser, String dateDeNaissanceUser, String usernameUser, String passwordUser, String roleUser, String dateDeCreationCompteUser) {
        super(idUser, nomUser, prenomUser, mailUser, ageUser, telUser, genreUser, dateDeNaissanceUser, usernameUser, passwordUser, roleUser, dateDeCreationCompteUser);
        this.idu = idu;
        this.idAdmin = idAdmin;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" + "idu=" + idu + ", idAdmin=" + idAdmin + super.toString()+'}';
    }
    
    
    
    
    
    
    


    
    


}
