/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.entities.Certificat;
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
public class CertificatCRUD {
     private final Connection cnx;
    private PreparedStatement ste;
      Statement st;
     ResultSet rs;

    public CertificatCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterCertification(Certificat c){
        String req ="INSERT INTO certificat (titre_certif,date_certif)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, c.getTitre_certif());
            ste.setString(2, c.getDate_certif());
            ste.executeUpdate();
            System.out.println("Certification ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
       public List<Certificat> CertificatListt() {

        List<Certificat> myList = new ArrayList<>();
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from certificat");
            while (rs.next()) {

               
                int id_certif = rs.getInt("id_certif");
                String titre_certif = rs.getString("titre_certif");
                String date_certif = rs.getString("date_certif");
               
                Certificat p = new Certificat(id_certif, titre_certif, date_certif);
                p.setId_certif(rs.getInt("id_certif"));
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }
    public ObservableList<Certificat> CertificatList(){
           ObservableList<Certificat> CertificatList = FXCollections.observableArrayList();
          String query = "SELECT * FROM certificat";

       try{
                st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Certificat q;
            while(rs.next()){
               q = new Certificat (rs.getInt("id_certif"),rs.getString("titre_certif"), rs.getString("date_certif"));
               CertificatList.add(q);
            }
                
        }catch(SQLException ex){
        }
        return CertificatList;
        
    }
    
     
    public void modifierCertification(int id_certif, String object, Object obj) {
        try {
            String requete = "UPDATE certificat SET ? = ? WHERE id_certif = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, object);
            pst.setObject(2, obj);
            pst.setInt(3, id_certif);
             String ch = pst.toString().replaceFirst("\'", "");
            String ch2 = ch.replaceFirst("\'", "");
            int pos = ch2.indexOf("UPDATE");
            String ch3;
            ch3 = ch2.substring(pos, ch2.length());
            pst = cnx.prepareStatement(ch3);
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("Certification modifiée avec succées");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
       public void supprimerCertification(Certificat q) {
         try {
            String requete = "DELETE FROM certificat WHERE id_certif=?";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, q.getId_certif());
            pst.executeUpdate();
            System.out.println("Certification supprimée avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
}