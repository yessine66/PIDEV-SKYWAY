/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Certificat;
import Esprit.services.CertificatCRUD;
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
    private TextArea champsCertif;
    @FXML
    private Button AjoutCertif;
    @FXML
    private TextField date;
    @FXML
    private AnchorPane modifcertif;
    CertificatCRUD rc;
 ObservableList<Esprit.entities.Certificat> Certificats = FXCollections.observableArrayList();
 JFXTreeTableView<Esprit.entities.Certificat> treeview = new JFXTreeTableView<>();
        final TreeItem<Esprit.entities.Certificat> root = new RecursiveTreeItem<Esprit.entities.Certificat>(Certificats, RecursiveTreeObject::getChildren);
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     // TODO
        rc = new CertificatCRUD();
        // id_certif table view
        JFXTreeTableColumn<Certificat, String> id_certif = new JFXTreeTableColumn<>("id_certif");
        id_certif.setPrefWidth(150);
        id_certif.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Certificat, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Certificat, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getId_certif()));
            }
        });        
        
     JFXTreeTableColumn<Esprit.entities.Certificat, String> titre_certif = new JFXTreeTableColumn<>("titre_certif");
        titre_certif.setPrefWidth(150);
        titre_certif.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Esprit.entities.Certificat, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Esprit.entities.Certificat, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getTitre_certif());
            }
        });
                 titre_certif.setCellFactory((TreeTableColumn<Esprit.entities.Certificat, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable titre_certif text field
        titre_certif.setOnEditCommit((TreeTableColumn.CellEditEvent<Esprit.entities.Certificat, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_certif();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setTitre_certif(t.getNewValue());
            rc.modifierCertification(idd, "titre_certif", newValue);
        });  
          JFXTreeTableColumn<Esprit.entities.Certificat, String> date_certif = new JFXTreeTableColumn<>("date_certif");
        date_certif.setPrefWidth(150);
        date_certif.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Esprit.entities.Certificat, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Esprit.entities.Certificat, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDate_certif());
            }
        });
                 date_certif.setCellFactory((TreeTableColumn<Esprit.entities.Certificat, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        //setting the new value for editable date_certif text field
        date_certif.setOnEditCommit((TreeTableColumn.CellEditEvent<Esprit.entities.Certificat, String> t) -> {
            int idd = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getId_certif();
            String newValue = t.getNewValue();

            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().setDate_certif(t.getNewValue());
            rc.modifierCertification(idd, "date_certif", newValue);
        });
        
       
        
    List<Esprit.entities.Certificat> myLst;
        myLst = rc.CertificatListt();
        ObservableList<Esprit.entities.Certificat> Certificats = FXCollections.observableArrayList();

        myLst.forEach(p -> Certificats.add(p));
        JFXTreeTableView<Esprit.entities.Certificat> treeview = new JFXTreeTableView<>();
        final TreeItem<Esprit.entities.Certificat> root = new RecursiveTreeItem<Esprit.entities.Certificat>(Certificats, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(id_certif, titre_certif,date_certif);
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
                Label l1 = new Label("Delete Certificat?");
                grid2.add(l1, 2, 2);
                confirmation.setTitle("Confirmation de suppression!");
                confirmation.getDialogPane().setContent(grid2);
                ButtonType Confi = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType Ann = new ButtonType("No", ButtonBar.ButtonData.OK_DONE);
                confirmation.getDialogPane().getButtonTypes().add(Confi);
                confirmation.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                confirmation.setResultConverter(new Callback<ButtonType, Esprit.entities.Certificat>() {
                    @Override
                    public Esprit.entities.Certificat call(ButtonType param) {
                        if (param == Confi) {
                            Esprit.entities.Certificat p = treeview.getSelectionModel().getSelectedItem().getValue();
                            rc.supprimerCertification((Esprit.entities.Certificat) p);
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
          modifcertif.getChildren().addAll(treeview,DltBtn); 
    }    
    

   

    @FXML
    private void ajouterCertif(ActionEvent event) {
      try{   if(event.getSource() == AjoutCertif)
             {
            String titre_certif = champsCertif.getText();
           String date_certif = date.getText();

           Certificat rep = new Certificat(22,titre_certif,date_certif);
           CertificatCRUD rc = new CertificatCRUD();
            rc.ajouterCertification(rep);
    }
    FXMLLoader loader = new FXMLLoader(getClass().getResource("BackCertificat.fxml"));
              treeview.refresh();
            Parent root = loader.load();

            champsCertif.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(BackReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }
                     treeview.refresh();

        }
          
        
        
    }
