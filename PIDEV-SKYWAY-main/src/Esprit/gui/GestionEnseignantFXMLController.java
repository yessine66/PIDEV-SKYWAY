/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Enseignant;
import Esprit.entities.Utilisateur;
import Esprit.services.EnseignantCRUD;
import Esprit.services.UtilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author batata
 */
public class GestionEnseignantFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPaneGestionEnseignant;
    @FXML
    private TextField textFieldIdMod;
    @FXML
    private TextField textFieldMatiereMod;
    @FXML
    private TextField textFieldSpecialiteMod;
    @FXML
    private Button buttonModifier;
    @FXML
    private TextField textFielIdDelete;
    @FXML
    private Button buttonSupprimer;
    @FXML
    private TableView<Enseignant> tableViewEnseig;
    @FXML
    private TableColumn<Enseignant, Integer> tableColumnId;
    @FXML
    private TableColumn<Enseignant, String> tableColumnMatiere;
    @FXML
    private TableColumn<Enseignant, String> tableColumnBio;
    @FXML
    private TableColumn<Enseignant, String> tableColumnSpecialite;
    @FXML
    private Button buttonBack;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      // AffichageEnseignant();
    }    

    @FXML
    private void handlebuttonModifierAction(ActionEvent event) {
        /*
                 int  mIdp= Integer.parseInt(tidp.getText()) ;
                  String mNomp = tnomp.getText();
            String mDomaine = tdomaine.getText();
                 String mdateP=DateSelec.getEditor().getText();
            partenaire par = new partenaire(mIdp,mNomp,mDomaine,mdateP);
            partenaireCRUD parc = new partenaireCRUD();
        parc.modifierPartenaire(par);
                  searchPart();
                  URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
        */
        int idMod = Integer.parseInt(textFieldIdMod.getText());
        String specialteMod = textFieldSpecialiteMod.getText();
        String matierMod = textFieldMatiereMod.getText();
        
        Enseignant enseim = new Enseignant(matierMod, matierMod, specialteMod, idMod);
        EnseignantCRUD enseiCerr = new EnseignantCRUD();
        enseiCerr.modifierUtilisateur(enseim);
                AffichageEnseignant();
        URL url = null;
        ResourceBundle rb = null;
        initialize(url,rb);
        
        
    }

    @FXML
    private void handlebuttonSupprimerAction(ActionEvent event) {
        

        int idsupp=Integer.parseInt(textFielIdDelete.getText());
        Utilisateur userx = new Utilisateur(idsupp);
        UtilisateurCRUD usercrud = new UtilisateurCRUD();
        usercrud.supprimerUtilisateur(userx);
        AffichageEnseignant();
        URL url = null;
        ResourceBundle rb = null;
        initialize(url,rb);
        
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
    public void AffichageEnseignant(){
        EnseignantCRUD enseix = new EnseignantCRUD();
        //ObservableList<Enseignant> listenseix =  (ObservableList<Enseignant>) enseix.afficherEnseignant();
        ObservableList<Enseignant> listenseix =   enseix.afficherEnseignant();
        
       // colIdpar.setCellValueFactory(new PropertyValueFactory<partenaire, Integer>("id_p"));
       tableColumnId.setCellValueFactory(new PropertyValueFactory<Enseignant, Integer>("id"));
       tableColumnMatiere.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("matier"));
       tableColumnBio.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("text"));
       tableColumnSpecialite.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("specialite"));
       
       tableViewEnseig.setItems(listenseix);
        
    }
    
    
    
}
