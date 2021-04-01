/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;







import Esprit.entities.theme;
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
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import Esprit.services.ServiceCours;
import Esprit.services.ServiceTheme;

/**
 * FXML Controller class
 *
 * @author simop
 */
public class ThemeController implements Initializable {
      String img="";
      List<String> type;
    private theme tt=null;
    @FXML
    private AnchorPane ap;
    @FXML
    private TextField nom;
    @FXML
    private Label erreurtitre;
    @FXML
    private Label erreurimg;
    private TableView<?> tvtheme;
    private TableColumn<theme, String> colId_t;
    private TableColumn<theme, String> colNom;
    @FXML
    private ListView<theme> lvtheme;
    @FXML
    private Button imagee;
    @FXML
    private ImageView importeimage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          afficher();
          type =new ArrayList();
          type.add("*.jpg");
          type.add("*.png");
         lvtheme.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               // String numero11 = String.valueOf(tt.getNumero());
                tt = (theme)lvtheme.getSelectionModel().getSelectedItem();
                System.out.println(tt);
                nom.setText(tt.getNom_t());
                importeimage.setImage(new Image("http://127.0.0.1/image/"+tt.getImage()));
                
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
              if(nom.getText().isEmpty() )
        {
                        
         JOptionPane.showMessageDialog(null, "verifer les champs");   
        }else{
            String nom1 = nom.getText();
        
            ServiceTheme sp = new ServiceTheme();
            theme t = new theme(nom1, img);
            
            sp.ajouter(t);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            nom.clear();
            
            importeimage.setImage(null);
            afficher();
              }
        } catch (SQLException ex) {
            Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
     ServiceTheme st = new ServiceTheme();
     System.out.println(st);
        if(st== null){
            JOptionPane.showMessageDialog(null, "choisir théme");
                   
        }else{
              
              try {
                 String nom1 = nom.getText();
               //????????  
                  if(img.length()==0) {       
                  st.update( new theme(nom1,img),tt.getId_t());
                  }
                  st.update( new theme(nom1,img),tt.getId_t());

                  afficher();
                  JOptionPane.showMessageDialog(null, "théme modifié");
                nom.clear();
                importeimage.setImage(null);
               
                tt=null;
              } catch (SQLException ex) {
                  Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceTheme st = new ServiceTheme();
         theme tt = (theme)lvtheme.getSelectionModel().getSelectedItem();
        System.out.println(tt);
        if(tt== null){
            JOptionPane.showMessageDialog(null, "choisir theme");
                   
        }else{
             try {
                 st.delete(tt.getId_t());
                 
                 afficher();
                 
                 JOptionPane.showMessageDialog(null, "théme supprimé");
                 
                 nom.clear();
                 importeimage.setImage(null);
               
                 tt=null;
             } catch (SQLException ex) {
                 Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
           
    }

    private void afficher() {
        try {
       ServiceTheme st = new ServiceTheme();
      // List events=st.readAll();
      ObservableList<theme> et=st.readAll();
     //  ObservableList et=FXCollections.observableArrayList(events);
       lvtheme.setItems(et);
       lvtheme.setCellFactory((ListView<theme> listView) -> new ListCellThemeController());

       
       //colId_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
       //colNom.setCellValueFactory(new PropertyValueFactory<>("nom_t"));
             
        } catch (SQLException ex) {
            Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


    
}
