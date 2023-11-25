
import java.io.IOException;
import java.util.ArrayList;

import Backend.User;
import Backend.UserTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Login {

    @FXML
    private Label createAnAccount;

    @FXML
    private Label invalidLogin;

    @FXML
    private Button logInButton;

    @FXML
    private Label loginLabel;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label welcomeLabel;

    private App m = new App();

    @FXML
    void createAccount(MouseEvent event) throws IOException {
        m.changeScene("createAccount.fxml");
    }

    @FXML
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException{
        UserTest test = new UserTest();
        ArrayList<User> users = new ArrayList<>();
        users = test.getUsers();
        for (User user : users) {
            if (username.getText().toString().equals(user.getEmail()) && password.getText().toString().equals(user.getPassword())){
                invalidLogin.setText("Login Success");
                if (user.getUserType() == 1){
                    m.changeScene("ApplicantGUI.fxml");
                }
                else if (user.getUserType() == 2){
                    m.changeScene("AdminGUI.fxml");
                }
                else if (user.getUserType() == 3){
                    m.changeScene("ReviewerGUI.fxml");
                }
                else if (user.getUserType() == 4){
                    m.changeScene("SponsorGUI.fxml");
                }
                else if (user.getUserType() == 5){
                    m.changeScene("StewerGUI.fxml");
                }
                else if (user.getUserType() == 6){
                    m.changeScene("SupportGUI.fxml");
                }
            }
            else if(username.getText().isEmpty() && password.getText().isEmpty()){
                invalidLogin.setText("Please enter your login");
            }
            else{
                invalidLogin.setText("Incorrect email or password");
            }
        }
    }

}