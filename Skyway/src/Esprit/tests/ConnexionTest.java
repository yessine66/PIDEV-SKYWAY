package Esprit.tests;

import Esprit.entities.Questions;
import Esprit.services.QuestionsCRUD;
import Esprit.tools.MyConnection;

/**
 *
 * @author Fayechi
 */
public class ConnexionTest {

    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        QuestionsCRUD per = new  QuestionsCRUD();
         Questions p2 = new  Questions(8,"Foulen",2);
        per.ajouterQuestion(p2);
    }
    
}
