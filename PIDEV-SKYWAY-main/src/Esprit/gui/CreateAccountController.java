/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mega-pc
 */
public class CreateAccountController implements Initializable {
    
    ObservableList listRole = FXCollections.observableArrayList();

    @FXML
    private AnchorPane anchorPaneCreateAccount;
    @FXML
    private Label labelCreateAccount;
    @FXML
    private ChoiceBox<String> choiceBoxRole;
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonBack;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadRole();
    } 
    
    
    
    
    
    
        private void loadRole(){
        listRole.removeAll(listRole);
        String enseigant="Enseignant";
        String apprenant="Apprenant";
        listRole.addAll(enseigant,apprenant);
        choiceBoxRole.getItems().addAll(listRole);
        choiceBoxRole.setValue(apprenant);
        
        
        
        
    }

    @FXML
    private void handleButtonSubmitAction(ActionEvent event) throws IOException {
        
        
         switch (choiceBoxRole.getValue()) {
                    case "Enseignant":
                        System.out.println("enseignant");
                                  
                                        Parent CreateAccountEnseignantParent = FXMLLoader.load(getClass().getResource("CreateAccountEnseignantFXML.fxml"));
                                        Scene sceneCreateAccountEnseignant = new Scene(CreateAccountEnseignantParent);
                                        Stage windowens = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        windowens.setScene(sceneCreateAccountEnseignant);
                                        windowens.show();

                        break;
                    case "Apprenant":
                        System.out.println("apprenant");
                     
                                        Parent CreateAccountApprenantParent = FXMLLoader.load(getClass().getResource("CreateAccountApprenantFXML.fxml"));
                                        Scene sceneCreateAccountApprenant = new Scene(CreateAccountApprenantParent);
                                        Stage windowap = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        windowap.setScene(sceneCreateAccountApprenant);
                                        windowap.show();

                        break;

                    default:
                        break;
                        
         }
        
        
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
        System.out.println("Back Button clicked");
        
                    Parent LoginParent = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
                    Scene loginScene = new Scene(LoginParent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(loginScene);
                    window.show();
    }
    
}
