/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;


import Esprit.entities.partenaire;

import Esprit.services.partenaireCRUD;
import Esprit.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/*********************/

/*import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

*/
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;







/************************/
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterPartenaireController implements Initializable {

    @FXML
    private TextField tnomp;
    @FXML
    private TextField tdomaine;
    @FXML
    private Button btnajouter;
    @FXML
    private TableView<partenaire> tvPar;
    @FXML
    private TableColumn<partenaire,Integer> colIdpar;
    @FXML
    private TableColumn<partenaire, String> colNompar;
    @FXML
    private TableColumn<partenaire, String> colDomainepar;
    @FXML
    private TextField tidp;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          showBooks();
    }    
    
    
    
  /*  private void ajouterPatenaire(ActionEvent event) {
        try {
            // Ajouter Perssonne
            String rNomp = tnomp.getText();
            String rDomaine = tdomaine.getText();
            partenaire par = new partenaire(22,rNomp,rDomaine);
            partenaireCRUD parc = new partenaireCRUD();
            parc.ajouterPartenaire(par);
            
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterPartenaire.fxml"));
              showBooks();
            Parent root = loader.load();
    /*PartenaireController aparc = loader.getController();
         aparc.setCnomp(rNomp);
            aparc.setCdomaine(rDomaine);*/
        /*    tnomp.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterPartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
*/
   
    public void showBooks(){
      
        partenaireCRUD parc = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<partenaire> list =  parc.partenaireList();
        
        colIdpar.setCellValueFactory(new PropertyValueFactory<partenaire, Integer>("id_p"));
        colNompar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("nom_p"));
        colDomainepar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("domaine"));
   
        
        tvPar.setItems(list);
    }

    @FXML
    private void btnPartenaireAction(ActionEvent event) {
           try {

             if(event.getSource() == btnajouter)
             {
            String rNomp = tnomp.getText();
            String rDomaine = tdomaine.getText();
            partenaire par = new partenaire(22,rNomp,rDomaine);
            partenaireCRUD parc = new partenaireCRUD();
            parc.ajouterPartenaire(par);
        }
             
             else if (event.getSource() == btnmodifier)
             
             
             {
                // int mIdp= tidp.getText();
           int  mIdp= Integer.parseInt(tidp.getText()) ;
                  String mNomp = tnomp.getText();
            String mDomaine = tdomaine.getText();
            partenaire par = new partenaire(mIdp,mNomp,mDomaine);
            partenaireCRUD parc = new partenaireCRUD();
        parc.modifierPartenaire(par);
                 
             }
             
             
             else if (event.getSource() == btnsupprimer)
             {
                 
                 
            int  mIdp= Integer.parseInt(tidp.getText()) ;
            //String mNomp = tnomp.getText();
            //String mDomaine = tdomaine.getText();
            partenaire par = new partenaire(mIdp);
            partenaireCRUD parc = new partenaireCRUD();
        parc.supprimerPartenaire(par);
                 
                 
                 
                 
                 
             }
             
             
             
             
             
            //Afficher Personne
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterPartenaire.fxml"));
              showBooks();
        Parent root = loader.load();
  
            tnomp.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(AjouterPartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        

    
     private void modifierPartenaire(){
           
      /*  String query = "UPDATE  partenaire SET nom_p  = '" + tnomp.getText() + "', domaine = '" + tdomaine.getText()  + " WHERE id_p = " + tidp.getText() + "";
         System.out.println("updateess");
    Connection cnx;
 
       Statement st;
     ResultSet rs;
   
        cnx = MyConnection.getInstance().getConnection();
         
            
        showBooks();
        try{
            
            st = cnx.createStatement();
        st.executeUpdate(query);
           
   //showBooks();
           
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        */
      
      
      
      /*
      
      
      
      PreparedStatement ps = conn.prepareStatement("select id_p from partenaire where id_ac=" +tidp.getText()+ ";");
        ResultSet res = ps.executeQuery();
        if (res.next()) {
            String t = a.getTitre_ac();
            String d = a.getDesc();
            String i = a.getImage_ac();
            PreparedStatement ps1 = conn.prepareStatement("update actualite set titre_ac= '" + t + "' , desc=" + d + " , image= '" + i + ";");
            ps1.executeUpdate();
            ps1.close();
        } else {
            System.out.println("Actualite n'existe pas");
        }
      
      
      
      
      
      
      
      
      
      
      
      */
      
      
      
      
      
      
      
      
      
      
      
      
     
    }
    
    
    
    
    

        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    
    
    }
    
    
    
    
    
