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
import javafx.scene.Parent;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
public class ModificationQuestionController implements Initializable {

    @FXML
    private AnchorPane AnchorQuestion;
    @FXML
    private AnchorPane AnchorReponse;
 
    
    public void initialize(URL url, ResourceBundle rb) {
        QuestionsCRUD qc= new QuestionsCRUD();
 ReponsesCRUD rc= new ReponsesCRUD();
     
        //***********************************
         JFXTreeTableColumn<Questions, String> text_q = new JFXTreeTableColumn<>("Question");
        text_q.setPrefWidth(150);
        text_q.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Questions, String>, ObservableValue<String>>(){
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Questions, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_q());
            }
        });
                 text_q.setCellFactory((TreeTableColumn<Questions, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable text_q text field
        text_q.setOnEditCommit((TreeTableColumn.CellEditEvent<Questions, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_q();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_q(t.getNewValue());
            qc.modifierQuestions(idd, "text_q", newValue);
        });
        //***********************************


// nbr_point table view
        JFXTreeTableColumn<Questions, String> nbr_point = new JFXTreeTableColumn<>("Score");
        nbr_point.setPrefWidth(150);
        nbr_point.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Questions, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Questions, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getNbr_point()));
            }
        });
        
        nbr_point.setCellFactory((TreeTableColumn<Questions, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable nbr_point text field
        nbr_point.setOnEditCommit((TreeTableColumn.CellEditEvent<Questions, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_q();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setNbr_point(Integer.parseInt(t.getNewValue()));
            qc.modifierQuestions(idd, "nbr_point", newValue);
        });
  //*************** TreeTableView Questions & réponses
     //Catégorie
        
  JFXTreeTableColumn<Questions, String> name_t = new JFXTreeTableColumn<>("theme");
        name_t.setPrefWidth(150);
        name_t.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Questions, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Questions, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getName_t());
            }
        });
                 name_t.setCellFactory((TreeTableColumn<Questions, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable text_q text field
        name_t.setOnEditCommit((TreeTableColumn.CellEditEvent<Questions, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_q();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setName_t(t.getNewValue());
            qc.modifierQuestions(idd, "name_t", newValue);
        });

    
       //*****************************************************************
       JFXTreeTableColumn<Reponses, String> text_r1 = new JFXTreeTableColumn<>("Bonne réponse");
        text_r1.setPrefWidth(150);
        text_r1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>>() {
            @Override
            
        //(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>(){
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reponses, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_r1());
            }
        });
                 text_r1.setCellFactory((TreeTableColumn<Reponses, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        text_r1.setOnEditCommit((TreeTableColumn.CellEditEvent<Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_r1(t.getNewValue());
            qc.modifierQuestions(idd, "text_r1", newValue);
        });

      
   //*****************************************************************
       JFXTreeTableColumn<Reponses, String> text_r2 = new JFXTreeTableColumn<>("1ere mauvaise réponse");
        text_r2.setPrefWidth(150);
        text_r2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>>() {
            @Override
            
        //(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>(){
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reponses, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_r2());
            }
        });
                 text_r2.setCellFactory((TreeTableColumn<Reponses, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        text_r2.setOnEditCommit((TreeTableColumn.CellEditEvent<Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_r2(t.getNewValue());
            qc.modifierQuestions(idd, "text_r2", newValue);
        });

      
        //*****************************************************************
       JFXTreeTableColumn<Reponses, String> text_r3 = new JFXTreeTableColumn<>("2ème mauvaise réponse");
        text_r3.setPrefWidth(150);
        text_r3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>>() {
            @Override
            
        //(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>(){
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reponses, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_r3());
            }
        });
                 text_r3.setCellFactory((TreeTableColumn<Reponses, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        text_r3.setOnEditCommit((TreeTableColumn.CellEditEvent<Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_r3(t.getNewValue());
            qc.modifierQuestions(idd, "text_r3", newValue);
        });

      
       //*****************************************************************
       JFXTreeTableColumn<Reponses, String> text_r4 = new JFXTreeTableColumn<>("3ème mauvaise réponse");
        text_r4.setPrefWidth(150);
        text_r4.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>>() {
            @Override
            
        //(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>(){
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reponses, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_r4());
            }
        });
                 text_r4.setCellFactory((TreeTableColumn<Reponses, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        text_r4.setOnEditCommit((TreeTableColumn.CellEditEvent<Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_r4(t.getNewValue());
            qc.modifierQuestions(idd, "text_r4", newValue);
        });

      
    
          
        List<Questions> myLst;
        myLst = qc.QuestionssListt();
        ObservableList<Questions> Questionss = FXCollections.observableArrayList();
List<Reponses> myLst2;
        myLst2 = rc.ReponsessListt();
        ObservableList<Reponses> Reponsess = FXCollections.observableArrayList();

        myLst.forEach(p -> Questionss.add(p));
        myLst2.forEach(p -> Reponsess.add(p));
        JFXTreeTableView<Questions> treeview = new JFXTreeTableView<>();
        final TreeItem<Questions> root = new RecursiveTreeItem<Questions>(Questionss, RecursiveTreeObject::getChildren);
        JFXTreeTableView<Reponses> treevieww = new JFXTreeTableView<>();
        final TreeItem<Reponses> roott = new RecursiveTreeItem<Reponses>(Reponsess, RecursiveTreeObject::getChildren);

        treeview.getColumns().setAll(text_q,nbr_point,name_t);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        treeview.setEditable(true);
        treevieww.getColumns().setAll(text_r1,text_r2,text_r3,text_r4);
        treevieww.setRoot(roott);
        treevieww.setShowRoot(false);
        treevieww.setEditable(true);
        
        //declarer la button supprimer
        JFXButton DltBtn = new JFXButton("Remove");
        DltBtn.setLayoutY(410D);
        DltBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            //eventHandler de la button supprimer 1
            @Override
            public void handle(ActionEvent event) {
                Dialog confirmation = new Dialog();
                GridPane grid2 = new GridPane();
                Label l1 = new Label("Delete?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Questions>() {
                    @Override
                    public Questions call(ButtonType param) {
                        if (param == Confi) {
                            Questions p = treeview.getSelectionModel().getSelectedItem().getValue();
                            qc.supprimerQuestions((Questions) p);
                            Button cancelButton = (Button) confirmation.getDialogPane().lookupButton(ButtonType.CLOSE);
                            cancelButton.fire();
                            initialize(url, rb);
                        }

                        return null;
                    }
                });
                confirmation.setResultConverter(new Callback<ButtonType, Reponses>() {
                    public Reponses call(ButtonType param) {
                        if (param == Confi) {
                            Reponses p = treevieww.getSelectionModel().getSelectedItem().getValue();
                            rc.supprimerReponse((Reponses) p);
                            Button cancelButton = (Button) confirmation.getDialogPane().lookupButton(ButtonType.CLOSE);
                            cancelButton.fire();
                            initialize(url, rb);
                        }

                        return null;
                    }
                });
                confirmation.showAndWait();
            }
            
        });  treeview.refresh();
        treevieww.refresh();
          AnchorQuestion.getChildren().addAll(treeview,DltBtn); 
          AnchorReponse.getChildren().addAll(treevieww,DltBtn);
        }


    }    
    

