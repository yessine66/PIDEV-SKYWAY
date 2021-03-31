/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EventTicketController implements Initializable {

    @FXML
    private ImageView event_img;
    @FXML
    private ImageView QR;
    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label location;
    @FXML
    private Label username;
    @FXML
    private ImageView QR_code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FindThem(MouseEvent event) {
    }
    
}
