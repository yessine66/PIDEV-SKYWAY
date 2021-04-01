/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.theme;
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
 * @author simop
 */
public class ListCellThemeController extends ListCell<theme>  {

    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private Label lbtitre;
    @FXML
    private Label lbdesc;
    @FXML
    private VBox vb11;
    @FXML
    private ImageView imev;
    @FXML
    private Label dateac;
    private FXMLLoader mLLoader;

    /**
     * Initializes the controller class.
     */
   @Override
    protected void updateItem(theme theme, boolean empty) {
        super.updateItem(theme, empty);
        
        if(empty || theme == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellTheme.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            System.out.println(theme.getNom_t());
            lbtitre.setText(theme.getNom_t());
            
            String url = theme.getImage();
            Image image = new Image("http://127.0.0.1/image/"+url);
            imev.setImage(image);
            
           
        
          
                     

            setText(null);
            setGraphic(gridp);
            
            }
    
    }
    
    
    
}