/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Questions;
import Esprit.entities.Reponses;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class ListCellReponsesController extends ListCell<Reponses>{
private FXMLLoader mLLoader;
    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private Label lbnomp;
    @FXML
    private Label lbcode;
    @FXML
    private Label lbdated;
    @FXML
    private Label lbdatef;
    @FXML
    private VBox vb11;
    @FXML
    private Label lbreduction;
    @FXML
    private Label lbid;

    /**
     * Initializes the controller class.
     */
    
    
 @Override
    protected void updateItem(Reponses reponses, boolean empty) {
        super.updateItem(reponses, empty);
        
        if(empty || reponses == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellReponses.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            lbcode.setText(reponses.getText_r2());
            lbdated.setText(reponses.getText_r3());
            lbdatef.setText(reponses.getText_r4());
          lbid.setText(reponses.getText_r1());
        
       //     Image image =new Image("http://127.0.0.1/image/"+url);
         //   imev.setImage(image);
            //lbdate.setText(toString().valueOf(partenaire.getDate_ajout()));
            setText(null);
            System.out.println("aaaaaaaaaaaaa");
            setGraphic(gridp);
            
            }
    
    }
}