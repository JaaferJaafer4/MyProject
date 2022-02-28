/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class FrontController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void GoUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainInter.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void GoAdmin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProdInterface.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void GoMap(ActionEvent event) throws IOException {
        Stage stage = new Stage();
     stage.setTitle("JavaFX Chart Demo");
      StackPane pane = new StackPane();
      pane.getChildren().add(createBarChart());
      
      stage.setScene(new Scene(pane, 400, 200));
      stage.show();
    }
public ObservableList<XYChart.Series<String, Double>>
         getDummyChartData() {
      ObservableList<XYChart.Series<String, Double>> data =
         FXCollections.observableArrayList();
      Series<String, Double> as = new Series<>();
      Series<String, Double> bs = new Series<>();
      Series<String, Double> cs = new Series<>();
      Series<String, Double> ds = new Series<>();
      Series<String, Double> es = new Series<>();
      Series<String, Double> fs = new Series<>();
      as.setName("A-Series");
      bs.setName("B-Series");
      cs.setName("C-Series");
      ds.setName("D-Series");
      es.setName("E-Series");
      fs.setName("F-Series");

      Random r = new Random();

      for (int i = 1900; i < 2017; i += 10) {

         as.getData().add(new XYChart.Data<>
         (Integer.toString(i), r.nextDouble()));
         bs.getData().add(new XYChart.Data<>
         (Integer.toString(i), r.nextDouble()));
         cs.getData().add(new XYChart.Data<>
         (Integer.toString(i), r.nextDouble()));
         ds.getData().add(new XYChart.Data<>
         (Integer.toString(i), r.nextDouble()));
         es.getData().add(new XYChart.Data<>
         (Integer.toString(i), r.nextDouble()));
         fs.getData().add(new XYChart.Data<>
         (Integer.toString(i), r.nextDouble()));
      }
      data.addAll(as, bs, cs, ds, es, fs);
      return data;
   }
   public XYChart<CategoryAxis, NumberAxis>
         createBarChart() {
      CategoryAxis xAxis = new CategoryAxis();
      NumberAxis yAxis = new NumberAxis();
      BarChart bc = new BarChart<>(xAxis, yAxis);
      bc.setData(getDummyChartData());
      bc.setTitle("Bar Chart on Random Number");
      return bc;
   }
}
