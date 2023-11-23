import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;

import Backend.StudentApplication;
import Backend.scholarship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class SponsorGUIController {

    //// statics
    // Observable list for lvApplicants
    private ObservableList<StudentApplication> StuAppList = FXCollections.observableArrayList();

    // StudentApplication for Submit Application
    StudentApplication selecteStudentApplication;
    // integer for rating
    int rating = 1;

    // String for Notes
    String notes = "";

    // Scene change
    private App m = new App();

    // Name of file where createdscholarship is
    String filename = "createdscholarship.csv";

    // path variable to access file
    Path path = Paths.get(filename);

    // Checks to see if is reviewer
    boolean selfReviewer = false;

    //// containers
    @FXML
    private Button btLogOut;

    @FXML
    private Button btSubmitApplicant;

    @FXML
    private Button btSearch;

    @FXML
    private ChoiceBox<Integer> cbReviewerRating;

    @FXML
    private ListView<StudentApplication> lvApplicants;

    @FXML
    private TextArea taProfile;

    @FXML
    private TextArea taScholarshipInformation;

    @FXML
    private TextArea tfNotes;

    @FXML
    private Text tfReviewersName;

    @FXML
    private TextField tfSearchBar;

    @FXML
    private RadioButton rbName;

    @FXML
    private RadioButton rbPayout;

    @FXML
    private RadioButton rbRelevance;

    //// scripts
    // Log out button sends to log in scene
    @FXML
    void btLogOutClicked(ActionEvent event) throws IOException {
        Files.delete(path);
        m.changeScene("LoginScene.fxml");
    }

    // Create Scholarship goes to CreateScholarshipGUI
    @FXML
    void btCreateScholarshipClicked(ActionEvent event) throws IOException {
        m.changeScene("CreateScholarship.fxml");
    }

    // Submit applicant button listener
    @FXML
    void btSubmitApplicantClicked(ActionEvent event) {
        confirmSubmitApplicant();
    }

    // Confirmation window for applicant button
    private void confirmSubmitApplicant() {
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure you want to proceed?");
        confirmationAlert.setContentText("Click OK to confirm or Cancel to abort.");

        // Add OK and Cancel buttons
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Cancel");
        confirmationAlert.getButtonTypes().setAll(okButton, cancelButton);

        // Show the alert and wait for the user's response
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        // Check if the user clicked OK
        if (result.isPresent() && result.get() == okButton) {
            System.out.println("User clicked OK. Proceeding...");
            System.out.println("*****************"
                    + "\nMock call to send Applicant to Administrator through backend\nPassed applicant is:\n"
                    + selecteStudentApplication.toString());
            return;
        } else {
            System.out.println("User clicked Cancel. Aborting...");
            return;
        }
    }

    @FXML
    void btSubmitNotesClicked(ActionEvent event) {
        System.out.println("*****************"
                + "\nMock call to send applicant notes to Backend\nInformation sent over is as follows:\n"
                + "Rating: " + rating + "\nNotes: " + tfNotes.getText());
    }

    @FXML
    void rbSortName(ActionEvent event) {
        System.out.println("*****************"
                + "\nMock call to send 'sort by name' to Matching");
    }

    @FXML
    void rbSortPayout(ActionEvent event) {
        System.out.println("*****************"
                + "\nMock call to send 'sort by payout' to Matching");
    }

    @FXML
    void rbSortRelevance(ActionEvent event) {
        System.out.println("*****************"
                + "\nMock call to send 'sort by relevance' to Matching");
    }

    @FXML
    void btSearchClicked(ActionEvent event) {
        System.out.println("*****************"
                + "\nMock call to send search to Matching\nInformation sent over is as follows:\n"
                + "Search Contents: " + tfSearchBar.getText());
    }

    // pass choice box number to global
    private void handleChoiceBoxSelection() {
        rating = cbReviewerRating.getValue();
        return;
    }

    // the initialize function that is called when the scene is built
    public void initialize() throws FileNotFoundException {
        //// For radioButtons
        ToggleGroup sortToggle = new ToggleGroup();
        rbName.setToggleGroup(sortToggle);
        rbPayout.setToggleGroup(sortToggle);
        rbRelevance.setToggleGroup(sortToggle);

        //// For tfReviewersName
        tfReviewersName.setText("User Three");

        //// For taScholarshipInformation
        if (Files.exists(path) && Files.isRegularFile(path)) {
            selfReviewer = true;
            Scanner s = new Scanner(new File(filename));
            scholarship madeScholarship = new scholarship(s.next(), s.nextInt(), s.next(), s.nextLine(), s.next());
            taScholarshipInformation.setText(madeScholarship.toString());
            s.close();
        }

        // turns fields on or off depending of if submitting notes
        cbReviewerRating.setDisable(!selfReviewer);
        tfNotes.setEditable(selfReviewer);

        //// For cbReviewerRating
        // create data for cbReviewerRating
        cbReviewerRating.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        cbReviewerRating.setValue(1);

        // create listener for box selection
        cbReviewerRating.setOnAction(event -> handleChoiceBoxSelection());

        //// For lvApplicants
        // create sample student data
        StudentApplication s1 = new StudentApplication("John Doe", 1234567890123456L, "Computer Science", "Mathematics",
                "apple orange banana chair table computer program music  happy sad sky cloud rain sun flower mountain river book read write language science art love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");
        StudentApplication s2 = new StudentApplication("Jane Smith", 2345678901234567L, "Electrical Engineering",
                "Physics",
                "orange banana chair table computer program music dance happy sad sky cloud rain sun flower mountain river book read write language science art love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");
        StudentApplication s3 = new StudentApplication("Alice Johnson", 3456789012345678L, "Biology", "Chemistry",
                "apple orange banana chair table computer program music dance happy sad sky cloud rain sun flower mountain river book read write language science art love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");
        StudentApplication s4 = new StudentApplication("Bob Williams", 4567890123456789L, "History",
                "Political Science",
                "apple  banana chair table computer program music dance happy sad sky cloud rain sun flower mountain river book read write language science art love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");
        StudentApplication s5 = new StudentApplication("Eva Davis", 5678901234567890L, "Psychology", "Sociology",
                "apple orange banana chair table computer program music dance happy sad sky cloud rain sun flower mountain river book read write language science art love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");
        StudentApplication s6 = new StudentApplication("Olivia Miller", 7890123456789012L, "Mathematics",
                "Computer Science",
                "chair table computer program music dance happy sad sky cloud rain sun flower mountain river book read write language science art love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");
        StudentApplication s7 = new StudentApplication("Michael Brown", 6789012345678901L, "English", "Linguistics",
                "apple orange banana chair table computer program music happy sad sky cloud rain sun flower mountain river book read write language science love friend family house car journey dream sleep awake morning night star moon ocean beach city explore discover learn teach school college university student teacher knowledge wisdom courage strength health exercise food cook eat drink water air breathe walk run play game team win lose competition challenge problem solution create innovate design build technology internet social media friend post share like dislike emotion feeling think ponder reflect meditate calm peace war conflict resolution politics government country nation global world earth space universe star galaxy black white color art paint draw sketch photograph camera film watch listen hear sound noise quiet loud soft hard easy difficult challenge problem solution puzzle game play fun serious joke laugh smile face eyes nose mouth ear hair skin body health exercise run walk hike climb swim jump leap fall rise grow change adapt evolve learn teach education school college university student teacher mentor guide lead follow team group community society culture tradition history past present future plan goal dream wish hope fear courage strength weakness power control chaos order structure system process result outcome consequence cause effect influence impact change stability innovation technology internet social media connection communication language words speak listen hear understand comprehend knowledge wisdom insight intuition gut feeling emotion happiness joy sadness grief anger love hate indifference empathy sympathy compassion kindness generosity selfishness greed ambition contentment desire longing satisfaction dissatisfaction success failure achievement accomplishment task project work job career passion hobby interest boredom entertainment leisure relaxation stress pressure deadline time moment past present future now later sooner delay hurry speed slow fast movement stillness peace war conflict resolution agreement disagreement argument discussion conversation talk speak listen hear silence.\r\n"
                        + //
                        "");

        // add sample data to list
        // this is 'accessing the backend' (outside scope of front end)
        StuAppList.add(s1);
        StuAppList.add(s2);
        StuAppList.add(s3);
        StuAppList.add(s4);
        StuAppList.add(s5);
        StuAppList.add(s6);
        StuAppList.add(s7);

        // sets applications list view to the sample data
        if (selfReviewer) {
            lvApplicants.setItems(StuAppList);
        }

        // create an event listener for applications selection
        lvApplicants.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // set profile text to selected applicant
                taProfile.setText(newValue.toString());
                // pass globally for final selection
                selecteStudentApplication = newValue;
            }
        });

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        lvApplicants.setCellFactory(new Callback<>() {
            @Override
            public ListCell<StudentApplication> call(ListView<StudentApplication> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(StudentApplication person, boolean empty) {
                        super.updateItem(person, empty);

                        if (empty || person == null) {
                            setText(null);
                        } else {
                            setText(person.getName());
                        }
                    }
                };
            }
        });

    }

}
