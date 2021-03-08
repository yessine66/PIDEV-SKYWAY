/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;


import Esprit.entities.partenaire;
import Esprit.Connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class partenaireCRUD {
       private Connection cnx;
    private PreparedStatement ste;
       Statement st;
     ResultSet rs;
    public partenaireCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    
    
    
 public void ajouterPartenaire( partenaire par ){
        String req ="INSERT INTO partenaire (nom_p,domaine)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, par.getNom_p());
            ste.setString(2, par.getDomaine());
            ste.executeUpdate();
            System.out.println("partenaire ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
          System.out.println(ex.getMessage());
            
        }
        
    }
    
    
 public ObservableList<partenaire> partenaireList(){
     
     
           ObservableList<partenaire> partenaireList = FXCollections.observableArrayList();
          String query = "SELECT * FROM partenaire";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            partenaire par;
            while(rs.next()){
               par = new partenaire(rs.getInt("id_p"), rs.getString("nom_p"), rs.getString("domaine"));
               partenaireList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return partenaireList;
       
    }
 
 
  public void modifierPartenaire(partenaire par ){
  
   String requete = "UPDATE partenaire SET nom_p=?,domaine=? WHERE id_p=?";
        try {
          ste= cnx.prepareStatement(requete);
            /*PreparedStatement pst = 
            new MyConnection().cn.prepareStatement(requete);*/
        ste.setInt(3, par.getId_p());
        ste.setString(1, par.getNom_p());
         ste.setString(2, par.getDomaine());
     
           ste.executeUpdate();
            System.out.println("partenaire Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
                   System.out.println("partenaire nonnnnnnnn Modfié !");
        }    
       
   
  }
       
       public void supprimerPartenaire(partenaire par ){
  
   String requete = "DELETE FROM partenaire WHERE id_p=?";
        try {
          ste= cnx.prepareStatement(requete);
            ste.setInt(1, par.getId_p());
           ste.executeUpdate();
            System.out.println("partenaire Supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
  }
   
    }
    
    
    
    
    
    
    
    

