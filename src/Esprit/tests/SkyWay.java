/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.tests;

import Esprit.Connection.MyConnection;
import Esprit.Entities.Actualite;
import Esprit.Entities.Evenement;
import Esprit.Services.ActualiteService;
import Esprit.Services.EvenementService;
import java.sql.SQLException;

import java.util.Scanner;

/**
 *
 * @author khouja safa
 */
public class SkyWay{
    
       public static void main(String[] args) throws SQLException {
        MyConnection cnx= MyConnection.getInstance();
        ActualiteService ac = new ActualiteService();
        EvenementService ev = new EvenementService();
        
        Scanner sc = new Scanner(System.in);
        int choix=100;
        
        while(choix !=0)
        {
        System.out.println("*****************************");
        System.out.println("  pour l'actualite taper 1 :");
        System.out.println("  pour l'evenement taper 2 :");
        System.out.println("  pour quitter taper 0 :");
        
        choix = Integer.parseInt(sc.nextLine());
        System.out.println("*****************************");
        switch(choix){
            case 1:
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
            
            case 2:
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
        }
        }
    }
}
    
    