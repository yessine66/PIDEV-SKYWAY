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
public class themeSession {

    @Override
    public String toString() {
        return "themeSession{" + "id_t=" + id_t + '}';
    }

    public static void setInstance(themeSession instance) {
        themeSession.instance = instance;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public static themeSession getInstance() {
        return instance;
    }

    public int getId_t() {
        return id_t;
    }
    private static themeSession instance;
    private int id_t;

    public themeSession(int id_t) {
        this.id_t = id_t;
    }
    public static themeSession getInstace(int id_t) {
        if(instance == null) {
         instance = new themeSession(id_t);
        }
        return instance;
    }   
    
     public void cleanUserSession() {
        id_t=0;
      instance = null;
        
       // or null
    }
    
}
