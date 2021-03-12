/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.Connection.MyConnection;
import Esprit.entities.categorie;
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
public class ServiceCategorie implements Iservice<categorie>{
    
     private  Connection con;
     private Statement ste;
     private PreparedStatement pre;
    
     public ServiceCategorie(){
    con = MyConnection.getInstance().getConnection();
    }

    @Override
    public void ajouter(categorie t) throws SQLException {
        pre=con.prepareStatement("INSERT INTO `skyway`.`categorie` (`nom_categorie`,`image`,`id_t`) VALUES ( ?,?,?);");
        pre.setString(1, t.getNom_categorie());
        pre.setString(2, t.getImage());
        pre.setInt(3, t.getId_t());
        pre.executeUpdate();    }

    @Override
    public boolean delete(int id) throws SQLException {
        if(chercher(id)){
            System.out.println("exist");
            pre=con.prepareStatement("delete from `skyway`.`categorie` where id_categorie  = (?)");
            pre.setInt(1,id);
            System.out.println(pre.execute());
            return true;
        }
        else 
            {System.out.println("nexiste pas");
            return false;
            }  
    }

    @Override
    public boolean chercher(int id) throws SQLException {
        String req="select * from categorie";
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id);  
    }

    @Override
    public boolean chercher_ajout(categorie t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(categorie t, int id_categorie) throws SQLException {
        if(chercher(id_categorie)){
       
            pre=con.prepareStatement("UPDATE categorie SET nom_categorie =?,image =? WHERE id_categorie = ?");
         
            pre.setString(1, t.getNom_categorie());
            pre.setString(2, t.getImage());
            pre.setInt(3, id_categorie);
            pre.executeUpdate();
    
            System.out.println("update valide");
            return true;
        }
        System.out.println("update invalid: Catégorie n'existe pas");
        return false;
    }

    @Override
    public List<categorie> readAll() throws SQLException {
        String req="select * from categorie  ";
        List<categorie> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                ImageView v = new ImageView();
                v.setImage(new Image("http://127.0.0.1/image/"+rs.getString(3)));
                v.setFitWidth(100);
                v.setFitHeight(100);
                
                //ystem.out.println(v.getImage().toString());
                categorie c2=new categorie(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                
                c2.setPhoto(v);
                list.add(c2);
              // list.add(new Publicite(rs.getInt(1),rs.getString(2),rs.getString(3),d1, rs.getString(6), d2,rs.getDouble(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    } 
     public ObservableList<String>  comboListTheme ()
        {
        //ComboBox IdPPartPicker;
        ObservableList<String> comboListTheme = FXCollections.observableArrayList();
        // ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT nom_t FROM theme";

       try{
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(query);
           
            while(rs.next()){
              
               comboListTheme.add(rs.getString("nom_t"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
      // IdPPartPicker.setItems( comboListPar);
        
        return  comboListTheme;
        
        }
     public String getName_theme(String name_theme){
        
               
        String query = "SELECT id_t FROM theme where nom_t = '" + name_theme + "';";
        String id_theme_test = null;
        try{
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(query);
           
            while(rs.next()){
              
               id_theme_test = rs.getString("id_t");
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return id_theme_test;
        
    }
    
    
}
    
    

