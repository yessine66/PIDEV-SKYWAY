/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import connexionBD.cnxBD;
import entite.Commentaire;
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
/**
 *
 * @author IBTIHEL
 */
public class CommentaireService {
        private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection conn;

    public CommentaireService() {
        conn = cnxBD.getInstance().getCnx();
    }
     public void ajouterCommentaire(Commentaire com) {
        String req = "insert into commentaire (text,date_pub,destinatire,image,id) values (?,?,CURDATE(),?,?,? )";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, com.getId_com());
            pst.setString(2, com.getText());
          //  pst.setString(3, com.getDate_pub());
            pst.setString(3, com.getDestinataire());
            pst.setString(4, com.getImage());
            pst.setInt(5, com.getId());            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void supprimerCommentaire(int id_com) throws SQLException {
        String req="DELETE FROM commentaire WHERE commentaire.id_com = ? ;";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id_com);
            pst.executeUpdate();
            System.out.println("Supprimé avec succees");
            
            } catch (SQLException ex) {
                System.out.println("suppression echoué");
                System.out.println(ex);
        }

    }
     
      
       public void editer(Commentaire c) throws SQLException {
       String req="select id_com from commentaire where id_com= ? ;";
        pst = conn.prepareStatement(req);
        pst.setInt(1, c.getId_com());
        ResultSet res = pst.executeQuery();
        if (res.next()) {
            String txt = c.getText();
            String date = c.getDate_pub();
            String des = c.getDestinataire();
            String img = c.getImage();
            int id=c.getId();
            PreparedStatement ps1 = conn.prepareStatement("update commentaire set text= '" +
                    txt + "' , date_pub='" + 
                    date + "' , destinatire= '" + 
                    des + "', image='" + 
                    img + "', id=" +
                    id + " WHERE commentaire.id_com =" +
                    c.getId_com()+ ";");
            ps1.executeUpdate();
            System.out.println("Modifié avec succees");
        } else {
            System.out.println("Commentaire n'existe pas");
        }
    }
       
      public List<Commentaire> listerCommentaire() {
        List<Commentaire> myList = new ArrayList<>();
        String requete = "SELECT * from commentaire"; 
        try { 
            
            Statement st; 
            st = cnxBD.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            Commentaire R = new Commentaire();

            while (rs.next()) {
                R.setId_com(rs.getInt(1));
                R.setText(rs.getString(2));
                R.setDate_pub(rs.getString(3));
                R.setDestinataire(rs.getString(4));
                R.setImage(rs.getString(5));
                R.setId(rs.getInt(6));
                myList.add(R);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
}}
