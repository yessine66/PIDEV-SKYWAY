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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class CategorietestsController implements Initializable {

    @FXML
    private Button svt1;
    @FXML
    private Button svt;
    @FXML
    private Button svt2;
    @FXML
    private Button svt3;
    @FXML
    private Button svt4;
    @FXML
    private AnchorPane categ;
    @FXML
    private BorderPane categs;
    @FXML
    private Button buttonBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CategorietestsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    categs.setCenter(root);
    
    
    
    
    }

    @FXML
    private void svt(MouseEvent event) {
         
    }
    

    @FXML
    private void maths(MouseEvent event) {
    }

    @FXML
    private void poo(MouseEvent event) {
        LoadPage("souscategorie");
    }

    @FXML
    private void littérature(MouseEvent event) {
    }

    @FXML
    private void histoire(MouseEvent event) {
    }

    @FXML
    private void handleActionButtonBack(ActionEvent event) throws IOException {
        
                                                      Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("dashBoard.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();
    }
}
