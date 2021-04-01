/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.theme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author simop
 */
public class ServiceTheme implements Iservice<theme>{
    
    private  Connection con;
     private Statement ste;
    private PreparedStatement pre;
    
     public ServiceTheme(){
    con = MyConnection.getInstance().getConnection();
    }

    @Override
    public void ajouter(theme t) throws SQLException {
        
        pre=con.prepareStatement("INSERT INTO `skyway`.`theme` (`nom_t`,`image`) VALUES ( ?,?);");
        pre.setString(1, t.getNom_t());
        pre.setString(2, t.getImage());
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
            return false;
        }
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
       
    pre=con.prepareStatement("UPDATE theme SET  nom_t =? ,image =? WHERE id_t = ?");
         
    pre.setString(1, t.getNom_t());
    pre.setString(2, t.getImage());
    pre.setInt(3, id_t);
    pre.executeUpdate();
    
      System.out.println("update valide");
         return true;}
        System.out.println("update invalid: theme nexiste pas");
        return false;
    }
    

    @Override
    public ObservableList<theme> readAll() throws SQLException {
        String req="select * from theme  ";
        ObservableList<theme> list = FXCollections.observableArrayList();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                ImageView v = new ImageView();
                v.setImage(new Image("http://127.0.0.1/image/"+rs.getString(3)));
                v.setFitWidth(100);
                v.setFitHeight(100);
                
                //ystem.out.println(v.getImage().toString());
                theme c2=new theme(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                
                c2.setPhoto(v);
                list.add(c2);
              // list.add(new Publicite(rs.getInt(1),rs.getString(2),rs.getString(3),d1, rs.getString(6), d2,rs.getDouble(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTheme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    }
   
   
}
    

