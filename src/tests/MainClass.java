/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import entities.Produit;
import java.util.ArrayList;
import java.util.List;
import services.GestionRemise;
import services.ProduitCRUD;

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
       Produit r = new Produit("gateau",4,categories.get(0)); 
    
     // rcd.addProd(r);     
      //  rcd.updateProd(r);
      // rcd.deleteProd("kafteji");
 
      GestionRemise GR = new GestionRemise();
      GR.RemiseOnProd("kafteji", 40);
      GR.DisplayProd();
       
       

    }
    
}
