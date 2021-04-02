/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.Connection.MyConnection;
import Esprit.entities.Questions;
import Esprit.entities.theme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void ajouterQuestions(Questions q){
        String req ="INSERT INTO question (text_q,nbr_point,name_t)"+"values (?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, q.getText_q());
            ste.setInt(2, q.getNbr_point());
           // ste.setString(3, q.getId_t().getNom_t());
            ste.setString(3,q.getName_t());
            ste.executeUpdate();
            System.out.println("Questions ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
       public List<Questions> QuestionssListt() {

        List<Questions> myList = new ArrayList<>();
        try {
             Questions p= new Questions();
            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from question");
            while (rs.next()) {

               
                p = FindQuestionsByName(rs.getString("text_q"));
                
                                
                
               
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
               q = FindQuestionsByName(rs.getString("text_q"));
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
    public void modifierQuestions(int id_q, String object, Object obj) {
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
            System.out.println("Questions modifiée avec succées");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ObservableList<String> justquestion() throws SQLException 
     
           { 
           ObservableList<String> randomList = FXCollections.observableArrayList();
        
      String query = "SELECT SELECT text_q FROM question ORDER BY rand() ";
              try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        String par,par2,par3,par4;
            while(rs.next()){
               par = rs.getString("text_q");
              
            
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return randomList;
    }
       public void supprimerQuestions(Questions q) {
         try {
            String requete = "DELETE FROM question WHERE id_q=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, q.getId_q());
            pst.executeUpdate();
            System.out.println("Questions supprimée avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   public String randomList() throws SQLException{
     
       //    ObservableList<String> randomList = FXCollections.observableArrayList();
          String query = "SELECT text_q FROM question ORDER BY rand() limit 1";


            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
         String par = null;
            while(rs.next()){
               par = rs.getString("text_q");
              
            }
                
      
          
       return par;
    }

           

public int returningid(String question_name)
    { 
        String query = "SELECT id_q FROM question WHERE text_q = ' +question_name+ ' ";
 int id_q=0;
       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
          
           
            while(rs.next()){
                id_q=rs.getInt("id_q");
              
            }
                
        }catch(SQLException ex){
        }
   
    return id_q;    
    }
  
   
public Questions FindQuestionsByName(String name) {

        Questions q = new Questions();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from question WHERE text_q='" + name + "'");
             
            while (rs.next()) {
                
    
            
            q.setId_q(rs.getInt("id_q"));
            q.setText_q(rs.getString("text_q"));
            q.setNbr_point(rs.getInt("nbr_point"));
            q.setName_t(rs.getString("name_t"));
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return q;

    }
   public int FindQuestion()  {
       int max=0;    
       try {
               Statement pst = cnx.createStatement();
              ResultSet rs = pst.executeQuery("SELECT MAX(id_q) from question");
               
               
               if (rs.next()) {
                   max = rs.getInt(1);
               }          } catch (SQLException ex) {
               Logger.getLogger(QuestionsCRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
   
   return max;
           
   }
   
   
   public int loadCodeBase(String nom) throws SQLException {
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT text_q,id_q FROM question WHERE text_q =?");
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             rs.getString("text_q");
             int id_q=   rs.getInt("id_q");
                return id_q;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("code non recuperer!");
        }
        return -1;
    }
}
