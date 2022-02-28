/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JOptionPane;
import services.ProduitCRUD;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class AddProdInterfaceController implements Initializable {

    @FXML
    private TextField lib_txt;
    @FXML
    private TextField price_txt;
    @FXML
    private TextField quantity_txt;
    @FXML
    private TextArea Desc_txt;
    @FXML
    private ComboBox<String> Cat_List;

    ProduitCRUD pcr = new ProduitCRUD();

    ObservableList<String> items = FXCollections.observableArrayList("Breakfast", "Plat", "Sandiwch", "Pizza", "Boisson", "Autre");
    ObservableList<String> prom = FXCollections.observableArrayList("0", "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%");
    @FXML
    private ComboBox<String> Remise_cb;
    @FXML
    private Button Image_btn;
    File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Cat_List.getItems().removeAll(Cat_List.getItems());
        Cat_List.setItems(items);
        Cat_List.getSelectionModel();

        Remise_cb.getItems().removeAll(Remise_cb.getItems());
        Remise_cb.setItems(prom);
        Remise_cb.getSelectionModel();

    }

    @FXML
    private void AddProduct(ActionEvent event) throws IOException {

        if (lib_txt.getText().equals("") || price_txt.getText().equals("") || quantity_txt.getText().equals("") || Desc_txt.getText().equals("") || Cat_List.getValue() == null) {

            JOptionPane.showMessageDialog(null, "Champ manquant!", "Input error ", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                if (selectedFile != null) {
                    int price = Integer.parseInt(price_txt.getText());
                    int quantity = Integer.parseInt(quantity_txt.getText());
                    String lib = lib_txt.getText();

                    String Description = Desc_txt.getText();
                    String categorie = Cat_List.getValue();

                    //inseretion dans la bd
                    Produit p = new Produit(lib, Description, price, quantity, categorie);

                    if (Remise_cb.getValue() != null) {
                        p.setRemise(Remise_cb.getValue());
                    }

                    Path from;
                    Path to;

                    Image_btn.setText(selectedFile.getName());
                    from = Paths.get(selectedFile.toURI());
                    to = Paths.get("C:\\Users\\SBS\\Documents\\NetBeansProjects\\MyProject\\src\\GUI\\Photos\\" + lib+".png");
                    Files.copy(from, to);
                    p.setPath(to.toString());

                    pcr.addProd(p);
                    quantity_txt.setText("");
                    price_txt.setText("");
                    lib_txt.setText("");
                    Desc_txt.setText("");
                    Cat_List.setValue(null);
                    Image_btn.setText("");
                    JOptionPane.showMessageDialog(null, "Repa ajouté", "Ajouté ", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Selectionner un image!", "Input error ", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                quantity_txt.setText("");
                price_txt.setText("");
            }

        }

    }

    @FXML
    private void ModifiyProduct(ActionEvent event
    ) {
        if (lib_txt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nom manquant!", "Input error ", JOptionPane.ERROR_MESSAGE);

        } else {
            try {

                String lib = lib_txt.getText();

                String Description = Desc_txt.getText();
                String categorie = Cat_List.getValue();
                Produit p = new Produit(lib, Description, categorie);

                if (!price_txt.getText().equals("") && !quantity_txt.getText().equals("")) {

                    p.setPrix_prod(Integer.parseInt(price_txt.getText()));
                    p.setQuaniteDispo(Integer.parseInt(quantity_txt.getText()));
                }

                if (price_txt.getText().equals("") && !quantity_txt.getText().equals("")) {
                    p.setQuaniteDispo(Integer.parseInt(quantity_txt.getText()));
                }

                if (quantity_txt.getText().equals("") && !price_txt.getText().equals("")) {
                    p.setPrix_prod(Integer.parseInt(price_txt.getText()));
                }

                pcr.updateProd(p);

                if (Cat_List.getValue() != null) {
                    p.setCategorie(Cat_List.getValue());
                    pcr.updatecategorie(p);
                }

                if (Remise_cb.getValue() != null) {
                    p.setRemise(Remise_cb.getValue());
                    pcr.updateremise(p);
                }

                quantity_txt.setText("");
                price_txt.setText("");
                lib_txt.setText("");
                Desc_txt.setText("");
                Cat_List.setValue(null);
                JOptionPane.showMessageDialog(null, "Repa modifié", "Modifié ", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error!", "error ", JOptionPane.ERROR_MESSAGE);
                quantity_txt.setText("");
                price_txt.setText("");
            }

        }
    }

    @FXML
    private void RemoveProduct(ActionEvent event
    ) {

        if (lib_txt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nom manquant!", "Input error ", JOptionPane.ERROR_MESSAGE);

        } else {
            try {

                pcr.deleteProd(lib_txt.getText());
                quantity_txt.setText("");
                price_txt.setText("");
                lib_txt.setText("");
                Desc_txt.setText("");
                Cat_List.setValue(null);
                JOptionPane.showMessageDialog(null, "Repa Supprimé", "Supprimé ", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error!", "error ", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    @FXML
    private void ImageManipulation() {
        Path from;
        Path to;

        FileChooser fc = new FileChooser();
         selectedFile = fc.showOpenDialog(null);
        /* fc.setInitialDirectory(new File("C:\\Users\\SBS\\Pictures"));
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fc.getExtensionFilters().add(extFilter);
        
        if (selectedFile != null) {
            Image_btn.setText(selectedFile.getName());
           from = Paths.get(selectedFile.toURI());
           to = Paths.get("C:\\Users\\SBS\\Music\\" + selectedFile.getName());
           Files.copy(from, to);
            System.out.println(fc.getInitialDirectory());*/
        if (selectedFile != null) {
            Image_btn.setText(selectedFile.getName());
        }

    }

}
