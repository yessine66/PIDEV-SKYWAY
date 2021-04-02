/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Actualite;
import Esprit.entities.Utilisateur;
import Esprit.services.ActualiteService;
import Esprit.services.EvenementService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;







/**
 * FXML Controller class
 *
 * @author khouja safa
 */
public class FrontActualiteController implements Initializable {

    @FXML
    private Tab TabList;
    @FXML
    private TextField BtnRech;
    @FXML
    private ListView<Actualite> ListAct;
    @FXML
    private Tab TabDetail;
    @FXML
    private Label LabDet;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    private Actualite ac = null ;
    String img="";
    List<String> type;
    private boolean update;
    int actualite_id;
    private Utilisateur userlogin;
    @FXML
    private Label LabDet1;
    @FXML
    private VBox hb2;
    @FXML
    private Button refreshicon;
    @FXML
    private Button viewicon;
    @FXML
    private TabPane tp;
    @FXML
    private Button btnRetour;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //final WebEngine web = webv.getEngine();
        type =new ArrayList();
        type.add("*.jpg");
        type.add("*.png");
        loadData(); 
        
    }      
    
    public void initData(Utilisateur usereo){
        userlogin = usereo;
        System.out.println(userlogin+ "\n rolte mte3ou "+ userlogin.getRoleUser() );
    }
        private void loadData() {
            
        ActualiteService act = new ActualiteService();
        ObservableList<Actualite> list =  act.readAll();
        
        ListAct.setItems(list);
        ListAct.setCellFactory((ListView<Actualite> ListView) -> new ListCellController());
        }
    void setUpdate(boolean b) {
    this.update = b;
    }

    private String importerImage(ActionEvent event) {
    FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc=f.showOpenDialog(null);
        
        if(fc != null)
        {   
            //System.out.println(fc.getName());
            img=fc.getName();
           FileSystem fileSys = FileSystems.getDefault();
           Path srcPath= fc.toPath();
           Path destPath= fileSys.getPath("C:\\wamp64\\www\\image\\"+fc.getName());
            try {
                Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                System.out.println(ex);
            }
            //System.out.println(srcPath.toString());
            //Image i = new Image(fc.getAbsoluteFile().toURI().toString());
           
        }
        return(img);
        
        }

    @FXML
    private void btnActionRefrech(ActionEvent event) {
        ListAct.getItems().removeAll(ac);
        loadData();
    }

    @FXML
    private void btnActionView(ActionEvent event) {
        ac = ListAct.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Actualite.fxml"));
        TabDetail.getContent();
        LabDet1.setText(ac.getTitre_ac());
        LabDet.setText(ac.getDesc()+"\n"+ac.getId_ev());
        tp.getSelectionModel().select(TabDetail); 
    }    

    @FXML
    private void btnActionRetour(ActionEvent event) {
    }
}
