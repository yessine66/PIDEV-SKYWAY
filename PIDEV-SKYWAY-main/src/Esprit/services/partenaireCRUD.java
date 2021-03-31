/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;


import Esprit.entities.partenaire;
import Esprit.Connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class partenaireCRUD {
       private Connection cnx;
    private PreparedStatement ste;
       Statement st;
     ResultSet rs;
    public partenaireCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    
    
    
 public void ajouterPartenaire( partenaire par ){
        String req ="INSERT INTO partenaire (nom_p,domaine,date_p)"+"values (?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, par.getNom_p());
            ste.setString(2, par.getDomaine());
            ste.setString(3, par.getDate_p());
            ste.executeUpdate();
            System.out.println("partenaire ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
          System.out.println(ex.getMessage());
            
        }
        
    }
    
    
 public ObservableList<partenaire> partenaireList(){
     
     
           ObservableList<partenaire> partenaireList = FXCollections.observableArrayList();
          String query = "SELECT * FROM partenaire";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
            partenaire par;
            while(rs.next()){
               par = new partenaire(rs.getInt("id_p"), rs.getString("nom_p"), rs.getString("domaine"), rs.getString("date_p"));
               partenaireList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return partenaireList;
       
    }
 
 
  public void modifierPartenaire(partenaire par ){
  
   String requete = "UPDATE partenaire SET nom_p=?,domaine=? ,date_p=? WHERE id_p=?";
        try {
          ste= cnx.prepareStatement(requete);
            /*PreparedStatement pst = 
            new MyConnection().cn.prepareStatement(requete);*/
        ste.setInt(4, par.getId_p());
        ste.setString(1, par.getNom_p());
         ste.setString(2, par.getDomaine());
          ste.setString(3, par.getDate_p());
     
           ste.executeUpdate();
            System.out.println("partenaire Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
                   System.out.println("partenaire non Modfié !");
        }    
       
   
  }
       
       public void supprimerPartenaire(partenaire par ){
  
   String requete = "DELETE FROM partenaire WHERE id_p=?";
        try {
          ste= cnx.prepareStatement(requete);
            ste.setInt(1, par.getId_p());
           ste.executeUpdate();
            System.out.println("partenaire Supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
  }
   
       
       
       
       
       /********selection random********************/
       
       
       
       
       
       
       
       
       public ObservableList<String> randomList(){
     
     
           ObservableList<String> randomList = FXCollections.observableArrayList();
          String query = "SELECT mail FROM utilisateur where role='apprenant' ORDER BY rand() LIMIT 3";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
         String par;
            while(rs.next()){
               par = rs.getString("mail");
               randomList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return randomList;
       
    }
 
     public ObservableList<partenaire> partenaireListClient(){
     
     
           ObservableList<partenaire> partenaireList = FXCollections.observableArrayList();
          String query = "SELECT * FROM partenaire";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
            partenaire par;
            while(rs.next()){
               par = new partenaire( rs.getString("nom_p"), rs.getString("domaine"), rs.getString("date_p"));
               partenaireList.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return partenaireList;
       
    }  
       
      public ObservableList<partenaire> partenaireListFront(){
     
     
           ObservableList<partenaire> partenaireListFront = FXCollections.observableArrayList();
          String query = "SELECT * FROM partenaire";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
            partenaire par;
            while(rs.next()){
              //par = new partenaire(rs.getInt("id_p"), rs.getString("nom_p"), rs.getString("domaine"), rs.getString("date_p"));
                par = new partenaire(rs.getString("nom_p"), rs.getString("domaine"), rs.getString("date_p"));
               partenaireListFront.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return partenaireListFront;
       
    }
 
  
       public ObservableList<String> emails() {
        ObservableList<String> emails = FXCollections.observableArrayList();
		//emails.add("nourhelali799@gmail.com");
		//emails.add("smart.kindergarten0@gmail.com");
                  System.out.println("Liste avant le mélange : "+emails);
                 String query = "SELECT mail FROM utilisateur where role='apprenant' ORDER BY rand() LIMIT 3 ";

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
         String par;
            while(rs.next()){
               par = rs.getString("mail");
             emails.add(par);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
        //System.out.println("Liste avant le mélange : "+emails);
 
      // Random rand = new Random();
   

        //Collections.shuffle(emails);

  
        System.out.println("Liste des mails a envoyer dans le mail apres melange fonction 1 emails"+emails);
		
            //.collect(Collectors.toObservableList());	 
            return emails;	
    }
       
         public ObservableList<String> randomProm() {
            
            
     ObservableList<String> randomProm = FXCollections.observableArrayList();
                 //String query = "SELECT nom_p FROM promotion  ORDER BY rand() LIMIT 2 ";
                  String query = "SELECT * FROM promotion  ORDER BY rand() LIMIT 1 ";
                 

       try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
         
        // String par;
         String par1;
           String par2;
                String par3;
                 String par4;
         String yes;
              String yes1;
            while(rs.next()){
                par2 = rs.getString("reduction");
                                par3 = rs.getString("nom_p");
                                  par4 = rs.getString("dateF");
               //par = rs.getString("id_prom");
                par1 = rs.getString("code_p");
                yes="Une reduction de"+" "+par2+"%"+"chez notre partenaire"+" "+par3+"\n Depechez vous et profitez de ce cadeau avant le"+""+par4+"\n voila votre code promo"+""+par1+"\n\n\n";
                //yes1="Une reduction de"+"   "+par2+"%"+"chez notre partenaire"+"   "+par3+"  "+"valide jusqu'a"+"   "+par4+"\n votre code promo"+"   "+par1+"\n\n\n";
             randomProm.add(yes);
             
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
  
        System.out.println("Liste des promotions a envoyer dans le mail apres melange fonction 1 randomprom   : "+randomProm);
            return randomProm;	
    }
         
       
       
       
       /******************************************/
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }
    
    
    
    
    
    
    
    

