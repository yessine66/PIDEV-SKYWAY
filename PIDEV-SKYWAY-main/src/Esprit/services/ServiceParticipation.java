/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;



import java.sql.SQLException;
import java.util.List;

import Esprit.Connection.MyConnection;
import Esprit.entities.Participation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simop
 */
public class ServiceParticipation  {

     private Connection con;
    private Statement ste;
    private PreparedStatement pre;
   
    
    public ServiceParticipation(){
    con = MyConnection.getInstance().getConnection();
    }
 
    public void ajouter(Participation t) throws SQLException {
         if(!chercher(t.getId_participer())){
    pre=con.prepareStatement("INSERT INTO `skyway`.`participation` ( `id_cours`, `id_user`) VALUES ( ?, ?);");
    pre.setInt(1, t.getId_cours());
    pre.setInt(2, t.getId_user());
   

   // pre.setDate(3, sDate);
    pre.executeUpdate();
            System.out.println("ajout valide");
    }
        else System.out.println("ajout invalide");
    }

    public boolean chercher(int id) throws SQLException {
 String req="select * from participation";
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list.contains(id);    }

    
    public boolean chercher_ajout(Participation t) throws SQLException {
  String req="select * from participation where id_cours= '"+t.getId_cours()+ "' AND id_user ='"+t.getId_user()+ "'";
        List<Participation> list = new ArrayList<>();
       
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(new Participation(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (list.size()!=0);
    }    


    

      
}
