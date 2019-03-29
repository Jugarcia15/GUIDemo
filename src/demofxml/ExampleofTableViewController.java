/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Juan G
 */
public class ExampleofTableViewController implements Initializable {
    
    
    //configure the table
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    
    // these instance variables are used to create new person objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;
    
    @FXML private Button detailedPersonViewButton;
    
    //this method will allow the user to double click on a cell and update the first name of the person
    public void changeFirstNameCellEvent(CellEditEvent editedCell)
    {
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(editedCell.getNewValue().toString());
    }
public void changeLastNameCellEvent(CellEditEvent editedCell)
    {
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(editedCell.getNewValue().toString());
    }    
    
    //this method will enable the detailed view button once a row in the table
    // is selected
    public void userClickedonTable()
    {
        this.detailedPersonViewButton.setDisable(false);
    }


    
    /**
     * Initializes the controller class.
     */
    //this method is called it will change the scene to a table view example
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        
        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    //when this method is called, it will pass the selected person object to 
    // the detailed view
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        PersonViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        
        
        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //set up the column in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
        
        //load dummy date
        tableView.setItems(getPeople());
        
        //update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //this will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        // disable the detailed person view button until a row is selected
        this.detailedPersonViewButton.setDisable(true);
        
        
    }
    
    // this method will remove the selected rows from the table
    public void deleteButtonPushed()
    {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        
        //loop over the selected rows and remove the Person objects from the
        //table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
        }
    }
    
    
    
    
    
    // this method will create a new person and add it to the table
    public void newPersonButtonPushed()
    {
        Person newPerson = new Person(firstNameTextField.getText(),
                                      lastNameTextField.getText(),
                                      birthdayDatePicker.getValue());
        
        // get all the items from the table as a list, then add the new person 
        //to the list
        tableView.getItems().add(newPerson);
        
    }
    
    
//this method will return on observable list of people objects
    public ObservableList<Person> getPeople()
    {
       ObservableList<Person> people = FXCollections.observableArrayList();
       people.add(new Person("Frank","Sinatra",LocalDate.of(1915, Month.DECEMBER, 12), new Image("FrankSinatra.jpg")));
       people.add(new Person("Juan","Eden",LocalDate.of(1920, Month.JANUARY, 19)));
       people.add(new Person("Jack","Mulaney",LocalDate.of(1998, Month.FEBRUARY, 23)));
       
               return people;
    }

    
    
}
