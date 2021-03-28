/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.Apprenant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mega-pc
 */
public class ApprenantCRUD {
    
    
        private Connection cnx;
    private PreparedStatement ste;
    Statement st;
   // ResultSet rs;
    
        public ApprenantCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
        
        
         public void AffecterAdmin(Apprenant ap) {

 
               // String req = "INSERT INTO apprenant (id) values (SELECT id FROM utilisateur WHERE id =" +ap.getId()+");";
                                String req = "INSERT INTO `apprenant` (`id`, `id_app`,`description`) VALUES ((SELECT id FROM utilisateur WHERE id =" +ap.getId()+"),NULL,'"+ap.getDescripton()+"');";
        

        try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("apprenant affecte");

        } catch (SQLException ex) {
            System.out.println("error sql affectation apprenant");
            System.out.println(ex.getMessage());
        }

    }
     
    
}
