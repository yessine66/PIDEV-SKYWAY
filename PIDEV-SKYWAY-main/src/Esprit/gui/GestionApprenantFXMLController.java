/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Utilisateur;
import Esprit.services.UtilisateurCRUD;
import Esprit.services.partenaireCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author batata
 */
public class GestionApprenantFXMLController implements Initializable {

    @FXML
    private Button buttonBack;
    @FXML
    private ListView<Utilisateur> ListViewApprenant;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showApprenant();
    }    

    @FXML
    private void handlebuttonBackAction(ActionEvent event) throws IOException {
                    System.out.println("apprenant");
                                                                Parent menuFrontParent;
            menuFrontParent = FXMLLoader.load(getClass().getResource("Page6Compte.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuFrontParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
    }
    
          public void showApprenant(){
              
              System.out.println("\n\n\n affichaage mtaa list apperanant");
      
              UtilisateurCRUD userco = new UtilisateurCRUD();
            //parc.partenaireList();
        ObservableList<Utilisateur> list =  userco.afficherUtilisateursNew();
        
     
        ListViewApprenant.setItems(list);
         ListViewApprenant.setCellFactory((ListView<Utilisateur> ListView) -> new ListCellApprenantController());
    }
    
}
