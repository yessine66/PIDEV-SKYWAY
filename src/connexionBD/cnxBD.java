/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;

/**
 *
 * @author IBTIHEL
 */
public class cnxBD {
    private String url="jdbc:mysql://127.0.0.1/skyway";
    private String login="root";
    private String pwd="";
    
    private Connection cnx;
    
    private static cnxBD instance;

    private cnxBD() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion");
        } catch (SQLException ex) {
            Logger.getLogger(cnxBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static cnxBD getInstance(){
        if(instance==null)
            instance=new cnxBD();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
