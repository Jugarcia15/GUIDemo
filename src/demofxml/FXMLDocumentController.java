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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
    
    
    // these items are for the combobox example
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;
    
    // these items are for the radio buttons exampls
    @FXML private RadioButton phpRadioButton;
        @FXML private RadioButton JavaRadioButton;
        @FXML private RadioButton cSharpRadioButton;
    @FXML private RadioButton cPlusPlusRadioButton;
        @FXML private Label radioButtonLabel;
        private ToggleGroup favLangToggleGroup;

    
    
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
    
    // this will update the combobox label when the combox is changed
    public void comboBoxWasUpdate()
    {
        this.comboBoxLabel.setText("Course selected: \n" + comboBox.getValue().toString());
    }
    
    //this method will update the radiobutton label when ever a different radiobutton is pushed
    public void radioButtonChanged()
    {
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.cPlusPlusRadioButton))
            radioButtonLabel.setText("The selected item is: C++");
        
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.cSharpRadioButton))
                radioButtonLabel.setText(" the selected item is: C#");
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.JavaRadioButton))
                radioButtonLabel.setText(" the selected item is: Java");
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.phpRadioButton))
                radioButtonLabel.setText(" the selected item is: php");
                              
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
        
        // this items are for configuration for the combo box
        comboBox.getItems().add("COMP1030");
        comboBox.getItems().addAll("COMP1008","MGMT2003","MGMT2010");
        comboBoxLabel.setText(" ");
        
        //these items are for configuring the radioButtons
        radioButtonLabel.setText(" ");
        favLangToggleGroup = new ToggleGroup();
        this.cPlusPlusRadioButton.setToggleGroup(favLangToggleGroup);
        this.cSharpRadioButton.setToggleGroup(favLangToggleGroup);
        this.phpRadioButton.setToggleGroup(favLangToggleGroup);
        this.JavaRadioButton.setToggleGroup(favLangToggleGroup);
        
    }    
    
}
