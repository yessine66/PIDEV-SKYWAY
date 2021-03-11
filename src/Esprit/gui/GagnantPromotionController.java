/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.partenaire;
import Esprit.services.partenaireCRUD;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class GagnantPromotionController implements Initializable {

    @FXML
    private ListView<String> tvwinner;
    @FXML
    private Button btnwinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //showWinner();
    }


 public void showWinner(){
      
        partenaireCRUD win = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<String> randlist =  win.randomList();
        
     
        tvwinner.setItems(randlist);
    }

    @FXML
    private void btnwwinner(ActionEvent event) {
        showWinner();
        /* if(event.getSource() == btnwinner)
             {
                 /* try 
                  { showWinner();
            
            /************************************/
         
       /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("gagnatPromotion.fxml"));
            Parent root =loader.load();
            AfficherPartenaireController afficherPartenaire= loader.getController();
            // AjouterPromotionController.showInformation();
            
            Stage stage = new Stage();
            stage.setScene(new Scene (root));
            stage.setTitle("display partenaire");
            stage.show();
                  }
                  
       
  
            catch (IOException ex) {
            Logger.getLogger(AjouterPartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            */
            
            
            
            
            
            
                  // }
        }
    }
    
    
    
    















    
    
