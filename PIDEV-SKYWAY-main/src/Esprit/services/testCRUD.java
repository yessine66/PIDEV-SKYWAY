/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.test;
import Esprit.Connection.MyConnection;
import Esprit.entities.Questions;
import Esprit.entities.Reponses;
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
      
      
      public void modifier(int id_test, String object, Object obj) {
        try {
            String requete = "UPDATE test SET ? = ? WHERE id_test = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, object);
            pst.setObject(2, obj);
            pst.setInt(3, id_test);
             String ch = pst.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3;
            ch3 = ch2.substring(pos, ch2.length());
            pst = cnx.prepareStatement(ch3);
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("Test modifié avec succées");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public List<Reponses> ReponsessListt() {

        List<Reponses> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from reponse");
            while (rs.next()) {
 Questions qq = new Questions();

               QuestionsCRUD qc = new QuestionsCRUD();
                int id_r = rs.getInt("id_r");
                String text_r1 = rs.getString("text_r1");
                 String text_r2 = rs.getString("text_r2");
                 String text_r3 = rs.getString("text_r3");
                 String text_r4 = rs.getString("text_r4");
                int id_q = rs.getInt("id_q");
                 qq.setId_q(id_q);
                  int id= rs.getInt("id");
               
                Reponses p = new Reponses(id_r, text_r1,text_r2,text_r3,text_r4,qq,id);
               
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    public ObservableList<test> ReponsesList(){
           ObservableList<test> ReponsesList = FXCollections.observableArrayList();
          String query = "SELECT * FROM test";
Questions qq = new Questions();
 


       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            test q;
            while(rs.next()){
                
                
               q = new test (rs.getInt("id_test"),rs.getInt("id"),rs.getString("date_test"),rs.getInt("score"));
               ReponsesList.add(q);
            }
                
        }catch(SQLException ex){
        }
        return ReponsesList;
        
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
