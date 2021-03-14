/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mega-pc
 */
public class FXMain extends Application {
 //   Stage window;
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       // window = primaryStage;
        
        Button btn = new Button();
        btn.setText("Se connecter ¯\\_(ツ)_/¯ ♥♥♥☺ ");
        btn.setOnAction((ActionEvent event) -> {
            try {
                System.out.println("Hello World!");
                Parent rootx = FXMLLoader.load(FXMain.this.getClass().getResource("LoginFXML.fxml"));
                Scene loginScene = new Scene(rootx);
                primaryStage.setScene(loginScene);
                primaryStage.show();
            }catch (IOException ex) {
                Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
    
        Scene scene = new Scene(root, 1133, 734 );
        
        primaryStage.setTitle("SKYWAY☺");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}