/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.GUI;

import Esprit.Connection.MyConnection;
import Esprit.Entities.Actualite;
import Esprit.Services.ActualiteService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.util.Callback;




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
    private ChoiceBox<?> evChoice;
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
    private ChoiceBox<?> evChoicem;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ActualiteService act = new ActualiteService();
        ObservableList<Actualite> list =  act.readAll();
        
        ListAct.setItems(list);
        ListAct.setCellFactory((ListView<Actualite> ListView) -> new ListCellController());
                
    }    
    private void importimage(ActionEvent event) {
       
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        String filname=f.getAbsolutePath();
    } 
        
        private void loadData() {
        
        /*ListCellController.deleteIcon.setOnMouseClicked((MouseEvent event)->{
            try {
            ac = ListAct.getSelectionModel().getSelectedItem();
            query = "DELETE FROM `actualite` WHERE id  ="+ ac.getId_ac();
            connection = MyConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
               } catch (SQLException ex) {
                   System.out.println(ex);
            } 
             
            });
        ListCellController.editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
            ac = ListAct.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource("/tableView/addStudent.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                System.out.println(ex);
                }
                            
            ActualiteController actualiteController = loader.getController();
            actualiteController.setUpdate(true);
            actualiteController.setTextField(actualite.getId_ac(), ac.getTitre_ac(), 
            ac.getDesc()/*,ac.getEvenement());
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
                         
          });*/
        }

    void setUpdate(boolean b) {
    this.update = b;
    }

    private void setTextField(int id_ac, String titre_ac, String desc) {
        
        actualite_id = id_ac;
        TFtitrem.setText(titre_ac);
        TFdescm.setText(desc);
    }

    @FXML
    private void btnAjoutAction(ActionEvent event) {
        try {

             if(event.getSource() == BtnAjout)
             {
                String titre_ac = TFtitre.getText();
                String desc = TFdesc.getText();
                String im =TFimage.getText();
                Actualite act = new Actualite(titre_ac,desc,im,100);
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
                             
                String titre_ac = TFtitre.getText();
                String desc = TFdesc.getText();
                String im =TFimage.getText();
                Actualite act = new Actualite(titre_ac,desc,im,100);
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

     
    
}
