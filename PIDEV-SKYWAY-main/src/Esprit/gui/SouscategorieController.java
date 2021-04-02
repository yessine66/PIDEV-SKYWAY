/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Questions;
import Esprit.services.QuestionsCRUD;
import Esprit.services.ReponsesCRUD;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class SouscategorieController implements Initializable {

    @FXML
    private BorderPane bps;
    @FXML
    private Button cppp;
    @FXML
    private Label comp;
 ReponsesCRUD rc= new ReponsesCRUD();
 QuestionsCRUD qc= new QuestionsCRUD();
 Questions q= new Questions();   /**
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
            Logger.getLogger(SouscategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    bps.setCenter(root);
    
    
    
    
    }
    
    
    @FXML
    private void cpp(MouseEvent event) {
        //if( comp.getText().equals (qc.returningid(q.getName_t())))
          LoadPage("FrontQuestion");
        
    }
    
}
