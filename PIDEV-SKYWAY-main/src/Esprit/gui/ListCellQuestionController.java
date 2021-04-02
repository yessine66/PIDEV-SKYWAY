/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Questions;
import Esprit.entities.partenaire;
import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class ListCellQuestionController  extends ListCell<Questions>{
private FXMLLoader mLLoader;
    @FXML
    private GridPane gridp;
    @FXML
    private VBox vb1;
    @FXML
    private Label lbnomp;
    private Label lbdatef;
    @FXML
    private VBox vb11;
    @FXML
    private Label lbreduction;
    

    /**
     * Initializes the controller class.
     */
    
    
 @Override
    protected void updateItem(Questions questions, boolean empty) {
        super.updateItem(questions, empty);
        
        if(empty || questions == null) {
            
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellQuestion.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            lbnomp.setText(questions.getText_q());
          lbreduction.setText(questions.getName_t());
        
       //     Image image =new Image("http://127.0.0.1/image/"+url);
         //   imev.setImage(image);
            //lbdate.setText(toString().valueOf(partenaire.getDate_ajout()));
            setText(null);
            System.out.println("aaaaaaaaaaaaa");
            setGraphic(gridp);
            
            }
    
    }
}