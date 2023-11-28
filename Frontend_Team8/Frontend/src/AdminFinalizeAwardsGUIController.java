import java.io.IOException;

import Backend.AppData;
import Backend.ScholarshipApplicationContact;
import Backend.StudentApplication;
import Backend.scholarship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class AdminFinalizeAwardsGUIController {
    //// Statics

    // Scene change
    private App m = new App();

    // passed in user
    AppData currUser = AppData.getInstance();

    // observable list for lcSAC
    private ObservableList<ScholarshipApplicationContact> SACList = FXCollections.observableArrayList();

    ScholarshipApplicationContact selectedSAC;

    @FXML
    private Button btCreateFeedback;

    @FXML
    private Button btCreateScholarship;

    @FXML
    private Button btFinalize;

    @FXML
    private Button btFinalizeAwards;

    @FXML
    private Button btLogOut;

    @FXML
    private Button btManageScholarships;

    @FXML
    private ListView<ScholarshipApplicationContact> lvSAC;

    @FXML
    private TextArea taProfile;

    @FXML
    private TextArea taScholarship;

    @FXML
    private TextArea taContact;

    @FXML
    private Text tfAdminName;

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

    public void initialize() {
        //// For tfAdminName
        tfAdminName.setText(currUser.getSharedVariable().getName());

        //// For lvSAC
        // create 4 scholarships
        // Sample 1
        scholarship s1 = new scholarship("Academic Excellence Scholarship", 5000, "December 15, 2023",
                "Submit official transcripts and a letter of recommendation", "Computer Science, Engineering");

        // Sample 2
        scholarship s2 = new scholarship("Community Service Grant", 3000, "January 31, 2024",
                "Document at least 50 hours of community service", "Social Work, Psychology, Sociology");

        // Sample 3
        scholarship s3 = new scholarship("STEM Innovation Award", 8000, "February 28, 2024",
                "Submit a project showcasing innovation in STEM", "Science, Technology, Engineering, Mathematics");

        // Sample 4
        scholarship s4 = new scholarship("Arts and Culture Scholarship", 6000, "March 15, 2024",
                "Submit a portfolio or performance video", "Fine Arts, Performing Arts");

        // create 4 sample applicants
        // Sample 1
        StudentApplication a1 = new StudentApplication("John Doe", "jd1234", "S1234567", "Computer Science",
                "Mathematics", "Dean's List", true, "Why I Pursue Computer Science");

        // Sample 2
        StudentApplication a2 = new StudentApplication("Jane Smith", "js5678", "S2345678", "Biology", "Chemistry",
                "Outstanding Researcher", false, "Exploring the Intersection of Biology and Chemistry");

        // Sample 3
        StudentApplication a3 = new StudentApplication("Alice Johnson", "aj9012", "S3456789", "Psychology",
                "Sociology", "President's List", true, "Impact of Social Structures on Individual Behavior");

        // Sample 4
        StudentApplication a4 = new StudentApplication("Bob Williams", "bw3456", "S4567890", "History",
                "Political Science", "Historical Scholar", true, "The Role of Political History in Shaping Societies");

        // combine them into the SAC class
        ScholarshipApplicationContact sac1 = new ScholarshipApplicationContact(s1, a1, "Alice Johnson", "555-1234",
                "alice.johnson@example.com");
        ScholarshipApplicationContact sac2 = new ScholarshipApplicationContact(s2, a2, "Bob Smith", "555-5678",
                "bob.smith@example.com");
        ScholarshipApplicationContact sac3 = new ScholarshipApplicationContact(s3, a3, "Alice Johnson", "555-9012",
                "claire.davis@example.com");
        ScholarshipApplicationContact sac4 = new ScholarshipApplicationContact(s4, a4, "David Miller", "555-3456",
                "david.miller@example.com");

        // add them to SACList
        SACList.add(sac1);
        SACList.add(sac2);
        SACList.add(sac3);
        SACList.add(sac4);

        lvSAC.setItems(SACList);

        // create an event listener for applications selection
        lvSAC.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // set text fields
                taProfile.setText(newValue.getStuapp().toString());
                taScholarship.setText(newValue.getScholarship().toString());
                taContact.setText(newValue.getName() + "\n" + newValue.getPhoneNumber() + "\n" + newValue.getEmail());
                // pass globally for final selection
                selectedSAC = newValue;
            }
        });

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        lvSAC.setCellFactory(new Callback<>() {
            @Override
            public ListCell<ScholarshipApplicationContact> call(ListView<ScholarshipApplicationContact> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(ScholarshipApplicationContact sac, boolean empty) {
                        super.updateItem(sac, empty);

                        if (empty || sac == null) {
                            setText(null);
                        } else {
                            setText(sac.getStuapp().getName());
                        }

                    }
                };
            }
        });

        //// For btDelete
        btFinalize.setOnAction(event -> {
            // Get selected index
            System.out.println("*****************"
                    + "\nMock call to finalize award to reporting and backend\nPassed award is:"
                    + "\nScholarship:\n " + taScholarship.getText()
                    + "\nApplicant:\n " + taProfile.getText());
            int selectedIndex = lvSAC.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                // Remove item from the ObservableList
                SACList.remove(selectedIndex);
                lvSAC.setItems(SACList);
            }
        });
    }
}