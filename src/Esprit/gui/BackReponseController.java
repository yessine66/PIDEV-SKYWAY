/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.services.ReponsesCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class BackReponseController implements Initializable {

    @FXML
    private TextArea champsReponse;
    @FXML
    private Button AjoutReponse;
    @FXML
    private ComboBox<Integer> combor;
    @FXML
    private AnchorPane AnchorReponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          showCombobox();
    }    
 public void showCombobox()
     {
          ReponsesCRUD reponse = new ReponsesCRUD();
         ObservableList<Integer> listrep = reponse.comboreponse ();
    
      combor.setItems(listrep);
         
     }
    @FXML
    private void ajouterReponse(ActionEvent event) {
       
    }
    
}
