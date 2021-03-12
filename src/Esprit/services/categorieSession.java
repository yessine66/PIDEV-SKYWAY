/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

/**
 *
 * @author simop
 */
public class categorieSession {
    private static categorieSession instance;
    private int id_cat;
   

    public static void setInstance(categorieSession instance) {
        categorieSession.instance = instance;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public static categorieSession getInstance() {
        return instance;
    }

    public int getId_cat() {
        return id_cat;
    }
   

    public categorieSession(int id_cat) {
        this.id_cat = id_cat;
    }
    
     @Override
    public String toString() {
        return "categorieSession{" + "id_cat=" + id_cat + '}';
    }
    
    public static categorieSession getInstace(int id_cat) {
        if(instance == null) {
         instance = new categorieSession(id_cat);
        }
        return instance;
    }   
    
     public void cleanUserSession() {
        id_cat=0;
      instance = null;
        
       // or null
    }
    
}
