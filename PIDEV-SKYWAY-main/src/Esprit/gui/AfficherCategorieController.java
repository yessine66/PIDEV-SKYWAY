/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.Connection.MyConnection;
import Esprit.entities.categorie;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Esprit.gui.AfficherCategorieController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Esprit.services.categorieSession;
import Esprit.services.themeSession;

/**
 * FXML Controller class
 *
 * @author simop
 */
public class AfficherCategorieController implements Initializable {
    private Connection con;
    @FXML
    private TextField search;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox categoriecontainer;
    int n=1;
    @FXML
    private AnchorPane pane2;
    int o=0;
    @FXML
    private Button ret;
    
    
    public AfficherCategorieController() {
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
                   categoriecontainer.setSpacing(5);
            try {
                o=get();
                displayCategorie();
            } catch (SQLException ex) {
                Logger.getLogger(AfficherCategorieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        // TODO
    }    
public int get() throws SQLException
{
    int i2=0;
      themeSession n = themeSession.getInstance();
      System.out.println(n);
                               int s1 = n.getId_t();
                               System.out.println("test test"+s1);
                               Statement stmt1 = con.createStatement();
                              String SQL1 = "SELECT * FROM theme  WHERE id_t ='" +s1+"'";
                               ResultSet rs1 = stmt1.executeQuery(SQL1);
                               while(rs1.next())
                                {
                                    i2=rs1.getInt(1);
                                           
                                }
                               System.out.println("test 2 "+i2);
        return i2;
                              
    
}
    private void displayCategorie() throws SQLException {
       
        int id_theme =o;
        System.out.println("===*******>"+id_theme);
        
        
       // ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(5,11));
        
      //  String req = "select * from categorie where id_t  =\'"+ ar.get(1) + "\' ";
        String req = "select * from categorie where id_t  =\'"+ id_theme + "\' ";

        
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            

            categorie c1 = new categorie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4));
            
            ImageView va = new ImageView(new Image("http://127.0.0.1/image/"+rs.getString(3)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre catégorie : " + c1.getNom_categorie());
            
            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
//            HBox h2 = new HBox();
//            h2.setSpacing(10);
//            h2.setAlignment(Pos.CENTER);
//            h2.getChildren().addAll(description);
//            HBox h3 = new HBox();
//            h3.setSpacing(10);
//            h3.setAlignment(Pos.CENTER);
//            h3.getChildren().addAll(duree);
//            HBox h4 = new HBox();
//            h4.setSpacing(10);
//            h4.setAlignment(Pos.CENTER);
//            h4.getChildren().addAll(duree);
            Button bt2=new Button("Voir les cours" ) ;
            bt2.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                     System.out.println("creation");
                      Object node = event.getSource();
                    int id1 = c1.getId_categorie();
                    System.out.println(c1.getId_categorie());
                    Button b =(Button)node;
                    System.out.println(b.getText());
                try {
                         categorieSession.getInstace(id1);
                         AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherCours.fxml"));
                         pane2.getChildren().setAll(pane);
                     } catch (IOException ex) {
                         Logger.getLogger(AfficherCategorieController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  
                      bt2.setDisable(true); 
                      
                 }
             });

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1,bt2);

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
        categoriecontainer.getChildren().addAll(list);
    }    

    @FXML
    
    private void retourner(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("AfficherTheme.fxml"));
        pane2.getChildren().setAll(page);
    }
    }