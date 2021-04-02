/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.partenaire;
import Esprit.services.partenaireCRUD;
import Esprit.services.promotionCRUD;
//import Esprit.tests.MailSend;
//import Esprit.tests.ReceiveEmail;
import static Esprit.tests.mail2.sendBulkEmail;
import static Esprit.tests.mail2.sendBulkEmail2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.net.URL;
import javax.mail.Session;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import java.lang.String;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class GagnerPromotionController implements Initializable {

  private  String linkAttachtest;
    
    
    @FXML
    private ListView<String> tvwinner;
    @FXML
    private Button btnwinner;
    @FXML
    private Button retun;
    @FXML
    private Button send_btn;
    @FXML
    private Button btnwinnerprom;
    @FXML
    private ListView<String> tvwinnerprom;
    @FXML
    private Button attachMailbtn;
 List<String> type;
 String img="";
  String x="";
    @FXML
    private ImageView importeimage;
    @FXML
    private ImageView j;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("********************************************");
System.out.println(emailget);
System.out.println(randpromget);
  System.out.println("********************************************");
  
linkAttachtest="";
    }

    
    

    
    NotifGagnantController notif = new  NotifGagnantController();
    
    
partenaireCRUD win = new partenaireCRUD();

private  ObservableList<String> emailget=win.emails();
private  ObservableList<String> randpromget=win.randomProm();

 //ReceiveEmail r_email=new ReceiveEmail();


 public void showWinner(){
 
          tvwinner.setItems(emailget);
    }
 
 
 public void showWinnerProm(){
  
          tvwinnerprom.setItems(randpromget);
    }

    @FXML
    private void btnwwinner(ActionEvent event) {
       showWinner();
          
        }


    @FXML
    private void on_return_button(ActionEvent event) throws IOException {
        Parent menuFrontParent;
            menuFrontParent = FXMLLoader.load(getClass().getResource("gagnerPromotion.fxml"));
                                        Scene scene_Menu_Back = new Scene(menuFrontParent);
                                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        window.setScene(scene_Menu_Back);
                                  
                                        window.show();
                                        
                                        
                                        
        
    }

    @FXML
    private void on_send_button(ActionEvent event) {
        
    type =new ArrayList();
          type.add("*.jpg");
          type.add("*.png");
         try {
             
  
                partenaireCRUD win = new partenaireCRUD();


		String subject = "We have a surprise for you!";
		
		// message which is to be sent
		String message = "Vous avez gagnez "+randpromget;
                
                 if(linkAttachtest.isEmpty()){
                    System.out.println("\n\n\n sans attachement");
                 
                     sendBulkEmail2(subject,emailget, message); 
                    
                    
                }else{
                    
                    System.out.println("\n\navec attachement "+linkAttachtest);
                    sendBulkEmail(subject,emailget, message,linkAttachtest);
                   
                }

		//sendBulkEmail(subject,emailget, message,linkAttachtest);
     
        } catch (Exception ex) {
            Logger.getLogger(GagnantPromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnwinnerprom(ActionEvent event) {
         showWinnerProm();
    }

    /*private void jouezbtn(ActionEvent event) throws IOException {
 
      Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
      LotteryWheel wheel = new LotteryWheel();
      wheel.start(stage);
      
    
      /*Alert alert = new Alert (Alert.AlertType.WARNING);
          alert.setTitle("alert code promo vode");
          alert.setHeaderText(null);
          alert.setContentText("Veuillez remplir tous les champs ! ");
          alert.showAndWait();*/
       
        
        
  //  }*/
    public String attachMail2() {
           //type.clear();
          type =new ArrayList();
          type.add("*.jpg");
          type.add("*.png");
          type.add("*.*");
        
        FileChooser f=new FileChooser();
 
           f.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)|*.*",type));
        
        File fc=f.showOpenDialog(null);
        
      //  if(fc != null)
       // {
     
            System.out.println(fc.getName());
            img=fc.getName();
           FileSystem fileSys = FileSystems.getDefault();
           Path srcPath= fc.toPath();
     
           Path destPath= fileSys.getPath(fc.getName());
            try {
                Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {

            }
       
            System.out.println(srcPath.toString());
     //   Image i = new Image(fc.getAbsoluteFile().toURI().toString());
    //  importeimage.setImage(i);
            String x=srcPath.toString();
         
           System.out.println(x);
       // }
         
    linkAttachtest=x;
 
        System.out.println(linkAttachtest);
        return x;
        
    }

    
    
    


    @FXML
    public String attachMail(ActionEvent event) {
 
         String x=attachMail2();
         return x;

    }

    @FXML
    private void showQR(ActionEvent event) throws FileNotFoundException, IOException{
        
        
                 String org = "";
             notif.qrrcode(randpromget);
               
                  String str =  "a";
              String path = "C:\\Users\\Lenovo\\Desktop\\backupnotifouta\\PIDEV-SKYWAY\\PIDEV-SKYWAY-main\\src\\Esprit\\img\\EventTicket\\g"+str+".png";
                 //C:\\Users\\Lenovo\\Desktop\\backupnotifouta\\PIDEV-SKYWAY\\PIDEV-SKYWAY-main\\src\\Esprit\\img\\EventTicket
                  System.out.println("1"+path);
                // Image img6 = new Image(new FileInputStream(pat));
                Image img = new Image(new FileInputStream(path));
                  System.out.println("2"+path);
                 //event_img.setImage(img);
                 //name.setText(E.getNom_event());
                 j.setImage(img);
                     System.out.println("2"+path);
                // username.setText("Organized by: " + org); 
                 
                // date.setText(" " + E.getDate_event().format(formatters));
                // location.setText(" " + E.getLocation_event());
   //String pathh =    "file:///C:\\Users\\Lenovo\\Downloads\\qrrrrrrr\\crashtest-ArtBox-main\\src\\ArtHub\\images\\QR code\\dow"+str+".png ";   
          /*URL u= new URL( "file:///C:\\Users\\Lenovo\\Downloads\\qrrrrrrr\\crashtest-ArtBox-main\\src\\ArtHub\\images\\QR code\\dow"+str+".png ");
          System.out.println("3"+u);
        BufferedImage imsg = ImageIO.read(u);
        File file = new File(path);
        ImageIO.write(imsg, "png", file); */  
                 
             
        
    }
}
    
    
    
    













