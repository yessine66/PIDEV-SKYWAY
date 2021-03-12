/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mega-pc
 */
public class Page6CompteController implements Initializable {

    @FXML
    private Button buttonGereEnseignant;
    @FXML
    private Button buttonGererCompte;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonGereEnseignantAction(ActionEvent event) throws IOException {
                                       System.out.println("Log out button clicked");
                    Parent LoginParent = FXMLLoader.load(getClass().getResource("GestionEnseignantFXML.fxml"));
                    Scene LoginScene = new Scene(LoginParent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(LoginScene);
                    window.show();
    }

    @FXML
    private void handleButtonGererComppteAction(ActionEvent event) throws IOException {
                                               System.out.println("Log out button clicked");
                    Parent LoginParent = FXMLLoader.load(getClass().getResource("GestionApprenantFXML.fxml"));
                    Scene LoginScene = new Scene(LoginParent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(LoginScene);
                    window.show();
    }
    
}
