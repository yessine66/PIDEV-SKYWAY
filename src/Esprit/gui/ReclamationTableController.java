/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.Connection.MyConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import Esprit.entities.Reclamation;
import Esprit.services.ReclamationService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
 * @author IBTIHEL
 */
public class ReclamationTableController implements Initializable {

    @FXML
    private TableView<Reclamation> reclamationTable;
    @FXML
    private TableColumn<Reclamation, Integer> idCol;
    @FXML
    private TableColumn<Reclamation, String> objetCol;
    @FXML
    private TableColumn<Reclamation, String> textCol;
    @FXML
    private TableColumn<Reclamation, String> dateCol;
    @FXML
    private TableColumn<Reclamation, Integer> userCol;
    @FXML
    private TableColumn<Reclamation, String> editCol;
    //@FXML
    //private CheckBox Desc_chb;   
   // @FXML
   // private CheckBox Asc_chb; 
ObservableList<Reclamation>  ReclamationList = FXCollections.observableArrayList();
 String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Reclamation reclamation = null ;
    @FXML
    private TextField filterField;
    @FXML
    private CheckBox Asc_chb;
    @FXML
    private CheckBox Desc_chb;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
    }    

    @FXML
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addReclamation.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refreshTable() {
        connection =  MyConnection.getInstance().getConnection();//    cnxBD.getInstance().getCnx();
        try {
            ReclamationList.clear();
            String query = "SELECT * FROM `reclamation`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                ReclamationList.add(new  Reclamation(
                        resultSet.getInt("id_rec"),
                        resultSet.getString("objet"),
                        resultSet.getString("text_r"),
                        resultSet.getString("date_envoi"),
                        resultSet.getInt("id")));
                reclamationTable.setItems(ReclamationList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

   private void loadDate() {
        
        connection =  MyConnection.getInstance().getConnection();
        refreshTable();
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
        textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        //add cell of button edit 
         Callback<TableColumn<Reclamation, String>, TableCell<Reclamation, String>> cellFoctory = (TableColumn<Reclamation, String> param) -> {
            // make cell containing buttons
            final TableCell<Reclamation, String> cell = new TableCell<Reclamation, String>() {
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
                                reclamation = reclamationTable.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `reclamation` WHERE id_rec  ="+reclamation.getId_rec();
                                connection =  MyConnection.getInstance().getConnection();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            reclamation = reclamationTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("addReclamation.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AddReclamationController addReclamationController = loader.getController();
                            addReclamationController.setUpdate(true);
                            addReclamationController.setTextField(reclamation.getId_rec(), reclamation.getObjet(), 
                            reclamation.getText()/*,reclamation.getDate_env()*/);
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
         editCol.setCellFactory(cellFoctory);
         reclamationTable.setItems(ReclamationList);
         
         
    }
   ReclamationService rs = new ReclamationService();

    @FXML
    private void Tri_Asc(ActionEvent event) {
        if (Asc_chb.isSelected()) {
            Desc_chb.setSelected(false);
           

            try {

                ObservableList<Reclamation> list = rs.TriAscPromo();

                idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
                objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                userCol.setCellValueFactory(new PropertyValueFactory<>("id"));

                reclamationTable.setItems(list);
                System.out.println("Succes tri ASC");
            }catch (Exception ex) {
                System.out.println("echec tri ASC");
            }
        }
        //chercherPromotion();
    }
    @FXML
    private void Tri_Desc(ActionEvent event) {
           if (Desc_chb.isSelected()) {
            
            Asc_chb.setSelected(false);
            try {
                ObservableList<Reclamation> list = rs.TriDscPromo();
              
                idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
                objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                userCol.setCellValueFactory(new PropertyValueFactory<>("id"));

                reclamationTable.setItems(list);
                System.out.println("Succes tri DESC");
            } catch (Exception ex) {
                System.out.println("echec tri DESC");
            }
        }
    }
    void chercherPromotion(){
        ObservableList<Reclamation> dataList;
        dataList = rs.readReclamation();
        Reclamation p = new Reclamation();
               idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
                objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                userCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                
        reclamationTable.setItems(dataList);

        FilteredList<Reclamation> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Reclamation post) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (post.getObjet().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username

                }
                else {
                    return false; 
                }
            });
        });
        SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(reclamationTable.comparatorProperty());
        reclamationTable.setItems(sortedData);
        
    }
    
    }

    
  
   
   
    


