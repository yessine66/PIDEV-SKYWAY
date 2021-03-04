/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBSkyWay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author khouja safa
 */
public class Singleton {
    
    private String url="jdbc:mysql://localhost:3306/skyway";
    private String login="root";
    private String pwd="";
    
    private Connection cnx;
    
    private static Singleton instance;

    private Singleton() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion");
        } catch (SQLException ex) {
            System.out.println("Problème de cnx");
            System.out.println(ex.getMessage());        }
    }
    
    public static Singleton getInstance(){
        if(instance==null)
            instance=new Singleton();
        return instance;
    }

    public Connection getConnection() {
return cnx;
    }
    
    
    
    
    
    
    
}

