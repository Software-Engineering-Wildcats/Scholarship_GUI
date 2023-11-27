import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    String filepath = "createdscholarship.csv";

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
        if (taAdditionalRequirements.getText().isBlank()) {
            taAdditionalRequirements.setText("None");
        }
        String scholarshipinfo = String.format("%s %d %s %s\n %s", tfName.getText(),
                Integer.parseInt(tfPayout.getText()),
                tfDeadline.getText(), taAdditionalRequirements.getText(), tfMajors.getText());
        if (cbSelfReviewer.isSelected()) {
            writeToFile(filepath, scholarshipinfo);
        } else {
        }
        System.out.println("*****************"
                + "\nMock call to send Scholarship to Administrator through backend\nPassed scholarship information is:\n"
                + scholarshipinfo);
        if (cbSelfReviewer.isSelected()) {
            System.out.println("SelfReviewer: true");
        } else {
            System.out.println("SelfReviewer: false");
        }
        try {
            m.changeScene("SponsorGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
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

    private static void writeToFile(String filePath, String content) {
        // Create a Path object
        Path path = Paths.get(filePath);

        // Use try-with-resources to automatically close resources
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            // Write content to the file
            writer.write(content);
        } catch (IOException e) {
            // Handle the exception appropriately (e.g., log it, show a message)
            e.printStackTrace();
        }
    }

}
