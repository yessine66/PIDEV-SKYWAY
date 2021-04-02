/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Utilisateur;
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
 * @author simop
 */
public class DashBoardController implements Initializable {
    
        private Utilisateur userlogin;


    @FXML
    private Button btnCours;
    @FXML
    private Button btnTests;
    @FXML
    private Button btnReclamations;
    @FXML
    private Button btnPartenaires;
    @FXML
    private Button btnEvenements;
    @FXML
    private Button buttonLogOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
        public void initData(Utilisateur usereo){
        userlogin = usereo;
        System.out.println(userlogin+ "\n rolte mte3ou "+ userlogin.getRoleUser() );
    }

    @FXML
    private void handleButtonCoursAction(ActionEvent event) throws IOException {
        System.out.println("\nCours clicked");
        
       // System.out.println("\n\na7na tawa fel boutton mtaa cours front: \n"+userlogin);
        LoginFXMLController mmmmmm = new LoginFXMLController();
          Utilisateur usermimi = LoginFXMLController.usertest;
                FXMLLoader loader = new FXMLLoader();
                    loader.setLocation((getClass().getResource("AfficherTheme.fxml")));
            
                                                    Parent menuBackParent = loader.load();
                                                    
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        
//                                        AfficherThemeController controller=loader.getController();
//                                        controller.initData(userlogin);
//                                        
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
        
    }

    @FXML
    private void handleButtonTestsAction(ActionEvent event) throws IOException {
        System.out.println("\n Tests clicked");
        
                                               Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("categorietests.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();
 
        
    }

    @FXML
    private void handleButtonReclamationsAction(ActionEvent event) throws IOException {
        System.out.println("\n reclamations clicked");
      
                                        Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("ReclamationTable.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();

 
        
    }

    @FXML
    private void handleButtonPartenairesAction(ActionEvent event) throws IOException {
        System.out.println("\n Partenaires clicked");
        
                                                       Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("FrontPartenaire4.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();
    }

    @FXML
    private void handleButtonEvennementsAction(ActionEvent event) throws IOException {
    
        Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("FrontEvents.fxml"));
        Scene reateAccountScene = new Scene(CreateAccountParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(reateAccountScene);
        window.show();

        
    }

    @FXML
    private void handleButtonLogOutAction(ActionEvent event) throws IOException {
                      LoginFXMLController mmmmmm = new LoginFXMLController();
              Utilisateur usermimi = LoginFXMLController.usertest;
              usermimi=null;
              
                                        Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();
    }
    
}
