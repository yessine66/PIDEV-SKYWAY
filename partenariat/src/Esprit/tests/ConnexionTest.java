package Esprit.tests;


import Esprit.entities.Promotion;
import Esprit.entities.partenaire;

import Esprit.services.partenaireCRUD;
import Esprit.services.promotionCRUD;
import Esprit.tools.MyConnection;

/**
 *
 * @author Fayechi
 */
public class ConnexionTest {

    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();

        partenaireCRUD part = new partenaireCRUD();
     
        partenaire p1= new partenaire (8,"adidas","nike");
      partenaire p2= new partenaire (2,"zara","zara");
            partenaire p3= new partenaire (26);
        part.ajouterPartenaire(p1);
          part.modifierPartenaire(p2);
          System.out.println(p2);
          //part.ajouterPartenaire(p3);
                    System.out.println(p3);
          part.supprimerPartenaire(p3);
          
          /******************************************************/
          
          
     promotionCRUD prom = new promotionCRUD();  
       Promotion pro1 = new  Promotion (8,"adidas",55);
          prom.ajouterPromotion(pro1);
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
    }
    
}
