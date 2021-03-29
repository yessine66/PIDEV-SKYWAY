/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.GUI;

import Esprit.entities.Actualite;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.ImageIcon;

/**
 * FXML Controller class
 *
 * @author khouja safa
 */
    public class ListCellController extends ListCell<Actualite>{

    @FXML
    private Label lbtitre;
    @FXML
    private Label lbdesc;
    @FXML
    private ImageView imev;
    @FXML
    private Label dateac;
    
    private FXMLLoader mLLoader;
    @FXML
    private VBox vb1;
    public Button deleteIcon;
    public Button editIcon;
    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb11;

    /**
     * Initializes the controller class.
     * @param actualite
     */
    
    @Override
    protected void updateItem(Actualite actualite, boolean empty) {
        super.updateItem(actualite, empty);
        
        if(empty || actualite == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            lbtitre.setText(actualite.getTitre_ac());
            lbdesc.setText(actualite.getDesc());
            /*Image getAbsolutePath=null; 
            Image image =new Image(actualite.getImage_ac());
            imev.setImage(image);*/
//dateac.setText(actualite.getDate());
                     

            setText(null);
            setGraphic(gridp);
            
            }
    
    }

}
