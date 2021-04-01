/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.Evenement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author khouja safa
 */
public class EvenementService {
 private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection cnx;

    public EvenementService() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterEvenement(Evenement e) {
        String req = "insert into evenement (nom_ev,date_ev,espace,nombre_pl) values ('" 
                +e.getNom_ev()+"','" 
                +e.getDate_ev()+"','" 
                +e.getEspace()+"'," 
                +e.getNombre_pl()+");";

        try {
            pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Ajouté avec succees");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void supprimer(int id_ev) throws SQLException {
        String req="DELETE FROM evenement WHERE evenement.id_ev = ? ;";
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, id_ev);
            pst.executeUpdate();
            System.out.println("Supprimé avec succees");
            
            } catch (SQLException ex) {
                System.out.println("suppression echoué");
                System.out.println(ex);
        }

    }
    
    public void editer(Evenement e) {
        String req="select id_ev from evenement where id_ev= ? ;";
        try{
        pst = cnx.prepareStatement(req);
        pst.setInt(1, e.getId_ev());
        ResultSet res = pst.executeQuery();
        if (res.next()) {
            String n = e.getNom_ev();
            Date d = e.getDate_ev();
            String es = e.getEspace();
            int nb = e.getNombre_pl();
            int i = e.getId();
            PreparedStatement ps1 = cnx.prepareStatement("update evenement set nom_ev= '" +
                    n + "' , date_ev='" + 
                    d +"' , espace='" + 
                    es +"' , nombre_pl=" + 
                    nb +" WHERE evenement.id_ev =" +
                    e.getId_ev()+ ";");
            ps1.executeUpdate();
            System.out.println("Modifié avec succees");
        } 
        } 
        catch(SQLException ex){
        System.out.println(ex.getMessage()); 
        }
    }

    public ObservableList<Evenement> readAll() {
       ObservableList<Evenement> list = FXCollections.observableArrayList();
        String req = "select * from evenement";
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Evenement(rs.getInt("id_ev"), rs.getString("nom_ev"),rs.getDate("date_ev"),rs.getString("espace"),rs.getInt("nombre_pl"),rs.getInt("id")));
           }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());        }
        return list;
    }
    public ObservableList<String> comboEve(){
       
        ObservableList<String> comboAct = FXCollections.observableArrayList();
        String query = "SELECT nom_ev FROM evenement";
        try{
            ste = cnx.createStatement();
            rs = ste.executeQuery(query);
            while(rs.next()){
               comboAct.add(rs.getString("nom_ev"));
            }      
        }catch(SQLException ex){
        }
        return  comboAct;
    }
}
