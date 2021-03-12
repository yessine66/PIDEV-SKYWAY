/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;
import Esprit.Connection.MyConnection;
import Esprit.entities.cours;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
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
import javax.activation.DataSource;

/**
 *
 * @author asus
 */
public class ServiceCours implements Iservice<cours> {
    private  Connection con;
     private Statement ste;
    private PreparedStatement pre;
    
     public ServiceCours(){
con = MyConnection.getInstance().getConnection();    }

    @Override
    public void ajouter(cours t) throws SQLException {
    pre=con.prepareStatement("INSERT INTO `skyway`.`cours` ( `nom_c`, `numero`, `description`, `duree`, `image`, `id_t` ) VALUES ( ?, ?, ?, ?, ?, ?);");
    pre.setString(1, t.getNom_c());
    pre.setInt(2, t.getNumero());
    pre.setString(3, t.getDescription());
    pre.setInt(4, t.getDuree());
    pre.setString(5, t.getImage());
    pre.setInt(6, t.getId_t());
    
    pre.executeUpdate();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if(chercher(id)){
            System.out.println("exist");
        pre=con.prepareStatement("delete from `skyway`.`cours` where id_c  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
       return true;}
        else 
        {System.out.println("nexiste pas");
            return false;}
    }

    @Override
    public boolean chercher(int id_c) throws SQLException {

         String req="select * from cours";
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCours.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id_c);   
    }

    @Override
    public boolean chercher_ajout(cours t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(cours t, int id_c) throws SQLException {
         if(chercher(id_c)){
       
    pre=con.prepareStatement("UPDATE cours SET  nom_c =?,numero =?,description =?,duree =?,image =? , id_t =? WHERE id_c = ?");
         
    pre.setString(1, t.getNom_c());
    pre.setInt(2, t.getNumero());
    pre.setString(3, t.getDescription());
    pre.setInt(4, t.getDuree());
    pre.setString(5, t.getImage());
    pre.setInt(6, t.getId_t());
    pre.setInt(7, id_c);
    pre.executeUpdate();
    
      System.out.println("update valide");
         return true;}
        System.out.println("update invalid: cours nexiste pas");
        return false;
    }

    @Override
    public List<cours> readAll() throws SQLException {
        String req="select * from cours  ";
        List<cours> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
                ImageView v = new ImageView();
                v.setImage(new Image("http://127.0.0.1/image/"+rs.getString(6)));
                v.setFitWidth(100);
                v.setFitHeight(100);
               
                //ystem.out.println(v.getImage().toString());
                cours c2=new cours(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
                
                c2.setPhoto(v);
                list.add(c2);
              // list.add(new Publicite(rs.getInt(1),rs.getString(2),rs.getString(3),d1, rs.getString(6), d2,rs.getDouble(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    }
   
    public ObservableList<String>  comboListCat ()
        {
        //ComboBox IdPPartPicker;
        ObservableList<String> comboListCat = FXCollections.observableArrayList();
        // ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
          String query = "SELECT nom_categorie FROM categorie";

       try{
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(query);
           
            while(rs.next()){
              
               comboListCat.add(rs.getString("nom_categorie"));
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
      // IdPPartPicker.setItems( comboListPar);
        
        return  comboListCat;
        
        }
    
    public String getName_cat(String name_cat){
        
               
        String query = "SELECT id_categorie FROM categorie where nom_categorie = '" + name_cat + "';";
        String id_cat_test = null;
        try{
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(query);
           
            while(rs.next()){
              
               id_cat_test = rs.getString("id_categorie");
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return id_cat_test;
        
    }
    
    
}
