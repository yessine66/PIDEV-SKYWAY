/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.cours;


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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import Esprit.services.ServiceCours;

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
    private Label erreurtitre;
    @FXML
    private Button imagee;
    private TableView<cours> tvcours;
    private TableColumn<cours, String> colId;
    private TableColumn<cours, String > colNom;
    private TableColumn<cours, String> colNumero;
    private TableColumn<cours, String > colDescription;
    private TableColumn<cours, String> colDuree;
    @FXML
    private TextField nom;
    @FXML
    private TextField numero;
    @FXML
    private TextField description;
    @FXML
    private TextField duree;
    private TextField idtheme;
    private TableColumn<cours, String> colimage;
    private TableColumn<cours, String> colIdth;
    @FXML
    private ListView<cours> lvcours;
    @FXML
    private ComboBox<String> comboCategorie;
    @FXML
    private Label erreurnumero;
    @FXML
    private Label erreurdesc;
    @FXML
    private Label erreurduree;
    
    

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
          lvcours.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               // String numero11 = String.valueOf(cc.getNumero());
                cc = (cours)lvcours.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                nom.setText(cc.getNom_c());
                numero.setText(String.valueOf(cc.getNumero()));
                description.setText(cc.getDescription());
                duree.setText(String.valueOf(cc.getDuree()));
                //idtheme.setText(String.valueOf(cc.getId_t()));
                importeimage.setImage(new Image("http://127.0.0.1/image/"+cc.getImage()));
               
                
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
         
          description.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                      erreurdesc.setText("Il faut remplir le champ description");
                   else if(newValue.length()>25)
                       erreurdesc.setText("La description ne doit pas passer 25 caractéres");
                   else
                erreurdesc.setText("");
                }       
             });
             description.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(description.getText().length()==0)
                     erreurdesc.setText("Il faut remplir le champ description");    
            }
            });
         description.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            description.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
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
           duree.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                      erreurduree.setText("Il faut remplir le champ durée");
                   else if(newValue.length()>2)
                       erreurduree.setText("Le champ durée ne doit pas passer 2 caractéres");
                   else
                erreurduree.setText("");
                }       
             });
           
           duree.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s1-9*")) {
            duree.setText(newValue.replaceAll("[^\\s1-9]", ""));
        }
        });
                numero.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                      erreurnumero.setText("Il faut remplir le champ numéro");
                   else if(newValue.length()>2)
                       erreurnumero.setText("Le champ numéro ne doit pas passer 3 caractéres");
                   else
                erreurnumero.setText("");
                }       
             });
           
           numero.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s1-9*")) {
            numero.setText(newValue.replaceAll("[^\\s1-9]", ""));
        }
        });
           
    }    
      public void showCombo()
     {
         ServiceCours parc = new ServiceCours();
         ObservableList<String> listCom =parc.comboListCat() ;
         comboCategorie.setItems(listCom);
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
              if(nom.getText().isEmpty() ||(img.isEmpty()&&cc.getImage().isEmpty())  || description.getText().isEmpty() || numero.getText().isEmpty() || duree.getText().isEmpty() || comboCategorie.getValue().isEmpty() )
        
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");   
        }else{
            String nom1 = nom.getText();
            int numero1 = Integer.parseInt(numero.getText());
            String description1 = description.getText();
            int duree1 = Integer.parseInt(duree.getText());
            String valuePart=comboCategorie.getValue().toString();
            ServiceCours sp = new ServiceCours();
            //SC.getName_cat(valuePart);
            
            int idth1 = Integer.parseInt(sp.getName_cat(valuePart));
            cours c = new cours(nom1, numero1, description1, duree1, img, idth1);
            
            sp.ajouter(c);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            nom.clear();
            numero.clear();
            description.clear();
            duree.clear();
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
              //   int idth1 = Integer.parseInt(idtheme.getText());
                  String valuePart=comboCategorie.getValue().toString();
           
            
                  int idth1 = Integer.parseInt(cs.getName_cat(valuePart));
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
         cours cc = (cours)lvcours.getSelectionModel().getSelectedItem();
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
       lvcours.setItems(et);
       
//       colId.setCellValueFactory(new PropertyValueFactory<>("id_c"));
//       colNom.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
//       colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
//       colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
//       colDuree.setCellValueFactory(new PropertyValueFactory<>("duree"));
//       colimage.setCellValueFactory(new PropertyValueFactory<>("photo"));
//       colIdth.setCellValueFactory(new PropertyValueFactory<>("id_t"));
       
       
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }

    private void retourner(ActionEvent event) throws IOException {
           AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/main/Back.fxml"));
        ap.getChildren().setAll(pane);
    }
   }

  
    

