package Esprit.tests;


import Esprit.entities.Promotion;
import Esprit.entities.partenaire;
import Esprit.entities.Commentaire;
import Esprit.entities.Reclamation;
import Esprit.services.CommentaireService;
import Esprit.services.ReclamationService;
import Esprit.services.partenaireCRUD;
import Esprit.services.promotionCRUD;
import Esprit.Connection.MyConnection;
import Esprit.entities.Actualite;
import Esprit.entities.Evenement;
import Esprit.services.ActualiteService;
import Esprit.services.EvenementService;
import Esprit.entities.Questions;
import Esprit.services.QuestionsCRUD;
import Esprit.entities.Reponses;
import Esprit.services.ReponsesCRUD;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Fayechi
 */
public class ConnexionTest {

    public static void main(String[] args) throws SQLException {
        
        
        MyConnection mc= MyConnection.getInstance();
        Scanner sc = new Scanner(System.in);
        partenaireCRUD part = new partenaireCRUD();
        promotionCRUD prom=new promotionCRUD();
        ReclamationService rc=new ReclamationService();
        CommentaireService cm=new CommentaireService();
        ActualiteService ac = new ActualiteService();
        EvenementService ev = new EvenementService();
        QuestionsCRUD question = new QuestionsCRUD();
        ReponsesCRUD reponse=new ReponsesCRUD();
          
        int choix = 100;
          while (choix !=0)
          {
          
            System.out.println("pour gerer les partenaires taper 1 :");
            System.out.println("pour gerer les promotions taper 2 :");
            System.out.println("******************************************");
            System.out.println("pour gerer les reclamations taper 3 :");
            System.out.println("pour gerer les commentaires taper 4 :");
            System.out.println("******************************************");
            System.out.println("pour gerer les Actualites taper 5 :");
            System.out.println("pour gerer les Evenements taper 6 :");
            System.out.println("******************************************");
            System.out.println("pour gerer les questions taper 7 :");
            System.out.println("pour gerer les reponses taper 8 :");
            System.out.println("pour gerer les certificats taper 9 :");
            System.out.println("******************************************");
            System.out.println("pour quitter taper 0 :");
            System.out.println("******************************************");
            choix = Integer.parseInt(sc.nextLine());
          
          
            switch (choix)
            {
          
                case 1:
                {
                System.out.println("pour ajouter partenaire taper 1 :");
                System.out.println("pour modifier partenaire  taper 2 :");
		System.out.println("pour supprimer partenaire  taper 3 :");
                System.out.println("pour afficher partenaire  taper 4 :");
                System.out.println("pour retourner partenaire  taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
          
                switch (choix) 
                    {
                    case 1:
                    System.out.println("Veuillez saisir le nom du partenaire:");
                    String nomParta = sc.nextLine();
                    System.out.println("Veuillez saisir le domaine du partenaire :");
                    String domaineParta = sc.nextLine();
                    partenaire par = new partenaire(2,nomParta,domaineParta);
                    part.ajouterPartenaire(par);
                    System.out.println(par);
                    break;
                    
                    case 2:
                    System.out.println("aaaaaaaa Veuillez saisir l'id partenaire a modifier :");
                    int idPartm = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez saisir le nom de partenaire apres modification :");
                    String nomPartm = sc.nextLine();
                    System.out.println("Veuillez saisir le domaine de partenaire apres modification:");
                    String domainePartm = sc.nextLine();               
                    partenaire p2= new partenaire ( idPartm,nomPartm,domainePartm);
                    part.modifierPartenaire(p2);
                    System.out.println(p2);
                    break;
                    
                    case 3:
                    System.out.println("Veuillez saisir l'id partenaire a supprimer :");
                    int idParts = Integer.parseInt(sc.nextLine());
                    partenaire pars = new partenaire(idParts);
                    part.supprimerPartenaire(pars);
                    break;
                    case 4:
                    //pss.ajouterPersonne(p1);
                    part.partenaireList().forEach(e->System.out.println(e));
                    break;
                    }  
                break;  
                }
                case 2:
                {
                System.out.println("pour ajouter promotion taper 1 :");
                System.out.println("pour modifier promotion taper 2 :");
		System.out.println("pour supprimer promotion taper 3 :");
                System.out.println("pour affcher promotion taper 4 :");
                System.out.println("pour retourner taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
          
                    switch (choix) 
                    {
                    case 1:
                    System.out.println("Veuillez saisir le code de promotion:");
                    String codePro = sc.nextLine();
                    System.out.println("Veuillez saisir la reduction :");
                    int reduction = Integer.parseInt(sc.nextLine());
                    Promotion pros = new Promotion(2,codePro,reduction);
                    prom.ajouterPromotion(pros);
                    break;
                    case 2:
                    System.out.println("Veuillez id promotion a modifier  :");
                    int idProm = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez saisir le code de promotion apres modif :");
                    String codeProm = sc.nextLine();
                    System.out.println("Veuillez saisir la reduction apres modif:");
                    int reductionm = Integer.parseInt(sc.nextLine());
                    Promotion proo = new Promotion(idProm,codeProm,reductionm);
                    prom.modifierPromotion(proo);
                    break;
                    case 3:
                    System.out.println("Veuillez id promotion a supprimer :");
                    int idProms = Integer.parseInt(sc.nextLine());
                    Promotion pro = new Promotion(idProms);
                    prom.supprimerPromotion(pro);   
                    break;
                    case 4:
                    prom.PromotionList().forEach(e->System.out.println(e));
                    break;
                    }        
                    break;
                }
                
                
            case 3:
            {
                System.out.println("pour ajouter une reclamation taper 1 :");
                System.out.println("pour modifier une reclamation taper 2 :");
		System.out.println("pour supprimer une reclamation taper 3 :");
                System.out.println("pour afficher une reclamation taper 4 :");
                System.out.println("pour retourner  taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
                switch(choix){
                    case 1:
                    {
                        System.out.println("Veuillez saisir le text:");
                        String text = sc.nextLine();
                        System.out.println("Veuillez saisir l'objet :");
                        String obj = sc.nextLine();
                       // System.out.println("Veuillez saisir date_env :");
                        //String dat= sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Reclamation rec = new Reclamation(idu,text,obj);
                        rc.ajouterReclamation(rec);
                        break;
                    }
                    case 2:
                    {
                         System.out.println("Veuillez saisir l'id de la reclamation a modifier:");
                        int idr = Integer.parseInt(sc.nextLine());
                        System.out.println("Veuillez saisir le nouveau text :");
                        String text = sc.nextLine();
                        System.out.println("Veuillez saisir l'objet:");
                        String obj = sc.nextLine();
                        //System.out.println("Veuillez saisir la date d'envoi :");
                        //String date = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Reclamation rec1 = new Reclamation(idr,text,obj,idu);
                        rc.editer(rec1);
                        break;
                    }
		    case 3:
		    {
			System.out.println("Veuillez saisir l'id de la reclamation :");
                        int str = Integer.parseInt(sc.nextLine());
                        rc.supprimerReclamation(str);
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
            
            case 4:
            {
                System.out.println("pour ajouter un commentaire taper 1 :");
                System.out.println("pour modifier un commentaire taper 2 :");
		System.out.println("pour supprimer un commentaire taper 3 :");
                System.out.println("pour affcher un commentaire taper 4 :");
                System.out.println("pour retourner taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
                switch(choix){
                    case 1:
                    {
                        System.out.println("Veuillez saisir le text:");
                        String text = sc.nextLine();
                        System.out.println("Veuillez saisir le destinataire :");
                        String des = sc.nextLine();
                        //System.out.println("Veuillez saisir date_pub :");
                       // String dat= sc.nextLine();
                        System.out.println("Veuillez saisir l'url de l'image :");
                        String im= sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Commentaire com = new Commentaire(text,des);
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
                       // System.out.println("Veuillez saisir la date publication :");
                       // String date = sc.nextLine();
                        System.out.println("Veuillez saisir l'url de l'image :");
                        String im = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Commentaire c1 = new Commentaire(idc,text,des,im,idu);
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
            
            
            case 5:
            {
                System.out.println("*****************************");
                System.out.println("   pour ajouter taper 1 :");
                System.out.println("   pour supprimer taper 2 :");
                System.out.println("   pour modifier taper 3 :");
                System.out.println("   pour afficher taper 4:");
                System.out.println("   pour quitter taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
                System.out.println("*****************************");
                switch(choix){
                    case 1:
                    {
                        System.out.println("Veuillez saisir le titre de l'actualite :");
                        String act = sc.nextLine();
                        System.out.println("Veuillez saisir une description :");
                        String des = sc.nextLine();
                        System.out.println("Veuillez saisir l'url de l'image :");
                        String im = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Actualite p1 = new Actualite(act, des, im,idu);
                        ac.ajouterActualite(p1);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Veuillez saisir l'id de l'actualite :");
                        int str = Integer.parseInt(sc.nextLine());
                        ac.supprimer(str);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Veuillez saisir l'id de l'actualite a modifier:");
                        int ida = Integer.parseInt(sc.nextLine());
                        System.out.println("Veuillez saisir le nouveau titre de l'actualite :");
                        String act = sc.nextLine();
                        System.out.println("Veuillez saisir une description :");
                        String des = sc.nextLine();
                        System.out.println("Veuillez saisir l'url de l'image :");
                        String im = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'utilisateur:");
                        int idu = Integer.parseInt(sc.nextLine());
                        Actualite p2 = new Actualite(ida,act,des,im,idu);
                        ac.editer(p2);
                        break;
                    }
                    case 4:
                    {
                        ac.readAll().forEach(e->System.out.println(e));
                        break;
                    }
                }
                break;
            }
            
            case 6:
            {
                System.out.println("*****************************");
                System.out.println("   pour ajouter taper 1 :");
                System.out.println("   pour supprimer taper 2 :");
                System.out.println("   pour modifier taper 3 :");
                System.out.println("   pour afficher taper 4:");
                System.out.println("   pour quitter taper 0 :");
                choix = Integer.parseInt(sc.nextLine());
                System.out.println("*****************************");
                switch(choix){
                    case 1:
                    {
                        System.out.println("Veuillez saisir le nom de l'evenement :");
                        String eve = sc.nextLine();
                        System.out.println("Veuillez saisir la date  :");
                        String dat = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'actualité :");
                        int ida = Integer.parseInt(sc.nextLine());
                        
                        Evenement e1 = new Evenement(eve,dat,ida);
                        ev.ajouterEvenement(e1);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Veuillez saisir l'id de l'evenement :");
                        int str = Integer.parseInt(sc.nextLine());
                        ev.supprimer(str);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Veuillez saisir l'id de l'evenement a modifier:");
                        int ide = Integer.parseInt(sc.nextLine());
                        System.out.println("Veuillez saisir le nouveau nom de l'evenement :");
                        String eve = sc.nextLine();
                        System.out.println("Veuillez saisir une date :");
                        String dat = sc.nextLine();
                        System.out.println("Veuillez saisir l'id de l'acctualite qui correspond :");
                        int ida = Integer.parseInt(sc.nextLine());
                        Evenement e2 = new Evenement(ide,eve,dat,ida);
                        ev.editer(e2);
                        break;
                    }
                    case 4:
                    {
                        ev.readAll().forEach(e->System.out.println(e));
                        break;
                    }
                }
                break;
            }
            
            
            
            case 7:
            {
                System.out.println(" ***************** pour ajouter Questions taper 1 *****************:");
                System.out.println("***************** pour modifier Questions  taper 2 *****************:");
		System.out.println("***************** pour supprimer Questions  taper 3 ***************** :");
                System.out.println("***************** pour afficher Questions  taper 4 ***************** :");
                System.out.println(" ***************** pour retourner Questions  taper 0 *****************:");
                choix = Integer.parseInt(sc.nextLine());
          
                switch (choix) 
                {
                case 1:
                    System.out.println("***************** Veuillez saisir la Question *****************:");
                    String text_q = sc.nextLine();
                    System.out.println("Veuillez saisir le nbre des points de la Question :");
                    String point = sc.nextLine();
                    int nbr_point=Integer.parseInt(point);
                    Questions q = new Questions(2,text_q,nbr_point);
                    question.ajouterQuestion(q);
                    System.out.println(q);
                    break;
                    
                case 2:
                    System.out.println("***************** Veuillez saisir l'id Questions a modifier ***************** :");
                    int id_q = Integer.parseInt(sc.nextLine());
                    System.out.println("*****************Veuillez saisir la Questions apres modification***************** :");
                    String text = sc.nextLine();
                    System.out.println(" *****************Veuillez saisir le nbr de points de la Question apres modification: *****************");
                    String nbr_point1 = sc.nextLine();  
                    int nbr_point2=Integer.parseInt(nbr_point1);
                    Questions q1= new Questions ( id_q,text,nbr_point2);
                    question.modifierquest(q1);
                    System.out.println(q1);
                    break;
                    
                case 3:
                    System.out.println("***************** Veuillez saisir l'id Question a supprimer ***************** :");
                    int id_q1 = Integer.parseInt(sc.nextLine());
                    Questions quest = new Questions(id_q1);
                    question.supprimerQuestion(quest);
                    break;
                    
                case 4:
                    question.QuestionsList().forEach(e->System.out.println(e));
                    break;
                }  
                break;  
            }
            
            case 8:
            {
                System.out.println("***************** pour ajouter Reponses taper 1 *****************:");
                System.out.println("***************** pour modifier Reponses taper 2 *****************:");
		System.out.println("***************** pour supprimer Reponses taper 3 *****************:");
                System.out.println("***************** pour affcher Reponses taper 4 *****************:");
                System.out.println("***************** pour retourner taper 0 ***************** :");
                choix = Integer.parseInt(sc.nextLine());
          
                switch (choix) 
                {
                case 1:
                    System.out.println("*****************Veuillez saisir l'id de la question*****************:");
                    String idq=sc.nextLine();
                    int id_q2=Integer.parseInt(idq);
                    System.out.println("*****************Veuillez saisir la réponse*****************:");
                    String text_r = sc.nextLine();
                    Reponses rep = new Reponses(2,text_r,id_q2);
                    reponse.ajouterReponse(rep);
                    break;
  
                case 2:
                    System.out.println("Veuillez id question que vous voulez modifier  :");
                    int idq3 = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez id Reponse a modifier  :");
                    int id_r = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez saisir la Reponse apres modif :");
                    String reponsetext = sc.nextLine();
                    Reponses repp = new Reponses(id_r,reponsetext,idq3);            
                    reponse.modifierrep(repp);
                    break;
  
                case 3:
                    System.out.println("Veuillez id Reponse a supprimer :");
                    int  id_r2 = Integer.parseInt(sc.nextLine());
                    Reponses repo = new Reponses(id_r2);
                    reponse.supprimerReponse(repo);
                    break;
  
                case 4:
                    reponse.ReponsesList().forEach(e->System.out.println(e));
                    break;

                }        
           break;
            }
          
            }//taskiret switch prom wala part
          } //taskiret while    
    }
}
