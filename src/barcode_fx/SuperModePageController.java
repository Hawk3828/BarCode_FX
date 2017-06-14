/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode_fx;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author H586377
 */
public class SuperModePageController implements Initializable {
    
    @FXML
    private Button closeButton;
    
    
    @FXML
     public void closeButtonAction (){
    	// get a handle to the stage
    	    Stage stage = (Stage) closeButton.getScene().getWindow();
    	    // do what you have to do
    	    stage.close();
   }

    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
