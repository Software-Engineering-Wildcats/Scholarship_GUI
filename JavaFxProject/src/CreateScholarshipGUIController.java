import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateScholarshipGUIController {
    //// statics

    // Scene change
    private App m = new App();

    @FXML
    private Button btBack;

    @FXML
    private Button btSubmitScholarship;

    @FXML
    private CheckBox cbSelfReviewer;

    @FXML
    private TextArea taAdditionalRequirements;

    @FXML
    private TextField tfDeadline;

    @FXML
    private TextField tfMajors;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPayout;

    @FXML
    private Text tfReviewersName;

    //// scripts
    @FXML
    void btBackClicked(ActionEvent event) throws IOException {
        m.changeScene("SponsorGUI.fxml");
    }

    @FXML
    void btSubmitScholarshipClicked(ActionEvent event) {
        if (tfName.getText().isEmpty() || tfPayout.getText().isEmpty() || tfDeadline.getText().isEmpty()
                || tfMajors.getText().isEmpty()) {
            showIncompleteFormAlert();
            return;
        }
        if (cbSelfReviewer.isSelected()) {
            // TODO implement becomes reviewer
        } else {
            // TODO implement doesn't become reviewer
        }
        // TODO implement send to backend
    }

    private void showIncompleteFormAlert() {
        Alert incompleteFormAlert = new Alert(AlertType.WARNING);
        incompleteFormAlert.setTitle("Warning");
        incompleteFormAlert.setHeaderText("Incomplete Form");
        incompleteFormAlert.setContentText(
                "Please fill out all required fields before proceeding.\nRequired fields are indicated with '*'");

        // Add OK button
        ButtonType okButton = new ButtonType("OK");
        incompleteFormAlert.getButtonTypes().setAll(okButton);

        // Show the alert and wait for the user's response
        Optional<ButtonType> result = incompleteFormAlert.showAndWait();

        if (result.isPresent() && result.get() == okButton) {
            System.out.println("User clicked OK.");
            // Add your logic for handling the OK button click here
        }
    }

}
