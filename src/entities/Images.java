/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.GestionRemise;

/**
 *
 * @author SBS
 */
public class Images {
    List<ImageView> prod_images = new ArrayList();
    
    
    GestionRemise gr = new GestionRemise();

    public Images() {
        for(Produit e : gr.getListB())
        {
            if(e.getPath() != null){
            ImageView imageView = new ImageView(e.getPath());
            imageView.setImage(new Image(e.getPath()));
            prod_images.add(imageView);}
        
        }
        
        
    }

    public List<ImageView> getProd_images() {
        return prod_images;
    }
    
    
}
