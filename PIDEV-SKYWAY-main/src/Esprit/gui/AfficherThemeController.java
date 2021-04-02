/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.Connection.MyConnection;
import Esprit.entities.Utilisateur;
import Esprit.entities.theme;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Esprit.services.themeSession;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author simop
 */
public class AfficherThemeController implements Initializable {
    
    private Utilisateur userlogin;

    private Connection con;
    @FXML
    private TextField search;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox themecontainer;

    int n = 1;
    @FXML
    private AnchorPane pane1;

    public AfficherThemeController() {
    con = MyConnection.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
    String s1 = "";

    /**
     * Initializes the controller class.
     */
    
            public void initData(Utilisateur usereo){
        userlogin = usereo;
        System.out.println(userlogin+ "\n rolte mte3ou "+ userlogin.getRoleUser() );
    } 
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        themecontainer.setSpacing(5);
        try {
            displayTheme();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherThemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    

    private void displayTheme() throws SQLException {

        String req = "select * from theme  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {

            theme t1 = new theme(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            
            ImageView va = new ImageView(new Image("http://127.0.0.1/image/" + rs.getString(3)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre théme : " + t1.getNom_t());
           // Label id = new Label("id de theme : "+ t1.getId_t());
            int id1 = t1.getId_t();
            System.out.println("---------->>>"+t1.getId_t());

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            
//            HBox h2 = new HBox();
//            h2.setSpacing(10);
//            h2.setAlignment(Pos.CENTER);
          //  h2.getChildren().addAll(id);
            
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
        Button bt2 = new Button("Voir les categories");
       

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
            
             bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                System.out.println("creation");
                    Object node = event.getSource();
                    int id1 = t1.getId_t();
                    System.out.println(t1.getId_t());
                    Button b =(Button)node;
                    System.out.println(b.getText());
                try {
                     themeSession.getInstace(id1);
                   /*  AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
                     pane1.getChildren().setAll(pane);*/
                    System.out.println("\n\n\n nzelt aala boutton voir les categorie : \n" + userlogin);
                   
                                                         FXMLLoader loader = new FXMLLoader();
                    loader.setLocation((getClass().getResource("AfficherCategorie.fxml")));
            
                                                    Parent menuBackParent = loader.load();
                                                    
                                        Scene scene_Menu_Back = new Scene(menuBackParent);
                                        
                                        AfficherCategorieController controller=loader.getController();
                                        controller.initData(userlogin);
                                        
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                        window.show();
                   
                } catch (IOException ex) {
                    Logger.getLogger(AfficherThemeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                bt2.setDisable(true);

                }
            });

        }
        themecontainer.getChildren().addAll(list);
    }

//    public int get_idTheme() throws SQLException {
//        String req = "select * from theme";
//        List<VBox> list = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery(req);
//        int id_Theme = 0;
//        while (rs.next()) {
//
//            theme t1 = new theme(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
//            ImageView va = new ImageView(new Image("http://127.0.0.1/image/" + rs.getString(3)));
//            va.setFitHeight(170);
//            va.setFitWidth(200);
//            Label nom = new Label("Titre théme : " + t1.getNom_t());
//            
//            id_Theme = t1.getId_t();
//            ArrayList<Integer> s = new ArrayList<>();
//          
//            s.add(id_Theme);
//            for(Integer id: s )
//                {
//                        System.out.println("RSLT1"+t1.getId_t());
//                        System.out.println("RSLT2"+id_Theme);
//                }
//            
//            
//            
//            HBox h1 = new HBox();
//            h1.setSpacing(10);
//            h1.setAlignment(Pos.CENTER);
//            h1.getChildren().addAll(nom);
//            Button bt2 = new Button("Voir les categories");
//            bt2.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    System.out.println("creation");
//                    
//                    try {
//                        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
//                        pane1.getChildren().setAll(pane);
//                    } catch (IOException ex) {
//                        Logger.getLogger(AfficherThemeController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    bt2.setDisable(true);
//
//                }
//            });
//
//            VBox v = new VBox();
//            v.setAlignment(Pos.CENTER);
//            v.setSpacing(10);
//            v.getChildren().addAll(h1, bt2);
//
//            VBox vv = new VBox();
//            vv.setAlignment(Pos.CENTER);
//            vv.setSpacing(10);
//            vv.getChildren().addAll(va);
//            HBox No = new HBox();
//            No.setSpacing(10);
//            No.setAlignment(Pos.CENTER);
//            No.getChildren().addAll(vv, v);
//
//            VBox v1 = new VBox();
//            v1.setAlignment(Pos.CENTER);
//            v1.setSpacing(10);
//            v1.getChildren().addAll(No);
//            list.add(v1);
//        }
//        return id_Theme;
//
//    }

}
