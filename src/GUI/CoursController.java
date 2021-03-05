/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.cours;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import services.ServiceCours;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CoursController implements Initializable {
    @FXML
    private ImageView importeimage;
      String img="";
    List<String> type;

    private cours cc=null;
    @FXML
    private AnchorPane ap;
    
    @FXML
    private Label erreurimg;
    @FXML
    private Label erreurdateajout;
    @FXML
    private Label erreurdatemodif;
    @FXML
    private Label erreurtitre;
    @FXML
    private Button imagee;
    @FXML
    private TableView<cours> tvcours;
    @FXML
    private TableColumn<cours, String> colId;
    @FXML
    private TableColumn<cours, String > colNom;
    @FXML
    private TableColumn<cours, String> colNumero;
    @FXML
    private TableColumn<cours, String > colDescription;
    @FXML
    private TableColumn<cours, String> colDuree;
    @FXML
    private TextField nom;
    @FXML
    private TextField numero;
    @FXML
    private TextField description;
    @FXML
    private TextField duree;
    @FXML
    private TextField idtheme;
    @FXML
    private TableColumn<cours, String> colimage;
    @FXML
    private TableColumn<cours, String> colIdth;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
           type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
         
          tvcours.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               // String numero11 = String.valueOf(cc.getNumero());
                cc = (cours)tvcours.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                nom.setText(cc.getNom_c());
                numero.setText(String.valueOf(cc.getNumero()));
                description.setText(cc.getDescription());
                duree.setText(String.valueOf(cc.getDuree()));
                idtheme.setText(String.valueOf(cc.getId_t()));
                importeimage.setImage(new Image("http://127.0.0.1/image/"+cc.getImage()));
                
            }
          });
          
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
    private void ajouter(ActionEvent event) {
        try {
              if(nom.getText().isEmpty() ||(img.isEmpty()&&cc.getImage().isEmpty())  || description.getText().isEmpty() )
        
        {
                        
         JOptionPane.showMessageDialog(null, "verifer les champs");   
        }else{
            String nom1 = nom.getText();
            int numero1 = Integer.parseInt(numero.getText());
            String description1 = description.getText();
            int duree1 = Integer.parseInt(duree.getText());
            int idth1 = Integer.parseInt(idtheme.getText());

            ServiceCours sp = new ServiceCours();
            cours c = new cours(nom1, numero1, description1, duree1, img, idth1);
            
            sp.ajouter(c);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            nom.clear();
            numero.clear();
            description.clear();
            duree.clear();
            idtheme.clear();
            importeimage.setImage(null);
            afficher();}
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @FXML
    private void modifier(ActionEvent event) {
     ServiceCours cs = new ServiceCours();
     System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir cours");
                   
        }else{
              
              try {
                 String nom1 = nom.getText();
                 int numero1 = Integer.parseInt(numero.getText());
                 String description1 = description.getText();
                 int duree1 = Integer.parseInt(duree.getText());
                 int idth1 = Integer.parseInt(idtheme.getText());
                  
                  if(img.length()==0)
                      cs.update( new cours(nom1, numero1, description1, duree1, img, idth1),cc.getId_c());
                     
                  else
                      cs.update( new cours(nom1, numero1, description1, duree1, img, idth1),cc.getId_c());
                  
                  afficher();
                  JOptionPane.showMessageDialog(null, "cours modifié");
                nom.clear();
                numero.clear();
                description.clear();
                duree.clear();
                idtheme.clear();
                importeimage.setImage(null);
                  cc=null;
              } catch (SQLException ex) {
                  Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceCours cs = new ServiceCours();
         cours cc = (cours)tvcours.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir cours");
                   
        }else{
             try {
                 cs.delete(cc.getId_c());
                 
                 afficher();
                 
                 JOptionPane.showMessageDialog(null, "cours supprimer");
                 
                 nom.clear();
                numero.clear();
                description.clear();
                duree.clear();
                idtheme.clear();
                importeimage.setImage(null);
                 
                 cc=null;
             } catch (SQLException ex) {
                 Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
           
    
         
    }
    
      private void afficher()
   {   
    try {
       ServiceCours sc = new ServiceCours();
       List events=sc.readAll();
       ObservableList et=FXCollections.observableArrayList(events);
       tvcours.setItems(et);
       
       colId.setCellValueFactory(new PropertyValueFactory<>("id_c"));
       colNom.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
       colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
       colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
       colDuree.setCellValueFactory(new PropertyValueFactory<>("duree"));
       colimage.setCellValueFactory(new PropertyValueFactory<>("photo"));
       colIdth.setCellValueFactory(new PropertyValueFactory<>("id_t"));
       
       
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
           AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/main/Back.fxml"));
        ap.getChildren().setAll(pane);
    }
   }

  
    

