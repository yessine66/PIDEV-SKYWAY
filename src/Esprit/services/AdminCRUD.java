/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mega-pc
 */
public class AdminCRUD {
    
    
    private Connection cnx;
    private PreparedStatement ste;
    Statement st;
   // ResultSet rs;
    
        public AdminCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
        
        
             
     public void AffecterAdmin(Admin a) {

 
               // String req = "INSERT INTO admin (id) values (SELECT id FROM utilisateur WHERE id =" +a.getIdu()+");";
                 String req = "INSERT INTO `admin` (`id`, `id_adm`) VALUES ((SELECT id FROM utilisateur WHERE id =" +a.getIdu()+"),NULL);";
        
//INSERT INTO `admin` (`id`, `id_adm`) VALUES ('106', NULL);


        try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("admin affecte");

        } catch (SQLException ex) {
            System.out.println("error sql affectation admin");
            System.out.println(ex.getMessage());
        }

    }
     
     

}
