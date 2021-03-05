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
 * @author DELL-user
 */
public class ConnexionTest {

    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
  Scanner sc = new Scanner(System.in);
        QuestionsCRUD question = new QuestionsCRUD();
        ReponsesCRUD reponse=new ReponsesCRUD();
     
        //Questions p1= new Questions (8,"pourquoi le ciel est bleu?","4");
        //ajouter part
   /*     System.out.println("Veuillez saisir le nom du Questions:");
       String nomParta = sc.nextLine();
        System.out.println("Veuillez saisir le domaine du Questions :");
        String domaineParta = sc.nextLine();
         Questions par = new Questions(2,nomParta,domaineParta);
        part.ajouterPartenaire(par);
          System.out.println(par);*/
        
        //modif part 
  /*     System.out.println("aaaaaaaa Veuillez saisir l'id Questions a modifier :");
        int idPartm = Integer.parseInt(sc.nextLine());
        System.out.println("Veuillez saisir le nom de Questions apres modification :");
         String nomPartm = sc.nextLine();
         System.out.println("Veuillez saisir le domaine de Questions apres modification:");
         String domainePartm = sc.nextLine();               
         Questions p2= new Questions ( idPartm,nomPartm,domainePartm);
           part.modifierPartenaire(p2);
          System.out.println(p2);*/
          
        //supprimer part 
         /*System.out.println("Veuillez saisir l'id Questions a supprimer :");
        int idParts = Integer.parseInt(sc.nextLine());
        Questions pars = new Questions(idParts);
        part.supprimerPartenaire(pars);*/
         
        //ajouter Reponses 
         
         /* System.out.println("Veuillez saisir le code de Reponses:");
          String codePro = sc.nextLine();
          System.out.println("Veuillez saisir la reduction :");
          int reduction = Integer.parseInt(sc.nextLine());
           Reponses pro = new Reponses(2,codePro,reduction);
            prom.ajouterReponses(pro);*/
            
       //modifier Reponses 
      /* System.out.println("Veuillez id Reponses a modifier  :");
       int idProm = Integer.parseInt(sc.nextLine());
       System.out.println("Veuillez saisir le code de Reponses apres modif :");
       String codeProm = sc.nextLine();
       System.out.println("Veuillez saisir la reduction apres modif:");
       int reductionm = Integer.parseInt(sc.nextLine());
        Reponses proo = new Reponses(idProm,codeProm,reductionm);
        prom.modifierReponses(proo);*/
      
      //supprimer Reponses 
     /* System.out.println("Veuillez id Reponses a supprimer :");
      int idProms = Integer.parseInt(sc.nextLine());
     Reponses pro = new Reponses(idProms);
      prom.supprimerReponses(pro);
                        */
     
          
          /******************************************************/
  
          
          
          
int choix = 100;
          while (choix !=0)
          {
          
            System.out.println("pour gerer les Questions taper 1 :");
        System.out.println("pour gerer les Reponses taper 2 :");
        System.out.println("pour quitter taper 0 :");
        choix = Integer.parseInt(sc.nextLine());
          
          
          switch (choix)
          {
          
          case 1:
          {
          System.out.println(" ***************** pour ajouter Questions taper 1 *****************:");
                System.out.println("***************** pour modifier Questions  taper 2 *****************:");
		System.out.println("***************** pour supprimer Questions  taper 3 ***************** :");
                System.out.println("***************** pour afficher Questions  taper 4 ***************** :");
                System.out.println(" ***************** pour retourner Questions  taper 0 *****************:");
                choix = Integer.parseInt(sc.nextLine());
          
        switch (choix) {
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
          
          
          
          case 2:
          {
          
          System.out.println("***************** pour ajouter Reponses taper 1 *****************:");
                System.out.println("***************** pour modifier Reponses taper 2 *****************:");
		System.out.println("***************** pour supprimer Reponses taper 3 *****************:");
                System.out.println("***************** pour affcher Reponses taper 4 *****************:");
                System.out.println("***************** pour retourner taper 0 ***************** :");
                choix = Integer.parseInt(sc.nextLine());
          
    switch (choix) {
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
          
    
          
          }//switch
          
 
          
          
          } //while
          
          
         
          
          
    }
    
}
