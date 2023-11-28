import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminCreateScholarshipGUIController {
    //// Statics
    // Scene change
    private App m = new App();

    @FXML
    private Label adminLabel;

    @FXML
    private Button btBack;

    @FXML
    private TextField comments;

    @FXML
    private TextField description;

    @FXML
    private TextField payout;

    @FXML
    private TextField requirements;

    @FXML
    private Button scholarshipCreation;

    @FXML
    private TextField scholarshipName;

    //// Scripts
    @FXML
    void btLogOutClicked(ActionEvent event) {
        try {
            m.changeScene("AdminGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btScholarshipCreationClicked(ActionEvent event) {
        if (comments.getText().isBlank() || description.getText().isBlank() || payout.getText().isBlank()
                || scholarshipName.getText().isBlank() || requirements.getText().isBlank()) {
            showIncompleteFormAlert();
        } else {
            System.out.println("*****************"
                    + "\nMock call to send Scholarship to backend\nPassed Scholarship is:"
                    + "\nName: " + scholarshipName.getText()
                    + "\nPayout: " + payout.getText()
                    + "\nRequirements: " + requirements.getText()
                    + "\nComments: " + comments.getText()
                    + "\nDescriptions: " + description.getText());
        }
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
