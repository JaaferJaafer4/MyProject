/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Nour
 */
public class User {
   private int id;
   private String email;
   private String nom;
    private String password;
    private int follow;

    public User() {
    }

    
    public User(int id, String email, String nom, String password, int follow) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.follow = follow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", nom=" + nom + ", password=" + password + ", follow=" + follow + '}';
    }
    
    
    
}
