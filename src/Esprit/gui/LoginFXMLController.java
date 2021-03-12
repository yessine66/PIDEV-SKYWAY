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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mega-pc
 */
public class LoginFXMLController implements Initializable {

    ObservableList listRole = FXCollections.observableArrayList();
    
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private AnchorPane anchorPaneLogin;
    @FXML
    private Label labelWelcome;
    @FXML
    private Button butttonCreateNewAccount;
    @FXML
    private ChoiceBox<String> choiceBoxRole;

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

    private void handleButtonAction(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonCreateAccountAction(ActionEvent event) throws IOException {
        System.out.println("boutton create account clicked");
                                       Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();
    }

    @FXML
    private void handleButtonLoginAction(ActionEvent event) throws IOException {
        System.out.println("button login clicked");
        
        if("Admin".equals(choiceBoxRole.getValue()) ||"Enseignant".equals(choiceBoxRole.getValue()) ){
            System.out.println("admin wala mou3alem");
                                                    Parent menuBackParent = FXMLLoader.load(getClass().getResource("MenuBack.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
        }
        else if("Apprenant".equals(choiceBoxRole.getValue()) ) {
            System.out.println("apprenant");
                                                                Parent menuFrontParent;
            menuFrontParent = FXMLLoader.load(getClass().getResource("MenuFrontFXML.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuFrontParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
        }
        
        
        /*
                    switch (choiceBoxRole.getValue()) {
                    case "Enseignant":
                        System.out.println("enseignant");
                                    
                                        Parent menuBackParent = FXMLLoader.load(getClass().getResource("MenuBackFXML.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
//todo
                        break;
                    case "Apprenant":
                        System.out.println("apprenant");
//todo
                        break;
                    case "Admin":
                        System.out.println("admin");
                                                                Parent menuBackParent = FXMLLoader.load(getClass().getResource("MenuBackFXML.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
//todo
                        
                        break;
                    default:
                        break;
                }*/
        
    }
    
    private void loadRole(){
        listRole.removeAll(listRole);
        String admin="Admin";
        String enseigant="Enseignant";
        String apprenant="Apprenant";
        listRole.addAll(admin,enseigant,apprenant);
        choiceBoxRole.getItems().addAll(listRole);
        choiceBoxRole.setValue(apprenant);
        
        
        
        
    }
    
    
    
}