package barcode_fx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author H586377
 */
public class HomePageController implements Initializable {
    @FXML
    private AnchorPane AnchorPaneMain;
    
    @FXML
    private AnchorPane AnchorPaneScanIn;
    
    @FXML
    private AnchorPane AnchorPaneScanOut;
    
    @FXML
    private GridPane mainGridNewTrPage;
        
    @FXML
    private Button btnScanOut;
    @FXML
    private Label labVersion;
    @FXML
    private Button btnScanIn;
    
    
    //SQL statement for  handleButtonActionNewTR method line 
    String sql ="CREATE TABLE IF NOT EXISTS activetestrequest (" +
    		  	"TestName varchar(255) NOT NULL,"+
    		  	"Shift varchar(255) NOT NULL," +
    		  	"TestHours varchar (255) NOT NULL," +
    		  	"Fuel varchar(255) NOT NULL," +
    		  	"Notes varchar(255) NOT NULL," +
    		  	"PRIMARY KEY (TestName)) "+
    		  	"ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ";


   @FXML
   // Both button on the Check and CheckOut Page Share this method
   private void handleButtonAction(ActionEvent event) throws IOException{
     Stage stage; 
     Parent root;
     
     if(event.getSource()== btnScanOut){
        //get reference to the button's stage         
        stage = (Stage) btnScanOut.getScene().getWindow();
        
        //load up OTHER FXML document and covers the complete
        AnchorPane AnchorPaneScanOut = FXMLLoader.load(getClass().getResource("CheckOutPage.fxml"));
        AnchorPaneMain.getChildren().setAll(AnchorPaneScanOut);
      }
     else{
       stage =(Stage) btnScanIn.getScene().getWindow();
       AnchorPane AnchorPaneScanIn = FXMLLoader.load(getClass().getResource("CheckInPage.fxml"));
       AnchorPaneMain.getChildren().setAll(AnchorPaneScanIn);
      }

    }

   public void handleButtonActionNewTR (ActionEvent event) throws IOException{
	   GridPane mainGridNewTrPage = FXMLLoader.load(getClass().getResource("NewTRPage.fxml"));
	   Stage stage = new Stage();
	   
	   stage.setScene(new Scene(mainGridNewTrPage));
	   stage.show();
	   
	   
	   //Try with resources automatically closes the connection when complete.
		try(Connection conn =  DBUtil.getConnection(DBType.MYSQL);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
													  ResultSet.CONCUR_READ_ONLY);){
			
			stmt.executeUpdate(sql);
			
			System.out.println("Connected to Database!");
			} catch (SQLException e) {
				DBUtil.processException(e);
			}finally{
				
			}
			
   }
   
   public void handleButtonActionNewSuperMode (ActionEvent event) throws IOException{
	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("superModePage.fxml"));
	   Parent root1 = (Parent) fxmlLoader.load();
	   Stage stage = new Stage();
	   
	   stage.setScene(new Scene(root1));
	   stage.show();
	 
   }
   
   public void closeApp (ActionEvent event){
	   Platform.exit();
	   System.exit(0); 
  	 
   }
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	
		}
	}
