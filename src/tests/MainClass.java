/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import entities.Produit;
import java.util.ArrayList;
import java.util.List;
import services.ProduitCRUD;
import services.ProduitReview;
import utils.MyConnection;

/**
 *
 * @author SBS
 */
public class MainClass {


    public static void main(String[] args) {
       
       List<String> categories = new ArrayList();
       categories.add("plat");
       categories.add("other");
       categories.add("breakfast");
               
       ProduitCRUD rcd = new ProduitCRUD();
       Produit r = new Produit("gateau",8,categories.get(2)); 
    
     //rcd.addRepa(r);     
        rcd.updateRepa(r);
      // rcd.deleteRepa("crepe");
       for(Produit e : rcd.DisplayRepas()){
           System.out.println(e);
       }
       
       new ProduitReview().like("gateau");

    }
    
}
