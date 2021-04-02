/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.cours;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import Esprit.services.ServiceCours;
import Esprit.gui.FTPUploadFileDemo;
import Esprit.Connection.MyConnection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * FXML Controller class
 *
 * @author simop
 */
public class CoursController implements Initializable {
    @FXML
    private ImageView importeimage;
      String img="";
      String file="";
      String path="";
    List<String> type;
    List<String> typee;

    private cours cc=null;
    @FXML
    private AnchorPane ap;
    
    @FXML
    private Label erreurimg;
    @FXML
    private Label erreurtitre;
    @FXML
    private Button imagee;
    private TableView<cours> tvcours;
    private TableColumn<cours, String> colId;
    private TableColumn<cours, String > colNom;
    private TableColumn<cours, String> colNumero;
    private TableColumn<cours, String > colDescription;
    private TableColumn<cours, String> colDuree;
    @FXML
    private TextField nom;
    //private TextField numero;
    @FXML
    private TextField description;
    private TextField duree;
    private TextField idtheme;
    private TableColumn<cours, String> colimage;
    private TableColumn<cours, String> colIdth;
    @FXML
    private ListView<cours> lvcours;
    @FXML
    private ComboBox<String> comboCategorie;
    @FXML
    private Label erreurdesc;
    private Label erreurduree;
    @FXML
    private Label erreurdateajout;
    @FXML
    private Label erreurdatemodif;
    @FXML
    private Button fichier;
    private TextField pdf;
    @FXML
    private PieChart piechart;
    private Connection con;
    @FXML
    private Label caption;
     public CoursController() {
       con = MyConnection.getInstance().getConnection();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
          
        try {
           Statement stmt1 = con.createStatement();
             ObservableList<PieChart.Data>pieData = FXCollections.observableArrayList();
                              String SQL1 = "SELECT cours.nom_c, cours.nbparticipant FROM cours";
                               ResultSet rs1 = stmt1.executeQuery(SQL1);
                               while(rs1.next())
                                {
                                   pieData.add(new PieChart.Data("NOM cours : "+rs1.getString(1)+"\n"+"nombre de participation cours : "+rs1.getString(2),rs1.getDouble(2)));
                                           
                                }
                                  
       piechart.setData(pieData);
                        
       caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        

for (final PieChart.Data data : piechart.getData()) {
    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                int i = (int) data.getPieValue();
                caption.setText(String.valueOf("nb_participer : "+i));
             }
        });
}
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
        afficher();
        type =new ArrayList();
        type.add("*.jpg");
        type.add("*.png");
        typee=new ArrayList();
        typee.add("*.pdf");
        showCombo(); 
          lvcours.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               // String numero11 = String.valueOf(cc.getNumero());
                cc = (cours)lvcours.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                nom.setText(cc.getNom_c());
                //numero.setText(String.valueOf(cc.getNumero()));
                description.setText(cc.getDescription());
                duree.setText(String.valueOf(cc.getNbparticipant()));
                //idtheme.setText(String.valueOf(cc.getId_t()));
                importeimage.setImage(new Image("http://127.0.0.1/image/"+cc.getImage()));
                ServiceCours sc = new ServiceCours();
                String nomCategorie= sc.getName_cat(cc.getId_t());
                comboCategorie.setValue(nomCategorie);
                
            }
          });
             nom.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                      erreurtitre.setText("Il faut remplir le champ titre");
                   else if(newValue.length()>25)
                       erreurtitre.setText("Le titre ne doit pas passer 250 caractéres");
                   else
                erreurtitre.setText("");
                }       
             });
             nom.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(nom.getText().length()==0)
                     erreurtitre.setText("Il faut remplir le champ titre");    
            }
            });
         nom.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            nom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
        });
         
          description.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                      erreurdesc.setText("Il faut remplir le champ description");
                   else if(newValue.length()>25)
                       erreurdesc.setText("La description ne doit pas passer 25 caractéres");
                   else
                erreurdesc.setText("");
                }       
             });
             description.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(description.getText().length()==0)
                     erreurdesc.setText("Il faut remplir le champ description");    
            }
            });
         description.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            description.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
        });
          imagee.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       erreurimg.setText("Il faut remplir le champ image");
                   
                   else
                       erreurimg.setText("");
                }
                
                
            });
               
               imagee.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(imagee.getText().length()==0)
                     erreurimg.setText("Il faut remplir le champ image");    
                    
                }
                
            });
          
           
      
