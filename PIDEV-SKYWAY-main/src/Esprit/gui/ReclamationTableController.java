/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

//import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;
import Esprit.Connection.MyConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import Esprit.entities.Reclamation;
import Esprit.entities.Utilisateur;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import Esprit.services.ReclamationService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import static org.apache.poi.sl.usermodel.PaintStyle.GradientPaint.GradientType.linear;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author IBTIHEL
 */
public class ReclamationTableController implements Initializable {

    @FXML
    private TableView<Reclamation> reclamationTable;
   // @FXML
   // private TableColumn<Reclamation, Integer> idCol;
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
    private FileInputStream fis;
    @FXML
    private Button exportToXml;
    @FXML
    private TableColumn<Reclamation, String> coursCol;
    @FXML
    private TableColumn<Reclamation, String> ensCol;
    @FXML
    private ImageView image;
    private int x = 8 ;
    //private Integer useraddo = 10;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                               LoginFXMLController mmmmmm = new LoginFXMLController();
            Utilisateur usermimi = LoginFXMLController.usertest;
           System.out.println("\n\n\n\n iddddddddddddd fwest aReclamation table *************** :\n  "+ usermimi.getIdUser());
        
        // TODO
        loadDate();
        
        //chercherPromotion();
       // exportToXml.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
       /* ImageView img  = new ImageView  ();
        img.setImage(im);
        img.setFitWidth(120);
        Pane pn  = new HBox(15);
       Image im = new Image ("file:images.png");
       pn.getChildren().add(new ImageView(im));*/
      
       
        
    }    
   // Image im = new Image ("file:images.png");

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
   
        
        connection = MyConnection.getInstance().getConnection();
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
                        resultSet.getInt("id"),
                        resultSet.getString("cours") ,
                        resultSet.getString("enseignant")));
                reclamationTable.setItems(ReclamationList);
                System.out.println(ReclamationList);
                
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
            LoginFXMLController mmmmmm = new LoginFXMLController();
            Utilisateur usermimi = LoginFXMLController.usertest;
        connection =  MyConnection.getInstance().getConnection();
        refreshTable();
        //idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
        textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
        coursCol.setCellValueFactory(new PropertyValueFactory<>("cours"));
        ensCol.setCellValueFactory(new PropertyValueFactory<>("enseignant"));
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
                            //Alert dialog
                           Alert alert = new Alert(AlertType.CONFIRMATION);
                           alert.setTitle("Confirmation Dialog");
                           alert.setHeaderText("Vous ete sur de supprimer cette reclamation?");
                           Optional <ButtonType> action = alert.showAndWait();
                              if (action.get()== ButtonType.OK) {
                                  reclamation = reclamationTable.getSelectionModel().getSelectedItem();
                                  if (usermimi.getIdUser() == reclamation.getId()) {
                                   try {
                                
                                query = "DELETE FROM `reclamation` WHERE id_rec  ="+reclamation.getId_rec();
                                connection =  MyConnection.getInstance().getConnection();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                 
                                  } else {System.out.println("cancel");
                                   Alert al = new Alert(AlertType.ERROR);
                                  al.setTitle("Erreur");
                                  al.setContentText("tessssssssst");
                                   al.setHeaderText("Vous pouvez supprimer juste votre reclmation!");
                                   al.showAndWait(); }
                                  } else System.out.println("yala yala");
                                  
                                  /* if (utilisateur = reclamation.getId()) {   try {
                                reclamation = reclamationTable.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `reclamation` WHERE id_rec  ="+reclamation.getId_rec();
                                connection =  MyConnection.getInstance().getConnection();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null, ex);
                            }}
                                  else System.out.println("interdit") */

                     

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            //Alert dialog
                            Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            alert.setHeaderText("Vous ete sur de modifier cette reclamation?");
                            Optional <ButtonType> action = alert.showAndWait();
                            if (action.get()== ButtonType.OK) {
                            reclamation = reclamationTable.getSelectionModel().getSelectedItem();
                            if (usermimi.getIdUser() == reclamation.getId()) {
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
                            reclamation.getText_r(),reclamation.getCours(),reclamation.getEnseignant()/*,reclamation.getDate_env()*/);
                            Parent parent = loader.getRoot();
                            
                            Stage stage = new Stage();
                            
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            
                             } 
                            else {
                                Alert al = new Alert(AlertType.ERROR);
                                  al.setTitle("Erreur");
                                  al.setContentText("tessssssssst");
                                   al.setHeaderText("Vous pouvez supprimer juste votre reclmation!");
                                   al.showAndWait(); 
                            }
                                }
                 

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
          // test api excel 
         
      exportToXml.setOnMouseClicked((MouseEvent event) -> {    
         try {
          String query = "select * from reclamation ";
          preparedStatement = connection.prepareStatement(query);
          resultSet = preparedStatement.executeQuery();
       ReclamationService rs = new ReclamationService();

        XSSFWorkbook wb = new XSSFWorkbook(); // for earlier version use HSSF
        XSSFSheet sheet = wb.createSheet("reclamation details");
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("id_rec");
        header.createCell(1).setCellValue("objet");
        header.createCell(2).setCellValue("text_r");
        header.createCell(3).setCellValue("date_envoi");
        header.createCell(4).setCellValue("cours");
        header.createCell(5).setCellValue("enseignant");
        header.createCell(6).setCellValue("id");
            
         sheet.autoSizeColumn(1);
         sheet.autoSizeColumn(2);
         sheet.autoSizeColumn(3);
         sheet.autoSizeColumn(4);
         sheet.autoSizeColumn(5);
         sheet.autoSizeColumn(6);

        int index =1 ;
        while (resultSet.next()) {
                XSSFRow row = sheet.createRow(index);
               row.createCell(0).setCellValue(resultSet.getInt("id_rec"));
               row.createCell(1).setCellValue(resultSet.getString("objet"));
               row.createCell(2).setCellValue(resultSet.getString("text_r"));
               row.createCell(3).setCellValue(resultSet.getString("date_envoi"));
               row.createCell(4).setCellValue(resultSet.getString("cours"));
               row.createCell(5).setCellValue(resultSet.getString("enseignant"));
               row.createCell(6).setCellValue(resultSet.getInt("id"));
             
            index++; 
            }
               FileOutputStream fileOut = new FileOutputStream("reclamationdetails.xlsx");
               wb.write(fileOut);
               fileOut.close();

              Alert alert = new Alert(AlertType.INFORMATION);
                           alert.setTitle("Information Dialog");
                           alert.setHeaderText("Les réclamations vont ere expportés en fichier excel");
                           alert.showAndWait();
                        preparedStatement.close();
                        resultSet.close();
         }catch (SQLException | FileNotFoundException ex) {
                       Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null , ex);
                } catch (IOException ex) {
                      Logger.getLogger(ReclamationTableController.class.getName()).log(Level.SEVERE, null , ex);
                   }
                 Image img = new Image("/check.png");
                 Notifications notification;
                 notification = Notifications.create()
                .title("Export  réussit")
                .text("Done !!")
                .graphic(new ImageView(img))
                .position(Pos.BASELINE_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Clicked on notification");
                    }
                });
               notification.show();
              });
        
         
    }
   ReclamationService rs = new ReclamationService();

    @FXML
    private void Tri_Asc(ActionEvent event) {
        if (Asc_chb.isSelected()) {
            Desc_chb.setSelected(false);
           

            try {

                ObservableList<Reclamation> list = rs.TriAscPromo();

               // idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
                objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                coursCol.setCellValueFactory(new PropertyValueFactory<>("cours"));
                ensCol.setCellValueFactory(new PropertyValueFactory<>("enseignant"));
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
              
                //idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
                objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                coursCol.setCellValueFactory(new PropertyValueFactory<>("cours"));
                ensCol.setCellValueFactory(new PropertyValueFactory<>("enseignant"));
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
              // idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
                objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                coursCol.setCellValueFactory(new PropertyValueFactory<>("cours"));
                ensCol.setCellValueFactory(new PropertyValueFactory<>("enseignant"));
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

    
  
   /*  
        ReclamationService rs = new ReclamationService();
        // rs.readReclamation()
       ObservableList<Reclamation> lists =  rs.eadReclamation();
  objetCol.setCellValueFactory(new PropertyValueFactory<>("objet"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text_r"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date_envoi"));
                coursCol.setCellValueFactory(new PropertyValueFactory<>("cours"));
                ensCol.setCellValueFactory(new PropertyValueFactory<>("enseignant"));
                userCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                reclamationTable.setItems(lists);


FilteredList <Reclamation> filteredData = new FilteredList<>(lists, b -> true);  
       filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(Reclamation -> {
        if (newValue == null || newValue.isEmpty()) {
        return true;
        }    


       void searchPart() {   
        partenaireCRUD parc = new partenaireCRUD();
            //parc.partenaireList();
        ObservableList<partenaire> lists =  parc.partenaireList();
        colIdpar.setCellValueFactory(new PropertyValueFactory<partenaire, Integer>("id_p"));
        colNompar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("nom_p"));
        colDomainepar.setCellValueFactory(new PropertyValueFactory<partenaire, String>("domaine"));
        colDatee.setCellValueFactory(new PropertyValueFactory<partenaire, String>("date_p"));
       
       tvPar.setItems(lists);
      
        FilteredList <partenaire> filteredData = new FilteredList<>(lists, b -> true);  
        tsearch.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(partenaire -> {
        if (newValue == null || newValue.isEmpty()) {
        return true;
        }    
        String lowerCaseFilter = newValue.toLowerCase();
    
        if (partenaire.getNom_p().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
        return true; // Filter matches username
        } else if (partenaire.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1) {
        
        return true; // Filter matches password
        }
    
        else if (String.valueOf(partenaire.getId_p()).indexOf(lowerCaseFilter) != -1) {
     
       return true; // Filter matches password
        }
       else if (String.valueOf(partenaire.getDate_p()).indexOf(lowerCaseFilter) != -1) {
     
       return true; // Filter matches password
       }
                      
        else  
          return false; // Does not match.
      });
      });  
      SortedList<partenaire> sortedData = new SortedList<>(filteredData);  
      sortedData.comparatorProperty().bind(tvPar.comparatorProperty());  
      tvPar.setItems(sortedData);      
      }
*/
   
    

