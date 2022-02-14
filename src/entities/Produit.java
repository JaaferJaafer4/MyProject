/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author SBS
 */
public class Produit {


    private String lib_prod; 
    private String description; 
    private int prix_prod;
    private int solde_prod;
    private int quaniteDispo;
    private String categorie;

    public Produit() {
    }

    
    public Produit(String lib_prod, String categorie) {
        this.lib_prod = lib_prod;
        this.categorie = categorie;
    }

    public Produit(String lib_prod, int prix_prod, String categorie) {
        this.lib_prod = lib_prod;
        this.prix_prod = prix_prod;
        this.categorie = categorie;
    }

    public Produit(String lib_prod, String description, String categorie) {
        this.lib_prod = lib_prod;
        this.description = description;
        this.categorie = categorie;
    }

    public Produit(String lib_prod, String description, int prix_prod, int solde_prod, int quaniteDispo, String categorie) {
        this.lib_prod = lib_prod;
        this.description = description;
        this.prix_prod = prix_prod;
        this.solde_prod = solde_prod;
        this.quaniteDispo = quaniteDispo;
        this.categorie = categorie;
    }



    public String getLib_prod() {
        return lib_prod;
    }

    public void setLib_prod(String lib_prod) {
        this.lib_prod = lib_prod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(int prix_prod) {
        this.prix_prod = prix_prod;
    }

    public int getSolde_prod() {
        return solde_prod;
    }

    public void setSolde_prod(int solde_prod) {
        this.solde_prod = solde_prod;
    }

    public int getQuaniteDispo() {
        return quaniteDispo;
    }

    public void setQuaniteDispo(int quaniteDispo) {
        this.quaniteDispo = quaniteDispo;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "lib_prod=" + lib_prod + ", description=" + description + ", prix_prod=" + prix_prod + ", solde_prod=" + solde_prod + ", quaniteDispo=" + quaniteDispo + ", categorie=" + categorie + '}';
    }


    


 
    
    
}
