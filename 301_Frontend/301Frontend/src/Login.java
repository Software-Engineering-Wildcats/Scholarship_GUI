
import java.io.IOException;
import java.util.ArrayList;

import Backend.AppData;
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

    private UserTest users;
    private AppData currUser = AppData.getInstance();
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

    public void initialize(){
        if (users == null){
        users = new UserTest();
        }
    }

    private void checkLogin() throws IOException{
        for (User user : users.getUsers()) {
            if (username.getText().toString().equals(user.getEmail()) && password.getText().toString().equals(user.getPassword())){
                invalidLogin.setText("Login Success");
                if (user.getUserType() == 1){
                    currUser.setSharedVariable(user);
                    m.changeScene("ApplicantGUI.fxml");
                }
                else if (user.getUserType() == 2){
                    currUser.setSharedVariable(user);
                    m.changeScene("AdminGUI.fxml");
                }
                else if (user.getUserType() == 3){
                    currUser.setSharedVariable(user);
                    m.changeScene("ReviewerGUI.fxml");
                }
                else if (user.getUserType() == 4){
                    currUser.setSharedVariable(user);
                    m.changeScene("SponsorGUI.fxml");
                }
                else if (user.getUserType() == 5){
                    currUser.setSharedVariable(user);
                    m.changeScene("StewardGUI.fxml");
                }
                else if (user.getUserType() == 6){
                    currUser.setSharedVariable(user);
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

    public void setUser (UserTest users){
        this.users = users;
    }

}