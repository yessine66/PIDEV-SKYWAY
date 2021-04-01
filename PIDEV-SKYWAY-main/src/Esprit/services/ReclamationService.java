/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.Reclamation;
import Esprit.entities.categorie;
//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.activation.DataSource;

/**
 *
 * @author IBTIHEL
 */
public class ReclamationService {
      private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection conn;

    public ReclamationService() {
        conn = MyConnection.getInstance().getConnection();
    }
    public void ajouterReclamation(Reclamation rec) {
        String req = "insert into reclamation (objet,text_r,date_envoi,id) values (?,?,CURDATE(),?)";

        try {
            pst = conn.prepareStatement(req);
            //pst.setInt(1, rec.getId_rec());
            pst.setString(1, rec.getObjet());
            pst.setString(2, rec.getText_r());
           // pst.setString(4, rec.getDate_env());
             pst.setInt(3, rec.getId());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
      public void supprimerReclamation(int id_rec) throws SQLException {
        String req="DELETE FROM reclamation WHERE reclamation.id_rec = ? ;";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id_rec);
            pst.executeUpdate();
            System.out.println("Supprimé avec succees");
            
            } catch (SQLException ex) {
                System.out.println("suppression echoué");
                System.out.println(ex);
        }

    }
      
       public void editer(Reclamation r) throws SQLException {
        String req="select id_rec from reclamation where id_rec= ? ;";
        pst = conn.prepareStatement(req);
        pst.setInt(1, r.getId_rec());
        ResultSet res = pst.executeQuery();
        if (res.next()) {
            String obj = r.getObjet();
            String txt = r.getText_r();
           // String date =  r.getDate_env(); // String.valueOf(r.CURDATE());
            int id=r.getId();
            PreparedStatement ps1 = conn.prepareStatement("update reclamation set objet= '" +
                    obj + "' , text_r='" + 
                    txt + "' , date_envoi= CURDATE() " + 
                     ", id=" + 
                    id + " WHERE reclamation.id_rec =" +
                    r.getId_rec()+ ";");
            ps1.executeUpdate();
            System.out.println("Modifié avec succees");
        } else {
            System.out.println("Reclamation n'existe pas");
        }
    }

      
      
        public List<Reclamation> listerReclamations() {
        List<Reclamation> myList = new ArrayList<Reclamation>();
        String requete = "SELECT * from Reclamation"; 
        try { 
            
            Statement st; 
            st = MyConnection.getInstance().getConnection().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation R = new Reclamation();
                R.setId(rs.getInt(1));
                R.setObjet(rs.getString(2));
                R.setText_r(rs.getString(3));
                R.setDate_envoi(rs.getString(4));
                myList.add(R);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }
        public ObservableList<Reclamation> readReclamation() {
         ObservableList<Reclamation>  Reclamation = FXCollections.observableArrayList();
        /*  String requete = "SELECT * from Reclamation";
        try{
            Statement st; 
            st = cnxBD.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
        
            while(rs.next()){
               Reclamation R = new Reclamation();
                R.setId(rs.getInt(4));
                R.setObjet(rs.getString(1));
                R.setText_r(rs.getString(2));
                R.setDate_env(rs.getString(3));
                R.setCours(rs.getString(5));
                R.setEnseignant(rs.getString(6));
                Reclamation.add(R);
            }}
        catch (SQLException ex){
            ex.printStackTrace();
            
        }*/
        try {
            Statement st = conn.createStatement();
            String req = "SELECT * FROM reclamation";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Reclamation.add(new Reclamation(rs.getInt("id_rec"),rs.getString("objet"), rs.getString("text_r"),rs.getString("date_env"),rs.getInt("id")));

            }

        } catch (SQLException ex) {
        }
        
        return Reclamation;
       }
        //Service : tri ASC

    public ObservableList<Reclamation> TriAscPromo() {

           ObservableList<Reclamation> promotions = FXCollections.observableArrayList();

        try {
            Statement st = conn.createStatement();
            String req = "SELECT * FROM reclamation ORDER BY date_envoi ASC";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                promotions.add(new Reclamation(rs.getInt("id_rec"),rs.getString("objet"), rs.getString("text_r"),rs.getString("date_envoi"),rs.getInt("id"),rs.getString("cours"),rs.getString("enseignant")));

            }

        } catch (SQLException ex) {
        }

        return promotions;

    }

//Service : tri DESC
 
    public ObservableList<Reclamation> TriDscPromo() {
         ObservableList<Reclamation> promotions = FXCollections.observableArrayList();

        try {
            Statement st = conn.createStatement();
            String req = "SELECT * FROM reclamation ORDER BY date_envoi DESC";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
            promotions.add(new Reclamation(rs.getInt("id_rec"),rs.getString("objet"), rs.getString("text_r"),rs.getString("date_envoi"),rs.getInt("id"),rs.getString("cours"),rs.getString("enseignant")));
            }

        } catch (SQLException ex) {        }

        return promotions;


    }
    public ObservableList<String>  comboListPar ()
        
        {
        //ComboBox IdPPartPicker;
        ObservableList<String> comboListPar = FXCollections.observableArrayList();
        // ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT nom_c FROM cours";

       try{
            ste = conn.createStatement();
            rs = ste.executeQuery(query);
            
            //partenaire par;
            while(rs.next()){
              
               comboListPar.add(rs.getString("nom_c"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
           return  comboListPar;
          
        
}
     public ObservableList<String>  comboListEns ()
        
        {
        //ComboBox IdPPartPicker;
        ObservableList<String> comboListPar = FXCollections.observableArrayList();
        // ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT nom FROM utilisateur where role='enseignant'";

       try{
            ste = conn.createStatement();
            rs = ste.executeQuery(query);
            
            //partenaire par;
            while(rs.next()){
              
               comboListPar.add(rs.getString("nom"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
           return  comboListPar;
          
        
}

}


