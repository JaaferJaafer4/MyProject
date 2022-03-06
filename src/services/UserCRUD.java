/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Produit;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;


/**
 *
 * @author SBS
 */
public class UserCRUD {

    /*  public void addRepaST(){
        try {
            String request = "INSERT INTO repas (name,price) VALUES('soup ',15) ";
            Statement st = (Statement) MyConnection.getInstance().getCnx().createStatement() ;
            st.executeUpdate(request);
            System.out.println("repa ajouté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     */
 

   public List<User> GetProd() {
        List<User> myList = new ArrayList();
        try {

            String request = "SELECT * FROM users";

            Statement st = (Statement) MyConnection.getInstance().getCnx().createStatement();
            ResultSet res = st.executeQuery(request);

            while (res.next()) {
                User u = new User();

                u.setId(res.getInt(1));
                u.setEmail(res.getString(2));
                u.setNom(res.getString(3));
                u.setPassword(res.getString(4));
                u.setFollow(res.getInt(5));

                
                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    
}
