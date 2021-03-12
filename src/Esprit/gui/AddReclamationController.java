/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;


import Esprit.Connection.MyConnection;
import Esprit.entities.Reclamation;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author IBTIHEL
 */
public class AddReclamationController implements Initializable {

    @FXML
    private TextField objetTF;
    @FXML
    private TextArea textTF;
    @FXML
    private TextField userTF;
    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Reclamation student = null;
private boolean update;
int reclamationId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(MouseEvent event) {
         connection = MyConnection.getInstance().getConnection();
        String objet = objetTF.getText();
        //String birth = String.valueOf(textTF.getValue());
        String text = textTF.getText();
        String user = userTF.getText();

        if (objet.isEmpty() || text.isEmpty() || user.isEmpty()) {
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
    }
    
     private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `reclamation`( `objet`, `text_r`, `date_envoi`, `id`) VALUES (?,?,CURDATE(),?)";

        }else{
            query = "UPDATE `reclamation` SET "
                    + "`objet`=?,"
                    + "`text_r`=?,"
                    + "`date_envoi`=,"
                    + "`id`= ? WHERE id_rec = "+reclamationId;
        }

    }
      private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, objetTF.getText());
            //String.valueOf(userTF.getValue()));
            preparedStatement.setString(2, textTF.getText());
            preparedStatement.setInt(3, Integer.parseInt(userTF.getText()));
            
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AddReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
      void setTextField(int id, String objet,  String text) {

         reclamationId = id;
        objetTF.setText(objet);
        textTF.setText(text);
       // userTF.setInt(Integer.parseInt(user));
       
        

    }
     
     
       void setUpdate(boolean b) {
        this.update = b;

    }
}
