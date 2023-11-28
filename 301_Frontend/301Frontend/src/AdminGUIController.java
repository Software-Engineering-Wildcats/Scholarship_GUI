import java.io.IOException;

import Backend.AppData;
import Backend.FinalScholarship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class AdminGUIController {
    //// Statics

    // observable list for lcScholarships
    private ObservableList<FinalScholarship> FSList = FXCollections.observableArrayList();

    // Scene change
    private App m = new App();

    // passed in user
    AppData currUser = AppData.getInstance();

    // selected scholarship
    FinalScholarship selectedScholarship;

    @FXML
    private Button btCreateFeedback;

    @FXML
    private Button btCreateScholarship;

    @FXML
    private Button btDeleteScholarship;

    @FXML
    private Button btEditScholarship;

    @FXML
    private Button btFinalizeAwards;

    @FXML
    private Button btLogOut;

    @FXML
    private Button btManageScholarships;

    @FXML
    private ListView<FinalScholarship> lvScholarships;

    @FXML
    private Text tfAdminName;

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfComments;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfRequirements;

    @FXML
    void btCreateFeedbackClicked(ActionEvent event) {
        try {
            m.changeScene("AdminCreateFeedback.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btCreateScholarshipClicked(ActionEvent event) {
        try {
            m.changeScene("AdminCreateScholarshipGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btEditScholarshipClicked(ActionEvent event) {
        selectedScholarship.setName(tfName.getText());
        selectedScholarship.setAmount(tfAmount.getText());
        selectedScholarship.setDescription(tfDescription.getText());
        selectedScholarship.setRequirements(tfRequirements.getText());
        selectedScholarship.setComments(tfComments.getText());

        System.out.println("*****************"
                + "\nMock call to edit Scholarship in backend\nEdited Scholarship is:"
                + selectedScholarship.toString());
    }

    @FXML
    void btFinalizeAwardsClicked(ActionEvent event) {
        try {
            m.changeScene("AdminFinalizeAwardsGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btLogOutClicked(ActionEvent event) {
        try {
            m.changeScene("LoginScene.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btManageScholarshipsClicked(ActionEvent event) {
        try {
            m.changeScene("AdminGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // the initialize function that is called when the scene is built
    public void initialize() {

        //// For tfAdminName
        tfAdminName.setText(currUser.getSharedVariable().getName());

        //// For lvScholarships
        // Sample 1
        FinalScholarship s1 = new FinalScholarship("Merit Scholarship", "$5000",
                "For outstanding academic achievements",
                "GPA 3.5 or higher", "No additional comments");

        // Sample 2
        FinalScholarship s2 = new FinalScholarship("STEM Excellence Award", "$8000", "Supporting STEM majors",
                "Major in Computer Science or Engineering", "Deadline extension may be possible");

        // Sample 3
        FinalScholarship s3 = new FinalScholarship("Community Service Grant", "$3000",
                "Recognizing community involvement",
                "Minimum 50 hours of community service", "Preference given to local residents");

        // Sample 4
        FinalScholarship s4 = new FinalScholarship("Arts and Culture Scholarship", "$6000",
                "Promoting arts and culture",
                "Submit a portfolio or performance video", "Interview required for final selection");

        // Sample 5
        FinalScholarship s5 = new FinalScholarship("Diversity and Inclusion Award", "$4000",
                "Promoting diversity in education",
                "Open to students from underrepresented backgrounds", "Essay on the importance of diversity required");

        // Sample 6
        FinalScholarship s6 = new FinalScholarship("Athletic Achievement Scholarship", "$7000",
                "Recognizing excellence in sports",
                "Varsity athletes with outstanding performance", "Recommendation letter from coach required");

        // add sample data to list
        // this is 'accessing the backend' (outside scope of front end)
        FSList.add(s1);
        FSList.add(s2);
        FSList.add(s3);
        FSList.add(s4);
        FSList.add(s5);
        FSList.add(s6);

        // sets applications list view to the sample data
        lvScholarships.setItems(FSList);

        // create an event listener for applications selection
        lvScholarships.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // set text fields
                tfName.setText(newValue.getName());
                tfAmount.setText(newValue.getAmount());
                tfDescription.setText(newValue.getDescription());
                tfRequirements.setText(newValue.getRequirements());
                tfComments.setText(newValue.getComments());
                // pass globally for final selection
                selectedScholarship = newValue;
            }
        });

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        lvScholarships.setCellFactory(new Callback<>() {
            @Override
            public ListCell<FinalScholarship> call(ListView<FinalScholarship> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(FinalScholarship scholarship, boolean empty) {
                        super.updateItem(scholarship, empty);

                        if (empty || scholarship == null) {
                            setText(null);
                        } else {
                            setText(scholarship.getName());
                        }
                    }
                };
            }
        });

        //// For btDelete
        btDeleteScholarship.setOnAction(event -> {
            // Get selected index
            System.out.println("*****************"
                    + "\nMock call to delete Scholarship in backend\nDeleted Scholarship is:"
                    + selectedScholarship.toString());
            int selectedIndex = lvScholarships.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                // Remove item from the ObservableList
                FSList.remove(selectedIndex);
                lvScholarships.setItems(FSList);
            }
        });
    }
}
