/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import entity.theme;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.ServiceCours;
import services.ServiceTheme;

/**
 * FXML Controller class
 *
 * @author simop
 */
public class ThemeController implements Initializable {
    @FXML
    private ImageView importeimage;
//    String img="";
//    List<String> type;
    private theme tt=null;
    @FXML
    private AnchorPane ap;
    @FXML
    private TextField nom;
    @FXML
    private Label erreurtitre;
    @FXML
    private Label erreurcontenu;
    @FXML
    private Button imagee;
    @FXML
    private Label erreurimg;
    @FXML
    private Label erreurdateajout;
    @FXML
    private Label erreurdatemodif;
    @FXML
    private TableView<?> tvtheme;
    @FXML
    private TableColumn<?, ?> colId_t;
    @FXML
    private TableColumn<?, ?> colNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          afficher();
//        type =new ArrayList();
//        type.add("*.jpg");
//        type.add("*.png");
         tvtheme.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               // String numero11 = String.valueOf(tt.getNumero());
                tt = (theme)tvtheme.getSelectionModel().getSelectedItem();
                System.out.println(tt);
                nom.setText(tt.getNom_t());
             //   importeimage.setImage(new Image("http://127.0.0.1/image/"+tt.getImage()));
                
            }
          });
        
    }    


    @FXML
    private void importimage(ActionEvent event) {
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
            theme t = new theme(nom1);
            
            sp.ajouter(t);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            nom.clear();
            
           // importeimage.setImage(null);
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
                                   
                 st.update( new theme(nom1),tt.getId_t());
                  
                  afficher();
                  JOptionPane.showMessageDialog(null, "théme modifié");
                nom.clear();
               
                tt=null;
              } catch (SQLException ex) {
                  Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceTheme st = new ServiceTheme();
         theme tt = (theme)tvtheme.getSelectionModel().getSelectedItem();
        System.out.println(tt);
        if(tt== null){
            JOptionPane.showMessageDialog(null, "choisir theme");
                   
        }else{
             try {
                 st.delete(tt.getId_t());
                 
                 afficher();
                 
                 JOptionPane.showMessageDialog(null, "théme supprimé");
                 
                 nom.clear();
               
                 tt=null;
             } catch (SQLException ex) {
                 Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
           
    }

    private void afficher() {
        try {
       ServiceTheme st = new ServiceTheme();
       List events=st.readAll();
       ObservableList et=FXCollections.observableArrayList(events);
       tvtheme.setItems(et);
       
       colId_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
       colNom.setCellValueFactory(new PropertyValueFactory<>("nom_t"));
             
        } catch (SQLException ex) {
            Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
