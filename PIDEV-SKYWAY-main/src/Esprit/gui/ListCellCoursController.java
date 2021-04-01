/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.cours;
import java.io.File;
import Esprit.services.ServiceCours;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ListCellCoursController extends ListCell<cours> {

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
    private FXMLLoader mLLoader;
    @FXML
    private Label lbcategorie;
    /**
     * Initializes the controller class.
     */
    @Override
    protected void updateItem(cours cours, boolean empty) {
        super.updateItem(cours, empty);
        
        if(empty || cours == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellCours.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
           //System.out.println(cours.getNom_c());
            lbtitre.setText(cours.getNom_c());
            lbdesc.setText(cours.getDescription());
            ServiceCours sc = new ServiceCours();
            String nomCategorie= sc.getName_cat(cours.getId_t());
           // System.out.println("voir nom categorie : "+nomCategorie);
            lbcategorie.setText(nomCategorie);
            
            String url = cours.getImage();
            Image image = new Image("http://127.0.0.1/image/"+url);
            imev.setImage(image);
            
            
            
           // lbcategorie.setText();
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
