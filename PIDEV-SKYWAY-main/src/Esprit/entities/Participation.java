/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author simop
 */
public class Participation {
    private int id_participer;
    private int id_cours;
    private int id_user;

    public Participation(int id_participer, int id_cours, int id_user) {
        this.id_participer = id_participer;
        this.id_cours = id_cours;
        this.id_user = id_user;
    }

    public Participation(int id_cours, int id_user) {
        this.id_cours = id_cours;
        this.id_user = id_user;
    }

    public int getId_participer() {
        return id_participer;
    }

    public void setId_participer(int id_participer) {
        this.id_participer = id_participer;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_participer=" + id_participer + ", id_cours=" + id_cours + ", id_user=" + id_user + '}';
    }
    

   
}
