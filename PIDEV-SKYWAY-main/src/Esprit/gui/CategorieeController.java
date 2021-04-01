/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.Connection.MyConnection;
import Esprit.entities.categorie;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import Esprit.services.ServiceCategorie;
import Esprit.services.ServiceTheme;


/**
 * FXML Controller class
 *
 * @author simop
 */
public class CategorieeController implements Initializable {
      String img="";
      List<String> type;   
    private categorie cc=null;

    @FXML
    private Label erreurtitre;
    @FXML
    private TextField nom;
    @FXML
    private Label erreurimg;
    @FXML
    private Label erreurdatemodif;
    @FXML
    private ListView<categorie> lvcategorie;
    @FXML
    private AnchorPane pane2;
    @FXML
    private Button imagee;
    @FXML
    private ImageView importeimage;
    @FXML
    private ComboBox<String> comboTheme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          afficher();
          type =new ArrayList();
          type.add("*.jpg");
          type.add("*.png");
          showCombo();
         lvcategorie.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               // String numero11 = String.valueOf(tt.getNumero());
                cc = (categorie)lvcategorie.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                nom.setText(cc.getNom_categorie());
                importeimage.setImage(new Image("http://127.0.0.1/image/"+cc.getImage()));
                
                ServiceCategorie sc = new ServiceCategorie();
                String nomTheme= sc.getName_theme(cc.getId_t());
                comboTheme.setValue(nomTheme);
                
            }
          });
          nom.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                      erreurtitre.setText("Il faut remplir le champ titre");
                   else if(newValue.length()>25)
                       erreurtitre.setText("Le titre ne doit pas passer 25 caractéres");
                   else
                erreurtitre.setText("");
                }       
             });
             nom.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(nom.getText().length()==0)
                     erreurtitre.setText("Il faut remplir le champ titre");    
            }
            });
         nom.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            nom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
        });
          imagee.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       erreurimg.setText("Il faut remplir le champ image");
                   
                   else
                       erreurimg.setText("");
                }
                
                
            });
               
               imagee.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(imagee.getText().length()==0)
                     erreurimg.setText("Il faut remplir le champ image");    
                    
                }
                
            });
         
    }
          public void showCombo()
     {
          ServiceCategorie parc = new ServiceCategorie();
         ObservableList<String> listCom =parc.comboListTheme() ;
         comboTheme.setItems(listCom);
         
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
                Logger.getLogger(CategorieeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(srcPath.toString());
            Image i = new Image(fc.getAbsoluteFile().toURI().toString());
            importeimage.setImage(i);
           
        }
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        try {
              if(nom.getText().isEmpty() || (img.isEmpty()&&cc.getImage().isEmpty()))
        {
         JOptionPane.showMessageDialog(null, "verifer les champs");   
        }else{
            String nom1 = nom.getText();
        
            ServiceCategorie sp = new ServiceCategorie();
            String valuePart=comboTheme.getValue().toString();
            
            //SC.getName_cat(valuePart);
            
            int idth1 = Integer.parseInt(sp.getName_theme(valuePart));
            categorie c = new categorie(nom1,img,idth1);
            
            sp.ajouter(c);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            nom.clear();
            importeimage.setImage(null);
            afficher();
              }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
         ServiceCategorie sc = new ServiceCategorie();
         System.out.println(sc);
        if(sc== null){
            JOptionPane.showMessageDialog(null, "choisir catégorie"); 
        }else{
              
              try {
                 String nom1 = nom.getText();
                 String valuePart=comboTheme.getValue().toString();
            
            //SC.getName_cat(valuePart);
            
                  int idth1 = Integer.parseInt(sc.getName_theme(valuePart));
                 
                  if(img.length()==0) {       
                 sc.update( new categorie(nom1,img),cc.getId_categorie());
                  }
                 sc.update( new categorie(nom1,img),cc.getId_categorie());
                  
                  afficher();
                  JOptionPane.showMessageDialog(null, "Catégorie modifié");
                   nom.clear();
                   importeimage.setImage(null);
                cc=null;
              } catch (SQLException ex) {
                  Logger.getLogger(CategorieeController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceCategorie sc = new ServiceCategorie();
         categorie c1 = (categorie)lvcategorie.getSelectionModel().getSelectedItem();
        System.out.println(c1);
        if(c1== null){
            JOptionPane.showMessageDialog(null, "Choisir categorie");
                   
        }else{
             try {
                 sc.delete(c1.getId_categorie());
                 
                 afficher();
                 
                 JOptionPane.showMessageDialog(null, "Categorie supprimée");
                 
                 nom.clear();
                 importeimage.setImage(null);
               
                 c1=null;
             } catch (SQLException ex) {
                 Logger.getLogger(CategorieeController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    }
     private void afficher() {
        try {
       ServiceCategorie sc = new ServiceCategorie();
       ObservableList<categorie> et=sc.readAll();
       lvcategorie.setItems(et);
       lvcategorie.setCellFactory((ListView<categorie> listView) -> new ListCellCatController());

       
       //colId_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
       //colNom.setCellValueFactory(new PropertyValueFactory<>("nom_t"));
             
        } catch (SQLException ex) {
            Logger.getLogger(CategorieeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


}
