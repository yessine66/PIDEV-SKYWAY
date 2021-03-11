/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.Services;

import Esprit.Connection.MyConnection;
import Esprit.Entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        String req = "insert into evenement (nom_ev,date_ev,id_ac) values ('" 
                +e.getNom_ev()+"','" 
                +e.getDate_ev()+"',(SELECT id_ac FROM actualite WHERE id_ac =" 
                +e.getId_ac()+"));";

        try {
            pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Ajouté avec succees");

        } catch (SQLException ex) {
            System.out.println("id actualité doit etre existant");
            //System.out.println(ex.getMessage());
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
            String d = String.valueOf(e.getDate_ev());
            int i = e.getId_ac();
            PreparedStatement ps1 = cnx.prepareStatement("update evenement set nom_ev= '" +
                    n + "' , date_ev='" + 
                    d + "' , id_ac=(SELECT id_ac FROM actualite WHERE id_ac =" + 
                    i + ") WHERE evenement.id_ev =" +
                    e.getId_ev()+ ";");
            ps1.executeUpdate();
            System.out.println("Modifié avec succees");
        } 
        } 
        catch(SQLException ex){
        System.out.println("Actualite ou utilisateur n'existe pas");
        System.out.println(ex.getMessage()); 
        }
    }

    public List<Evenement> readAll() {
        String req = "select * from evenement";

        List<Evenement> list=new ArrayList<>();
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Evenement(rs.getInt("id_ev"), rs.getString("nom_ev"), String.valueOf(rs.getDate("date_ev")), rs.getInt("id_ac")));
           }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());        }
        return list;
    }

   
}
