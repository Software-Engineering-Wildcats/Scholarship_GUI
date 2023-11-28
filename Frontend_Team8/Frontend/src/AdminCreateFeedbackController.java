import java.io.IOException;

import Backend.AppData;
import Backend.Feedback;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AdminCreateFeedbackController {
    //// Statics
    // Scene change
    private App m = new App();

    // passed in user
    AppData currUser = AppData.getInstance();

    // the created feedback
    Feedback currFeedback = new Feedback();

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
    private ChoiceBox<Integer> cbThreatLevel;

    @FXML
    private ChoiceBox<String> cbUserType;

    @FXML
    private TextArea taReport;

    @FXML
    private Text tfAdminName;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfName;

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
    void btFinalizeClicked(ActionEvent event) {
        currFeedback.setReportTitle(tfName.getText());
        currFeedback.setDateSubmitted(tfDate.getText());
        currFeedback.setUserTypeSubmitted(convertUserType(cbUserType.getValue()));
        currFeedback.setThreatLevel(cbThreatLevel.getValue());
        currFeedback.setFeedbackReport(taReport.getText());

        System.out.println("*****************"
                + "\nMock call to create Feedback to Backend\nCreated feedback is:"
                + currFeedback.toString());
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

    // helper method to go string to int
    public int convertUserType(String userType) {
        if (userType == "Applicant") {
            return 1;
        } else if (userType == "Admin") {
            return 2;
        } else if (userType == "Reviewer") {
            return 3;
        } else if (userType == "Sponsor") {
            return 4;
        } else if (userType == "Stewer") {
            return 5;
        } else if (userType == "Support") {
            return 6;
        } else {
            return 1;
        }
    }

    public void initialize() {
        //// For tfAdminName
        tfAdminName.setText(currUser.getSharedVariable().getName());

        //// For cbUserType
        cbUserType.setItems(
                FXCollections.observableArrayList("Applicant", "Admin", "Reviewer", "Sponsor", "Steward", "Support"));
        cbUserType.setValue("Applicant");

        //// For cbThreatLevel
        cbThreatLevel.setItems(
                FXCollections.observableArrayList(1, 2, 3, 4, 5));
        cbThreatLevel.setValue(1);
    }
}
