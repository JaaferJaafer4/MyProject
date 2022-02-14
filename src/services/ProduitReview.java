/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import utils.MyConnection;

/**
 *
 * @author SBS
 */
public class ProduitReview {
    
    
    public void like(String lib_prod){
             try {
            String request = "INSERT INTO produit_review (lib_prod,review) VALUES(?,?) ";
            PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().clientPrepareStatement(request);
            pst.setString(1, lib_prod);
            pst.setInt(2, 1);
            pst.executeUpdate();
            System.out.println("liked! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
    
    
}
