import java.io.File;
import java.io.IOException;
import Backend.StudentApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ApplicationCreationSceneController {

    StudentApplication currApplication = new StudentApplication();

    String scholarshipName;

    App m = new App();

    File selectedFile;

    @FXML
    private Button backButton;

    @FXML
    private TextArea ApplicantEssay;

    @FXML
    private TextArea ApplicantAcademicAche;

    @FXML
    private CheckBox ApplicantFinancialAid;

    @FXML
    private TextField ApplicantMajor;

    @FXML
    private TextField ApplicantMinor;

    @FXML
    private TextField ApplicantName;

    @FXML
    private TextField ApplicantNetID;

    @FXML
    private TextField ApplicantStudentID;

    @FXML
    private Button ApplicationSubmit;

    @FXML
    private Button docUpload;

    @FXML
    private Label FilePath;

    @FXML
    public void initialize(){

    }

    @FXML
    void backScene(ActionEvent event) throws IOException {
        m.changeScene("ApplicantGUI.fxml");
    }

    @FXML
    void btnApplicationSubmition(ActionEvent event) {
        try {
            currApplication = new StudentApplication(ApplicantName.getText(), ApplicantNetID.getText(), ApplicantStudentID.getText(), ApplicantMajor.getText(), ApplicantMinor.getText(), ApplicantAcademicAche.getText(), ApplicantFinancialAid.isSelected(), ApplicantEssay.getText());

            //Would be sent to the backend here using the scholarship name as the key
            System.out.println(currApplication.toString());
            System.out.println("ScholarshipName = " + scholarshipName);
            if (selectedFile.exists()){
                System.out.println(selectedFile.getName());
            }
    


            m.changeScene("ApplicantGUI.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("This is where it broke");
        }

    }


    @FXML
    void btnDocUpload(ActionEvent event) {
        Stage m = new Stage();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
        FileChooser file = new FileChooser();
        file.getExtensionFilters().add(extFilter);
        file.setTitle("Open File");
        selectedFile = file.showOpenDialog(m);


        if (file != null){
            Label pthLabel = (Label) FilePath;
            pthLabel.setText(selectedFile.getName());
            

        }

    }

    void setScholarshipName(String name){
        scholarshipName = name;
    }


}
