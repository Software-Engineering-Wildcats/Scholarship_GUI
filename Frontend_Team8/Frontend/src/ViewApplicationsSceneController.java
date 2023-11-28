import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Backend.StudentApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class ViewApplicationsSceneController {

    App m = new App();

    List<StudentApplication> applicationTest = new ArrayList();

    StudentApplication currentFood;

    String scholarshipName;

    @FXML
    private Label listInfo;

    @FXML
    private Button backButton;

    @FXML
    private TextField EssayField;

    @FXML
    private TextField AcademicAcheField;

    @FXML
    private TextField NetIDField;

    @FXML
    private CheckBox financialAidField;

    @FXML
    private TextField MajorField;

    @FXML
    private TextField MinorField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField StudentIDField;

    @FXML
    private Button Submit;

    @FXML
    private ListView<StudentApplication> listy;

    // If we had a backend database, this function would actually take the data
    // straight from the backend, and since in
    // AccountCreationController we "upload" the data of the scholarship name into
    // the database we would simply pull it out
    // of the database in order to label the scholarships correctly. Because of this
    // complication I used "Placeholder" to
    // demonstrate that there would normally be a varaible there.

    public void initialize() {

        applicationTest = testApplication();

        for (int i = 0; i < applicationTest.size(); i++) {
            listy.getItems().add(applicationTest.get(i));
        }

        // set cellfactory to change the data in list view to just name
        // uses anonymous inner class
        listy.setCellFactory(new Callback<>() {
            @Override
            public ListCell<StudentApplication> call(ListView<StudentApplication> listy) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(StudentApplication person, boolean empty) {
                        super.updateItem(person, empty);

                        if (empty || person == null) {
                            setText(null);
                        } else {
                            setText("Placeholder");
                        }
                    }
                };
            }
        });

        listy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentApplication>() {

            @Override
            public void changed(ObservableValue<? extends StudentApplication> arg0, StudentApplication arg1,
                    StudentApplication arg2) {

                currentFood = listy.getSelectionModel().getSelectedItem();

                listInfo.setText(currentFood.toString());

            }

        });

    }

    public void setScholarshipName(String name) {
        scholarshipName = name;

    }

    private List<StudentApplication> testApplication() {
        List<StudentApplication> temp = new ArrayList();

        StudentApplication a = new StudentApplication();
        StudentApplication f = new StudentApplication("The Application", "testm", "1234567890", "SFWE", "MSE",
                "Dean's List", true,
                "When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. The rainbow is a division of white light into many beautiful colors. These take the shape of a long round arch, with its path high above, and its two ends apparently beyond the horizon. There is, according to legend, a boiling pot of gold at one end. People look, but no one ever finds it. When a man looks for something beyond his reach, his friends say he is looking for the pot of gold at the end of the rainbow.");

        temp.add(a);
        temp.add(f);

        return temp;

    }

    // Logic of the if statements here doesn't actally work maybe?

    @FXML
    void btnSubmit(ActionEvent event) {

        if (!NameField.getText().isEmpty()) {
            currentFood.setName(NameField.getText());
        }
        if (!NetIDField.getText().isEmpty()) {
            currentFood.setNetID(NetIDField.getText());
        }
        if (!StudentIDField.getText().isEmpty()) {
            currentFood.setstudentID(StudentIDField.getText());
        }
        if (!MajorField.getText().isEmpty()) {
            currentFood.setMajor(MajorField.getText());
        }
        if (!MinorField.getText().isEmpty()) {
            currentFood.setMinor(MinorField.getText());
        }
        if (!AcademicAcheField.getText().isEmpty()) {
            currentFood.setacademicAche(AcademicAcheField.getText());
        }
        if (!EssayField.getText().isEmpty()) {
            currentFood.setEssay(EssayField.getText());
        }
        currentFood.setfinancialAid(financialAidField.isSelected());

        // This is everything being sent to the backend, it would update the stuff
        System.out.println("This information would be updated to the backend.");
        System.out.println(currentFood.toString());

        try {
            m.changeScene("ApplicantGUI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void backScene(ActionEvent event) throws IOException {
        m.changeScene("ApplicantGUI.fxml");
    }

}