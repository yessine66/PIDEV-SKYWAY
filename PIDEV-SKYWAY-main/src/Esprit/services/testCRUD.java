/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.test;
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
 * @author User-DELL
 */
public class testCRUD {
     private final Connection cnx;
    private PreparedStatement ste;
      Statement st;
     ResultSet rs;
     public testCRUD (){
        cnx = MyConnection.getInstance().getConnection();
}

 

      public ObservableList<String> justanswer() throws SQLException 
     
           { 
           ObservableList<String> randomList = FXCollections.observableArrayList();
        
      String query = "SELECT text_r1, text_r2, text_r3, text_r4 FROM reponse  ORDER BY rand() where id_q=id_q";
              try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
         String par;
            while(rs.next()){
               par = rs.getString("text_r");
            
               randomList.addAll(par);
             
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return randomList;
    }
            public int recupscore() throws SQLException{
     
     
         String query = "SELECT score from test ";
  //String query = "SELECT text_r FROM reponse where text_r='oui'";
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        int par = 0;
            while(rs.next()){
               par = rs.getInt("score");
            }
     
        
        return par;
       
    }
 
    
    
    
    
    
    
    
    
}
