/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Promotion;
import Esprit.entities.partenaire;
import Esprit.services.partenaireCRUD;

import Esprit.services.promotionCRUD;
import Esprit.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterPromotionController implements Initializable {

    @FXML
    private TextField tidpro;
    @FXML
    private TextField tcodepro;
    @FXML
    private TextField treduction;
    @FXML
    private Button btnAjouterPro;
    @FXML
    private Button btnModifierPro;
    @FXML
    private Button btnSupprimerPro;
    @FXML
    private TableView<Promotion> tvPromotion;
    @FXML
    private TableColumn<Promotion, Integer> colIdpro;
    @FXML
    private TableColumn<Promotion, String> colCodepro;
    @FXML
    private TableColumn<Promotion, Integer> colReduction;
    @FXML
    private TableColumn<Promotion, Integer> colIdparEtr;
    @FXML
    private ComboBox<Integer> comboPar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPromotion();
        showCombo();
       
    }    
     public void showCombo()
     {
          promotionCRUD parc = new promotionCRUD();
         ObservableList<Integer> listCom =       parc. comboListPar ();
    
      comboPar.setItems(listCom);
         
     }
    
     public void showPromotion(){
      
        promotionCRUD parc = new promotionCRUD();
            //parc.promotionList();
        ObservableList<Promotion> list =  parc.PromotionList();
        
       colIdpro.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("id_prom"));
       colCodepro.setCellValueFactory(new PropertyValueFactory<Promotion, String>("code_p"));
       colReduction.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("reduction"));
   colIdparEtr.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("id_p"));
     tvPromotion.setItems(list);
    }
    
    

    @FXML
    private void btnPromotionAction(ActionEvent event) {
        
        
        
         try {

             if(event.getSource() == btnAjouterPro)
             {
            String rCodepro = tcodepro.getText();
      
            int rReduction= Integer.parseInt(treduction.getText()) ;
         String valuePart=comboPar.getValue().toString();
           int rIdpart= Integer.parseInt(valuePart) ;
            
            //int rIdPartenaore = Integer.parseInt(tId partenaire.getText()) ;
           Promotion pro = new Promotion(22,rCodepro,rReduction,rIdpart);
           promotionCRUD proc = new promotionCRUD();
           // normalment appel l fct fillCombobox 
            proc.ajouterPromotion(pro);
        }
             
             else if (event.getSource() == btnModifierPro)
             
             
             {
                // int mIdp= tidp.getText();
           int  mIdpro= Integer.parseInt(tidpro.getText()) ;
             String mCodepro = tcodepro.getText();
            int mReduction= Integer.parseInt(treduction.getText()) ;
               String valuePart=comboPar.getValue().toString();
           int rIdpart= Integer.parseInt(valuePart) ;
            
          Promotion pro = new Promotion(mIdpro,mCodepro,mReduction, rIdpart);
       promotionCRUD proc = new promotionCRUD();
           proc.modifierPromotion(pro);
                 
             }
             
               
             else if (event.getSource() == btnSupprimerPro)
             {
                 
                 
      int  mIdpro= Integer.parseInt(tidpro.getText()) ;
     
    Promotion pro = new Promotion(mIdpro);
     promotionCRUD proc = new promotionCRUD();
       proc.supprimerPromotion(pro);
                 
                 
                 
                  
                  
             }
             
             
             
             
             
            //Afficher Personne
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterPromotion.fxml"));
              showPromotion();
        Parent root = loader.load();
  
          tcodepro.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(AjouterPartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
