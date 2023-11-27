import java.io.IOException;

import Backend.AppData;
import Backend.Feedback;
import Backend.User;
import Backend.UserTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class ManageAccountGUIController {
    //// Statics

    // observable list for lvUsers
    private ObservableList<User> userList = FXCollections.observableArrayList();

    // Scene change
    private App m = new App();

    // passed in user
    AppData currUser = AppData.getInstance();

    // selected user
    User selectedUser;

    @FXML
    private Button btCreate;

    @FXML
    private Button btDelete;

    @FXML
    private Button btEdit;

    @FXML
    private Button btFeedback;

    @FXML
    private Button btLogOut;

    @FXML
    private Button btManageAccount;

    @FXML
    private ChoiceBox<String> cbUserType;

    @FXML
    private ListView<User> lvAccounts;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPassword;

    @FXML
    private Text tfSupportName;

    //// Scripts
    @FXML
    void btCreateClicked(ActionEvent event) {
        User u = new User(tfEmail.getText(), tfPassword.getText(), tfName.getText(), cbUserType.getValue());
        userList.add(u);
        lvAccounts.setItems(userList);

        System.out.println("*****************"
                + "\nMock call to create User in backend\nCreated applicant is:"
                + "\nName: " + tfName.getText()
                + "\nEmail: " + tfEmail.getText()
                + "\nPassword: " + tfPassword.getText()
                + "\nUser Type: " + cbUserType.getValue());
    }

    @FXML
    void btEditClicked(ActionEvent event) {
        selectedUser.setName(tfName.getText());
        selectedUser.setEmail(tfEmail.getText());
        selectedUser.setPassword(tfPassword.getText());
        selectedUser.setUserType(cbUserType.getValue());

        System.out.println("*****************"
                + "\nMock call to edit User in backend\nEdited applicant is:"
                + "\nName: " + tfName.getText()
                + "\nEmail: " + tfEmail.getText()
                + "\nPassword: " + tfPassword.getText()
                + "\nUser Type: " + cbUserType.getValue());
    }

    @FXML
    void btLogOutClicked(ActionEvent event) {
        try {
            m.changeScene("LoginScene.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btManageAccountClicked(ActionEvent event) {
        try {
            m.changeScene("ManageAccountGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btManageFeedbackClicked(ActionEvent event) {
        try {
            m.changeScene("SupportGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        // get passed in user name
        tfSupportName.setText(currUser.getSharedVariable().getName());

        //// For cbReviewerRating
        // create data for cbReviewerRating
        cbUserType.setItems(
                FXCollections.observableArrayList("Applicant", "Admin", "Reviewer", "Sponsor", "Steward", "Support"));
        cbUserType.setValue("Applicant");

        //// for lvUsers
        // add sample data to listView
        UserTest testUsers = new UserTest();
        userList.addAll(testUsers.getUsers());

        //// For btDelete
        btDelete.setOnAction(event -> {
            // Get selected index
            System.out.println("*****************"
                    + "\nMock call to delete User in backend\nDeleted applicant is:"
                    + "\nName: " + tfName.getText()
                    + "\nEmail: " + tfEmail.getText()
                    + "\nPassword: " + tfPassword.getText()
                    + "\nUser Type: " + cbUserType.getValue());
            int selectedIndex = lvAccounts.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                // Remove item from the ObservableList
                userList.remove(selectedIndex);
                lvAccounts.setItems(userList);
            }
        });

        // set lvAccounts to sample data
        lvAccounts.setItems(userList);

        // create an event listener for applications selection
        lvAccounts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // set account info fields;
                tfName.setText(newValue.getName());
                tfEmail.setText(newValue.getEmail());
                cbUserType.setValue(Feedback.typeToString(newValue.getUserType()));
                tfPassword.setText(newValue.getPassword());

                // pass globally for final selection
                selectedUser = newValue;
            }
        });

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        lvAccounts.setCellFactory(new Callback<>() {
            @Override
            public ListCell<User> call(ListView<User> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(User user, boolean empty) {
                        super.updateItem(user, empty);

                        if (empty || user == null) {
                            setText(null);
                        } else {
                            setText(user.getName());
                        }

                    }
                };
            }
        });
    }
}
