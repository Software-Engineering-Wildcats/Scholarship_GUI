import java.io.IOException;

import Backend.AppData;
import Backend.Feedback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class SupportGUIController {
    //// Statics
    // observable list for lvFeedback
    private ObservableList<Feedback> FeedList = FXCollections.observableArrayList();

    // Scene change
    private App m = new App();

    // Passed in user
    AppData currUser = AppData.getInstance();

    // selected feedback
    Feedback selectedFeedback;
    //// containers
    @FXML
    private Button btFeedback;

    @FXML
    private Button btLogOut;

    @FXML
    private Button btManageAccount;

    @FXML
    private Button btSubmit;

    @FXML
    private ChoiceBox<Boolean> cbComplete;

    @FXML
    private ListView<Feedback> lvFeedback;

    @FXML
    private TextArea taFeedback;

    @FXML
    private TextArea tfNotes;

    @FXML
    private Text tfSupportName;

    //// Scripts
    @FXML
    void btLogOutClicked(ActionEvent event) {
        try {
            m.changeScene("LoginScene.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btManageAccountClicked(ActionEvent event) {
        try {
            m.changeScene("ManageAccountGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btManageFeedbackClicked(ActionEvent event) {
        try {
            m.changeScene("SponsorGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btSubmitClicked(ActionEvent event) {
        System.out.println("*****************"
                + "\nMock call to send FeedbackNotes to backend\nPassed FeedbackNotes are:"
                + "\nIsComplete: " + cbComplete.getValue()
                + "\nNotes: " + tfNotes.getText());

        selectedFeedback.setCompleted(cbComplete.getValue());
        selectedFeedback.setNotes(tfNotes.getText());
    }

    public void initialize() {
        // get passed in user name
        tfSupportName.setText(currUser.getSharedVariable().getName());

        //// For cbCompleted
        // create data for cbComplete
        cbComplete.setItems(FXCollections.observableArrayList(false, true));
        cbComplete.setValue(false);

        //// For lvFeedback
        // create sample feedback data
        Feedback f1 = new Feedback(false, "Report 1", "2023-11-01", 1, 3, "Good job!", "No additional notes");
        Feedback f2 = new Feedback(false, "Report 2", "2023-11-02", 2, 2, "Some improvements needed.",
                "Note: Important points to address.");
        Feedback f3 = new Feedback(false, "Report 3", "2023-11-03", 3, 1, "Excellent work!",
                "Minor suggestions for enhancement.");
        Feedback f4 = new Feedback(false, "Report 4", "2023-11-04", 4, 4, "Needs urgent attention.",
                "Note: Critical issues identified.");
        Feedback f5 = new Feedback(false, "Report 5", "2023-11-05", 5, 2, "Well done!", "No specific notes.");
        Feedback f6 = new Feedback(false, "Report 6", "2023-11-06", 6, 3, "Satisfactory performance.",
                "Note: Further discussion required.");
        Feedback f7 = new Feedback(false, "Report 7", "2023-11-07", 7, 5, "Incomplete submission.",
                "Note: Missing key details.");

        // add sample data to list
        // this is 'accessing the backend' which is outside of the scope of Front End
        FeedList.add(f1);
        FeedList.add(f2);
        FeedList.add(f3);
        FeedList.add(f4);
        FeedList.add(f5);
        FeedList.add(f6);
        FeedList.add(f7);

        // sets feedback list view to the sample data
        lvFeedback.setItems(FeedList);

        // create an event listener for applications selection
        lvFeedback.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // set profile text to selected applicant
                taFeedback.setText(newValue.toString());
                // set review fields;
                cbComplete.setValue(newValue.isCompleted());
                tfNotes.setText(newValue.getNotes());
                // pass globally for final selection
                selectedFeedback = newValue;
            }
        });

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        lvFeedback.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Feedback> call(ListView<Feedback> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Feedback report, boolean empty) {
                        super.updateItem(report, empty);

                        if (empty || report == null) {
                            setText(null);
                        } else {
                            setText(report.getReportTitle());
                            if (report.isCompleted()) {
                                setTextFill(Color.web("#E2E9EB"));
                            } else {
                                setTextFill(Color.BLACK);
                            }
                        }

                    }
                };
            }
        });
    }

}
