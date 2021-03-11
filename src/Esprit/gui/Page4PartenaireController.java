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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class Page4PartenaireController implements Initializable {

    @FXML
    private Button partenariat;
    @FXML
    private Button promotion;
    @FXML
    private AnchorPane anchorprojection;
    @FXML
    private Button gagnant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnPartenariat(ActionEvent event) {
        LoadPage("AjouterPartenaire");
    }

    @FXML
    private void btnPromotion(ActionEvent event) {
        LoadPage("AjouterPromotion");
    }
    private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Page4PartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }

anchorprojection.getChildren().setAll(root);

    
    }

    @FXML
    private void btnJouer(ActionEvent event) {
                LoadPage("GagnantPromotion");
    }
}
