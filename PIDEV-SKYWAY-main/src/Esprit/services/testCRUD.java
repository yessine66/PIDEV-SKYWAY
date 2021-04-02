/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.test;
import Esprit.Connection.MyConnection;
import Esprit.entities.Questions;
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

 public void ajouterTest(test t){
        String req ="INSERT INTO test (id,date_test,score,nom_categorie)"+"values (?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, t.getId());
            ste.setString(2, t.getDate_test());
            ste.setInt(3, t.getScore());
           // ste.setString(3, q.getId_t().getNom_t());
            ste.setString(4,t.getName_t());
            ste.executeUpdate();
            System.out.println("Test ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
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

    public int recupscore2(int id) throws SQLException {
         String query = "SELECT score from test while nom_categorie= "+id;
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
