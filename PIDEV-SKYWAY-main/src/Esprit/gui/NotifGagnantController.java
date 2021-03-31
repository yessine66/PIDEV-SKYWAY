/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
//import com.​google.​zxing.​client.​j2se.​MatrixToImageWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

 
//import com.google.zxing.client.j2se;
/**
 * FXML Controller class
 *
 * @author Kais
 */

public class NotifGagnantController implements Initializable {

  DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  String str = "data eli bech t5rajhom";
    @FXML
    private ImageView event_img;
    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label location;
    @FXML
    private Label username;
    @FXML
    private ImageView QR;
    @FXML
    private ImageView QR_code;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
           
             try {
                 String org = "";
                 qrrcode();
               
                  String str =  "bouuu";
                  String path = "C:\\Users\\Lenovo\\Downloads\\qrrrrrrr\\crashtest-ArtBox-main\\src\\ArtHub\\images\\QR code\\EventTicket"+str+".png";
                  System.out.println("1"+path);
                // Image img6 = new Image(new FileInputStream(pat));
                Image img = new Image(new FileInputStream(path));
                 //event_img.setImage(img);
                 //name.setText(E.getNom_event());
                 QR.setImage(img);
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
                 
                 } catch (FileNotFoundException ex) {
                 Logger.getLogger("qrrrrrrr");} catch (IOException ex) {
        Logger.getLogger(NotifGagnantController.class.getName()).log(Level.SEVERE, null, ex);
    }
            
   
    }    

    @FXML
    private void FindThem(MouseEvent event) {
    }
    
  
    
    
    public void qrrcode() throws IOException {

       System.out.println("TICKTICK  qrr into "); 
       String str =  "bouuu";
       String content = "Ticket code: " +"ggg"  + "\n" + "User Full Name: " + "ggg" + "\n" +"Event name: " +"gggg" + "\n" + "Event date: " +"gggg"  + "\n";
          
        
        try {
         String imageFormat = "png";
            System.out.println("TICKTICK  qrr into "); 
            String outputFileName = "C:\\Users\\Lenovo\\Downloads\\qrrrrrrr\\crashtest-ArtBox-main\\src\\ArtHub\\images\\QR code\\EventTicket"+str+"." + imageFormat;
            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
               System.out.println(outputFileName); 
            //MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get(outputFileName));
          //MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get(outputFileName));
            //MatrixToImageWriter.writeToPath
               //System.out.println("TICKTICK  qrr into "); 
       // MatrixToImageWriter.
        
           //  MatrixToImageWriter.writeToPath
        } catch (WriterException ex) {
            Logger.getLogger(NotifGagnantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}

    
    
}
