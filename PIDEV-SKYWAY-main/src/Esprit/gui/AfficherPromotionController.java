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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AfficherPromotionController implements Initializable {

    @FXML
    private ListView<Promotion> listViewPromC;
    @FXML
    private Button jouzbtnp;

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
      listViewPromC.setCellFactory((ListView<Promotion> ListView) -> new ListCellPromFrontController());
    }

    @FXML
    private void jouezbtnp(ActionEvent event) throws IOException {
          Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
      LotteryWheel wheel = new LotteryWheel();
      wheel.start(stage);
    }
    


/*
     @FXML
    private void jouezbtnp(ActionEvent event) throws IOException {
          Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
      LotteryWheel wheel = new LotteryWheel();
      wheel.start(stage);
    }
    
    
    */





    
    
}
