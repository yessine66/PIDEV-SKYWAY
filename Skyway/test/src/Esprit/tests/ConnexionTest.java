package Esprit.tests;

import Esprit.entities.Questions;
import Esprit.services.QuestionsCRUD;
import Esprit.entities.Certificat;
import Esprit.entities.Reponses;
import Esprit.services.CertificatCRUD;
import Esprit.services.ReponsesCRUD;
import Esprit.tools.MyConnection;
import java.util.Scanner;

/**
 *
 * @author Fayechi
 */
public class ConnexionTest {

    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        QuestionsCRUD per = new  QuestionsCRUD();
        /* Questions p2 = new  Questions(8,"Foulen",2);
        per.ajouterQuestion(p2);*/
   /*   partenaireCRUD part = new partenaireCRUD();
     
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
          
          
   /*  promotionCRUD prom = new promotionCRUD();  
       Promotion pro1 = new  Promotion (8,"adidas",55);
          prom.ajouterPromotion(pro1);*/
   
   
        Questions q=new Questions();
        ReponsesCRUD r=new ReponsesCRUD();
        Scanner sc = new Scanner(System.in);
        int choix=100;
        
        while(choix !=0)
        {
        System.out.println("pour gerer les questions taper 1 :");
        System.out.println("pour gerer les reponses taper 2 :");
        System.out.println("pour gerer les certificats taper 3 :");
        System.out.println("pour quitter taper 0 :");
        choix = Integer.parseInt(sc.nextLine());
        
        switch(choix){
            case 1:
            {
                System.out.println("pour ajouter taper 1 :");
                System.out.println("pour modifier taper 2 :");
		System.out.println("pour supprimer taper 3 :");
                System.out.println("pour afficher taper 4 :");
                System.out.println("pour retourner taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
                switch(choix){
                    case 1:
                    {
                        System.out.println("Veuillez saisir la question:");
                        String text_q = sc.nextLine();
                        System.out.println("Veuillez saisir le nbre des points associées :");
                        String nbr  = sc.nextLine();
                        int nbr_point = Integer.parseInt(nbr);
                      
                        Questions quest = new Questions(2,text_q,nbr_point);
                        q.ajouterQuestion(quest);
                        break;
                    }
                    case 2:
                    {
                        
                        System.out.println("Veuillez saisir la questions apres modification :");
                       String text_q = sc.nextLine();
                        System.out.println("Veuillez saisir le nbre des points apres modification:");
                         String domainePart = sc.nextLine();
                     String nbr  = sc.nextLine();
                        int nbr_point = Integer.parseInt(nbr);
                        break;
                    }
		    case 3:
		    {
			System.out.println("Veuillez saisir l'id ppartenaire a supprimer :");
                        int str = Integer.parseInt(sc.nextLine());
                       // q.supprimerQuestion();
                        break;
		    }
                     case 4:
		    {
                    //    q.QuestionsList().forEach(e->System.out.println(e));
                        break;
		    }
                }
                break;
            }
            
            case 2:
            {
                System.out.println("pour ajouter taper 1 :");
                System.out.println("pour modifier taper 2 :");
		System.out.println("pour supprimer taper 3 :");
                System.out.println("pour affcher taper 4 :");
                System.out.println("pour retourner taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
                switch(choix){
                    case 1:
                    {
                        System.out.println("Veuillez saisir la réponse:");
                        String text_r = sc.nextLine();
                        System.out.println("Veuillez saisir l'id question associée :");
                        String id = sc.nextLine();
                        int id_q= Integer.parseInt(id);
                        Reponses com = new Reponses(2,text_r,id_q);
                       r.ajouterReponse(com);
                        break;
                    }
                    case 2:
                    { 
                        System.out.println("Veuillez saisir la nouvelle reponse a modifier:");
                        String text_r = sc.nextLine();
                        System.out.println("Veuillez saisir le nv id de la question associée :");
                       int id_q = Integer.parseInt(sc.nextLine());
                     
                        Reponses rep = new Reponses(2,text_r,id_q);
                        r.modifierReponse(2, text_r, id_q);
                        break;
                    }
		    case 3:
		    {
			System.out.println("Veuillez saisir l'id de la commentaire :");
                        int str = Integer.parseInt(sc.nextLine());
                      //  cm.supprimerReponse(str);
                        break;
		    }
                    case 4:
		    {
			//cm.listerReponse().forEach(e->System.out.println(e));
                        break;
		    }
                }
                break;
            }
        }
        }}} 
    
