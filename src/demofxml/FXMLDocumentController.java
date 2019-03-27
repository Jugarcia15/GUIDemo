/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofxml;
// these items were for the checkbox
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author Juan G
 */

public class FXMLDocumentController implements Initializable {
    // these items are for the checkbox exampls

    @FXML private Label Test;
    @FXML private CheckBox DarkSouls;
    @FXML private CheckBox DankSouls;
    @FXML private CheckBox Sekiro;
    
    // these items are for the choicebox exampls

    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;
    
    
    // this will update the label for the  choicebox example
    public void choiceBoxButtonPushed()
    {
        choiceBoxLabel.setText("My favorite fruit is:\n" +choiceBox.getValue().toString());
    }
    // this is for the checkbox example

    public void TestButtonPushed()
    {
       String order = "Games are: ";
       if (DarkSouls.isSelected())
           order += "\nDark Souls";
       if (DankSouls.isSelected())
           order += "\nDank Souls";
       if (Sekiro.isSelected())
           order += "\nSekiro";
       
       this.Test.setText(order);
    }
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        Test.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Test.setText(" ");
        
        //this items are for configuring choicebox example
        choiceBoxLabel.setText(" ");
        choiceBox.getItems().add("apples");
        choiceBox.getItems().add("oranges");
        choiceBox.getItems().addAll("strawberries", "Pears", "Pumpkins");
        choiceBox.setValue("Apples");
    }    
    
}
