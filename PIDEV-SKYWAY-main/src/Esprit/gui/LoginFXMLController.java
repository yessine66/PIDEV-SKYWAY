/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Utilisateur;
import Esprit.services.UtilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 * FXML Controller class
 *
 * @author mega-pc
 */
public class LoginFXMLController implements Initializable {
    
        public static final String ACCOUNT_SID = "AC362d49d2ebfabfaba17d31b804e7f233";
    public static final String AUTH_TOKEN = "cac762102b76c9eda4d69bdcf7eb623b";

    ObservableList listRole = FXCollections.observableArrayList();
    
    
    
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private AnchorPane anchorPaneLogin;
    @FXML
    private Label labelWelcome;
    @FXML
    private Button butttonCreateNewAccount;
    @FXML
    private PasswordField passwordFieldPassword;
    @FXML
    private Button buttonForgetPassword;
    @FXML
    private Button buttonSMS;
    @FXML
    private Button buttonMAIL;

    
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonMAIL.setVisible(false);
        buttonSMS.setVisible(false);
      
    } 

    private void handleButtonAction(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonCreateAccountAction(ActionEvent event) throws IOException {
        System.out.println("boutton create account clicked");
                                       Parent CreateAccountParent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
                                        Scene reateAccountScene = new Scene(CreateAccountParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(reateAccountScene);
                                        window.show();
    }

    @FXML
    private void handleButtonLoginAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("button login clicked");
        
        UtilisateurCRUD usercru = new UtilisateurCRUD();
        
        Utilisateur userxo = new Utilisateur();
        userxo= usercru.Connexion(textFieldUsername.getText(), passwordFieldPassword.getText());
        if(userxo==null){
                      Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("You can't log in");
        alert.setContentText("The Mail or password you’ve entered doesn’t match any account ");
        alert.showAndWait();
        
        }
        else {
            System.out.println("test login yemchi" + userxo.getRoleUser());
            if("admin".equals(userxo.getRoleUser()) ||"enseignant".equals(userxo.getRoleUser()) ){
            System.out.println("admin wala mou3alem");
            
            
                FXMLLoader loader = new FXMLLoader();
                    loader.setLocation((getClass().getResource("MenuBack.fxml")));
            
                                                    Parent menuBackParent = loader.load();
                                                    
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        
                                        MenuBackController controller=loader.getController();
                                        controller.initDate(userxo);
                                        
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
        }
        else if("apprenant".equals(userxo.getRoleUser()) ) {
            System.out.println("apprenant");
                                                                Parent menuFrontParent;
            menuFrontParent = FXMLLoader.load(getClass().getResource("FrontMenu.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuFrontParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
                                        
        }
        }
        
        
       /* 
          Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("You can't log in");
        alert.setContentText("The Username or password you’ve entered doesn’t match any account ");
        alert.showAndWait();
        
        
        
        */
        
      /*  
        if("Admin".equals(choiceBoxRole.getValue()) ||"Enseignant".equals(choiceBoxRole.getValue()) ){
            System.out.println("admin wala mou3alem");
                                                    Parent menuBackParent = FXMLLoader.load(getClass().getResource("MenuBack.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
        }
        else if("Apprenant".equals(choiceBoxRole.getValue()) ) {
            System.out.println("apprenant");
                                                                Parent menuFrontParent;
            menuFrontParent = FXMLLoader.load(getClass().getResource("FrontMenu.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuFrontParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
        }
        
        */
        /*
                    switch (choiceBoxRole.getValue()) {
                    case "Enseignant":
                        System.out.println("enseignant");
                                    
                                        Parent menuBackParent = FXMLLoader.load(getClass().getResource("MenuBackFXML.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
//todo
                        break;
                    case "Apprenant":
                        System.out.println("apprenant");
//todo
                        break;
                    case "Admin":
                        System.out.println("admin");
                                                                Parent menuBackParent = FXMLLoader.load(getClass().getResource("MenuBackFXML.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
//todo
                        
                        break;
                    default:
                        break;
                }*/
        
    }

    @FXML
    private void handleButtonForgetAction(ActionEvent event) {
                buttonMAIL.setVisible(true);
        buttonSMS.setVisible(true);
    }

    @FXML
    private void HandleButtonSMSAction(ActionEvent event) throws SQLException {
        String passwordi;
        
        UtilisateurCRUD usercru = new UtilisateurCRUD();
        
        if(textFieldUsername.getText().isEmpty()){
                                  Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("You can't send sms");
        alert.setContentText("Enter Your Mail ");
        alert.showAndWait();
        }
        else{
                    passwordi = usercru.loadPasswordBase(textFieldUsername.getText());
        
        
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        

       Message message = Message.creator(new PhoneNumber("+21652635795"), new PhoneNumber("+12245019503"), "Your Password is : "+passwordi).create();
       
        System.out.println(message.getSid());
        }

    }

    @FXML
    private void HandleButtonMailAction(ActionEvent event) {
    }
    

    
    
    
}
