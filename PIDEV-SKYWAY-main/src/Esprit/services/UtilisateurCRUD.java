/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.entities.Utilisateur;
import Esprit.Connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mega-pc
 */
public class UtilisateurCRUD {
    
    private Connection cnx;
    private PreparedStatement ste;
    Statement st;
    ResultSet rs;
    
    public UtilisateurCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
     public void ajouterUtilisateur( Utilisateur u ){
        String req ="INSERT INTO utilisateur (nom,prenom,mail,age,tel,genre,date_naiss,username,password,role,cre_compte)"+"values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
   
            ste = cnx.prepareStatement(req);
            
            ste.setString(1, u.getNomUser());
            ste.setString(2, u.getPrenomUser());
            ste.setString(3, u.getMailUser());
            ste.setInt(4, u.getAgeUser());
            ste.setInt(5, u.getTelUser());
            ste.setString(6, u.getGenreUser());
            ste.setString(7, u.getDateDeNaissanceUser());
            ste.setString(8, u.getUsernameUser());
            ste.setString(9, u.getPasswordUser());
            ste.setString(10, u.getRoleUser());
            ste.setString(11, u.getDateDeCreationCompteUser());
            
            ste.executeUpdate();
            System.out.println("utilisateur ajoute");
            
        } catch (SQLException ex) {
            System.out.println("error sql ajout user");
          System.out.println(ex.getMessage());
            
        }
        
    }
     
     
       public void modifierUtilisateur(Utilisateur u ){
  
   String req = "UPDATE utilisateur SET nom=?,prenom=?,mail=?,age=?,tel=?,genre=?,date_naiss=?,username=?,password=?,role=?,cre_compte=? WHERE id=?";
        try {
          ste= cnx.prepareStatement(req);
        ste.setInt(12, u.getIdUser());
        ste.setString(1, u.getNomUser());
         ste.setString(2, u.getPrenomUser());
         ste.setString(3, u.getMailUser());
         ste.setInt(4, u.getAgeUser());
         ste.setInt(5, u.getTelUser());
         ste.setString(6, u.getGenreUser());
         ste.setString(7, u.getDateDeNaissanceUser());
         ste.setString(8, u.getUsernameUser());
         ste.setString(9, u.getPasswordUser());
         ste.setString(10, u.getRoleUser());
         ste.setString(11, u.getDateDeCreationCompteUser());
     
           ste.executeUpdate();
            System.out.println("Utilisateur modfie ");
        } catch(SQLException ex) {
            System.out.println("erreur modification utilisateur");
            System.err.println(ex.getMessage());
        }    
       
   
  }
       
       public int RecuperLastId() throws SQLException{
           String req;
           int result = 0;
        req = "SELECT * FROM `utilisateur` WHERE id = (SELECT MAX(id) FROM `utilisateur`);";
           try {
                                      st = cnx.createStatement();
           rs= st.executeQuery(req);
                   List<Utilisateur> listxi=new ArrayList<>();
                   listxi.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));

           result=listxi.get(0).getIdUser();
           System.out.println("\n////////////////\n");
           System.out.println("\n////////////////\n");
           System.out.println("\n////////////////\n");
           System.out.println("\n////////////////\n");
           System.out.println("\n//////////////// eli f west element loul mtaa list\n");
                      System.out.println(listxi.get(0).getIdUser());
                      System.out.println("\n////////////////\n");
                      System.out.println("\n////////////////\n");
                      System.out.println("\n////////////////\nvaleur li f west resultat bid ha \n");
                                 System.out.println(result);
           } catch (SQLException e) {
                           System.out.println("erreur recupareation id utilisateur");
            System.err.println(e.getMessage());
           }

           return result;
       }
       
       public int RecuperLastIdTest(){
           List<Utilisateur> listxi=new ArrayList<>();
           listxi=afficherUtilisateurs();
           
           int resultat;
           resultat=listxi.get(listxi.size()-1).getIdUser()+1;
           
           return resultat;
           
       }
     
     
            public void supprimerUtilisateur(Utilisateur u ){
  
   String req = "DELETE FROM utilisateur WHERE id=?";
        try {
          ste= cnx.prepareStatement(req);
            ste.setInt(1, u.getIdUser());
           ste.executeUpdate();
            System.out.println("utilisateur  supprime ");
        } catch(SQLException ex) {
            System.out.println("erreur supression utilisateur");
            System.err.println(ex.getMessage());
        }
  }
   
     
     
     
     
    public List<Utilisateur> afficherUtilisateurs() {
        String req = "select * from utilisateur";

        List<Utilisateur> list=new ArrayList<>();
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               list.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
           }
 
        } catch (SQLException ex) {
            System.out.println("erreur recuperation des donnee utilisateur");
            System.out.println(ex.getMessage());        }
        return list;
    }
    
       public Utilisateur Connexion(String mail,String pwd ) throws SQLException{
      String requete = "select * from utilisateur where mail = ? and password = ?"; 
         try{
        ste= cnx.prepareStatement(requete);
        Utilisateur us = new Utilisateur();
        ste.setString(1, mail);
        ste.setString(2, pwd);
        
        ResultSet rs = ste.executeQuery();
        
          if(!rs.next()){
              System.out.println("Login error");
              return null;
          }else{
              us.setMailUser(mail);
              us.setPasswordUser(pwd);
              us.setRoleUser(rs.getString("role"));
              us.setIdUser(rs.getInt("id"));
              us.setAgeUser(rs.getInt("age"));
              us.setGenreUser(rs.getString("genre"));
              us.setNomUser(rs.getString("nom"));
              us.setPrenomUser(rs.getString("prenom"));
              us.setTelUser(rs.getInt("tel"));
              us.setUsernameUser(rs.getString("username"));
              us.setDateDeCreationCompteUser("2010-11-11");
              us.setDateDeNaissanceUser("2010-11-11");
              
              System.out.println(" \n Login sucessfull" + rs.getString("role"));
             return us;
          }
         }catch(SQLException ex){
             System.out.println("\nerrooor loginn");
            System.out.println(ex.getMessage());
         }
         return null;
    }
       
       
           public String loadPasswordBase(String mailo) throws SQLException {
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT password FROM utilisateur WHERE mail =?");
            ps.setString(1, mailo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                return rs.getString("password");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("password non recuperer!");
        }
        return null;
    }
 
     
     
     
     
     
}


