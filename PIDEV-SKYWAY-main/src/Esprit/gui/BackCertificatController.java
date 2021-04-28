/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.test;
import Esprit.entities.test;
import Esprit.services.testCRUD;
import Esprit.services.testCRUD;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
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
import java.util.ResourteBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class BackCertificatController implements Initializable {

    @FXML
    private AnchorPane modifcertif;
 
 
 
    
     
    public void initialize(URL url, ResourceBundle rb) {
     // TODO
       testCRUD rt = new testCRUD();
        // id_test table view
        JFXTreeTableColumn<test, String> id_test = new JFXTreeTableColumn<>("id_test");
        id_test.setPrefWidth(150);
        id_test.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<test, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<test, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_test()));
            }
        });        
        
     JFXTreeTableColumn<Esprit.entities.test, String> score = new JFXTreeTableColumn<>("score");
        score.setPrefWidth(150);
            score.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Esprit.entities.test, String>, ObservableValue<String>>(){
            
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<test, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getScore()));
            }
        });
                 score.setCellFactory((TreeTableColumn<Esprit.entities.test, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable score text field
        score.setOnEditCommit((TreeTableColumn.CellEditEvent<Esprit.entities.test, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_test();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setScore(Integer.parseInt(t.getNewValue()));
            rt.modifier(idd, "score", newValue);
        });  
          JFXTreeTableColumn<Esprit.entities.test, String> date_test = new JFXTreeTableColumn<>("date_test");
        date_test.setPrefWidth(150);
        date_test.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Esprit.entities.test, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Esprit.entities.test, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDate_test());
            }
        });
                 date_test.setCellFactory((TreeTableColumn<Esprit.entities.test, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable date_test text field
        date_test.setOnEditCommit((TreeTableColumn.CellEditEvent<Esprit.entities.test, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_test();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setDate_test(t.getNewValue());
            rt.modifier(idd, "date_test", newValue);
        });
        
       
        
    List<test> myLst;
        myLst = rt.ReponsesList();
        ObservableList<test> Questionss = FXCollections.observableArrayList();

        myLst.forEach(p -> Questionss.add(p));
        JFXTreeTableView<test> treeview = new JFXTreeTableView<>();
        final TreeItem<test> root = new RecursiveTreeItem<test>(Questionss, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_test, score,date_test);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        treeview.setEditable(true);
       
        
  treeview.refresh();
           
          modifcertif.getChildren().add(treeview);
    }    

    

    
   

   
}
          
        
        
    
