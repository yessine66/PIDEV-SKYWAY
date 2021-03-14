/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.services.QuestionsCRUD;
import Esprit.services.ReponsesCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class QuizFrontController implements Initializable {

    @FXML
    private TextField tiwtiw;
    @FXML
    private Button check;
    @FXML
    private ListView<String> lesreponses;
    @FXML
    private ContextMenu rrr;
    @FXML
    private TextField ijebaheya;

    /**
     * Initializes the controller class.
     */
    @Override
      public void initialize(URL url, ResourceBundle rb) {
        QuestionsCRUD qc=  new QuestionsCRUD();
        ReponsesCRUD rc= new ReponsesCRUD();
        try {
            //  ObservableList<String> randlist= qc.randomList();
            tiwtiw.setText(qc.randomList());
        } catch (SQLException ex) {
            Logger.getLogger(QuizFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
        ObservableList<String> randlist = null;
        try {
            randlist = rc.justanswer();
        } catch (SQLException ex) {
            Logger.getLogger(QuizFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
              lesreponses.setItems(randlist);
            



    
    
    

    
        
          //  baba.setText(rc.rightanswer());
          //  mama.setText(rc.justanswer());
          
      
    }

    @FXML
    private void checkbtn(ActionEvent event) throws SQLException {
  String reponse= ijebaheya.getText();
  ReponsesCRUD rc=new ReponsesCRUD();
  System.out.println("test réussi");
if( rc.verif(reponse)==1){  
    System.out.println("C'est juste! BRAVO");
       /*Dialog confirmation = new Dialog();
                GridPane grid2 = new GridPane();
                Label l1 = new Label("Bonne réponse!");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("BRAVO!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
  confirmation.getDialogPane().getButtonTypes().add(Confi);*/
     
    }
 }}
 