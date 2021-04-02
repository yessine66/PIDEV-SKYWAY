/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.Connection.MyConnection;
import Esprit.entities.Reclamation;
import Esprit.entities.Utilisateur;
import Esprit.entities.categorie;
import java.net.URL;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import Esprit.services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author IBTIHEL
 */
public class AddReclamationController implements Initializable {

    @FXML
    private TextField objetTF;
    @FXML
    private TextField textTF;
    @FXML
    private TextField userTF;
    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Reclamation student = null;
    private boolean update;
    int reclamationId;
    @FXML
    private ComboBox combo1;
    @FXML
    private ComboBox<String> combo2;
    @FXML
    private TextField recTF;
//private int usertest = 10;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
                    LoginFXMLController mmmmmm = new LoginFXMLController();
            Utilisateur usermimi = LoginFXMLController.usertest;
            System.out.println("\n\n\n\n iddddddddddddd fwest add reclamatoin conttroller *************** :\n  "+ usermimi.getIdUser());
        
        combo1.getItems().clear();
        showCombo();
        
        
       
    }
    
 
    
    
    
  
      public void showCombo()
     { 
          combo2.getItems().clear();
          combo1.accessibleHelpProperty();
          ObservableList<String> list = FXCollections.observableArrayList("Cours","Enseignant");
          combo1.setItems(list);
          //combo1.setValue(list);
          combo1.valueProperty().addListener(new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> observable,String oldValue, String newValue) {
           // System.out.println("Value is: "+newValue);
            if (newValue.equals("Cours"))
                
            {  
             ReclamationService parc = new ReclamationService();
             ObservableList<String> listCom = parc. comboListPar ();
             combo2.setItems(listCom);
            } 
            else combo2.getItems().clear();
            if (newValue.equals("Enseignant"))
            {  
             ReclamationService par = new ReclamationService();
             ObservableList<String> listCom = par. comboListEns ();
             combo2.setItems(listCom);
            } 
            //else combo2.getItems().clear();
        }
          });
     }
      

    @FXML
    private void envoyer(MouseEvent event) {
         connection = MyConnection.getInstance().getConnection();
        String objet = objetTF.getText();
        String text = textTF.getText();
        String user = userTF.getText();

        if (objet.isEmpty() || text.isEmpty()  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tout les champs pour réclamer!");
            alert.showAndWait();

        } else {
            getQuery();
            insert();
            cancel();
        }
       
    }

    @FXML
    private void cancel() {
        objetTF.setText(null);
        textTF.setText(null);
        userTF.setText(null);
        combo1.setValue(null);
        combo2.setValue(null);
        Image img = new Image("/a1.png");
                 Notifications notification;
                 notification = Notifications.create()
                .title("Annuler ")
                .text("Votre réclamation est annuler ")
                .graphic(new ImageView(img))
                .position(Pos.BASELINE_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Clicked on notification");
                    }
                });
               notification.show();
    }
     
     private void getQuery() {
         LoginFXMLController mmmmmm = new LoginFXMLController();
            Utilisateur usermimi = LoginFXMLController.usertest;
           String s = combo1.getSelectionModel().getSelectedItem().toString();
          
        if (update == false) {
            if (combo1.getSelectionModel().getSelectedItem().toString().equals("Cours")){
                query = "INSERT INTO `reclamation`( `objet`, `text_r`, `date_envoi`, `id`,`cours`) VALUES (?,?,CURDATE(),"+usermimi.getIdUser()+",?)";     
              } else if (combo1.getSelectionModel().getSelectedItem().toString().equals("Enseignant")){
                query = "INSERT INTO `reclamation`( `objet`, `text_r`, `date_envoi`, `id`,`enseignant`) VALUES (?,?,CURDATE(),"+usermimi.getIdUser()+",?)";
              }
             
             
       
        }else{
            
            if (combo1.getSelectionModel().getSelectedItem().toString().equals("Cours")){
                query = "UPDATE `reclamation` SET "
                    + "`objet`=?,"
                    + "`text_r`=?,"
                    + "`date_envoi`=,"
                    + "`id`= "+usermimi.getIdUser()+","
                    + "`cours`=? WHERE id_rec = "+reclamationId;
    
              } else if (combo1.getSelectionModel().getSelectedItem().toString().equals("Enseignant")){
                     query = "UPDATE `reclamation` SET "
                    + "`objet`=?,"
                    + "`text_r`=?,"
                    + "`date_envoi`=,"
                    + "`id`= "+usermimi.getIdUser()+" ,"
                    + "`enseignant`=? WHERE id_rec = "+reclamationId;
              }
            
            /*query = "UPDATE `reclamation` SET "
                    + "`objet`=?,"
                    + "`text_r`=?,"
                    + "`date_envoi`=,"
                    + "`id`= ? WHERE id_rec = "+reclamationId;*/
        }

    }
      private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
         // preparedStatement.setInt(1, Integer.parseInt(recTF.getText()));
            preparedStatement.setString(1, objetTF.getText());
          //String.valueOf(userTF.getValue()));
            preparedStatement.setString(2, textTF.getText());
            //preparedStatement.setInt(3,utilisateur/*3, Integer.parseInt(userTF.getText())*/);
            preparedStatement.setString(3, combo2.getSelectionModel().getSelectedItem().toString());
            preparedStatement.execute();
            
            Image img = new Image("/check.png");
                 Notifications notification;
                 notification = Notifications.create()
                .title("Envoi ")
                .text("DVotre réclamation est envoyer avec succés ")
                .graphic(new ImageView(img))
                .position(Pos.BASELINE_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Clicked on notification");
                    }
                });
               notification.show();
             

        } catch (SQLException ex) {
            Logger.getLogger(AddReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
      void setTextField(int id, String objet,  String text,String cours , String enseignant) {
         
         reclamationId = id;
         objetTF.setText(objet);
         textTF.setText(text);
         String var = "Cours"; 
         if(/*cours.equals("cours")*/ cours ==var){
            combo2 .setValue(enseignant);
            combo1.setValue("enseignant");
         }else{
             combo1.setValue("cours");         
            combo2 .setValue(cours);}
        // combo2.getSelectionModel().select(cmb);
       // userTF.setInt(Integer.parseInt(user));

    }
       void setUpdate(boolean b) {
        this.update = b;
    }
}
