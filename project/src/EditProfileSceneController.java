import java.io.IOException;

import Backend.AppData;
import Backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditProfileSceneController {

    App m = new App();

    AppData currUser = AppData.getInstance();

    User newUser;


 @FXML
    private TextField ConfirmedNewPassword;

    @FXML
    private TextField NewEmail;

    @FXML
    private TextField NewName;

    @FXML
    private TextField NewPassword;

    @FXML
    private Label PasswordChecker;

    @FXML
    private Button UpdateAccount;

    @FXML
    private Button backButton;

    @FXML
    void backScene(ActionEvent event) throws IOException {
        m.changeScene("ApplicantGUI.fxml");
    }

    @FXML
    void btnUpdateAccount(ActionEvent event) throws IOException {

        String name = currUser.getSharedVariable().getName();
        String password = currUser.getSharedVariable().getPassword();
        String email = currUser.getSharedVariable().getEmail();
        int userPriv = 1;
        
        if (!NewEmail.getText().isEmpty()){
            email = NewEmail.getText();
        }
        if (!NewName.getText().isEmpty()){
            name = NewName.getText();
        }
        if (NewPassword.getText().equals(ConfirmedNewPassword.getText())){
            if (!NewPassword.getText().isEmpty() && !ConfirmedNewPassword.getText().isEmpty()) {
                password = NewPassword.getText();
            }
        }
        else{
            PasswordChecker.setText("The passwords do not match.");
        }

        newUser = new User(email, password, name, userPriv);
        currUser.setSharedVariable(newUser);

        //Output to backend
        System.out.println("Writing of the new user details to the backend would happen here");
        System.out.println("Name: " + newUser.getName());
        System.out.println("Email: " + newUser.getEmail());
        System.out.println("Password: " + newUser.getPassword());


        if (NewPassword.getText().equals(ConfirmedNewPassword.getText())){
            m.changeScene("ApplicantGUI.fxml");
        }
    }

}
