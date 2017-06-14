/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode_fx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import javafx.scene.control.TextField;
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
    private TextField co_ScanTestRequest;

    @FXML
    private TextField co_ScanOperatorShift;

    @FXML
    private TextField co_ScanOperatorName;
    
	
 	

    @FXML
    private void handleButtonActionPrint(ActionEvent event) throws IOException , SQLException {
    	
    	 String tablename =  co_ScanTestRequest.getText();
    	 
         //SQL statement for  handleButtonActionNewTR method line 
         String sql ="CREATE TABLE IF NOT EXISTS " + tablename + " (" +
         			"SCAN INT NOT NULL AUTO_INCREMENT," +
         		  	"Shift varchar(255) NOT NULL,"+
         		  	"Operator varchar(255) NOT NULL," +
         		  	"Testdate DATE  NOT NULL," +
         		  	"ScanOut TIME  NOT NULL," + 
         		  	"ScanIn TIME  NOT NULL DEFAULT 'null'," +
         		  	"RunTime FLOAT NOT NULL DEFAULT 'null'," +
         		  	"ActiveHours FLOAT  NOT NULL DEFAULT 'null' ," +
         		  	"Unit_Issue varchar(255) NOT NULL DEFAULT 'null'," +
         		  	"Notes varchar(255) NOT NULL DEFAULT 'null'," +
         		  	"PRIMARY KEY (SCAN)) "+
         		  	"ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ";
         
       //Prepared SQL Statement...
       	String prepared = "INSERT INTO " + co_ScanTestRequest.getText() + " (SCAN, SHIFT, Operator, Testdate, ScanOut) VALUES (?,?,?,?,?)";
       	
       	Time currentScanOut = Time.valueOf(LocalTime.now());
       	Date currentScanOutDate = Date.valueOf(LocalDate.now());
   
    	try(Connection conn =  DBUtil.getConnection(DBType.MYSQL);
    			
    		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  					  								  ResultSet.CONCUR_READ_ONLY);
    			
			PreparedStatement preparedstatement = conn.prepareStatement(prepared);)
    		{
    			
    		stmt.executeUpdate(sql);

    	    System.out.println( co_ScanTestRequest.getText() + "'s Table has been Creaeted!");
    	    
			preparedstatement.setInt(1, 0);
			preparedstatement.setString(2, co_ScanOperatorShift.getText());
			preparedstatement.setString(3, co_ScanOperatorShift.getText());
			preparedstatement.setDate(4,currentScanOutDate);
			preparedstatement.setTime(5,currentScanOut);
			
			preparedstatement.executeUpdate();
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        
	        //load up OTHER FXML document
	        AnchorPane shiftForm = FXMLLoader.load(getClass().getResource("Shift_Form.fxml"));
	        AnchorPaneScanOut.getChildren().setAll(shiftForm);
			
    		}
    	
    }
        
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
}//End of CLASS!
