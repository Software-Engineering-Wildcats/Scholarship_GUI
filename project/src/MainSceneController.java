import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Backend.scholarship;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;


public class MainSceneController {
    List<scholarship> slippy = new ArrayList();

    App peas = new App();

    scholarship currentFood;

    @FXML
    private Button EditProfile;

    @FXML   
    private Label lab;

    @FXML
    private Label listInfo;

    @FXML
    private ListView<scholarship> listy;

    @FXML
    private Button btnCreateApplication;

    @FXML
    private Button ViewApplications;


    @FXML
    public void initialize () {
        
        slippy = testScholarships();

        
        for (int i =0; i < slippy.size(); i++){
            listy.getItems().add(slippy.get(i));
        }

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        listy.setCellFactory(new Callback<>() {
            @Override
            public ListCell<scholarship> call(ListView<scholarship> listy) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(scholarship person, boolean empty) {
                        super.updateItem(person, empty);

                        if (empty || person == null) {
                            setText(null);
                        } else {
                            setText(person.getScholarshipName());
                        }
                    }
                };
            }
        });


        listy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<scholarship>() {

            @Override
            public void changed(ObservableValue<? extends scholarship> arg0, scholarship arg1, scholarship arg2) {
                currentFood = listy.getSelectionModel().getSelectedItem();

                listInfo.setText(currentFood.toString());
            }
            
        });

    }

    @FXML
    void applicationCreation(ActionEvent event) { 
        btnCreateApplication.setOnAction(e -> {
            try {

                peas.changeScene("AccountCreationScene.fxml", currentFood.getScholarshipName());
            }

             catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        

    }

    @FXML
    void btnEditProfile(ActionEvent event) {
        

        
    }

    @FXML
    void btnViewApplications(ActionEvent event) {
        try {
            peas.changeScene("ViewApplicationsScene.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private List<scholarship> testScholarships() {
        List<scholarship> temp = new ArrayList();

        scholarship a = new scholarship();
        scholarship b = new scholarship("The Scholarship 1");
        scholarship c = new scholarship("The Scholarship 2", 2);
        scholarship d = new scholarship("The Scholarship 3", 2, "04/14/2003");
        scholarship e = new scholarship("The Scholarship 4", 2, "04/14/2003", "One day, Bella and Jacky went to the market. They were picking up some fresh fruit for mama, but when they got there all they could find was tomotoes. Jackie said \"We'll kill that bitch.\" Bella said \"Thats out biscuit supplier\". One day, Bella and Jacky went to the market. They were picking up some fresh fruit for mama, but when they got there all they could find was tomotoes. Jackie said \\\"We'll kill that bitch.\\\" Bella said \\\"Thats out biscuit supplier\\\".");
        scholarship f = new scholarship("The Scholarship 5", 2, "04/14/2003", "You must not fucking idiot.", "ECE, MSE, Finance, BIology, people");

        temp.add(a);
        temp.add(b);
        temp.add(c); 
        temp.add(d);
        temp.add(e);
        temp.add(f);

        return temp;

    }


}
