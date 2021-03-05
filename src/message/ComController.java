/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import entite.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CommentaireService;

/**
 * FXML Controller class
 *
 * @author IBTIHEL
 */
public class ComController implements Initializable {

    @FXML
    private TextField tid;
    @FXML
    private TextField ttext;
    @FXML
    private TextField tdate;
    @FXML
    private TextField tdestinataire;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Commentaire, Integer> colIdcom;
    @FXML
    private TableColumn<Commentaire, String> coltext;
    @FXML
    private TableColumn<Commentaire, String> coldate;
    @FXML
    private TableColumn<Commentaire, String> coldestinataire;
    @FXML
    private TableColumn<Commentaire, Integer> coliduser;
    @FXML
    private TableView<Commentaire> tvCom;
    @FXML
    private TextField td_com;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void showBooks(){
      
        CommentaireService com= new CommentaireService();
            //parc.partenaireList();
        List<Commentaire> list =  com.listerCommentaire();
        
        colIdcom.setCellValueFactory(new PropertyValueFactory<Commentaire, Integer>("id_com"));
        coltext.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("text"));
        coldate.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("date_pub"));
   
        
        tvCom.setItems((ObservableList<Commentaire>) list);
    }

    @FXML
    private void btnCommentaireAction(ActionEvent event) throws SQLException {
           try {

             if(event.getSource() == ajouter)
             {
            String text = ttext.getText();
            String date = tdate.getText();
            String dest = tdestinataire.getText();
            
            Commentaire c = new Commentaire(text,date,dest);
            CommentaireService com = new CommentaireService();
            com.ajouterCommentaire(c);
        }
             
             else if (event.getSource() == modifier)
             
             
             {
                // int mIdp= tidp.getText();
           int  mIdp= Integer.parseInt(td_com.getText()) ;
                 String text = ttext.getText();
            String date = tdate.getText();
            String dest = tdestinataire.getText();
            String id = tid.getText();
           Commentaire c1 = new Commentaire(text,date,dest);
            CommentaireService com1 = new CommentaireService();
            com1.editer(c1);
                 
             }
             
             
             else if (event.getSource() == supprimer)
             {
                 
                 
            int  mIdp= Integer.parseInt(td_com.getText()) ;
            //String mNomp = tnomp.getText();
            //String mDomaine = tdomaine.getText();
            Commentaire c = new Commentaire(td_com);
            CommentaireService cc = new CommentaireService();
        cc.supprimerCommentaire(mIdp);
            
                 
             }
             
             
             
             
             
       FXMLLoader loader = new FXMLLoader(getClass().getResource("com.fxml"));
              showBooks();
        Parent root = loader.load();
  
            ttext.getScene().setRoot(root);
        }
           
           catch (IOException ex) {
            Logger.getLogger(ComController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
