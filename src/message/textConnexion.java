/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import connexionBD.cnxBD;
import entite.Commentaire;
import entite.Reclamation;
import java.sql.SQLException;
import java.util.Scanner;
import service.CommentaireService;
import service.ReclamationService;

/**
 *
 * @author IBTIHEL
 */
public class textConnexion {
       public static void main(String[] args) throws SQLException {
        // TODO code application logic here
//        DataSource ds1 = DataSource.getInstance();
//        
//        DataSource ds2 = DataSource.getInstance();
//        DataSource ds3 = DataSource.getInstance();
        cnxBD cnx= cnxBD.getInstance();
        ReclamationService rc=new ReclamationService();
        CommentaireService cm=new CommentaireService();
        Scanner sc = new Scanner(System.in);
        int choix=100;
        
        while(choix !=0)
        {
        System.out.println("pour la reclamation taper 1 :");
        System.out.println("pour les commantaires taper 2 :");
        System.out.println("pour quitter taper 0 :");
        choix = Integer.parseInt(sc.nextLine());
        
        switch(choix){
            case 1:
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
            
            case 2:
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
        }
     }   
    }
    }

    
         
