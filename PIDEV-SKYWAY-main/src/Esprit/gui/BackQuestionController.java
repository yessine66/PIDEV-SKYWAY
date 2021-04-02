/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Questions;
import Esprit.entities.Reponses;
import Esprit.entities.partenaire;
import Esprit.entities.theme;
import Esprit.services.QuestionsCRUD;
import Esprit.services.ReponsesCRUD;
import Esprit.services.ServiceTheme;
import Esprit.services.partenaireCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import nl.captcha.Captcha;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class BackQuestionController implements  Initializable {

    theme t = new theme();
    ReponsesCRUD rc = new ReponsesCRUD();
    QuestionsCRUD prc = new QuestionsCRUD();
    @FXML
    private TextField champsPoints;
    @FXML
    private TextArea champsQuestion;
    @FXML
    private Button AjoutQuestion;
    @FXML
    private TextField champstext1;
    @FXML
    private ComboBox<String> ComboCat;
    @FXML
    private TextField champstext2;
    @FXML
    private TextField champstext3;
    @FXML
    private TextField champstext4;
     Captcha captcha;
    @FXML
    private ImageView cap;
    @FXML
    private TextField code;
    @FXML
    private Button reset;
    @FXML
    private ListView<Questions> listViewPart2;
    @FXML
    private ListView<Reponses> listViewPart3;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        QuestionsCRUD qc = new QuestionsCRUD();
        ReponsesCRUD rc = new ReponsesCRUD();
        showCombobox();
        captcha = setCaptcha();
        showQuestions();
        showReponses();
    }

    public void showCombobox() {
        ReponsesCRUD reponse = new ReponsesCRUD();
        ObservableList<String> listrep = reponse.combocategorie();

        ComboCat.setItems(listrep);

    }

    @FXML
    private void ajouterQuestion(ActionEvent event) throws IOException {
        if (captcha.isCorrect(code.getText())) {

            String tilte = "Captcha";
            String message = "Correct";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000)); 
 ServiceTheme ts = new ServiceTheme();
        String text_q = champsQuestion.getText();
        String points = champsPoints.getText();
        int nbr_point = Integer.parseInt(points);
        String name_t = ComboCat.getValue();
       

     
        Questions q = new Questions(2, text_q, nbr_point, name_t);

        prc.ajouterQuestions(q);
        String text_r1 = champstext1.getText();
        String text_r2 = champstext2.getText();
        String text_r3 = champstext3.getText();
        String text_r4 = champstext4.getText();
        q.setId_q(prc.FindQuestion());
        Reponses r = new Reponses(2, text_r1, text_r2, text_r3, text_r4, q);
        rc.ajouterReponse(r);

        URL url = null;
        ResourceBundle rb = null;
        initialize(url, rb);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BackQuestion.fxml"));
        Parent root = loader.load();
         notificationShow("Ena mouch mrigl","hahaha");
        champsQuestion.getScene().setRoot(root);
        
        }else {
            String tilte = "Captcha";
            String message = "Incorrect Captcha";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));

            captcha = setCaptcha();
            code.setText("");
        }
    }
public void notificationShow(String title,String message) {
    Notifications notificationBuilder = Notifications.create()
               .title(title).text(message).graphic(null).hideAfter(javafx.util.Duration.seconds(20))
               .position(Pos.CENTER)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {

                       System.out.println("clicked ON ");
               }});
       notificationBuilder.darkStyle();
       notificationBuilder.show();




}

      public void showQuestions(){
      
        QuestionsCRUD qc = new QuestionsCRUD();
            //parc.partenaireList();
        ObservableList<Questions> list =  qc.QuestionsList();
        
     
        listViewPart2.setItems(list);
         listViewPart2.setCellFactory((ListView<Questions> Listview) -> new ListCellQuestionController());
    }
       public void showReponses(){
      
        ReponsesCRUD qc = new ReponsesCRUD(); 
            //parc.partenaireList();
        ObservableList<Reponses> list =  qc.ReponsesList();
       
        
     
        listViewPart3.setItems(list);
         listViewPart3.setCellFactory((ListView<Reponses> Listview) -> new ListCellReponsesController());
    }




public Captcha setCaptcha() {
        Captcha captcha = new Captcha.Builder(250, 200)
                .addText()
                .addBackground()
                .addNoise()
                .gimp()
                .addBorder()
                .build();

        System.out.println(captcha.getImage());
        Image image = SwingFXUtils.toFXImage(captcha.getImage(), null);

        cap.setImage(image);

        return captcha;
    }

    private void resetCaptcha(ActionEvent event) {
        captcha = setCaptcha();
        code.setText("");
    }}
    
    
    
    


    






