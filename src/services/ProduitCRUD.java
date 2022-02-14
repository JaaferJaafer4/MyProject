/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import entities.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author SBS
 */
public class ProduitCRUD {

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
    public void addProd(Produit r) {
        try {
            String request = "INSERT INTO produit (lib_prod,description,prix_prod,solde_prod,quantiteDispo,categorie) VALUES(?,?,?,?,?,?) ";
            PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().clientPrepareStatement(request);

            pst.setString(1, r.getLib_prod());
            pst.setString(2, r.getDescription());
            pst.setInt(3, r.getPrix_prod());
            pst.setInt(4, r.getSolde_prod());
            pst.setInt(5, r.getQuaniteDispo());
            pst.setString(6, r.getCategorie());

            pst.executeUpdate();
            System.out.println("Repa ajouté! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void updateProd(Produit r) {
        try {
            String request = "UPDATE produit Set lib_prod = ?, description = ?, prix_prod = ?, solde_prod = ?, quantiteDispo = ?, categorie = ? where lib_prod = ?  ";
            PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().clientPrepareStatement(request);

            pst.setString(1, r.getLib_prod());
            pst.setString(2, r.getDescription());
            pst.setInt(3, r.getPrix_prod());
            pst.setInt(4, r.getSolde_prod());
            pst.setInt(5, r.getQuaniteDispo());
            pst.setString(6, r.getCategorie());
            pst.setString(7, r.getLib_prod());
            pst.executeUpdate();
            System.out.println("Repa modifié! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteProd(String name) {
        try {
            String request = "DELETE FROM produit WHERE lib_prod = ?  ";
            PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().clientPrepareStatement(request);

            pst.setString(1, name);
            pst.executeUpdate();
            System.out.println("Repa supprimé! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Produit> DisplayProd() {
        List<Produit> myList = new ArrayList();
        try {
            
                String request = "SELECT * FROM produit";

                Statement st = (Statement) MyConnection.getInstance().getCnx().createStatement();
                ResultSet res = st.executeQuery(request);

                while (res.next()) {
                    Produit r = new Produit();

                    r.setLib_prod(res.getString(1));
                    r.setDescription(res.getString(2));
                    r.setPrix_prod(res.getInt(3));
                    r.setSolde_prod(res.getInt(4));
                    r.setQuaniteDispo(res.getInt(5));
                    r.setCategorie(res.getString(6));
                    myList.add(r);
                }
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
