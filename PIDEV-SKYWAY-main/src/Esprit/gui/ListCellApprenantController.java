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
 * @author mega-pc
 */
public class ListCellApprenantController extends  ListCell<Utilisateur> {
    
    private FXMLLoader mLLoader;

    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private VBox vb11;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelAge;
    @FXML
    private Label labelGenre;
    @FXML
    private Label labelNumero;

    /**
     * Initializes the controller class.
     */
    
    
        @Override
    protected void updateItem(Utilisateur userx, boolean empty) {
        super.updateItem(userx, empty);
        
        if(empty || userx == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellApprenant.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            labelNom.setText(userx.getNomUser());
                 labelPrenom.setText(userx.getPrenomUser());
                labelAge.setText(toString().valueOf(userx.getAgeUser()));
                labelGenre.setText(userx.getGenreUser());
                labelNumero.setText(toString().valueOf(userx.getTelUser()));
                

            setText(null);
            setGraphic(gridp);
            
            }
    
    }
  
    
    
    
}
