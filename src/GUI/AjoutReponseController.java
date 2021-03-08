/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Esprit.entities.Reponses;
import Esprit.services.ReponsesCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class AjoutReponseController implements Initializable {

    @FXML
    private TableView<Reponses> AffichageReponse;
    @FXML
    private TableColumn<Reponses, Integer> colidr;
    @FXML
    private TableColumn<Reponses, String> colreponse;
    @FXML
    private TableColumn<Reponses, Integer> colnbrq;
    @FXML
    private TextArea champsReponse;
    @FXML
    private Button AjoutReponse;
    @FXML
    private ComboBox<Integer> combor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showReponses();
       showCombobox();
    }    
public void showCombobox()
     {
          ReponsesCRUD reponse = new ReponsesCRUD();
         ObservableList<Integer> listrep = reponse.comboreponse ();
    
      combor.setItems(listrep);
         
     }
public void showReponses(){
      
        ReponsesCRUD parc = new ReponsesCRUD();
            //parc.promotionList();
        ObservableList<Reponses> list =  parc.ReponsesList();
        colidr.setCellValueFactory(new PropertyValueFactory<Reponses, Integer>("id_r"));
       colreponse.setCellValueFactory(new PropertyValueFactory<Reponses, String>("text_r"));
   colnbrq.setCellValueFactory(new PropertyValueFactory<Reponses, Integer>("id_q"));
     AffichageReponse.setItems(list);
    }
    @FXML
    private void ajouterReponse(ActionEvent event) {
      try {

             if(event.getSource() == AjoutReponse)
             {
            String text_r = champsReponse.getText();
      String value_r=combor.getValue().toString();
           int id_qr= Integer.parseInt(value_r) ;
            
           Reponses rep = new Reponses(22,text_r,id_qr);
           ReponsesCRUD rc = new ReponsesCRUD();
           // normalment appel l fct fillCombobox 
            rc.ajouterReponse(rep);
        }
           
             
             
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutReponse.fxml"));
              showReponses();
        Parent root = loader.load();
  
          champsReponse.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(AjoutReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
