/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.Enseignant;
import Esprit.entities.partenaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mega-pc
 */
public class EnseignantCRUD {
    
    
        private Connection cnx;
    private PreparedStatement ste;
    Statement st;
    ResultSet rs;
    
        public EnseignantCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
        
        
    public void affecterEnseignant(Enseignant ens) {
        String req = "INSERT INTO `enseignant` (`matiere`,`bibliographie`,`specialite`,`id_ens`,`id`) values ('" +ens.getMatier()+"','" +ens.getText()+"','"+ens.getSpecialite()+"',NULL,(SELECT id FROM utilisateur WHERE id =" +ens.getId()+"));";
                                                                    //String req = "INSERT INTO `admin` (`id`, `id_adm`) VALUES ((SELECT id FROM utilisateur WHERE id =" +a.getIdu()+"),NULL);";

        try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("enseignant affecte");

        } catch (SQLException ex) {
            System.out.println("erreur sql affectation enseignant");
            System.out.println(ex.getMessage());
        }

    }


    public ObservableList<Enseignant> afficherEnseignant() {
        String req = "SELECT * from enseignant";
        
ObservableList<Enseignant> list = FXCollections.observableArrayList();
        
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               list.add(new Enseignant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
           }
 
        } catch (SQLException ex) {
            System.out.println("erreur recuperation des donnee enseignant");
            System.out.println(ex.getMessage());        }
        return list;
    }

 public void modifierUtilisateur(Enseignant ens ){
  
   String req = "UPDATE enseignant SET matiere=?,bibliographie=?,specialite=? WHERE id=?";  
   
   try {
          ste= cnx.prepareStatement(req);
        ste.setString(1, ens.getMatier());
         ste.setString(2, ens.getText());
         ste.setString(3, ens.getSpecialite());
         ste.setInt(4, ens.getId());

           ste.executeUpdate();
            System.out.println("Enseignant modfie ");
        } catch(SQLException ex) {
            System.out.println("erreur modification enseignant");
            System.err.println(ex.getMessage());
        }    
       
   
  }    
    
}
