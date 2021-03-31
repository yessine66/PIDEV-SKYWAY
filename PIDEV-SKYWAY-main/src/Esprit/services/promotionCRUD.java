/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.services;

import Esprit.entities.Promotion;
import Esprit.Connection.MyConnection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class promotionCRUD {

    private Connection cnx;
    private PreparedStatement ste;
    Statement st;
    ResultSet rs;

    public promotionCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }

    public void ajouterPromotion(Promotion pro) {
        String req = "INSERT INTO promotion (code_p,reduction,dateD,dateF,nom_p)" + "values (?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, pro.getCode_p());
            ste.setInt(2, pro.getReduction());
            ste.setString(3, pro.getDateD());
            ste.setString(4, pro.getDateF());
            //ste.setInt(5, pro.getId_p());
            ste.setString(5, pro.getNom_p());

            ste.executeUpdate();
            System.out.println("Promotion ajoutée");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }

    }

    public ObservableList<Promotion> PromotionList() {

        ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
        String query = "SELECT * FROM promotion";

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Promotion par;
            while (rs.next()) {
                //par = new Promotion(rs.getInt("id_prom"), rs.getString("code_p"), rs.getInt("reduction"),rs.getString("dateD") , rs.getString("dateF"),rs.getInt("id_p"));
                // par = new Promotion(rs.getInt("id_prom"), rs.getString("code_p"), rs.getInt("reduction"),rs.getString("dateD") , rs.getString("dateF"),rs.getInt("id_p"),rs.getString("nom_p"));
                par = new Promotion(rs.getInt("id_prom"), rs.getString("dateD"), rs.getString("dateF"), rs.getString("code_p"), rs.getInt("reduction"), rs.getString("nom_p"));
                PromotionList.add(par);   //int id_prom, String dateD, String dateF, String code_p, int reduction, String nom_p
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return PromotionList;

    }

    public void modifierPromotion(Promotion pro) {

        String requete = "UPDATE promotion SET code_p=?,reduction=?, dateD= ? ,dateF =?,nom_p = ? WHERE id_prom=?";
        try {
            ste = cnx.prepareStatement(requete);
            /*PreparedStatement pst = 
            new MyConnection().cn.prepareStatement(requete);*/
            ste.setInt(6, pro.getId_prom());
            ste.setString(1, pro.getCode_p());
            ste.setInt(2, pro.getReduction());
            ste.setString(3, pro.getDateD());
            ste.setString(4, pro.getDateF());
            ste.setString(5, pro.getNom_p());

            ste.executeUpdate();
            System.out.println("promotion Modfié !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("promotion non Modfié !");
        }

    }

    public void supprimerPromotion(Promotion pro) {

        String requete = "DELETE FROM promotion WHERE id_prom=?";
        try {
            ste = cnx.prepareStatement(requete);
            ste.setInt(1, pro.getId_prom());
            ste.executeUpdate();
            System.out.println("promotion Supprimé !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("promotion non supprimé !");
        }
    }

    public ObservableList<String> comboListPar() {
        //ComboBox IdPPartPicker;
        ObservableList<String> comboListPar = FXCollections.observableArrayList();
        // ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
        String query = "SELECT nom_p FROM partenaire";

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);

            //partenaire par;
            while (rs.next()) {

                comboListPar.add(rs.getString("nom_p"));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // IdPPartPicker.setItems( comboListPar);
        return comboListPar;

    }

    public ObservableList<Promotion> PromotionListClient() {

        ObservableList<Promotion> PromotionList = FXCollections.observableArrayList();
        String query = "SELECT * FROM promotion";

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            //Books books;
            Promotion par;
            while (rs.next()) {
                //par = new Promotion(rs.getString("code_p"), rs.getInt("reduction"),rs.getString("dateD") , rs.getString("dateF"),rs.getString("nom_p"));
                par = new Promotion(rs.getInt("id_prom"), rs.getString("dateD"), rs.getString("dateF"), rs.getString("code_p"), rs.getInt("reduction"), rs.getString("nom_p"));
                PromotionList.add(par);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return PromotionList;

    }

    public String writeFile() throws IOException {
        String file = null;
        String code1 = null;
        String code2 = null;
        String code3 = null;
        FileWriter fstream = new FileWriter("names.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        String query = "SELECT * FROM promotion";
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                code1 = rs.getString("nom_p");
                // code2=rs.getString("reduction");
                // code3=rs.getString("code_p");  
                //   code3=rs.getString("desc_p");     
                /*out.write(rs.getStr
                    /*out.write(rs.getString("nom_p") + ", ");
                        out.write(rs.getString("reduction")+"%" + ", ");
                       
                            out.newLine();
     code=rs.getString("code_p");*/
                out.write(code1);
                // out.write(code1+ ",");
                //   out.write(code2+ ",");
                //out.write(code3+ ",");
                //   System.out.println("1"+code3);
                out.newLine();
                //out.write(rs.getString("code_p"));

            }

            // code3=rs.getString("code_p");  
            /*out.write(System.getProperty("line.separator"));*/
        } catch (SQLException ex) {
            Logger.getLogger(promotionCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Completed writing into text file");

        out.close();
        System.out.println("\n  \n\n\nretouuuuuuuuuuuuuuuuuuur" + code3);
        return code3;

    }

    public String loadCodeBase(String nom) throws SQLException {
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT code_p FROM promotion WHERE nom_p =?");
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                return rs.getString("code_p");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("code non recuperer!");
        }
        return null;
    }
    
    
        public int loadCreducBase(String nom) throws SQLException {
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT reduction FROM promotion WHERE nom_p =?");
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

               // return rs.getString("code_p");
                return rs.getInt("reduction");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("reduction non recuperer!");
        }
        return 0;
    }

}
