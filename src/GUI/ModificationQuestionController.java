/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Esprit.services.QuestionsCRUD;
import Esprit.entities.Questions;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class ModificationQuestionController implements Initializable {

    @FXML
    private AnchorPane AnchorQuestion;
    QuestionsCRUD qc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qc = new QuestionsCRUD();
       // id_q table view
        JFXTreeTableColumn<Questions, String> id_q = new JFXTreeTableColumn<>("id_q");
        id_q.setPrefWidth(150);
        id_q.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Questions, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Questions, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_q()));
            }
        });
        
        id_q.setCellFactory((TreeTableColumn<Questions, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable id_q text field
        id_q.setOnEditCommit((CellEditEvent<Questions, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_q();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_q(Integer.parseInt(t.getNewValue()));
            qc.modifierQuestion(idd, "id_q", newValue);
        });
        
         JFXTreeTableColumn<Questions, String> text_q = new JFXTreeTableColumn<>("text_q");
        text_q.setPrefWidth(150);
        text_q.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Questions, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Questions, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_q());
            }
        });
                 text_q.setCellFactory((TreeTableColumn<Questions, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable text_q text field
        text_q.setOnEditCommit((CellEditEvent<Questions, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_q();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_q(t.getNewValue());
            qc.modifierQuestion(idd, "text_q", newValue);
        });

// nbr_point table view
        JFXTreeTableColumn<Questions, String> nbr_point = new JFXTreeTableColumn<>("nbr_point");
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
        nbr_point.setOnEditCommit((CellEditEvent<Questions, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_q();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setNbr_point(Integer.parseInt(t.getNewValue()));
            qc.modifierQuestion(idd, "nbr_point", newValue);
        });
          
        List<Questions> myLst;
        myLst = qc.QuestionssListt();
        ObservableList<Questions> Questionss = FXCollections.observableArrayList();

        myLst.forEach(p -> Questionss.add(p));
        JFXTreeTableView<Questions> treeview = new JFXTreeTableView<>();
        final TreeItem<Questions> root = new RecursiveTreeItem<Questions>(Questionss, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_q, text_q,nbr_point);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        treeview.setEditable(true);
        
        //declarer la button supprimer
        JFXButton DltBtn = new JFXButton("Remove");
        DltBtn.setLayoutY(410D);
        DltBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            //eventHandler de la button supprimer
            @Override
            public void handle(ActionEvent event) {
                Dialog confirmation = new Dialog();
                GridPane grid2 = new GridPane();
                Label l1 = new Label("Delete Questions?");
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
                            qc.supprimerQuestion((Questions) p);
                            Button cancelButton = (Button) confirmation.getDialogPane().lookupButton(ButtonType.CLOSE);
                            cancelButton.fire();
                            initialize(url, rb);
                        }

                        return null;
                    }
                });
                confirmation.showAndWait();
            }
        }); 
          AnchorQuestion.getChildren().addAll(treeview,DltBtn); 
    }

}
