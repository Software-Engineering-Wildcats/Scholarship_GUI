import java.io.IOException;

import Backend.UserTest;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateAccount {

    private String userType;
    private App m = new App();

    @FXML
    private Button backButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private TextField createEmail;

    @FXML
    private TextField createPassword;

    @FXML
    private TextField createName;

    @FXML
    private Label errorLabel;

    @FXML
    private Label nonStudentError;

    @FXML
    private ChoiceBox<String> userSelect;

    @FXML
    void accountCreate(ActionEvent event) throws IOException {
       if (createName.getText().isEmpty() ||createEmail.getText().isEmpty() || createPassword.getText().isEmpty() || userSelect.getValue() == null){
        errorLabel.setText("Please enter all the fields");
        nonStudentError.setText("");
       }
       else if(userSelect.getValue().equals("Non-Student")){
        errorLabel.setText("");
        nonStudentError.setText("If you are a Non-Student, please contact University Staff to create an account for you.");
       }
       else if (userSelect.getValue().equals("Student") && !(createName.getText().isEmpty()) && !(createEmail.getText().isEmpty()) && !(createPassword.getText().isEmpty())){
        UserTest test = new UserTest();
        test.addUser(createEmail.getText().toString(), createPassword.getText().toString(), createName.getText().toString(), 1); 
        m.changeScene("LoginScene.fxml", test);
       }
    }
    
    @FXML
    void goBack(ActionEvent event) throws IOException {
        m.changeScene("LoginScene.fxml");
    }

    private void handleChoiceBoxSelection() {
        userType = userSelect.getValue();
        return;
    }

    public void initialize() {
        userSelect.setItems(FXCollections.observableArrayList("Student", "Non-Student"));

        //Create listener for box selection
        userSelect.setOnAction(event -> handleChoiceBoxSelection());
    }

}
