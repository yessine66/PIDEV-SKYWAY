/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Evenement;
import Esprit.entities.Utilisateur;
import Esprit.services.EvenementService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;
import org.controlsfx.control.Notifications;



/**
 * FXML Controller class
 *
 * @author khouja safa
 */
public class EvenementController implements Initializable {

    @FXML
    private ListView<Evenement> ListEv;
    @FXML
    private Button BtnAjout;
    @FXML
    private Tab TabUpdate;
    @FXML
    private Button BtnModif;
    @FXML
    private Tab TabDetail;
    @FXML
    private Label LabDet;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    private Evenement ev = null ;
    private boolean update;
    
    private Utilisateur userlogin;
    
    @FXML
    private Label LabDet1;
    @FXML
    private TabPane tp;
    @FXML
    private TextField TFidm;
    @FXML
    private TextField TFnom;
    @FXML
    private DatePicker TFdate;
    @FXML
    private TextField TFespace;
    @FXML
    private TextField TFnbrpl;
    @FXML
    private TextField TFnomm;
    @FXML
    private DatePicker TFdatem;
    @FXML
    private TextField TFespacem;
    @FXML
    private TextField TFnbrplm;
    @FXML
    private Tab TabList;
    @FXML
    private VBox hb2;
    @FXML
    private Button refreshicon;
    @FXML
    private Button viewicon;
    @FXML
    private Button editIcon;
    @FXML
    private Button deleteIcon;
    @FXML
    private TextField BtnRech;
    @FXML
    private Tab TabAdd;
    @FXML
    private Button btnMap;
    @FXML
    private Button btnImage1;
    @FXML
    private Label erreurtitreev;
    @FXML
    private Label erreurdateev;
    @FXML
    private Label erreurplace;
    @FXML
    private Label erreurnombre;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
        TFnom.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty())
                    erreurtitreev.setText("Il faut remplir le champ");
                else
                    erreurtitreev.setText("");
                }       
            });
        
        TFnom.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            TFnom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            erreurtitreev.setText("le non doit comporter que des caractères");
        }
        });
        
        TFespace.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.isEmpty())
                erreurplace.setText("Il faut remplir le champ");
            else
                erreurplace.setText("");
            }       
        });
        
        TFespace.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            TFespace.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            erreurplace.setText("le non doit comporter que des caractères");
        }
        });
        
        TFnbrpl.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s1-9*")) {
            erreurnombre.setText(newValue.replaceAll("[^\\s1-9]", ""));
        }
        });
        
    }            
    public void initData(Utilisateur usereo){
        userlogin = usereo;
        System.out.println(userlogin+ "\n rolte mte3ou "+ userlogin.getRoleUser() );
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
    private void btnAjoutActionEv(ActionEvent event) throws SQLException {
        
        if(event.getSource() == BtnAjout){
            String nom_ev = TFnom.getText();
            Date date = Date.valueOf(TFdate.getValue());
            String espace =TFespace.getText();
            int nombre_pl=Integer.parseInt(TFnbrpl.getText());
            //int id_user=Integer.parseInt(TFuser.getText());
            Evenement evenement = new Evenement(nom_ev, date, espace, nombre_pl,10);
            EvenementService events = new EvenementService();
            events.ajouterEvenement(evenement);
            Image img = new Image("/pic/check.png");
            Notifications notification;
            notification = Notifications.create()
                    .title("Ajouté avec succée")
                    .text("Done !!")
                    .graphic(new ImageView(img))
                    
                    .position(Pos.BASELINE_RIGHT)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on notification");
                        }
                    });
            notification.show();
        }
        tp.getSelectionModel().select(TabList);
        ListEv.getItems().removeAll(ev);
        loadData();        
    }

    @FXML
    private void btnModifActionEv(ActionEvent event) {
        
        if(event.getSource() == BtnModif){
            int id_ev =Integer.parseInt(TFidm.getText());
            String nom_ev = TFnomm.getText();
            Date date = Date.valueOf(TFdatem.getValue())/*.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))*/;
            String espace =TFespacem.getText();
            int nombre_pl =Integer.parseInt(TFnbrplm.getText());
            Evenement evenement = new Evenement(id_ev,nom_ev, date, espace, nombre_pl,10);
            EvenementService events = new EvenementService();
            events.editer(evenement);
            Image img = new Image("/pic/check.png");
                Notifications notification;
                notification = Notifications.create()
                    .title("Modifier avec succée")
                    .text("Done !!")
                    .graphic(new ImageView(img))
                    
                    .position(Pos.BASELINE_RIGHT)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on notification");
                        }
                    });
            notification.show();
        }
        tp.getSelectionModel().select(TabList);
        ListEv.getItems().removeAll(ev);
        loadData();
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
    private void btnActionUpdateEv(ActionEvent event) {
        
        ev = ListEv.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Evenement.fxml"));
        TabUpdate.getContent();
        TFidm.setText(toString().valueOf(ev.getId_ev()));
        TFnomm.setText(ev.getNom_ev());
        TFdatem.setValue(LocalDate.parse(toString().valueOf(ev.getDate_ev())));
        TFespacem.setText(ev.getEspace());
        TFnbrplm.setText(toString().valueOf(ev.getNombre_pl()));
        tp.getSelectionModel().select(TabUpdate);
    }

    @FXML
    private void btnActionDeleteEv(ActionEvent event) {
        
        ev = ListEv.getSelectionModel().getSelectedItem();
        int str = ev.getId_ev();
        EvenementService evs = new EvenementService();
        try {
            evs.supprimer(str);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadData();
    }

     
    
}
