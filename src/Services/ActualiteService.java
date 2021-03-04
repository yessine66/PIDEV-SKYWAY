/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DBSkyWay.Singleton;
import Entities.Actualite;
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
public class ActualiteService {

    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection cnx;

    public ActualiteService() {
        cnx = Singleton.getInstance().getConnection();
    }

    public void ajouterActualite(Actualite a) {
        String req = "insert into actualite (titre_ac,description,image,id) values ('" 
                +a.getTitre_ac() +"','" 
                +a.getDesc()+"','" 
                +a.getImage_ac()+"'," 
                +a.getUser()+");";

        try {
            pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Ajouté avec succees");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
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
            int id=a.getUser();
            PreparedStatement ps1 = cnx.prepareStatement("update actualite set titre_ac= '" +
                    t + "' , description='" + 
                    d + "' , image= '" + 
                    i + "', id=" + 
                    id + " WHERE actualite.id_ac =" +
                    a.getId_ac()+ ";");
            ps1.executeUpdate();
            System.out.println("Modifié avec succees");
        } else {
            System.out.println("Actualite n'existe pas");
        }
    }

    public List<Actualite> readAll() {
        String req = "select * from actualite";

        List<Actualite> list=new ArrayList<>();
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Actualite(rs.getInt("id"), rs.getString("nom"), rs.getString(3), rs.getString(3)));
           }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());        }
        return list;
    }


}
