import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Backend.AppData;
import Backend.scholarship;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class ApplicantSceneController {
    List<scholarship> slippy = new ArrayList();

    App m = new App();

    scholarship currentFood;
    private AppData currUser = AppData.getInstance();
    @FXML
    private Label userName;

    @FXML
    private Button logOutButton;

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
        userName.setText(currUser.getSharedVariable().getName());
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

                m.changeScene("ApplicationCreationScene.fxml", currentFood.getScholarshipName());
            }

             catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        

    }

    @FXML
    void btnEditProfile(ActionEvent event) throws IOException{
        m.changeScene("EditProfileScene.fxml");
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        m.changeScene("LoginScene.fxml");
    }

    @FXML
    void btnViewApplications(ActionEvent event) {
        try {
            m.changeScene("ViewApplicationsScene.fxml");
        } catch (IOException e) {
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
