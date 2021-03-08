/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Certificat;
import Esprit.entities.Certificat;
import Esprit.services.CertificatCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class AjoutCertificatController implements Initializable {

    @FXML
    private TableView<Certificat> AffichageCertif;
    @FXML
    private TableColumn<Certificat, Integer> colidr;
    @FXML
    private TableColumn<Certificat, String> colreponse;
    @FXML
    private TableColumn<Certificat, String> colnbrq;
    @FXML
    private TextArea champsCertif;
    @FXML
    private Button AjoutCertif;
    @FXML
    private TextField date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     showCertificats();
      
    }    

public void showCertificats(){
      
        CertificatCRUD cert = new CertificatCRUD();
            //parc.promotionList();
        ObservableList<Certificat> list =  cert.CertificatList();
        colidr.setCellValueFactory(new PropertyValueFactory<Certificat, Integer>("id_certif"));
       colreponse.setCellValueFactory(new PropertyValueFactory<Certificat, String>("titre_certif"));
   colnbrq.setCellValueFactory(new PropertyValueFactory<Certificat, String>("date_certif"));
     AffichageCertif.setItems(list);
    }
    @FXML
    private void ajouterCertif(ActionEvent event) {
      try {

             if(event.getSource() == AjoutCertif)
             {
            String titre_certif = champsCertif.getText();
           String date_certif = date.getText();

           Certificat rep = new Certificat(22,titre_certif,date_certif);
           CertificatCRUD rc = new CertificatCRUD();
           // normalment appel l fct fillCombobox 
            rc.ajouterCertification(rep);
        }
           
             
             
       FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutCertificat.fxml"));
              showCertificats();
        Parent root = loader.load();
  
          champsCertif.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(AjoutCertificatController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
    }}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
