/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Promotion;
import Esprit.entities.partenaire;
import Esprit.services.partenaireCRUD;

import Esprit.services.promotionCRUD;
import Esprit.Connection.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterPromotionController implements Initializable {

    @FXML
    private TextField tidpro;
    @FXML
    private TextField tcodepro;
    @FXML
    private TextField treduction;
    @FXML
    private Button btnAjouterPro;
    @FXML
    private Button btnModifierPro;
    @FXML
    private Button btnSupprimerPro;
    @FXML
    private TableView<Promotion> tvPromotion;
    @FXML
    private TableColumn<Promotion, Integer> colIdpro;
    @FXML
    private TableColumn<Promotion, String> colCodepro;
    @FXML
    private TableColumn<Promotion, Integer> colReduction;
    @FXML
    private TableColumn<Promotion, String> colIdparEtr;
    @FXML
    private ComboBox<String> comboPar;
    //DatePicker date;
    @FXML
    private DatePicker dateDp;
    @FXML
    private DatePicker dateFp;
    @FXML
    private TableColumn<Promotion, String> colDateD;
    @FXML
    private TableColumn<Promotion, String> colDateF;
    @FXML
    private ListView<Promotion> listProm;
    @FXML
    private TextField tsearchp;
    int index =-1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPromotion();
        showCombo();
        searchProm();
        //dateFp= new DatePicker ();
  
    }    
     public void showCombo()
     {
          promotionCRUD parc = new promotionCRUD();
         ObservableList<String> listCom =  parc. comboListPar ();
    
      comboPar.setItems(listCom);
         
     }
    
     public void showPromotion(){
       promotionCRUD parc = new promotionCRUD();
            //parc.promotionList();
        ObservableList<Promotion> list =  parc.PromotionList();
        
       colIdpro.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("id_prom"));
       colCodepro.setCellValueFactory(new PropertyValueFactory<Promotion, String>("code_p"));
       colReduction.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("reduction"));
         colDateD.setCellValueFactory(new PropertyValueFactory<Promotion, String>("dateD"));
          colDateF.setCellValueFactory(new PropertyValueFactory<Promotion, String>("dateF"));
   colIdparEtr.setCellValueFactory(new PropertyValueFactory<Promotion, String>("nom_p"));
     listProm.setItems(list);
   tvPromotion.setItems(list);
     
     
    }
    
    

  /*  private void btnPromotionAction(ActionEvent event) {
        
        
        
         try {

             if(event.getSource() == btnAjouterPro)
             {
                 if (validation()){
            String rCodepro = tcodepro.getText();
      
            int rReduction= Integer.parseInt(treduction.getText()) ;
            String rdateD=dateDp.getEditor().getText();
            String rdateF=dateFp.getEditor().getText();
            //String valuePart=comboPar.getValue().toString();
          //int rIdpart= Integer.parseInt(valuePart) ;

         String rIdpart = comboPar.getValue().toString();
           
           Promotion pro = new Promotion(22,rCodepro,rReduction,rdateD,rdateF,rIdpart);
           
           //int id_prom, String dateD, String dateF, String code_p, int reduction, String nom_p
           promotionCRUD proc = new promotionCRUD();
            proc.ajouterPromotion(pro);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                 }
            
            
            
        }
             
             else if (event.getSource() == btnModifierPro)
             
             
             {
           
           int  mIdpro= Integer.parseInt(tidpro.getText()) ;
             String mCodepro = tcodepro.getText();
            int mReduction= Integer.parseInt(treduction.getText()) ;
               String valuePart=comboPar.getValue().toString();
               //String mIdpart=comboPar.getEditor().getText();
                String mdateD=dateDp.getEditor().getText();
                 String mdateF = dateFp.getEditor().getText();
               
           //int rIdpart= Integer.parseInt(valuePart) ;
            
        Promotion pro = new Promotion(mIdpro,mCodepro,mReduction,mdateD,mdateF, valuePart);
       promotionCRUD proc = new promotionCRUD();
     proc.modifierPromotion(pro);
                 
             }
             
               
             else if (event.getSource() == btnSupprimerPro)
             {
                 
                 
      int  mIdpro= Integer.parseInt(tidpro.getText()) ;
     
    Promotion pro = new Promotion(mIdpro);
     promotionCRUD proc = new promotionCRUD();
       proc.supprimerPromotion(pro);
                 
                 
                 
                  
                  
             }
             
         
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterPromotion.fxml"));
              showPromotion();
        Parent root = loader.load();
  
          tcodepro.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(AjouterPartenaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
    }*/

    @FXML
    private void DateSelect(ActionEvent event) {
        //dateDp.getValue().toString ();
        
    }

  /*  @FXML
    private void DateSelect2(ActionEvent event) {
    }
    */

    @FXML
    private void DateSelect2(ActionEvent event) {
    }
    
    private boolean validation ()
    {
        
        
        if (tcodepro.getText().isEmpty() | treduction.getText().isEmpty() | comboPar.getSelectionModel().isEmpty()|dateDp.getEditor().getText().isEmpty() | dateFp.getEditor().getText().isEmpty() )
            
        {
          Alert alert = new Alert (AlertType.WARNING);
          alert.setTitle("alert code promo vode");
          alert.setHeaderText(null);
          alert.setContentText("Veuillez remplir tous les champs ! ");
          alert.showAndWait();
          return false;
        }
        
        
        
        
        
        
        return true;
        
        
        
        
    }
    
    
    void searchProm() {   
          promotionCRUD parc = new promotionCRUD();
            //parc.promotionList();
        ObservableList<Promotion> listp =  parc.PromotionList();
        
       colIdpro.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("id_prom"));
       colCodepro.setCellValueFactory(new PropertyValueFactory<Promotion, String>("code_p"));
       colReduction.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("reduction"));
         colDateD.setCellValueFactory(new PropertyValueFactory<Promotion, String>("dateD"));
          colDateF.setCellValueFactory(new PropertyValueFactory<Promotion, String>("dateF"));
   colIdparEtr.setCellValueFactory(new PropertyValueFactory<Promotion, String>("nom_p"));
    
   tvPromotion.setItems(listp);
      
        FilteredList <Promotion> filteredData = new FilteredList<>(listp, b -> true);  
 tsearchp.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(promotion -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (promotion.getCode_p().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    }
    
    else if (String.valueOf(promotion.getReduction()).indexOf(lowerCaseFilter) != -1) {
     
     return true; // Filter matches password
    }
    else if (String.valueOf(promotion.getId_prom()).indexOf(lowerCaseFilter) != -1) {
     
     return true; // Filter matches password
    }
     else if (String.valueOf(promotion.getDateD()).indexOf(lowerCaseFilter) != -1) {
     
     return true; // Filter matches password
    }
      else if (String.valueOf(promotion.getDateF()).indexOf(lowerCaseFilter) != -1) {
     
     return true; // Filter matches password
    }
    
     
                             
         else  
          return false; // Does not match.
   });
  });  
  SortedList<Promotion> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(tvPromotion.comparatorProperty());  
  tvPromotion.setItems(sortedData);      
    }

    @FXML
    private void selectProm(MouseEvent event) {
         System.err.println("click2!");
         index = tvPromotion.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
   tidpro.setText(colIdpro.getCellData(index).toString());
 tcodepro.setText(colCodepro.getCellData(index).toString());
  treduction.setText(colReduction.getCellData(index).toString());
    //DateSelec.setString(colDatee.getCellData(index));
       
     searchProm();
    }

    @FXML
    private void btnAjoutProm(ActionEvent event) {
        if (validation()){
            String rCodepro = tcodepro.getText();
      
            int rReduction= Integer.parseInt(treduction.getText()) ;
            String rdateD=dateDp.getEditor().getText();
            String rdateF=dateFp.getEditor().getText();
            //String valuePart=comboPar.getValue().toString();
          //int rIdpart= Integer.parseInt(valuePart) ;

         String rIdpart = comboPar.getValue().toString();
           
           Promotion pro = new Promotion(22,rCodepro,rReduction,rdateD,rdateF,rIdpart);
           
           //int id_prom, String dateD, String dateF, String code_p, int reduction, String nom_p
           promotionCRUD proc = new promotionCRUD();
            proc.ajouterPromotion(pro);
            URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);

                 }
  
    }

    @FXML
    private void btnModifierProm(ActionEvent event) {
         int  mIdpro= Integer.parseInt(tidpro.getText()) ;
             String mCodepro = tcodepro.getText();
            int mReduction= Integer.parseInt(treduction.getText()) ;
               String valuePart=comboPar.getValue().toString();
               //String mIdpart=comboPar.getEditor().getText();
                String mdateD=dateDp.getEditor().getText();
                 String mdateF = dateFp.getEditor().getText();
               
           //int rIdpart= Integer.parseInt(valuePart) ;
            
        Promotion pro = new Promotion(mIdpro,mCodepro,mReduction,mdateD,mdateF, valuePart);
       promotionCRUD proc = new promotionCRUD();
     proc.modifierPromotion(pro);
   URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
    }

    @FXML
    private void btnSupprimerProm(ActionEvent event) {
         int  mIdpro= Integer.parseInt(tidpro.getText()) ;
     
    Promotion pro = new Promotion(mIdpro);
     promotionCRUD proc = new promotionCRUD();
       proc.supprimerPromotion(pro);
        showPromotion();
        URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
    }
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
