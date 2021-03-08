/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Esprit.services.ReponsesCRUD;
import Esprit.entities.Reponses;
import Esprit.services.ReponsesCRUD;
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
public class ModifReponseController implements Initializable {

    @FXML
    private AnchorPane AnchorReponse;
    ReponsesCRUD rc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rc = new ReponsesCRUD();
        // id_r table view
        JFXTreeTableColumn<Reponses, String> id_r = new JFXTreeTableColumn<>("id_r");
        id_r.setPrefWidth(150);
        id_r.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reponses, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_q()));
            }
        });
        
        JFXTreeTableColumn<Esprit.entities.Reponses, String> text_r = new JFXTreeTableColumn<>("text_r");
        text_r.setPrefWidth(150);
        text_r.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Esprit.entities.Reponses, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Esprit.entities.Reponses, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getText_r());
            }
        });
                 text_r.setCellFactory((TreeTableColumn<Esprit.entities.Reponses, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable text_r text field
        text_r.setOnEditCommit((CellEditEvent<Esprit.entities.Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setText_r(t.getNewValue());
            rc.modifierReponse(idd, "text_r", newValue);
        });
  // id_q table view
        JFXTreeTableColumn<Esprit.entities.Reponses, String> id_q = new JFXTreeTableColumn<>("id_q");
        id_q.setPrefWidth(150);
        id_q.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Esprit.entities.Reponses, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Esprit.entities.Reponses, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_q()));
            }
        });
        
        id_q.setCellFactory((TreeTableColumn<Esprit.entities.Reponses, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable id_q text field
        id_q.setOnEditCommit((CellEditEvent<Esprit.entities.Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_q(Integer.parseInt(t.getNewValue()));
            rc.modifierReponse(idd, "id_q", newValue);
        });
        
        List<Esprit.entities.Reponses> myLst;
        myLst = rc.ReponsessListt();
        ObservableList<Esprit.entities.Reponses> Reponsess = FXCollections.observableArrayList();

        myLst.forEach(p -> Reponsess.add(p));
        JFXTreeTableView<Esprit.entities.Reponses> treeview = new JFXTreeTableView<>();
        final TreeItem<Esprit.entities.Reponses> root = new RecursiveTreeItem<Esprit.entities.Reponses>(Reponsess, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_r, text_r,id_q);
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
                Label l1 = new Label("Delete Reponses?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Esprit.entities.Reponses>() {
                    @Override
                    public Esprit.entities.Reponses call(ButtonType param) {
                        if (param == Confi) {
                            Esprit.entities.Reponses p = treeview.getSelectionModel().getSelectedItem().getValue();
                            rc.supprimerReponse((Esprit.entities.Reponses) p);
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
          AnchorReponse.getChildren().addAll(treeview,DltBtn); 
    }    
    
}
