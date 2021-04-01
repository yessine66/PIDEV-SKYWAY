/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.categorie;
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
import Esprit.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author simop
 */
public class ListCellCatController extends ListCell<categorie> {

    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private Label lbtitre;
    @FXML
    private Label lbTheme;
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
    protected void updateItem(categorie categorie, boolean empty) {
        super.updateItem(categorie, empty);
        
        if(empty || categorie == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellCat.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
           // System.out.println(categorie.getNom_categorie());
            lbtitre.setText(categorie.getNom_categorie());
            
            ServiceCategorie sc = new ServiceCategorie();
            String nomTheme= sc.getName_theme(categorie.getId_t());
            lbTheme.setText(nomTheme);

            
            String url = categorie.getImage();
            Image image = new Image("http://127.0.0.1/image/"+url);
            imev.setImage(image);
            
           // lbdesc.setText(theme.getDescription());
          //  lbduree.setText(toString().valueOf(cours.getDuree()));
            /*Image getAbsolutePath=null; 
            Image image =new Image(actualite.getImage_ac());
            imev.setImage(image);*/
            //dateac.setText(actualite.getDate());
                     

            setText(null);
            setGraphic(gridp);
            
            }
    
    }
    
}

