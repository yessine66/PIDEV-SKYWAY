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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mega-pc
 */
public class CreateAccountEnseignantFXMLController implements Initializable {
    
    ObservableList listGenre = FXCollections.observableArrayList();

    @FXML
    private AnchorPane anchorPaneCreateAccountEnseignant;
    @FXML
    private Label labelCreateAccount;
    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldPrenom;
    @FXML
    private TextField textFieldMail;
    @FXML
    private TextField textFieldAge;
    @FXML
    private TextField textFieldTel;
    @FXML
    private ChoiceBox<String> choiceBocGenre;
    @FXML
    private TextField textFieldDateNaiss;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField passwordFieldPassword;
    @FXML
    private TextField textFieldMatier;
    @FXML
    private TextArea textAreaBio;
    @FXML
    private TextField textFieldSpecialite;
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonBack;
    @FXML
    private TextField textFieldDateCreCompte;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadGenre();
    } 
    
    
    private void loadGenre(){
        listGenre.removeAll(listGenre);
        String femme="Femme";
        String homme="Homme";
        String autre="Autre";
        listGenre.addAll(femme,homme,autre);
        choiceBocGenre.getItems().addAll(listGenre);
        choiceBocGenre.setValue(autre);

    }
    
            private Utilisateur loadAccountDate(){
            
            String nom=textFieldNom.getText();
            String prenom=textFieldPrenom.getText();
            String mailu=textFieldMail.getText();
            String ages=textFieldAge.getText();
            int age=Integer.parseInt(ages);
            String tels=textFieldTel.getText();
            int tel=Integer.parseInt(tels);
            String genre=choiceBocGenre.getValue();
            String dateNaiss=textFieldDateNaiss.getText();
            String username=textFieldUsername.getText();
            String password=passwordFieldPassword.getText();
            String dateCreCompte=textFieldDateCreCompte.getText();
            
            Utilisateur userr;
            userr = new Utilisateur(1, nom, prenom, mailu, age, tel, genre, dateNaiss, username, password, "enseignant", dateCreCompte);
            return userr;
        }
            
            private Enseignant loadEnseignantData(){
               UtilisateurCRUD userCRUD = new UtilisateurCRUD();
                String  matiere=textFieldMatier.getText();
                String bio=textAreaBio.getText();
                String specialite=textFieldSpecialite.getText();
                int iduserto=userCRUD.RecuperLastIdTest();
                Enseignant ens;
                ens = new Enseignant( matiere, bio, specialite, 1,iduserto);
                return ens;
            }

    @FXML
    private void handleButtonSubmitAction(ActionEvent event) {
        
                System.out.println("submit button clicked");
if(verificationTextField()){
                        UtilisateurCRUD userCRUD = new UtilisateurCRUD();
        EnseignantCRUD ensCRUD = new EnseignantCRUD();
       // SELECT * FROM `utilisateur` WHERE id = (SELECT MAX(id) FROM `utilisateur`);

       int iduserto=userCRUD.RecuperLastIdTest();
        
        userCRUD.ajouterUtilisateur(loadAccountDate());
                        String  matiere=textFieldMatier.getText();
                String bio=textAreaBio.getText();
                String specialite=textFieldSpecialite.getText();
                int idusertox=userCRUD.RecuperLastIdTest();
                Enseignant ens,ensi;
                ensi = new Enseignant(matiere, bio, specialite, 1, iduserto);
                //ens = new Enseignant( matiere, bio, specialite, 1,idusertox);
                   ensCRUD.affecterEnseignant(ensi);
                   clearTextFields();
}
else{
                                      Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("You can't submit");
        alert.setContentText("missing data ");
        alert.showAndWait();
}
                   
        
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
                System.out.println("back button clicked");
                    Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
                    Scene reateAccountScene = new Scene(CreateAccountParent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(reateAccountScene);
                    window.show();
    }
    
                void clearTextFields(){
                textFieldNom.clear();
                textFieldPrenom.clear();
                textFieldMail.clear();
                textFieldAge.clear();
                textFieldTel.clear();
                choiceBocGenre.setValue("Autre");
                textFieldDateNaiss.clear();
                textFieldUsername.clear();
                passwordFieldPassword.clear();
                textFieldDateCreCompte.clear();
                textFieldMatier.clear();  
                textAreaBio.clear(); 
                textFieldSpecialite.clear(); 
                
            }
                
            boolean verificationTextField(){
                boolean test=false;
                 if(textFieldNom.getText().isEmpty()||textFieldPrenom.getText().isEmpty()||textFieldMail.getText().isEmpty()||textFieldDateNaiss.getText().isEmpty()||textFieldUsername.getText().isEmpty()||passwordFieldPassword.getText().isEmpty()||textFieldDateCreCompte.getText().isEmpty()||textFieldMatier.getText().isEmpty()||textAreaBio.getText().isEmpty()||textFieldSpecialite.getText().isEmpty())
                     test=false;
                 else 
                     test=true;
                 return test;                    
            }
    
}
