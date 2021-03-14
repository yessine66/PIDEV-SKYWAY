/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.Connection.MailSend;
import Esprit.services.partenaireCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class GagnantPromotionController implements Initializable {

    @FXML
    private ListView<String> tvwinner;
    @FXML
    private Button btnwinner;
    @FXML
    private TextField tMail;
    @FXML
    private Button btnMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


 public void showWinner(){
      
        partenaireCRUD win = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<String> randlist =  win.randomList();
        
     
        tvwinner.setItems(randlist);
    }

    @FXML
    private void btnwwinner(ActionEvent event) {
        showWinner();
   
        }

    @FXML
    private void btnSendWinner(ActionEvent event) {
          MailSend m = new MailSend();
         String rMail = tMail.getText();
                String subject = "Félicitations!";
                String message = "aaaaaVous avez gagnez une promotion de 50/ avec notre Partenaire Nike";
                m.sendMail("0artbox1@gmail.com", rMail, subject, message);
    }
   
    
    }
    
    
    
    















    
    
