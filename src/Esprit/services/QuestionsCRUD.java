/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.Questions;
import Esprit.Connection.MyConnection;
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
public class QuestionsCRUD {
       private final Connection cnx;
    private PreparedStatement ste;
      Statement st;
     ResultSet rs;

    public QuestionsCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    /**
     *
     * @param q
     */
    public void ajouterQuestion(Questions q){
        String req ="INSERT INTO question (text_q,nbr_point)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, q.getText_q());
            ste.setInt(2, q.getNbr_point());
            ste.executeUpdate();
            System.out.println("Question ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
       public List<Questions> QuestionssListt() {

        List<Questions> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from question");
            while (rs.next()) {

               
                int id_q = rs.getInt("id_q");
                String text_q = rs.getString("text_q");
                int nbr_point = rs.getInt("nbr_point");
                                
                Questions p = new Questions(id_q, text_q, nbr_point);
                p.setId_q(rs.getInt("id_q"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    public ObservableList<Questions> QuestionsList(){
           ObservableList<Questions> QuestionsList = FXCollections.observableArrayList();
          String query = "SELECT * FROM question";

       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Questions q;
            while(rs.next()){
               q = new Questions (rs.getInt("id_q"),rs.getString("text_q"), rs.getInt("nbr_point"));
               QuestionsList.add(q);
            }
                
        }catch(SQLException ex){
        }
        return QuestionsList;
        
    }
    
       public void modifierquest(Questions q ){
  
  
   String requete = "UPDATE question SET text_q=?, nbr_point=? WHERE id_q=?";
      /*String requete = "UPDATE reponse SET id_q=?,text_r=? WHERE id_r = ?";
        
           PreparedStatement ste = cnx.prepareStatement(requete);
           ste.setInt(1, r.getId_r());
        ste.setString(2, r.getText_r());
         ste.setInt(3, r.getId_q());
     String ch = ste.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3;
            ch3 = ch2.substring(pos, ch2.length());
            ste = cnx.prepareStatement(ch3);
            System.out.println(ste);
           ste.executeUpdate();
            System.out.println("réponse Modfiéee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                   System.out.println("réponse non Modfié e!");
        }    
       */   
   try {
         PreparedStatement ste = cnx.prepareStatement(requete);
        
        ste.setInt(3, q.getId_q());
        ste.setString(1, q.getText_q());
         ste.setInt(2, q.getNbr_point());
                     System.out.println(ste);
           ste.executeUpdate();
            System.out.println("question Modfiée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
                   System.out.println("question non Modfié e!");
        }    
       
   
  }
    public void modifierQuestion(int id_q, String object, Object obj) {
        try {
            String requete = "UPDATE question SET ? = ? WHERE id_q = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, object);
            pst.setObject(2, obj);
            pst.setInt(3, id_q);
             String ch = pst.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3;
            ch3 = ch2.substring(pos, ch2.length());
            pst = cnx.prepareStatement(ch3);
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("Question modifiée avec succées");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
       public void supprimerQuestion(Questions q) {
         try {
            String requete = "DELETE FROM question WHERE id_q=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, q.getId_q());
            pst.executeUpdate();
            System.out.println("Question supprimée avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
          public ObservableList<String> randomList(){
     
     
           ObservableList<String> randomList = FXCollections.observableArrayList();
          String query = "SELECT text_q FROM question ORDER BY rand() LIMIT 1";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
         String par;
            while(rs.next()){
               par = rs.getString("text_q");
               randomList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return randomList;
       
    }

    
    
}
