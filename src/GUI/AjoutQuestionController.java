/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class AjoutQuestionController implements Initializable {

    @FXML
    private TableView<?> AffichageQuestion;
    @FXML
    private TableColumn<?, ?> colidq;
    @FXML
    private TableColumn<?, ?> colquestion;
    @FXML
    private TableColumn<?, ?> colnbrq;
    @FXML
    private TextField champsPoints;
    @FXML
    private TextArea champsQuestion;
    @FXML
    private Button AjoutQuestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterQuestion(ActionEvent event) {
    }
    
}
