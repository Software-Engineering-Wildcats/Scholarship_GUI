
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

public class Controller {

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
        users = test.createUsers();
        for (User user : users) {
            if (username.getText().toString().equals(user.getEmail()) && password.getText().toString().equals(user.getPassword())){
                invalidLogin.setText("Login Success");

                m.changeScene("afterLogin.fmxl");
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