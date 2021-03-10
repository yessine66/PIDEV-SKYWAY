/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.entities.Promotion;
import Esprit.entities.partenaire;
import Esprit.Connection.MyConnection;
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
        String req ="INSERT INTO promotion (code_p,reduction,dateD,dateF,id_p)"+"values (?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, pro.getCode_p());
            ste.setInt(2, pro.getReduction());
             ste.setString(3, pro.getDateD());
              ste.setString(4, pro.getDateF());
             ste.setInt(5, pro.getId_p());
              
            
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
               par = new Promotion(rs.getInt("id_prom"), rs.getString("code_p"), rs.getInt("reduction"),rs.getString("dateD") , rs.getString("dateF"),rs.getInt("id_p"));
               PromotionList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return PromotionList;
        
    }
 
 
  public void modifierPromotion(Promotion pro ){
  
   String requete = "UPDATE promotion SET code_p=?,reduction=?, dateD= ? ,dateF =?,id_p = ? WHERE id_prom=?";
        try {
          ste= cnx.prepareStatement(requete);
            /*PreparedStatement pst = 
            new MyConnection().cn.prepareStatement(requete);*/
        ste.setInt(6, pro.getId_prom());
        ste.setString(1, pro.getCode_p());
         ste.setInt(2, pro.getReduction());
           ste.setString(3, pro.getDateD());
              ste.setString(4, pro.getDateF());
                 ste.setInt(5, pro.getId_p());
     
           ste.executeUpdate();
            System.out.println("promotion Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
                   System.out.println("promotion non Modfié !");
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
              System.out.println("promotion non supprimé !");
        }
  }
       
    
    
    
    
 public ObservableList<Integer>  comboListPar ()
        
        {
        //ComboBox IdPPartPicker;
        ObservableList<Integer> comboListPar = FXCollections.observableArrayList();
        // ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT id_p FROM partenaire";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            
            //partenaire par;
            while(rs.next()){
              
               comboListPar.add(rs.getInt("id_p"));
                   
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
      // IdPPartPicker.setItems( comboListPar);
        
        
        
        return  comboListPar;
        
        }
        
        
       
    public ObservableList<Promotion> PromotionListClient(){
     
     
           ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT * FROM promotion";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Promotion par;
            while(rs.next()){
               par = new Promotion(rs.getString("code_p"), rs.getInt("reduction"),rs.getString("dateD") , rs.getString("dateF"),rs.getInt("id_p"));
               PromotionList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return PromotionList;
        
    }
    
         
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
