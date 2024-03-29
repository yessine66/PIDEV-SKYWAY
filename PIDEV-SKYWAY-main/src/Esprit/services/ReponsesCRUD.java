
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.Reponses;
import Esprit.Connection.MyConnection;
import Esprit.entities.Questions;
import Esprit.entities.Utilisateur;
import Esprit.entities.theme;
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
public class ReponsesCRUD {
       private final Connection cnx;
    private PreparedStatement ste;
      Statement st;
     ResultSet rs;

    public ReponsesCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
   
    public void ajouterReponse(Reponses r){
        String req ="INSERT INTO reponse (text_r1,text_r2,text_r3,text_r4,id_q,id)"+"values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, r.getText_r1());
            ste.setString(2, r.getText_r2());
            ste.setString(3, r.getText_r3());
            ste.setString(4, r.getText_r4());
            ste.setInt(5, r.getId_q().getId_q());
            ste.setInt(6, r.getId());
            ste.executeUpdate();
            System.out.println("Réponse ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
     public ObservableList<Integer>  comboreponse ()
        
        {
        ObservableList<Integer> comboreponse = FXCollections.observableArrayList();
          String query = "SELECT id_t FROM question";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
                        while(rs.next()){
              
               comboreponse.add(rs.getInt("id_t"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
     return  comboreponse;
     }
      public ObservableList<String>  combocategorie ()
        
        {
        ObservableList<String> combocategorie = FXCollections.observableArrayList();
          String query = "SELECT nom_t FROM theme";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
                        while(rs.next()){
              
               combocategorie.add(rs.getString("nom_t"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
     return combocategorie;
        }
          public ObservableList<Integer>  comboid ()
        
        {
        ObservableList<Integer> comboid = FXCollections.observableArrayList();
          String query = "SELECT id FROM utilisateur";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
                        while(rs.next()){
              
               comboid.add(rs.getInt("id"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
     return  comboid;
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
    public ObservableList<Reponses> ReponsesList(){
           ObservableList<Reponses> ReponsesList = FXCollections.observableArrayList();
          String query = "SELECT * FROM reponse";
Questions qq = new Questions();
 


       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Reponses q;
            while(rs.next()){
                qq.setId_q(rs.getInt("id_q"));
                
               q = new Reponses (rs.getInt("id_r"),rs.getString("text_r1"),rs.getString("text_r2"),rs.getString("text_r3"),rs.getString("text_r4"), qq,rs.getInt("id"));
               ReponsesList.add(q);
            }
                
        }catch(SQLException ex){
        }
        return ReponsesList;
        
    }
    public void modifierrep(Reponses r ){
  
   String requete = "UPDATE reponse SET  id_t = ?, text_r1=? , text_r2=?, text_r3=?, text_r4=? WHERE id_r=?";
      /*String requete = "UPDATE reponse SET id_t=?,text_r=? WHERE id_r = ?";
        
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
        
        ste.setInt(1, r.getId_q().getId_q());
        ste.setString(2, r.getText_r1());
        ste.setString(3, r.getText_r2());
        ste.setString(4, r.getText_r3());
        ste.setString(5, r.getText_r4());
         ste.setInt(6, r.getId_r());
                     System.out.println(ste);
           ste.executeUpdate();
            System.out.println("réponse Modfiée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
                   System.out.println("réponse non Modfié e!");
        }    
       
   
  }
     
    public void modifierReponse(int id_r, String object, Object obj) {
        try {
            String requete = "UPDATE reponse SET ? = ? WHERE id_r = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, object);
            pst.setObject(2, obj);
            pst.setInt(3, id_r);
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
    public int returningid(String theme_name)
    { 
         String query = "SELECT * FROM theme where nom_t="+theme_name;
 int id_t=0;
       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
           
            while(rs.next()){
                id_t=rs.getInt("id_t");
              
            }
                
        }catch(SQLException ex){
        }
   
    return id_t;    
    }
    
       public void supprimerReponse(Reponses r) {
         try {
            String requete = "DELETE FROM reponse WHERE id_r=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, r.getId_r());
            pst.executeUpdate();
            System.out.println("Question supprimée avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

         public String rightanswer() throws SQLException{
     
     
         String query = "SELECT text_r1 from reponse";
  //String query = "SELECT text_r FROM reponse where text_r='oui'";
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
         String par = null;
            while(rs.next()){
               par = rs.getString("text_r1");
            }
     
        
        return par;
       
    }
      public int verif (String q) throws SQLException{
          // String par = null;
     String par = rightanswer();
      if (q.equals (par ))
      {
          return 1;
      }
      
      return -1;
      
      
      }
              
              
              
    public String justanswer2(int id) throws SQLException 
     
           { 
          // ObservableList<String> randomList = FXCollections.observableArrayList();
         //  String parr= rightanswer();
      //    String query = "SELECT text_r FROM reponse ORDER BY rand() LIMIT 3
      String query = "SELECT text_r2 from reponse where id_q="+id;
              
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        String par = null;
            while(rs.next()){
               par = rs.getString("text_r2");
              
            
             
            }
                
       
        return par;
    }
     public String justanswer1(int id) throws SQLException 
     
           { 
          // ObservableList<String> randomList = FXCollections.observableArrayList();
         //  String parr= rightanswer();
      //    String query = "SELECT text_r FROM reponse ORDER BY rand() LIMIT 3
      String query = "SELECT text_r1 from reponse where id_q="+id;
              
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        String par = null;
            while(rs.next()){
               par = rs.getString("text_r1");
              
            
             
            }
                
       
        return par;
    }
     public String justanswer3(int id) throws SQLException 
     
           { 
          // ObservableList<String> randomList = FXCollections.observableArrayList();
         //  String parr= rightanswer();
      //    String query = "SELECT text_r FROM reponse ORDER BY rand() LIMIT 3
      String query = "SELECT text_r3 from reponse where id_q="+id;
              
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        String par = null;
            while(rs.next()){
               par = rs.getString("text_r3");
              
            
             
            }
                
       
        return par;
    }
      public String justanswer4(int id) throws SQLException 
     
           { 
          // ObservableList<String> randomList = FXCollections.observableArrayList();
         //  String parr= rightanswer();
      //    String query = "SELECT text_r FROM reponse ORDER BY rand() LIMIT 3
      String query = "SELECT text_r4 from reponse where id_q="+id;
              
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        String par = null;
            while(rs.next()){
               par = rs.getString("text_r4");
              
            
             
            }
                
       
        return par;
    }
    public theme FindthemeByName(String name) {

        theme q = new theme();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from theme WHERE nom_t='" + name + "'");
            System.out.println("DKHAAAAAAAAAALT");
            while (rs.next()) {

                q.setId_t(rs.getInt("id_t"));
                q.setNom_t(rs.getString("nom_t"));
                q.setId(rs.getInt("id"));
                System.out.println("THEEEEEEEEEEEEELE IDDDDDDDDD   : "+q.getId_t());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return q;

    }
    public int returningid2(int id)
    { 
         String query = "SELECT id_q FROM reponse where id_q=  "+id;
 int id_t=0;
       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
           
            while(rs.next()){
                id_t=rs.getInt("id_q");
              
            }
                
        }catch(SQLException ex){
        }
   
    return id_t;    
    }

    public String loadCodeBase2(int id) throws SQLException {
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT name_t FROM reponse WHERE id_q=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
         String name_t=  rs.getString("name_t");
            
                return name_t;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("code non recuperer!");
        }
           String NULL = null;
        return NULL;
    }
}

 
    
