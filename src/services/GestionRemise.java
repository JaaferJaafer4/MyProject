/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Produit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SBS
 */
public class GestionRemise {

    List<Produit> l;

    public GestionRemise() {
        l = new ProduitCRUD().GetProd();
    }

    public void RemiseOnProd(String lib_prod, double by) {

        if (by > 0 && by < 80) {
            
            for (Produit e : l) {

                if (e.getLib_prod().matches(".*"+lib_prod+"*")) {
                    
                    l.stream().filter(n -> n.getLib_prod().matches(".*"+lib_prod+"*")).forEach(p -> p.setPrix_prod(p.getPrix_prod() * (by * 0.01)));
                    System.out.println("Remise effectué");
                }

            }
        }

    }

    public void DisplayProd() {
        for (Produit e : l) {
            System.out.println(e);
        }
    }

}
