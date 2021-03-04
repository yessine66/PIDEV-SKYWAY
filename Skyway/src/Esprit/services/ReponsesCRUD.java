
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.Reponses;
import Esprit.entities.Reponses;
import Esprit.tools.MyConnection;
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
    
    /**
     *
     * @param q
     */
    public void ajouterReponse(Reponses r){
        String req ="INSERT INTO reponse (text_r,id_q)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, r.getText_r());
            ste.setInt(2, r.getId_q());
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
          String query = "SELECT id_q FROM question";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
                        while(rs.next()){
              
               comboreponse.add(rs.getInt("id_q"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
     
        
        
        
        return  comboreponse;
        
        }
        
       public List<Reponses> ReponsessListt() {

        List<Reponses> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from reponse");
            while (rs.next()) {

               
                int id_r = rs.getInt("id_r");
                String text_r = rs.getString("text_r");
                int id_q = rs.getInt("id_q");
                                
                Reponses p = new Reponses(id_r, text_r, id_q);
                p.setId_q(rs.getInt("id_q"));
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

       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Reponses q;
            while(rs.next()){
               q = new Reponses (rs.getInt("id_r"),rs.getString("text_r"), rs.getInt("id_q"));
               ReponsesList.add(q);
            }
                
        }catch(SQLException ex){
        }
        return ReponsesList;
        
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

    
    
}