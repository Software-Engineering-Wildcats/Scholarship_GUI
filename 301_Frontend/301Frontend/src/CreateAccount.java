import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CreateAccount {

    private String userType;

    @FXML
    private Button createAccountButton;

    @FXML
    private TextField createEmail;

    @FXML
    private TextField createPassword;

    @FXML
    private ChoiceBox<String> userSelect;

    @FXML
    void accountCreate(ActionEvent event) {

    }
    private void handleChoiceBoxSelection() {
        userType = userSelect.getValue();
        return;
    }

    public void initialize() {
        userSelect.setItems(FXCollections.observableArrayList("Student", "Non-Student"));
        userSelect.setValue("Student");

        // create listener for box selection
        userSelect.setOnAction(event -> handleChoiceBoxSelection());
    }

}
