/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connection.Datasource;
import entity.theme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author simop
 */
public class ServiceTheme implements Iservice<theme>{
    
    private  Connection con;
     private Statement ste;
    private PreparedStatement pre;
    
     public ServiceTheme(){
    con = Datasource.getInstance().getCnx();
    }

    @Override
    public void ajouter(theme t) throws SQLException {
        pre=con.prepareStatement("INSERT INTO `skyway`.`theme` (`nom_t`) VALUES ( ?);");
        pre.setString(1, t.getNom_t());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(int id) throws SQLException {
         if(chercher(id)){
            System.out.println("exist");
        pre=con.prepareStatement("delete from `skyway`.`theme` where id_t  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
       return true;}
        else 
        {System.out.println("nexiste pas");
            return false;}
    }

    @Override
    public boolean chercher(int id_t) throws SQLException {
        String req="select * from theme";
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTheme.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id_t);  
    }

    @Override
    public boolean chercher_ajout(theme t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(theme t, int id_t) throws SQLException {
        if(chercher(id_t)){
       
pre=con.prepareStatement("UPDATE theme SET  nom_t =? WHERE id_t = ?");
         
    pre.setString(1, t.getNom_t());
    pre.setInt(2, id_t);
    pre.executeUpdate();
    
      System.out.println("update valide");
         return true;}
        System.out.println("update invalid: cours nexiste pas");
        return false;
    }
    

    @Override
    public List<theme> readAll() throws SQLException {
    String req="select * from theme  ";
        List<theme> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
               
           
               
                //ystem.out.println(v.getImage().toString());
                theme c2=new theme(rs.getInt(1),rs.getString(2),rs.getInt(3));
                
              //  c2.setPhoto(v);
                list.add(c2);
              // list.add(new Publicite(rs.getInt(1),rs.getString(2),rs.getString(3),d1, rs.getString(6), d2,rs.getDouble(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    }
   
   
}
    

