/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;


import com.itextpdf.text.DocumentException;
import Esprit.Connection.MyConnection;
import Esprit.entities.Participation;
import Esprit.entities.cours;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import Esprit.services.categorieSession;
import org.controlsfx.control.Notifications;
import Esprit.services.ServiceParticipation;
/**
 * FXML Controller class
 *
 * @author simop
 */
public class AfficherCoursController implements Initializable {

    private Connection con;
    @FXML
    private TextField search;
    @FXML
    private ScrollPane scroll;
    int n=1;
    int o=0;
    @FXML
    private Button ret;
    @FXML
    private AnchorPane pane;
    @FXML
    private VBox courscontainer;

    public AfficherCoursController() {
        con = MyConnection.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
    String s1 = "";
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            courscontainer.setSpacing(5);
            try {
                o=get();
                displayCours();
            } catch (SQLException ex) {
                Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public int get() throws SQLException
{
    int i2=0;
      categorieSession n = categorieSession.getInstance();
      System.out.println(n);
                               int s1 = n.getId_cat();
                               System.out.println("test test"+s1);
                               Statement stmt1 = con.createStatement();
                              String SQL1 = "SELECT * FROM categorie WHERE id_categorie ='" +s1+"'";
                               ResultSet rs1 = stmt1.executeQuery(SQL1);
                               while(rs1.next())
                                {
                                    i2=rs1.getInt(1);
                                           
                                }
                               System.out.println("test 2 "+i2);
        return i2;
                              
    
}

    private void displayCours() throws SQLException {
        int id_categorie =o;
         ServiceParticipation sp =new ServiceParticipation();
        System.out.println("===*******>"+id_categorie);
        
        String req = "select * from cours where id_t  =\'"+ id_categorie + "\' ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            

            cours a1 = new cours(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getInt(7));
            
            ImageView va = new ImageView(new Image("http://127.0.0.1/image/"+rs.getString(6)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre cours : " + a1.getNom_c());
            Label description = new Label("La description : " + a1.getDescription());
            Label duree = new Label("La durée : " + a1.getNbparticipant());
            

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(description);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(duree);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(duree);
            
            Button participer=new Button("participer" ) ;
              if (sp.chercher_ajout(new Participation(a1.getId_c(),2)))
                         {
                   participer.setDisable(true);
              }
                  participer.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                                    Notifications notificationBuilder=Notifications.create()
                                   .title("VOUS AVEZ PARTICIPER A CE COURS")
                                   .text("FELICITATION")
                                   .graphic(null)
                                   .hideAfter(Duration.seconds(5))
                                   .position(Pos.BOTTOM_CENTER)
                                   .onAction(new EventHandler<ActionEvent>(){
                                       @Override
                               public void handle(ActionEvent event) {
                                   System.out.println("Clicked on notif");
                               }
                                        });
                                    
                               notificationBuilder.showConfirm();
                        try {
            if (!sp.chercher_ajout(new Participation(a1.getId_c(),2))){
                
                try {
                    PDF pdf = new PDF();
                    try {
                        pdf.pdf(a1);
                    } catch (DocumentException ex) {
                        Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    sp.ajouter(new Participation(a1.getId_c(),2));
                     
                    String SQL1 = "UPDATE skyway.cours SET  nbparticipant=nbparticipant+1 WHERE id_c ='"+a1.getId_c()+"'";
                               int rs1 = ste.executeUpdate(SQL1);
                               
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
                }
                participer.setDisable(true);
            }else System.out.println("DEJA participer");
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
                      
                 }
             });

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,participer);

            VBox vv = new VBox();
            vv.setAlignment(Pos.CENTER);
            vv.setSpacing(10);
            vv.getChildren().addAll(va);
            HBox No = new HBox();
            No.setSpacing(10);
            No.setAlignment(Pos.CENTER);
            No.getChildren().addAll(vv, v);

            VBox v1 = new VBox();
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(10);
            v1.getChildren().addAll(No);
            list.add(v1);

        }
        courscontainer.getChildren().addAll(list);
    }
        private void displayCoursAvancee(String req) throws SQLException {
        int id_categorie =o;
         ServiceParticipation sp =new ServiceParticipation();
        System.out.println("===*******>"+id_categorie);
        
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            

            cours a1 = new cours(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getInt(7));
            
            ImageView va = new ImageView(new Image("http://127.0.0.1/image/"+rs.getString(6)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre cours : " + a1.getNom_c());
            Label description = new Label("La description : " + a1.getDescription());
            Label duree = new Label("La durée : " + a1.getNbparticipant());
            

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(description);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(duree);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(duree);
            
            Button participer=new Button("participer" ) ;
              if (sp.chercher_ajout(new Participation(a1.getId_c(),2)))
                         {
                   participer.setDisable(true);
              }
                  participer.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                                    Notifications notificationBuilder=Notifications.create()
                                   .title("VOUS AVEZ PARTICIPER A CE COURS")
                                   .text("FELICITATION")
                                   .graphic(null)
                                   .hideAfter(Duration.seconds(5))
                                   .position(Pos.BOTTOM_CENTER)
                                   .onAction(new EventHandler<ActionEvent>(){
                                       @Override
                               public void handle(ActionEvent event) {
                                   System.out.println("Clicked on notif");
                               }
                                        });
                                    
                               notificationBuilder.showConfirm();
                        try {
            if (!sp.chercher_ajout(new Participation(a1.getId_c(),2))){
                
                try {
                    sp.ajouter(new Participation(a1.getId_c(),2));
                     
                    String SQL1 = "UPDATE skyway.cours SET  nbparticipant=nbparticipant+1 WHERE id_c ='"+a1.getId_c()+"'";
                               int rs1 = ste.executeUpdate(SQL1);
                               
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
                }
                participer.setDisable(true);
            }else System.out.println("DEJA participer");
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
                      
                 }
             });

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,participer);

            VBox vv = new VBox();
            vv.setAlignment(Pos.CENTER);
            vv.setSpacing(10);
            vv.getChildren().addAll(va);
            HBox No = new HBox();
            No.setSpacing(10);
            No.setAlignment(Pos.CENTER);
            No.getChildren().addAll(vv, v);

            VBox v1 = new VBox();
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(10);
            v1.getChildren().addAll(No);
            list.add(v1);

        }
        courscontainer.getChildren().addAll(list);
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void search(ActionEvent event) throws SQLException {
        int id_categorie =o;
         courscontainer.getChildren().removeAll(courscontainer.getChildren());
      String search11 = search.getText();
      String req ="select * from cours where nom_c = '"+search11+"' and id_t  =\'"+ id_categorie + "\'";
        displayCoursAvancee(req);
        if(search11.equals("")){
             req ="select * from cours where id_t  =\'"+ id_categorie + "\'";
        displayCoursAvancee(req);
            
        }
    }
    
      

  

   
        
       

}
