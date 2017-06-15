package barcode_fx;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Window;

public class NewTRPageController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;

	@FXML
	private GridPane mainGridNewTrPage;

	@FXML
	private Label lb_NewTr;

	@FXML
	private RadioButton rbtn_1stShift;
	@FXML
	private RadioButton rbtn_2ndtShift;
	@FXML
	private RadioButton rbtn_3rdShift;
	@FXML
	private RadioButton rbtn_AllShift;


	@FXML
	private RadioButton rbtn_AspenFuel;
	@FXML
	private RadioButton rbtn_MixedFuel;


	@FXML
	private Button btn_EnterRequest;

	@FXML
	private TextField txf_TR_Entry;

	@FXML
	private TextField txf_Hours_Entry;

	@FXML
	private TextField txf_TRnotes;

	@FXML
	private ToggleGroup tgl_FUEL;

	@FXML
	private ToggleGroup tgl_SHIFT;

	//Declare Variables
	private final CheckBox cbSetOwner = new CheckBox();
	private final ComboBox<Modality> modalityCombobox = new ComboBox<>();
	private Window stage;

	//Prepared SQL Statement...
	String prepared = "INSERT INTO activetestrequest (TESTNAME, SHIFT, TESTHOURS, FUEL, NOTES) VALUES (?, ?, ?, ?, ?)";


	@FXML
	public void handleButtonEnterTR() {	 

		RadioButton selectedShift = (RadioButton)tgl_SHIFT.getSelectedToggle();
		RadioButton selectedFuel =  (RadioButton)tgl_FUEL.getSelectedToggle();

		try(Connection conn =  DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement preparedstatement = conn.prepareStatement(prepared)){

			preparedstatement.setString(1, txf_TR_Entry.getText());
			preparedstatement.setString(2, selectedShift.getText());
			preparedstatement.setString(3,txf_Hours_Entry.getText());
			preparedstatement.setString(4, selectedFuel.getText());
			preparedstatement.setString(5 ,txf_TRnotes.getText());

			preparedstatement.executeUpdate();
			
			
			// Creation of Dialog Box
			Alert dlg = createAlert(AlertType.CONFIRMATION);
			dlg.setTitle("Test Request");
			dlg.getDialogPane().setHeaderText(txf_TR_Entry.getText() + " : has been Created!");
			dlg.getDialogPane().setContentText("Would You Like To Create Another Test Request");
			dlg.getButtonTypes().add(ButtonType.NO);

			Optional<ButtonType> result = dlg.showAndWait();

			if(result.get() !=ButtonType.OK){
				stage = btn_EnterRequest.getScene().getWindow();
				stage.hide();
			}

			System.out.println("Test Request Created!");

			} catch (SQLException e) {
			DBUtil.processException(e);
			}

	}

	private Alert createAlert(AlertType type) {
		Window owner = cbSetOwner.isSelected() ? stage : null;
		Alert dlg = new Alert(type, "");
		dlg.initModality(modalityCombobox.getValue());
		dlg.initOwner(owner);
		return dlg;
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	} 

}
