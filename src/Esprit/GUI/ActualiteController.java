/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.GUI;

import Esprit.Connection.MyConnection;
import Esprit.Entities.Actualite;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author khouja safa
 */
public class ActualiteController implements Initializable {

    @FXML
    private Tab TabList;
    @FXML
    private TextField BtnRech;
    @FXML
    private TableView<Actualite> ListAct;
    @FXML
    private TableColumn<Actualite, String> titre;
    @FXML
    private TableColumn<Actualite, String> description;
    @FXML
    private TableColumn<Actualite, Integer> evenement;
    @FXML
    private TableColumn<Actualite, String> action;
    @FXML
    private Tab TabAdd;
    @FXML
    private TextField TFtitre;
    @FXML
    private TextField TFdesc;
    @FXML
    private TextField TFimage;
    @FXML
    private ChoiceBox<?> evChoice;
    @FXML
    private TextField TFutilisateur;
    @FXML
    private Button BtnAjout;
    @FXML
    private Tab TabUpdate;
    @FXML
    private TextField TFtitrem;
    @FXML
    private TextField TFdescm;
    @FXML
    private TextField TFimagem;
    @FXML
    private ChoiceBox<?> evChoicem;
    @FXML
    private Button BtnModif;
    @FXML
    private Tab TabDetail;
    @FXML
    private Label LabDet;

    
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Actualite actualite = null ;
    
    private boolean update;
    int actualite_id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    private void loadData() {
        MyConnection cnx = MyConnection.getInstance();
       titre.setCellValueFactory(new PropertyValueFactory<>("titre_ac"));
       description.setCellValueFactory(new PropertyValueFactory<>("desc"));
       evenement.setCellValueFactory(new PropertyValueFactory<>("evenement"));
       
       ObservableList<Actualite>  ActualiteList = FXCollections.observableArrayList();
       
       
       
       
       
       Callback<TableColumn<Actualite, String>, TableCell<Actualite, String>> cellFoctory = (TableColumn<Actualite, String> param) -> {
            // make cell containing buttons
            final TableCell<Actualite, String> cell = new TableCell<Actualite, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            try {
                                actualite = ListAct.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `actualite` WHERE id  ="+ actualite.getId_ac();
                                connection = MyConnection.getInstance().getConnection();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                
                            } catch (SQLException ex) {
                                System.out.println(ex);
                            }
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            actualite = ListAct.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/tableView/addStudent.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                            
                            ActualiteController actualiteController = loader.getController();
                            actualiteController.setUpdate(true);
                            actualiteController.setTextField(actualite.getId_ac(), actualite.getTitre_ac(), 
                                    actualite.getDesc()/*,actualite.getEvenement()*/);
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         action.setCellFactory(cellFoctory);
         ListAct.setItems(ActualiteList);
         
         
  
      
    }
   
     void setTextField(int id_ac, String titre_ac,  String desc) {

         actualite_id = id_ac;
        TFtitrem.setText(titre_ac);
        TFdescm.setText(desc);
        // userTF.setInt(Integer.parseInt(user));
       
        

    }
        void setUpdate(boolean b) {
        this.update = b;

    }
   
    
}
