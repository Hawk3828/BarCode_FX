/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author H586377
 */
public class BarCodeFX1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(BarCodeFX1.class.getResource("BarCode_FX.css").toExternalForm());
        stage.setTitle("Husqvarna Barcode Application");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    /**
     * Driver
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
    
