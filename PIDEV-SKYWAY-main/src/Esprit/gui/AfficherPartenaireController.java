/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.partenaire;
import Esprit.services.partenaireCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AfficherPartenaireController implements Initializable {

    @FXML
    private ListView<partenaire> listViewPart2;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPartenaireClient();
    }    
    
      public void showPartenaireClient(){
      
        partenaireCRUD parc = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<partenaire> list =  parc.partenaireList();
        
     
        listViewPart2.setItems(list);
         listViewPart2.setCellFactory((ListView<partenaire> ListView) -> new ListCellPartIdController());
    }


   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
