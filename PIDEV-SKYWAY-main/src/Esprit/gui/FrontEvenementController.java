/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Evenement;
import Esprit.services.EvenementService;
import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author khouja safa
 */
public class FrontEvenementController implements Initializable {

    @FXML
    private JFXTabPane tp;
    @FXML
    private Tab TabList;
    @FXML
    private VBox hb2;
    @FXML
    private Button refreshicon;
    @FXML
    private Button viewicon;
    @FXML
    private ListView<Evenement> ListEv;
    @FXML
    private TextField BtnRech;
    @FXML
    private Tab TabDetail;
    @FXML
    private Label LabDet;
    @FXML
    private Label LabDet1;
    
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    private Evenement ev = null ;
    private boolean update;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadData();
    }    
    private void loadData() {
            
        EvenementService ev = new EvenementService();
        ObservableList<Evenement> list =  ev.readAll();
        
        ListEv.setItems(list);
        ListEv.setCellFactory((ListView<Evenement> ListView) -> new ListCellEController());
    }

    void setUpdate(boolean b) {
        
        this.update = b;
    }

    @FXML
    private void btnActionRefrechEv(ActionEvent event) {
        ListEv.getItems().removeAll(ev);
        loadData();
    }

    @FXML
    private void btnActionViewEv(ActionEvent event) {
         ev = ListEv.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Evenement.fxml"));
        TabDetail.getContent();
        LabDet1.setText(ev.getNom_ev());
        LabDet.setText(toString().valueOf(ev.getDate_ev().getDate())+"\n"+ev.getEspace()+"\n"+ev.getNombre_pl());
        tp.getSelectionModel().select(TabDetail);
    }

    @FXML
    private void btnActionRetour(ActionEvent event) {
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("dashBoard.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Page1CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
