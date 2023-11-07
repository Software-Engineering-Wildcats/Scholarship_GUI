import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button logInButton;
    @FXML
    private Label invalidLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    private App m = new App();


    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException{
        if (username.getText().toString().equals("samnperry@arizona.edu") && password.getText().toString().equals("123")){
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