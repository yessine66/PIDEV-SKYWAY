/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Actualite;
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
    String img="";
    List<String> type;
    private boolean update;
    int actualite_id;
    @FXML
    private Label LabDet1;
    @FXML
    private Button btnImage;
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
    @FXML
    private WebView webv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //final WebEngine web = webv.getEngine();
        type =new ArrayList();
        type.add("*.jpg");
        type.add("*.png");
        final String pageURI= new File("Web.html").toURI().toString(); 
        webv.getEngine().load(pageURI);
        loadData();    
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
                ActualiteService acts = new ActualiteService();
                int idev = acts.getIdEv(nom_ev);
                Actualite act = new Actualite(titre_ac,desc,im,idev,100);
                acts.ajouterActualite(act);
                
                  Image img = new Image("/check.png");
                Notifications notification;
                notification = Notifications.create()
                .title("Modification  réussite")
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
                ActualiteService acts = new ActualiteService();
                int idev = acts.getIdEv(nom_ev);
                Actualite act = new Actualite(id_ac,titre_ac,desc,im,idev,100);

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
        importerImage(event);
        TFimage.setText(img);
        }
    @FXML
    private void importimagemod(ActionEvent event) {
        importerImage(event);
        TFimagem.setText(img);
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
            LabDet.setText(ac.getDesc()+"\n"+ac.getId_ev());
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
