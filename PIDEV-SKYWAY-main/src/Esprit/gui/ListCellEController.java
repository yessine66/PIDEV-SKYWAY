/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.GUI;

import Esprit.entities.Evenement;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author khouja safa
 */
    public class ListCellEController extends ListCell<Evenement>{

    @FXML
    private Label lbtitre;
    private Label lbdesc;
    
    private FXMLLoader mLLoader;
    @FXML
    private VBox vb1;
    public Button deleteIcon;
    public Button editIcon;
    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb11;
    @FXML
    private Label lbespace;
    @FXML
    private Label lbnbrpl;
    @FXML
    private Label datev;

    /**
     * Initializes the controller class.
     * @param evenement
     */
    
    @Override
    protected void updateItem(Evenement evenement, boolean empty) {
        super.updateItem(evenement, empty);
        
        if(empty || evenement == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellE.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            lbtitre.setText(evenement.getNom_ev());
            lbespace.setText(evenement.getEspace());
            lbnbrpl.setText(toString().valueOf(evenement.getNombre_pl()));
            datev.setText(toString().valueOf(evenement.getDate_ev()));
            /*Image getAbsolutePath=null; 
            Image image =new Image(actualite.getImage_ac());
            imev.setImage(image);*/
//dateac.setText(actualite.getDate());
                     

            setText(null);
            setGraphic(gridp);
            
            }
    
    }

}
