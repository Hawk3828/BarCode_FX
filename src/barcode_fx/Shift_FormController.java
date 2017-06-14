/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode_fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author H586377
 */
public class Shift_FormController implements Initializable {
    
    @FXML
    private SplitPane splitPaneShift;
    @FXML
    private ListView<String> shiftListView;
    @FXML
    private Label lb_shiftLabel;
    @FXML
    private Label lb_shiftLabelNote;
    @FXML
    private Button btnShiftButton;
    @FXML
    private TextField txf_shiftInput;
    
    protected ListProperty<String> shiftList = new SimpleListProperty<>();
    
    protected int input;
    
    protected List<String> shift_1 = new ArrayList<>();
    protected List<String> shift_2 = new ArrayList<>();
    protected List<String> shift_3 = new ArrayList<>();
   
    
    
            
    @FXML   
    private void handleButtonAction(ActionEvent event) {
        shift_1.add ("H19-US395");
        shift_1.add ("H19-US396");
        shift_1.add ("H19-US397");
        
        shift_2.add ("H19-US385");
        shift_2.add ("H19-US386");
        shift_2.add ("H19-US387");
        
        shift_3.add ("H19-US375");
        shift_3.add ("H19-US376");
        shift_3.add ("H19-US374");
          
      
        if(txf_shiftInput == shift_1){
            input = 0;
        }else if(txf_shiftInput == shift_2){
            input = 1;
        }else{
            input = 2;    
        }
        
        switch(input){
            case 0 : shiftList.set(FXCollections.observableArrayList(shift_1));
            break;
            case 1 : shiftList.set(FXCollections.observableArrayList(shift_2));
            break; 
            case 2 : shiftList.set(FXCollections.observableArrayList(shift_3));
            break;
            default:
        }
       shiftListView.itemsProperty().bind(shiftList);
       
       shiftList.set(FXCollections.observableArrayList(shiftList));

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
