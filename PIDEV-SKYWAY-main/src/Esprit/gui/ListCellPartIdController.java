/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.partenaire;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListCellPartIdController extends ListCell<partenaire> {
private FXMLLoader mLLoader;
    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private Label lbnom;
    @FXML
    private Label lbdomaine;
    @FXML
    private Label lbmail;
    @FXML
    private VBox vb11;
    @FXML
    private Label lbdate;
    @FXML
    private ImageView imev;

    /**
     * Initializes the controller class.
     */
      @Override
    protected void updateItem(partenaire partenaire, boolean empty) {
        super.updateItem(partenaire, empty);
        
        if(empty || partenaire == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellPartId.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            lbnom.setText(partenaire.getNom_p());
               
          lbdomaine.setText(partenaire.getDomaine());
          lbdate.setText(partenaire.getDate_p());
          lbmail.setText(partenaire.getMailP());
            String url= partenaire.getLogoP(); 
                
            Image image =new Image("http://127.0.0.1/image/"+url);
            imev.setImage(image);
            //lbdate.setText(toString().valueOf(partenaire.getDate_ajout()));
            setText(null);
            setGraphic(gridp);
            
            }
    
    } 
    
}
