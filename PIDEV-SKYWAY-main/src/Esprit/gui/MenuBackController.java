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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class MenuBackController implements Initializable {
    
    private Utilisateur userlogin;

    @FXML
    private BorderPane bps;
    @FXML
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
    private void cours(MouseEvent event) {
        LoadPage("Page1cours");
    }

    @FXML
    private void test(MouseEvent event) {
        LoadPage("Page2Test");
    }

    @FXML
    private void evenement(MouseEvent event) {
        LoadPage("Page3Evenement");
    }

    @FXML
    private void partenariat(MouseEvent event) {
        LoadPage("Page4Partenaire");
    }

    @FXML
    private void communication(MouseEvent event) {
        LoadPage("Page5CommunicationController");
    }

    @FXML
    private void compte(MouseEvent event) {
        LoadPage("Page6Compte");
    }
     private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    bps.setCenter(root);
    
    
    
    
    }
    
}
