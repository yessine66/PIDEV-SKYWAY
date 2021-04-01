/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.Entities.Actualite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author khouja safa
 */
public class ActualiteService {

    private static Statement ste;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static Connection cnx;

    public ActualiteService() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterActualite(Actualite a) {
        String req = "insert into actualite (titre_ac,description,image,id_ev,id,date_ajout) values ('" 
                +a.getTitre_ac() +"','" 
                +a.getDesc()+"','" 
                +a.getImage_ac()+"','" 
                +a.getId_ev()+"',(SELECT id FROM utilisateur WHERE id =" 
                +a.getUser()+"),CURDATE());";

        try {
            pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Ajouté avec succees");

        } catch (SQLException ex) {
            System.out.println("id utilisateur doit etre existant");
            //System.out.println(ex.getMessage());
        }

    }
    public void supprimer(int id_ac) throws SQLException {
        String req="DELETE FROM actualite WHERE actualite.id_ac = ? ;";
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, id_ac);
            pst.executeUpdate();
            System.out.println("Supprimé avec succees");
            
            } catch (SQLException ex) {
                System.out.println("suppression echoué");
                System.out.println(ex);
        }

    }
    
    public void editer(Actualite a) throws SQLException {
        String req="select id_ac from actualite where id_ac= ? ;";
        pst = cnx.prepareStatement(req);
        pst.setInt(1, a.getId_ac());
        ResultSet res = pst.executeQuery();
        if (res.next()) {
            String t = a.getTitre_ac();
            String d = a.getDesc();
            String i = a.getImage_ac();
            int n = a.getId_ev();
            int id=a.getUser();
            PreparedStatement ps1 = cnx.prepareStatement("update actualite set titre_ac= '" +
                    t + "' , description='" + 
                    d + "' , image= '" + 
                    i + "' , id_ev= '" + 
                    n + "', id=(SELECT id FROM utilisateur WHERE id =" + 
                    id + " )WHERE actualite.id_ac =" +
                    a.getId_ac()+ ";");
            ps1.executeUpdate();
            System.out.println("Modifié avec succees");
        } else {
            System.out.println("Actualite n'existe pas");
        }
    }

    public ObservableList<Actualite> readAll() {
       ObservableList<Actualite> list = FXCollections.observableArrayList();
        String req = "select * from actualite";

        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Actualite(rs.getInt("id_ac"), rs.getString("titre_ac"), rs.getString("description"), rs.getString("image"),rs.getInt("id_ev"),rs.getInt("id"),rs.getString("date_ajout")));
           }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public boolean recherche(int id_ac) {
        boolean resultat=false;
        String req="select id_ac from actualite where id_ac="+id_ac+" ;";
        try {
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
            return resultat=true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultat;
        
    }
    
    public int getIdEv(String nom_ev) {
        int resultat=0;
        String req="select id_ev from evenement where nom_ev="+nom_ev+" ;";
        try {
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
            return resultat=res.getInt("id_ac");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultat;
        
    }

    
}
