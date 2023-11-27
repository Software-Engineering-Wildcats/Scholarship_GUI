import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Backend.StudentApplication;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;


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
    private TextField ApplicantMajor;

    @FXML
    private TextField ApplicantMinor;

    @FXML
    private TextField ApplicantName;

    @FXML
    private TextField ApplicantNetID;

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
            Long temp = Long.parseLong(ApplicantNetID.getText());
            currApplication = new StudentApplication(ApplicantName.getText(), temp, ApplicantMajor.getText(), ApplicantMinor.getText(), ApplicantEssay.getText());

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
