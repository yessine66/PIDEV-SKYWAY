/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.entities;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

/**
 *
 * @author User-DELL
 */
public class test {
 private int  id_test;
 private int id;
 private String date_test;
 private int score;
 private String name_t;

    public test(int id_test, int id, String date_test, int score, String name_t) {
        this.id_test = id_test;
        this.id = id;
        this.date_test = date_test;
        this.score = score;
        this.name_t = name_t;
    }

    public test(String date_test, int score, String name_t) {
        this.date_test = date_test;
        this.score = score;
        this.name_t = name_t;
    }

    public test(int id, String date_test, int score, String name_t) {
        this.id = id;
        this.date_test = date_test;
        this.score = score;
        this.name_t = name_t;
    }

    public test(int id_test) {
        this.id_test = id_test;
    }

    public int getId_test() {
        return id_test;
    }

    public int getId() {
        return id;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_test(String date_test) {
        this.date_test = date_test;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName_t(String name_t) {
        this.name_t = name_t;
    }

    public String getDate_test() {
        return date_test;
    }

    public int getScore() {
        return score;
    }

    public String getName_t() {
        return name_t;
    }
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
}
