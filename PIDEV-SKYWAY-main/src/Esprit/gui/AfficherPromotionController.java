/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Promotion;
import Esprit.entities.partenaire;
import Esprit.services.partenaireCRUD;
import Esprit.services.promotionCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AfficherPromotionController implements Initializable {

    @FXML
    private ListView<Promotion> listViewPromC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPartenaireClient();
    }







   public void showPartenaireClient(){
      
        promotionCRUD parc = new promotionCRUD();
            //parc.partenaireList();
        ObservableList<Promotion> listPromClient =  parc.PromotionListClient();
        
       listViewPromC.setItems(listPromClient);
    }
    








    
    
}
