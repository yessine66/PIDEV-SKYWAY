/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Promotion;
import Esprit.entities.partenaire;
import Esprit.services.ServiceCours;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListCellPromController  extends ListCell<Promotion> {

    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private VBox vb11;
    @FXML
    private Label lbnomp;
    @FXML
    private Label lbcode;
    @FXML
    private Label lbdated;
    @FXML
    private Label lbdatef;
    @FXML
    private Label lbreduction;
    private FXMLLoader mLLoader;

    /**
     * Initializes the controller class.
     */
     @Override
    protected void updateItem(Promotion promotion, boolean empty) {
        super.updateItem(promotion, empty);
        
        if(empty || promotion == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellProm.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
          lbnomp.setText(promotion.getNom_p());
          lbcode.setText(promotion.getCode_p());
           lbreduction.setText(toString().valueOf(promotion.getReduction()));
          
          lbdated.setText(promotion.getDateD());
          lbdatef.setText(promotion.getDateF());
      
         
            //lbdate.setText(toString().valueOf(partenaire.getDate_ajout()));
            setText(null);
            setGraphic(gridp);
            
            }
    
    }
  
    
}
