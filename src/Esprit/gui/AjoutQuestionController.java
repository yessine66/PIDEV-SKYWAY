/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;
import Esprit.entities.Questions;
import Esprit.services.QuestionsCRUD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class AjoutQuestionController implements Initializable {

    @FXML
    private TextArea champsQuestion;
    @FXML
    private TextField champsPoints;
    @FXML
    private Button AjoutQuestion;
    @FXML
    private TableView<Questions> AffichageQuestion;
    @FXML
    private TableColumn<Questions,Integer> colidq;
    @FXML
    private TableColumn<Questions, String> colquestion;
    @FXML
    private TableColumn<Questions, Integer> colnbrq;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showBooks();
          
 }  
    
    
    
    
 public void showBooks(){
          QuestionsCRUD q = new QuestionsCRUD();
        ObservableList<Questions> list =  q.QuestionsList();
        colidq.setCellValueFactory(new PropertyValueFactory<Questions,Integer>("id_q"));
        colquestion.setCellValueFactory(new PropertyValueFactory<Questions, String>("text_q"));
        colnbrq.setCellValueFactory(new PropertyValueFactory<Questions, Integer>("nbr_point"));
   
        
        AffichageQuestion.setItems(list);
    }
    @FXML
    private void ajouterQuestion(ActionEvent event) throws IOException {
        
      try{  
        // Ajouter Question
     
        String text_q = champsQuestion.getText();
        String points = champsPoints.getText();
        int nbr_point = Integer.parseInt(points);
        Questions q = new Questions (2,text_q,nbr_point);
        QuestionsCRUD prc = new QuestionsCRUD();
        prc.ajouterQuestion(q);
        
   
    
       //Afficher Question
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutQuestion.fxml"));
              showBooks();
            Parent root = loader.load();

            champsQuestion.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjoutQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        } }

   

}

  
     
        
    
    

