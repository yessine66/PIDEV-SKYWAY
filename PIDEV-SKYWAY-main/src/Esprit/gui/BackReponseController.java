/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;


import Esprit.entities.Questions;
import Esprit.entities.Reponses;
import Esprit.services.ReponsesCRUD;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class BackReponseController implements Initializable {

    @FXML
    private TextArea champsReponse;
    @FXML
    private Button AjoutReponse;
    @FXML
    private ComboBox<Integer> combor;
    @FXML
    private AnchorPane AnchorReponse;
 ReponsesCRUD rc;
   ObservableList<Esprit.entities.Reponses> Reponsess = FXCollections.observableArrayList();

        JFXTreeTableView<Esprit.entities.Reponses> treevieww = new JFXTreeTableView<>();
        final TreeItem<Esprit.entities.Reponses> root = new RecursiveTreeItem<Esprit.entities.Reponses>(Reponsess, RecursiveTreeObject::getChildren);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          showCombobox();
      
        // TODO
        rc = new ReponsesCRUD();
           // id_r table view
        JFXTreeTableColumn<Reponses, String> id_r = new JFXTreeTableColumn<>("id_r");
        id_r.setPrefWidth(150);
        id_r.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reponses, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reponses, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_r()));
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
        text_r.setOnEditCommit((TreeTableColumn.CellEditEvent<Esprit.entities.Reponses, String> t) -> {
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
        id_q.setOnEditCommit((TreeTableColumn.CellEditEvent<Esprit.entities.Reponses, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_r();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setId_q(Integer.parseInt(t.getNewValue()));
            rc.modifierReponse(idd, "id_q", newValue);
        });
        
        List<Esprit.entities.Reponses> myLstt;
        myLstt = rc.ReponsessListt();
        ObservableList<Esprit.entities.Reponses> Reponsess = FXCollections.observableArrayList();
        myLstt.forEach(p -> Reponsess.add(p));
       JFXTreeTableView<Esprit.entities.Reponses> treevieww = new JFXTreeTableView<>();
        final TreeItem<Esprit.entities.Reponses> root = new RecursiveTreeItem<Esprit.entities.Reponses>(Reponsess, RecursiveTreeObject::getChildren);
        treevieww.getColumns().setAll(id_r, text_r,id_q);
        treevieww.setRoot(root);
        treevieww.setShowRoot(false);
        treevieww.setEditable(true);  
        
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
        }); 
          AnchorReponse.getChildren().addAll(treevieww,DltBtn); 
    }

 public void showCombobox()
     {
          ReponsesCRUD reponse = new ReponsesCRUD();
         ObservableList<Integer> listrep = reponse.comboreponse ();
    
      combor.setItems(listrep);
         
     }
    @FXML
    private void ajouterReponse(ActionEvent event) {
         
        if(event.getSource() == AjoutReponse)
        {
            String text_r = champsReponse.getText();
            String value_r=combor.getValue().toString();
            int id_qr= Integer.parseInt(value_r) ;
            
            Reponses rep = new Reponses(22,text_r,id_qr);
            ReponsesCRUD rc = new ReponsesCRUD();
            // normalment appel l fct fillCombobox 
            rc.ajouterReponse(rep);
        }
        /* FXMLLoader loader = new FXMLLoader(getClass().getResource("BackReponse.fxml"));
        treevieww.refresh();
        Parent root = loader.load();*/
      //  champsReponse.getScene().setRoot(root);
                     treevieww.refresh();
                      URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);

        }
          
        
        
    }

    
           
    
    

