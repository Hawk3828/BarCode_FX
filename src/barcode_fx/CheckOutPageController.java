/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode_fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author H586377
 */
public class CheckOutPageController implements Initializable {
    
    @FXML
    private BorderPane BorderPaneMain;
    @FXML
    private AnchorPane AnchorPaneScanOut;
    @FXML
    private Button btnCheckOutPrint;

    @FXML
    private void handleButtonActionPrint(ActionEvent event) throws IOException {
    
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        AnchorPane shiftForm = FXMLLoader.load(getClass().getResource("Shift_Form.fxml"));
        AnchorPaneScanOut.getChildren().setAll(shiftForm);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
