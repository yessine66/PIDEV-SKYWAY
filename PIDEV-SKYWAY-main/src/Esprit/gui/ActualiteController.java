/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.GUI;

import Esprit.entities.Actualite;
import Esprit.services.ActualiteService;
import Esprit.services.EvenementService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;




import javax.swing.JFileChooser;


/**
 * FXML Controller class
 *
 * @author khouja safa
 */
public class ActualiteController implements Initializable {

    @FXML
    private Tab TabList;
    @FXML
    private TextField BtnRech;
    @FXML
    private ListView<Actualite> ListAct;
    @FXML
    private Tab TabAdd;
    @FXML
    private TextField TFtitre;
    @FXML
    private TextField TFdesc;
    @FXML
    private TextField TFimage;
    @FXML
    private ChoiceBox<String> Cbev;
    @FXML
    private TextField TFutilisateur;
    @FXML
    private Button BtnAjout;
    @FXML
    private Tab TabUpdate;
    @FXML
    private TextField TFtitrem;
    @FXML
    private TextField TFdescm;
    @FXML
    private TextField TFimagem;
    @FXML
    private ChoiceBox<String> Cbevm;
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
    private Actualite ac = null ;
    
    
    private boolean update;
    int actualite_id;
    @FXML
    private Label LabDet1;
    @FXML
    private Button btnImage;
    @FXML
    private ImageView ico;
    @FXML
    private ImageView ico1;
    @FXML
    private ImageView ico2;
    @FXML
    private Button btnImage1;
    @FXML
    private ImageView ico3;
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
    private TabPane tp;
    @FXML
    private TextField TFidm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        /*ActualiteService act = new ActualiteService();
        ObservableList<Actualite> list =  act.readAll();
        
        ListAct.setItems(list);
        ListAct.setCellFactory((ListView<Actualite> ListView) -> new ListCellController());*/
                
    }            
        private void loadData() {
            
        ActualiteService act = new ActualiteService();
        ObservableList<Actualite> list =  act.readAll();
        
        ListAct.setItems(list);
        ListAct.setCellFactory((ListView<Actualite> ListView) -> new ListCellController());
        showCombo();
        }
        
        public void showCombo(){
        
        EvenementService ev = new EvenementService();
        ObservableList<String> listevenement = ev.comboEve();
        Cbev.setItems(listevenement);
        Cbevm.setItems(listevenement);
    }  

    void setUpdate(boolean b) {
    this.update = b;
    }

    @FXML
    private void btnAjoutAction(ActionEvent event) {
        try {

             if(event.getSource() == BtnAjout)
             {
                String titre_ac = TFtitre.getText();
                String desc = TFdesc.getText();
                String im =TFimage.getText();
                im=im.replace("\\","\\\\");
                String nom_ev=Cbev.getSelectionModel().getSelectedItem();
                Actualite act = new Actualite(titre_ac,desc,im,nom_ev,100);
                ActualiteService acts = new ActualiteService();
                acts.ajouterActualite(act);
             }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Actualite.fxml"));
            Parent root = loader.load();
  
            TFtitre.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            }
                     
    }

    @FXML
    private void btnModifAction(ActionEvent event) {
        
        try {

             if(event.getSource() == BtnModif)
             {
                int id_ac =Integer.parseInt(TFidm.getText());
                String titre_ac = TFtitrem.getText();
                String desc = TFdescm.getText();
                String im =TFimagem.getText();
                String nom_ev=Cbev.getSelectionModel().getSelectedItem();
                Actualite act = new Actualite(id_ac,titre_ac,desc,im,nom_ev,100);
                ActualiteService acts = new ActualiteService();
                acts.editer(act);
             }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Actualite.fxml"));
            Parent root = loader.load();
  
            TFtitre.getScene().setRoot(root);
            }
           
           catch (IOException ex) {
            } catch (SQLException ex) {
            Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void importImage(ActionEvent event) {
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        TFimage.setText(f.getAbsolutePath());
        }

    @FXML
    private void btnActionRefrech(ActionEvent event) {
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Actualite.fxml"));
        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        loadData();
    }

    @FXML
    private void btnActionView(ActionEvent event) {
        ac = ListAct.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource("Actualite.fxml"));
            TabDetail.getContent();
            LabDet1.setText(ac.getTitre_ac());
            LabDet.setText(ac.getDesc());//,ac.getEvenement());
            tp.getSelectionModel().select(TabDetail);
            
    }

    @FXML
    private void btnActionUpdate(ActionEvent event) {
         ac = ListAct.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource("Actualite.fxml"));
            TabUpdate.getContent(); 
            TFidm.setText(toString().valueOf(ac.getId_ac()));
            TFtitrem.setText(ac.getTitre_ac());
            TFdescm.setText(ac.getDesc());//,ac.getEvenement());
            TFimagem.setText(ac.getImage_ac());
            TFutilisateur.setText(toString().valueOf(ac.getUser()));
            tp.getSelectionModel().select(TabUpdate);
    }

    @FXML
    private void btnActionDelete(ActionEvent event) {
        ac = ListAct.getSelectionModel().getSelectedItem();
            int str = ac.getId_ac();
             ActualiteService acts = new ActualiteService();
        try {
            acts.supprimer(str);
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadData();
    }

     
    
}
