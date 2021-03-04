/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.entities.Promotion;
import Esprit.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class promotionCRUD {
    
    
        private Connection cnx;
    private PreparedStatement ste;
       Statement st;
     ResultSet rs;
    public promotionCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    
    
    
 public void ajouterPromotion( Promotion pro ){
        String req ="INSERT INTO promotion (code_p,reduction)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, pro.getCode_p());
            ste.setInt(2, pro.getReduction());
            ste.executeUpdate();
            System.out.println("Promotion ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
          System.out.println(ex.getMessage());
            
        }
        
    }
    
    
 public ObservableList<Promotion> PromotionList(){
     
     
           ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT * FROM promotion";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Promotion par;
            while(rs.next()){
               par = new Promotion(rs.getInt("id_prom"), rs.getString("code_p"), rs.getInt("reduction"));
               PromotionList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return PromotionList;
        
    }
 
 
  public void modifierPromotion(Promotion pro ){
  
   String requete = "UPDATE promotion SET code_p=?,reduction=? WHERE id_prom=?";
        try {
          ste= cnx.prepareStatement(requete);
            /*PreparedStatement pst = 
            new MyConnection().cn.prepareStatement(requete);*/
        ste.setInt(3, pro.getId_prom());
        ste.setString(1, pro.getCode_p());
         ste.setInt(2, pro.getReduction());
     
           ste.executeUpdate();
            System.out.println("promotion Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
                   System.out.println("promotion nonnnnnnnn Modfié !");
        }    
       
   
  }
       
       public void supprimerPromotion(Promotion pro ){
  
   String requete = "DELETE FROM promotion WHERE id_prom=?";
        try {
          ste= cnx.prepareStatement(requete);
            ste.setInt(1, pro.getId_prom());
           ste.executeUpdate();
            System.out.println("promotion Supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
              System.out.println("promotion nonnnnnnnn ajouté !");
        }
  }
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
