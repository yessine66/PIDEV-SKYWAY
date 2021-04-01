/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import Esprit.entities.Promotion;
import Esprit.services.promotionCRUD;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class namess {
    promotionCRUD parc = new promotionCRUD();
            //parc.partenaireList();
        ObservableList<Promotion> listPromClient =  parc.PromotionListClient();
}
