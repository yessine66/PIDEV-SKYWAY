/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;


import Esprit.entities.partenaire;

import Esprit.services.partenaireCRUD;
import Esprit.Connection.MyConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
 import java.io.File;  // Import the File class
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

//import Esprit.gui.LotteryWheel;
import java.awt.event.MouseEvent;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;




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
    @FXML
    private TableColumn<partenaire, String> colDatee;
    @FXML
    private DatePicker DateSelec;
    @FXML
    private ListView<partenaire> listViewPart;
    @FXML
    private TextField tsearch;
    @FXML
    private Button btnsearch;
int index =-1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        showPartenaire();
           searchPart();
    }    
    
    
    
 
   
    public void showPartenaire(){
      
        partenaireCRUD parc = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<partenaire> list =  parc.partenaireList();
        
        colIdpar.setCellValueFactory(new PropertyValueFactory<partenaire, Integer>("id_p"));
        colNompar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("nom_p"));
        colDomainepar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("domaine"));
        colDatee.setCellValueFactory(new PropertyValueFactory<partenaire, String>("date_p"));
        
        tvPar.setItems(list);
        listViewPart.setItems(list);
         searchPart();
    }
   

    @FXML
    private void btnPartenaireAction(ActionEvent event) {
           try {

             if(event.getSource() == btnajouter)
             {
                   if (validationPartenaire()){
            String rNomp = tnomp.getText();
            String rDomaine = tdomaine.getText();
              String rdateP=DateSelec.getEditor().getText();
            partenaire par = new partenaire(22,rNomp,rDomaine,rdateP);
            partenaireCRUD parc = new partenaireCRUD();
            parc.ajouterPartenaire(par);
             searchPart();
            /************************************/
            
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPartenaire.fxml"));
            Parent root =loader.load();
        AjouterPartenaireController AjouterPartenaire= loader.getController();
            // AjouterPromotionController.showInformation();
            
            Stage stage = new Stage();
            stage.setScene(new Scene (root));
            stage.setTitle("display partenaire");
            stage.show();
        
  
            
            
            
            
            
            
            
            
            
                   }
        }
             
             else if (event.getSource() == btnmodifier)
             
             
             {
          
           int  mIdp= Integer.parseInt(tidp.getText()) ;
                  String mNomp = tnomp.getText();
            String mDomaine = tdomaine.getText();
                 String mdateP=DateSelec.getEditor().getText();
            partenaire par = new partenaire(mIdp,mNomp,mDomaine,mdateP);
            partenaireCRUD parc = new partenaireCRUD();
        parc.modifierPartenaire(par);
                  searchPart();
             }
             
             
             else if (event.getSource() == btnsupprimer)
             {
                 
                 
            int  mIdp= Integer.parseInt(tidp.getText()) ;
            partenaire par = new partenaire(mIdp);
            partenaireCRUD parc = new partenaireCRUD();
        parc.supprimerPartenaire(par);
         searchPart();
       
             }
             
       
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPartenaire.fxml"));
            showPartenaire();
        Parent root = loader.load();
  
            tnomp.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(AjouterPartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void DateSelec(ActionEvent event) {
    }
     private boolean validationPartenaire ()
    {
        
        
        if (tnomp.getText().isEmpty() | tdomaine.getText().isEmpty() |DateSelec.getEditor().getText().isEmpty())
            
        {
          Alert alert = new Alert (Alert.AlertType.WARNING);
          alert.setTitle("alert code promo vode");
          alert.setHeaderText(null);
          alert.setContentText("Veuillez remplir tous les champs ! ");
          alert.showAndWait();
          return false;
        }
        
        
        
        
        
        
        return true;
        
        
        
        
    }

    @FXML
    private void actionSearch(ActionEvent event) {
         searchPart();
    }
    
    
    void searchPart() {   
          partenaireCRUD parc = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<partenaire> lists =  parc.partenaireList();
        colIdpar.setCellValueFactory(new PropertyValueFactory<partenaire, Integer>("id_p"));
        colNompar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("nom_p"));
        colDomainepar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("domaine"));
        colDatee.setCellValueFactory(new PropertyValueFactory<partenaire, String>("date_p"));
        
      tvPar.setItems(lists);
      
        FilteredList <partenaire> filteredData = new FilteredList<>(lists, b -> true);  
 tsearch.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(partenaire -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (partenaire.getNom_p().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (partenaire.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1) {
        
     return true; // Filter matches password
    }
    
    else if (String.valueOf(partenaire.getId_p()).indexOf(lowerCaseFilter) != -1) {
     
     return true; // Filter matches password
    }
     else if (String.valueOf(partenaire.getDate_p()).indexOf(lowerCaseFilter) != -1) {
     
     return true; // Filter matches password
    }
    
     
                             
         else  
          return false; // Does not match.
   });
  });  
  SortedList<partenaire> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(tvPar.comparatorProperty());  
  tvPar.setItems(sortedData);      
    }
    
  
    @FXML
    private void selectpar(javafx.scene.input.MouseEvent event) {
         System.err.println("click!");
         index = tvPar.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tidp.setText(colIdpar.getCellData(index).toString());
    tnomp.setText(colNompar.getCellData(index).toString());
    tdomaine.setText(colDomainepar.getCellData(index).toString());
    //DateSelec.setString(colDatee.getCellData(index));
       
     searchPart();
    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    }
 