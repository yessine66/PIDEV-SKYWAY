/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Utilisateur;
import Esprit.entities.test;
import Esprit.services.QuestionsCRUD;
import Esprit.services.ReponsesCRUD;
import Esprit.services.testCRUD;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.O;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javax.sound.midi.ShortMessage.START;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author User-DELL
 */
public class FrontQuestionController implements Initializable {
Stage stage;
    @FXML
    private TextField tiwtiw;
    @FXML
    private Button check;
     private ToggleGroup tgGroup;
    @FXML
    private RadioButton text_r2;
    @FXML
    private RadioButton text_r3;
    @FXML
    private RadioButton text_r4;
    @FXML
    private RadioButton text_r1;
    @FXML
    private TextField compteur;
    Rectangle unlocktop;
Rectangle unlockbottom;
        Timeline timeline = null;
private Node root;
 test t;
 Integer timesec = START;
 private int score=4;
int compteurr=1;
 LoginFXMLController mmmmmm = new LoginFXMLController();
            Utilisateur usermimi = LoginFXMLController.usertest;
     
QuestionsCRUD qc=  new QuestionsCRUD();
        ReponsesCRUD rc= new ReponsesCRUD();
        testCRUD tc= new testCRUD();
    @FXML
    private Button next;
    @FXML
    private AnchorPane finishx;
    @FXML
    private Label timex;
    @FXML
    private Label bcarock;
    @FXML
    private Button getcertif;
     public void btnHandler() {
        tgGroup = new ToggleGroup();
        this.text_r1.setToggleGroup(tgGroup);
        this.text_r2.setToggleGroup(tgGroup);
        this.text_r3.setToggleGroup(tgGroup);
        this.text_r4.setToggleGroup(tgGroup);
    }        
     private void testqa() throws SQLException{
compteur.setText(Integer.toString(compteurr));
btnHandler();
  if (compteurr<11)
     {  unlockPressed();
         compteur.setText(Integer.toString(compteurr));
            tiwtiw.setText(qc.randomList());
             String wawa= tiwtiw.getText();
            //System.out.println(qc.loadCodeBase(wawa));
       if ( (qc.loadCodeBase(wawa))==rc.returningid2((qc.loadCodeBase(wawa))) )
          {              //        System.out.println("hhhhhhhhhhhh");

              ArrayList arrayList = new ArrayList();
    arrayList.add(rc.justanswer1((qc.loadCodeBase(wawa))));
    arrayList.add(rc.justanswer2((qc.loadCodeBase(wawa))));
    arrayList.add(rc.justanswer3((qc.loadCodeBase(wawa)))); 
    arrayList.add(rc.justanswer4((qc.loadCodeBase(wawa)))); 
                 //   System.out.println("hhhhhhh");
       
  
    Collections.shuffle(arrayList);
            //      System.out.println("gggg");
   text_r1.setText((String) arrayList.get(0)); //tjini valeur null
        text_r2.setText((String) arrayList.get(1));
        text_r3.setText((String) arrayList.get(2));
         text_r4.setText((String) arrayList.get(3));
       

     
   btnHandler();
                setBtnFalse();
    
          }
     //   else text_r1.setText(rc.re);
      
 
     }
     }
        private void setBtnFalse() {
        text_r1.setSelected(false);
        text_r2.setSelected(false);
        text_r3.setSelected(false);
        text_r4.setSelected(false);
    }
           private void unlockPressed() {
        //Thanks to Oracle Tutorial for this animation;
        
      
        if(timeline != null)
        {
            timeline.stop();
        }
        timesec = START;
        timex.setText("Time Left: "+(timesec/3600)+":"+(timesec%3600));
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                new EventHandler()
                {
                    @Override
                    public void handle(Event t) 
                    {
                        timesec--;
                        timex.setText("Time Left: "+(timesec/60)+":"+(timesec%60));
                        if(timesec<=0)
                        {
                            timeline.stop();
                            tiwtiw.setText("Time Out!!!\nYour Score is "+score);
                            root.setDisable(true);
                            finishQ();
                        }
                    }                    
                }));
        timeline.playFromStart();                }
        

    @Override
      public void initialize(URL url, ResourceBundle rb) {
          
           LoginFXMLController mmmmmm = new LoginFXMLController();
            Utilisateur usermimi = LoginFXMLController.usertest;
     
        QuestionsCRUD qc=  new QuestionsCRUD();
        ReponsesCRUD rc= new ReponsesCRUD(); 
        testCRUD tc= new testCRUD();
finishx.setVisible(false);
getcertif.setVisible(false);
     
        
      
        try {
            testqa();
        } catch (SQLException ex) {
            Logger.getLogger(FrontQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
       tgGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
           @Override
           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle)
           {
               if(tgGroup.getSelectedToggle()!=null)
               {
                   String ans = ((RadioButton) new_toggle).getText();
               }
           }
        });
      

    }
    
    
  private void finishQ()
    {
        //Thanks to Oracle Tutorial for this animation;
        Text t = new Text("Your Score: "+score);
        t.setFont(Font.font("Algerian", 50));
        t.setFill(Color.YELLOWGREEN);
        t.setCache(true);
        t.setTranslateY(320);//296
        t.setTranslateX(210);//210
        finishx.setVisible(true);
        getcertif.setVisible(true);
        Group circ = new Group();
        
        for(int i=0;i<25;i++)
        {
            Circle c = new Circle(150, Color.web("white", 0.05));
            c.setStrokeType(StrokeType.OUTSIDE);
            c.setStroke(Color.web("white", 0.16));
            c.setStrokeWidth(4);
            c.setEffect(new BoxBlur(10,10,3));
            circ.getChildren().add(c);
        }
        
        Rectangle col = new Rectangle(finishx.getWidth(), finishx.getHeight(), new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
                                        new Stop(0,    Color.web("#f8bd55")),
                                        new Stop(0.14, Color.web("#c0fe56")),
                                        new Stop(0.28, Color.web("#5dfbc1")),
                                        new Stop(0.43, Color.web("#64c2f8")),
                                        new Stop(0.57, Color.web("#be4af7")),
                                        new Stop(0.71, Color.web("#ed5fc2")),
                                        new Stop(0.85, Color.web("#ef504c")),
                                        new Stop(1,    Color.web("#f2660f")),}));
        col.widthProperty().bind(finishx.widthProperty());
        col.heightProperty().bind(finishx.heightProperty());
        Group grp = new Group(new Group(new Rectangle(finishx.getWidth(), finishx.getHeight(), Color.BLACK), circ), col);
        col.setBlendMode(BlendMode.OVERLAY);
        finishx.getChildren().add(grp);
        Timeline tm = new Timeline();
        for(Node cir: circ.getChildren())
        {
            tm.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(cir.translateXProperty(), random()*800), new KeyValue(cir.translateYProperty(), random()*600)), new KeyFrame(new Duration(20000), new KeyValue(cir.translateXProperty(), random()*800), new KeyValue(cir.translateYProperty(), random()*600)));
        }
        tm.setCycleCount(Timeline.INDEFINITE);
        tm.setAutoReverse(true);
        tm.play();        
        finishx.getChildren().add(t);
    }

    @FXML
    private void checkbtn(ActionEvent event) throws SQLException {
 
   
       check.setOnAction(new EventHandler<ActionEvent>() {
    
           public void handle(ActionEvent e) {
            
               try {
                   if ((rc.rightanswer()).equals(compteur.getText())) {
                       if (text_r1.isSelected()) {
                           score += 2;
                           
                       } else {
                           score -= 1;
                       }
                       
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(FrontQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }
               
              
               try {
                   if ((rc.rightanswer()).equals(compteur.getText())) {
                       if (text_r2.isSelected()) {
                           score += 2;
                       } else {
                           score -= 1;
                       }}
               } catch (SQLException ex) {
                   Logger.getLogger(FrontQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }
            
     
               try {
                   if ((rc.rightanswer()).equals(compteur.getText())) {
                       if (text_r3.isSelected()) {
                           score += 2;
                       } else {
                           score -= 1;
                       }
                       
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(FrontQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }
             
              
               try {
                   if ((rc.rightanswer()).equals(compteur.getText())) {
                       if (text_r4.isSelected()) {
                           score += 2;
                       } else {
                           score -= 1;
                       }
                       
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(FrontQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }

           }}
       
               );}
    @FXML
               private void nextbtn(ActionEvent event) throws SQLException {
                  
       try
        {
            stage.close();
        }
        catch(Exception e)
        {} 
       compteurr++;
     
   
       testqa(); 
//       
     verif();
       
            
        
        
    }
               private void verif(){
               if (compteurr>10){finishQ(); 
              t = new test (usermimi.getIdUser(),"not defined yet",score,"svt");
       tc.ajouterTest(t); 
           System.out.println("daww");}
               }
} 









 
 