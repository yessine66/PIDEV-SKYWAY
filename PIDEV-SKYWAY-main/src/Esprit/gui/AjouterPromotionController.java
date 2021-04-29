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
    /*private TableView<Promotion> tvPromotion;
    private TableColumn<Promotion, Integer> colIdpro;
    private TableColumn<Promotion, String> colCodepro;
    private TableColumn<Promotion, Integer> colReduction;
    private TableColumn<Promotion, String> colIdparEtr;*/
    @FXML
    private ComboBox<String> comboPar;
    //DatePicker date;
    @FXML
    private DatePicker dateDp;
    @FXML
    private DatePicker dateFp;
    private TableColumn<Promotion, String> colDateD;
    private TableColumn<Promotion, String> colDateF;
    int index =-1;
    @FXML
    private ListView<Promotion> listViewProm;
    @FXML
    private ComboBox<Integer> ComboPartenaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPromotion();
        showCombo();
       showComboPart();
  
    }    
     public void showCombo()
     {
          promotionCRUD parc = new promotionCRUD();
         ObservableList<String> listCom =  parc. comboListPar ();
    
      comboPar.setItems(listCom);
         
     }
     public void showComboPart()
     {
          promotionCRUD parc = new promotionCRUD();
         ObservableList<Integer> listCom =  parc.comboListPartenaire();
    
      ComboPartenaire.setItems(listCom);
         
     }
     public void showPromotion(){
       promotionCRUD parc = new promotionCRUD();
            //parc.promotionList();
        ObservableList<Promotion> list =  parc.PromotionList();
   
  listViewProm.setItems(list);
    listViewProm.setCellFactory((ListView<Promotion> ListView) -> new ListCellPromController());
     
    }
    
    

 
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
        
        
        if (tcodepro.getText().isEmpty() | treduction.getText().isEmpty() | dateDp.getEditor().getText().isEmpty() | dateFp.getEditor().getText().isEmpty() )
            
        {
          Alert alert = new Alert (AlertType.WARNING);
          alert.setTitle("alert code promo vide");
          alert.setHeaderText(null);
          alert.setContentText("Veuillez remplir tous les champs ! ");
          alert.showAndWait();
          return false;
        }
        
        
        
        
        
        
        return true;
        
        
        
        
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

         int id_p=ComboPartenaire.getValue();
           
          
           Promotion pro = new Promotion(22,rdateD,rdateF,rCodepro,rReduction,id_p,"haha");
           //int id_prom, String dateD, String dateF, String code_p, int reduction, String nom_p
           promotionCRUD proc = new promotionCRUD();
            proc.ajouterPromotion(pro);
            URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
showPromotion();
                 }
  
    }

    @FXML
    private void btnModifierProm(ActionEvent event) {
         int  mIdpro= Integer.parseInt(tidpro.getText()) ;
             String mCodepro = tcodepro.getText();
            int mReduction= Integer.parseInt(treduction.getText()) ;
               int valuePart=ComboPartenaire.getValue();
               //String mIdpart=comboPar.getEditor().getText();
                String mdateD=dateDp.getEditor().getText();
                 String mdateF = dateFp.getEditor().getText();
               
           //int rIdpart= Integer.parseInt(valuePart) ;
            
        Promotion pro = new Promotion(mIdpro,mdateD,mdateF,mCodepro,mReduction,valuePart,"");
       promotionCRUD proc = new promotionCRUD();
     proc.modifierPromotion(pro);
   URL url = null;
ResourceBundle rb = null;
                    initialize(url,rb);
                    showPromotion();
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
                    showPromotion();
    }
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
