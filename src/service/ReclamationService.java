/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexionBD.cnxBD;
import entite.Reclamation;
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
        conn = cnxBD.getInstance().getCnx();
    }
    public void ajouterReclamation(Reclamation rec) {
        String req = "insert into reclamation (objet,text_r,date_envoi,id) values (?,?,?,CURDATE(),?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, rec.getId_rec());
            pst.setString(2, rec.getObjet());
            pst.setString(3, rec.getText());
           // pst.setString(4, rec.getDate_env());
             pst.setInt(4, rec.getId());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
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
            String txt = r.getText();
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
            st = cnxBD.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation R = new Reclamation();
                R.setId(rs.getInt(1));
                R.setObjet(rs.getString(2));
                R.setText(rs.getString(3));
                R.setDate_env(rs.getString(4));
                myList.add(R);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }

    public void ajouterReclamation(ReclamationService RS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

}

