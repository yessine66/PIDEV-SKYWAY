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
 * @author khouja safa
 */
public class Page3EvenementController implements Initializable {

    @FXML
    private Button btnactualite;
    @FXML
    private Button btnevenement;
    @FXML
    private AnchorPane anchorprojection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnactualite(ActionEvent event) {
        LoadPage("Actualite");
    }

    @FXML
    private void btnevenement(ActionEvent event) {
        LoadPage("Evenement");
    }
    private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Page1CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    anchorprojection.getChildren().setAll(root);

    }
}
