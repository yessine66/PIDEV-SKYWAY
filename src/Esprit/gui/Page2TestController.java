/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class Page2TestController implements Initializable {

    @FXML
    private Button Question;
    @FXML
    private AnchorPane anchort;
    @FXML
    private AnchorPane anchorprojection;
    @FXML
    private Button Reponse;
    @FXML
    private Button Certificat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void btnQuestion(ActionEvent event) {
     LoadPage("BackQuestion");
    }

    @FXML
    private void btnReponse(ActionEvent event) {
        LoadPage("BackReponse");
    }

    @FXML
    private void btnCertificat(ActionEvent event) {
        LoadPage("BackCertificat");
    }
    private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Page2TestController.class.getName()).log(Level.SEVERE, null, ex);
        }

anchorprojection.getChildren().setAll(root);
         
            
            

            
            
            
            
            
        
       
    
    
    }
    
}