//                numero.textProperty().addListener(new ChangeListener<String>()
//            {
//                @Override
//                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                   if(newValue.isEmpty())
//                      erreurnumero.setText("Il faut remplir le champ numéro");
//                   else if(newValue.length()>2)
//                       erreurnumero.setText("Le champ numéro ne doit pas passer 3 caractéres");
//                   else
//                erreurnumero.setText("");
//                }       
//             });
//           
//           numero.textProperty().addListener((observable, oldValue, newValue) -> {
//        if (!newValue.matches("\\s1-9*")) {
//            numero.setText(newValue.replaceAll("[^\\s1-9]", ""));
//        }
//        });
//           
    }    
      public void showCombo()
     {
         ServiceCours parc = new ServiceCours();
         ObservableList<String> listCom =parc.comboListCat() ;
         comboCategorie.setItems(listCom);
     }

    @FXML
    private void importimage(ActionEvent event) {
       
        FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc=f.showOpenDialog(null);
        
        if(fc != null)
        {   
            System.out.println(fc.getName());
            img=fc.getName();
           FileSystem fileSys = FileSystems.getDefault();
           Path srcPath= fc.toPath();
           Path destPath= fileSys.getPath("C:\\wamp64\\www\\image\\"+fc.getName());
            try {
                Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(srcPath.toString());
            Image i = new Image(fc.getAbsoluteFile().toURI().toString());
            importeimage.setImage(i);
           
        }
 }

    @FXML
    private void ajouter(ActionEvent event) {
                          System.out.println("aaaaaaaaaa");

        try {
              if(nom.getText().isEmpty() ||(img.isEmpty()&&cc.getImage().isEmpty())  || description.getText().isEmpty()  ||  comboCategorie.getValue().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");   
        }else{
                  
            String nom1 = nom.getText();
            String pdf1 = pdf.getText();
            String description1 = description.getText();
//            int duree1 = Integer.parseInt(duree.getText());
            String valuePart=comboCategorie.getValue().toString();
            ServiceCours sp = new ServiceCours();
            //SC.getName_cat(valuePart);
            //////////////////////
            
        System.out.println("dhdhdhdh");
        String server = "127.0.0.1";
        int port = 21;
        String user = "nermine";
        String pass = "0000";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File(path);
 
            String firstRemoteFile = file;
            InputStream inputStream = new FileInputStream(firstLocalFile);
 
            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            
            //////////////////////
            int idth1 = Integer.parseInt(sp.getName_cat(valuePart));
            cours c = new cours(nom1, file , description1, img, idth1);
            
            sp.ajouter(c);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            nom.clear();
           // numero.clear();
            description.clear();
           // duree.clear();
            importeimage.setImage(null);
            afficher();
              }
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @FXML
    private void modifier(ActionEvent event) {
     ServiceCours cs = new ServiceCours();
     System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir cours");
                   
        }else{
              
              try {
                 String nom1 = nom.getText();
                 String pdf1 = pdf.getText();
                 String description1 = description.getText();
              //   int duree1 = Integer.parseInt(duree.getText());
              //   int idth1 = Integer.parseInt(idtheme.getText());
                  String valuePart=comboCategorie.getValue().toString();
           
            
                  int idth1 = Integer.parseInt(cs.getName_cat(valuePart));
                  if(img.length()==0)
                      cs.update( new cours(nom1, pdf1, description1,  img, idth1),cc.getId_c());
                      //cs.update( new cours(nom1, pdf1, description1, duree1, img, idth1),cc.getId_c());

                  else
                      cs.update( new cours(nom1, pdf1, description1,  img, idth1),cc.getId_c());
                  
                  afficher();
                  JOptionPane.showMessageDialog(null, "cours modifié");
                nom.clear();
              //  numero.clear();
                description.clear();
                duree.clear();
                idtheme.clear();
                importeimage.setImage(null);
                  cc=null;
              } catch (SQLException ex) {
                  Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
         
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceCours cs = new ServiceCours();
         cours cc = (cours)lvcours.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "il faut choisir un cours à supprimer");
                   
        }else{
             try {
                 cs.delete(cc.getId_c());
                 afficher();
                 JOptionPane.showMessageDialog(null, "Cours supprimé");
                 nom.clear();
                //numero.clear();
                description.clear();
                //duree.clear();
                idtheme.clear();
                importeimage.setImage(null);
                cc=null;
                 
             } catch (SQLException ex) {
                 Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
           
    
         
    }
    
      private void afficher()
   {   
       ServiceCours sc = new ServiceCours();//       colId.setCellValueFactory(new PropertyValueFactory<>("id_c"));
//       colNom.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
//       colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
//       colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
//       colDuree.setCellValueFactory(new PropertyValueFactory<>("duree"));
//       colimage.setCellValueFactory(new PropertyValueFactory<>("photo"));
//       colIdth.setCellValueFactory(new PropertyValueFactory<>("id_t"));
        ObservableList<cours> et=sc.readAll();
        //ObservableList<String> et=FXCollections.observableArrayList(events);
        lvcours.setItems(et);
        lvcours.setCellFactory((ListView<cours> listView) -> new ListCellCoursController());
    
   }

//    private void retourner(ActionEvent event) throws IOException {
//           AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/main/Back.fxml"));
//        ap.getChildren().setAll(pane);
//    }

    @FXML
    private void importfile(ActionEvent event) {
        FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("pdf files", typee));
        File fc=f.showOpenDialog(null);
        
        if(fc != null)
        {   
            System.out.println(fc.getName());
            file=fc.getName();
           FileSystem fileSys = FileSystems.getDefault();
           Path srcPath= fc.toPath();
//         //  Path destPath= fileSys.getPath("C:\\wamp64\\www\\cours\\"+fc.getName());
//            try {
//                Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
//            } catch (IOException ex) {
//                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
//            }
            System.out.println(srcPath.toString());
          //  Image j = new Image(fc.getAbsoluteFile().toURI().toString());
          path = srcPath.toString();
          File file = new File(path);
           
            System.out.println("voir le path"+path);
           
           
        }
             
        
    }
    
    
   }

  
    

