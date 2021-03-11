/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.util.Date;

/**
 *
 * @author mega-pc
 */
public class Utilisateur {
    protected int idUser;
    protected String nomUser;
    protected String prenomUser;
    protected String mailUser;
    protected int ageUser;
    protected int telUser;
    protected String genreUser;
    protected String dateDeNaissanceUser;
    protected String usernameUser;
    protected String passwordUser;
    protected String roleUser;
    protected String dateDeCreationCompteUser;

    public Utilisateur() {
    }

    public Utilisateur(int idUser) {
        this.idUser = idUser;
    }

    public Utilisateur(String nomUser, String prenomUser, String mailUser, int ageUser, int telUser, String genreUser, String dateDeNaissanceUser, String usernameUser, String passwordUser, String roleUser, String dateDeCreationCompteUser) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.mailUser = mailUser;
        this.ageUser = ageUser;
        this.telUser = telUser;
        this.genreUser = genreUser;
        this.dateDeNaissanceUser = dateDeNaissanceUser;
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
        this.dateDeCreationCompteUser = dateDeCreationCompteUser;
    }

    public Utilisateur(int idUser, String nomUser, String prenomUser, String mailUser, int ageUser, int telUser, String genreUser, String dateDeNaissanceUser, String usernameUser, String passwordUser, String roleUser, String dateDeCreationCompteUser) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.mailUser = mailUser;
        this.ageUser = ageUser;
        this.telUser = telUser;
        this.genreUser = genreUser;
        this.dateDeNaissanceUser = dateDeNaissanceUser;
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
        this.dateDeCreationCompteUser = dateDeCreationCompteUser;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUser=" + idUser + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", mailUser=" + mailUser + ", ageUser=" + ageUser + ", telUser=" + telUser + ", genreUser=" + genreUser + ", dateDeNaissanceUser=" + dateDeNaissanceUser + ", usernameUser=" + usernameUser + ", passwordUser=" + passwordUser + ", roleUser=" + roleUser + ", dateDeCreationCompteUser=" + dateDeCreationCompteUser + '}';
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public int getTelUser() {
        return telUser;
    }

    public void setTelUser(int telUser) {
        this.telUser = telUser;
    }

    public String getGenreUser() {
        return genreUser;
    }

    public void setGenreUser(String genreUser) {
        this.genreUser = genreUser;
    }

    public String getDateDeNaissanceUser() {
        return dateDeNaissanceUser;
    }

    public void setDateDeNaissanceUser(String dateDeNaissanceUser) {
        this.dateDeNaissanceUser = dateDeNaissanceUser;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public String getDateDeCreationCompteUser() {
        return dateDeCreationCompteUser;
    }

    public void setDateDeCreationCompteUser(String dateDeCreationCompteUser) {
        this.dateDeCreationCompteUser = dateDeCreationCompteUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idUser;
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    
    
    
 
    
    
}
