/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;


import Esprit.entities.partenaire;

import Esprit.services.partenaireCRUD;
import Esprit.Connection.MyConnection;
import Esprit.entities.Actualite;
import Esprit.entities.cours;
import Esprit.services.ServiceCours;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
 import java.io.File;  // Import the File class
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

//import Esprit.gui.LotteryWheel;
import java.awt.event.MouseEvent;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



/************************/
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterPartenaireController implements Initializable {

    @FXML
    private TextField tnomp;
    @FXML
    private TextField tdomaine;
    @FXML
    private Button btnajouter;
    //private TableView<partenaire> tvPar;
    //private TableColumn<partenaire,Integer> colIdpar;
    //private TableColumn<partenaire, String> colNompar;
    //rivate TableColumn<partenaire, String> colDomainepar;
    @FXML
    private TextField tidp;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    //private TableColumn<partenaire, String> colDatee;
    @FXML
    private DatePicker DateSelec;
int index =-1;
    @FXML
    private Button imagee;
    @FXML
    private ImageView importeimage;
    @FXML
    private TextField tmail;
     String img="";
      List<String> type;
    @FXML
    private ListView<partenaire> listViewPart;
      private partenaire cc = null ;
    @FXML
    private Button btncontact;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   type =new ArrayList();
          type.add("*.jpg");
          type.add("*.png");
        showPartenaire();
       
        
           
           
    }    
    
    
    
 
   
    public void showPartenaire(){
     
      
        partenaireCRUD parc = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<partenaire> list =  parc.partenaireList();
     
       listViewPart.setItems(list);
    listViewPart.setCellFactory((ListView<partenaire> ListView) -> new ListCellPartController());
       
    }
   

 
    @FXML
    private void DateSelec(ActionEvent event) {
    }
     private boolean validationPartenaire ()
    {
        
        
        if (tnomp.getText().isEmpty() | tdomaine.getText().isEmpty() |DateSelec.getEditor().getText().isEmpty())
            
        {
          Alert alert = new Alert (Alert.AlertType.WARNING);
          alert.setTitle("alert code promo vode");
          alert.setHeaderText(null);
          alert.setContentText("Veuillez remplir tous les champs ! ");
          alert.showAndWait();
          return false;
        }
        
        
        
        
        
        
        return true;
        
        
        
        
    }

   

    
  
    private void selectpar(javafx.scene.input.MouseEvent event) {
         System.err.println("click!");
         index =  listViewPart.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
   /* tidp.setText(colIdpar.getCellData(index).toString());
    tnomp.setText(colNompar.getCellData(index).toString());
    tdomaine.setText(colDomainepar.getCellData(index).toString());*/
    //DateSelec.setString(colDatee.getCellData(index));
       
   
    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void btnAjoutPar(ActionEvent event) {
        if (validationPartenaire()){
            String rNomp = tnomp.getText();
            String rDomaine = tdomaine.getText();
              String rdateP=DateSelec.getEditor().getText();
                String rMailp = tmail.getText();
            partenaire par = new partenaire(22,rNomp,rDomaine,rdateP,rMailp,img);
            partenaireCRUD parc = new partenaireCRUD();
            parc.ajouterPartenaire(par);
        
             URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
        }
    }

    @FXML
    private void btnModifierPar(ActionEvent event) {
         int  mIdp= Integer.parseInt(tidp.getText()) ;
                  String mNomp = tnomp.getText();
            String mDomaine = tdomaine.getText();
                 String mdateP=DateSelec.getEditor().getText();
                      String mMail=tmail.getText();
                
            partenaire par = new partenaire(mIdp,mNomp,mDomaine,mdateP,mMail,img);
            partenaireCRUD parc = new partenaireCRUD();
        parc.modifierPartenaire(par);
              importeimage.setImage(null);
                  //searchPart();
                   showPartenaire();
                  URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
    }

    @FXML
    private void btnSupprimerPar(ActionEvent event) {
        System.out.println("\n\n\nfassa555555\n\n\n");
         int  mIdp= Integer.parseInt(tidp.getText()) ;
            partenaire par = new partenaire(mIdp);
            partenaireCRUD parc = new partenaireCRUD();
        parc.supprimerPartenaire(par);
  
         URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
    }

    @FXML
    private void importimage(ActionEvent event) {
          FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc=f.showOpenDialog(null);
        
        if(fc != null)
        {   
            System.out.println(fc.getName());
            img=fc.getName();
           FileSystem fileSys = FileSystems.getDefault();
           Path srcPath= fc.toPath();
           Path destPath= fileSys.getPath("C:\\wamp64\\www\\image\\"+fc.getName());
            try {
                Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(srcPath.toString());
            Image i = new Image(fc.getAbsoluteFile().toURI().toString());
            importeimage.setImage(i);
           
        }
    }

    @FXML
    private void btncontact(ActionEvent event) throws IOException {
         Parent menuFrontParent;
            menuFrontParent = FXMLLoader.load(getClass().getResource("contactPart.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuFrontParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                  
                                        window.show();
                                        
    }


   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    }
 