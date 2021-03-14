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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FrontMenuController implements Initializable {

    @FXML
    private BorderPane front;
    @FXML
    private AnchorPane projection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cours(MouseEvent event) {
    }

    @FXML
    private void test(MouseEvent event) {
         LoadPage("FrontTest2");
    }

    @FXML
    private void evenement(MouseEvent event) {
    }

    @FXML
    private void partenariat(MouseEvent event) {
        LoadPage("FrontPartenaire4");
    }

    @FXML
    private void communication(MouseEvent event) {
    }

    @FXML
    private void compte(MouseEvent event) {
    }
      private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    front.setCenter(root);
    
    
    
    
    }
    
}
