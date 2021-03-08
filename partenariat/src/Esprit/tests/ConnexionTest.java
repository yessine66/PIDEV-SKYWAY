package Esprit.tests;


import Esprit.entities.Promotion;
import Esprit.entities.partenaire;

import Esprit.services.partenaireCRUD;
import Esprit.services.promotionCRUD;
import Esprit.tools.MyConnection;
import java.util.Scanner;

/**
 *
 * @author Fayechi
 */
public class ConnexionTest {

    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();

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
   
   
   
   
   
   
   
   partenaireCRUD part =new partenaireCRUD();
        Promotion prom=new Promotion();
        Scanner sc = new Scanner(System.in);
        int choix=100;
        
        while(choix !=0)
        {
        System.out.println("pour gerer les partenaires taper 1 :");
        System.out.println("pour gerer les promotion taper 2 :");
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
                        System.out.println("Veuillez saisir le nom du partenaire:");
                        String nomPart = sc.nextLine();
                        System.out.println("Veuillez saisir le domaine du partenaire :");
                        String domainePart = sc.nextLine();
                      
                        //int idu = Integer.parseInt(sc.nextLine());
                        partenaire par = new partenaire(2,nomPart,domainePart);
                        part.ajouterPartenaire(par);
                        break;
                    }
                    case 2:
                    {
                        
                        System.out.println("Veuillez saisir le nom de partenaire apres modification :");
                       String nomPart = sc.nextLine();
                        System.out.println("Veuillez saisir le domaine de partenaire apres modification:");
                         String domainePart = sc.nextLine();
                       partenaire par = new partenaire(2,nomPart,domainePart);
                        part.modifierPartenaire(par);
                        break;
                    }
		    case 3:
		    {
			System.out.println("Veuillez saisir l'id ppartenaire a supprimer :");
                        int str = Integer.parseInt(sc.nextLine());
                        part.supprimerParteanire(str);
                        break;
		    }
                     case 4:
		    {
                        rc.listerReclamations().forEach(e->System.out.println(e));
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
                        System.out.println("Veuillez saisir le text:");
                        String text = sc.nextLine();
                        System.out.println("Veuillez saisir le destinataire :");
                        String des = sc.nextLine();
                        System.out.println("Veuillez saisir date_pub :");
                        String dat= sc.nextLine();
                        System.out.println("Veuillez saisir l'url de l'image :");
                        String im= sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Commentaire com = new Commentaire(text,des,dat,im,idu);
                        cm.ajouterCommentaire(com);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Veuillez saisir l'id de la commentaire a modifier:");
                        int idc = Integer.parseInt(sc.nextLine());
                        System.out.println("Veuillez saisir le nouveau text :");
                        String text = sc.nextLine();
                        System.out.println("Veuillez saisir le destinataire");
                        String des = sc.nextLine();
                        System.out.println("Veuillez saisir la date publication :");
                        String date = sc.nextLine();
                        System.out.println("Veuillez saisir l'url de l'image :");
                        String im = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Commentaire c1 = new Commentaire(idc,text,des,date,im,idu);
                        cm.editer(c1);
                        break;
                    }
		    case 3:
		    {
			System.out.println("Veuillez saisir l'id de la commentaire :");
                        int str = Integer.parseInt(sc.nextLine());
                        cm.supprimerCommentaire(str);
                        break;
		    }
                    case 4:
		    {
			cm.listerCommentaire().forEach(e->System.out.println(e));
                        break;
		    }
                }
                break;
            }
        }
     }   
    }
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
    }
    

