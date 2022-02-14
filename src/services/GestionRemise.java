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
    List<Produit> l2;

    public GestionRemise() {
        l = new ProduitCRUD().GetProd();
        l2 = new ArrayList();
        l2.addAll(l);

    }

    public void remiseOnProd(String lib_prod, double by) {

        if (by > 0 && by < 80) {

            for (Produit e : l2) {

                if (e.getLib_prod().matches(".*" + lib_prod + "*")) {
                    e.setPrix_prod(e.getPrix_prod() * (by * 0.01));
                    System.out.println("Remise effectué");
                }

            }
        }

    }

    public void taxPerProd(double tax) {

        if (tax > 0 && tax < 20) {

            for (Produit e : l2) {

                e.setPrix_prod(e.getPrix_prod() - (e.getPrix_prod() * (tax * 0.01)));

            }
            System.out.println("tax effectué");
        }

    }

    public void displayProd() {
        System.out.println("\nAvant le Remise");

        for (Produit e : l) {
            System.out.println(e);
        }

        System.out.println("\nAprés le Remise");
        for (Produit e : l2) {
            System.out.println(e);
        }
    }

}
