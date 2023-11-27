import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Stewcontroller {

    @FXML
    private TextField tfTitle;

    @FXML
    private Button Submit;
    @FXML
    private Button LOut;
     @FXML
    private TableView<Info> Table_View;
    
    @FXML
    private TableColumn<Info, Integer> coulStudentID;

    @FXML
    private TableColumn<Info, String> coulStudentName;

    @FXML
    private TableColumn<Info, String> coulStatus;

    @FXML
    private TableColumn<Info, Integer> coulFunds;

    @FXML
    public void initialize() {
        // Set up the cell value factories
        coulStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        coulStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        coulStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        coulFunds.setCellValueFactory(new PropertyValueFactory<>("funds"));

        // Dummy Data
        ObservableList<Info> data = FXCollections.observableArrayList(
            new Info(1001, "Alice Smith", "Active", 5000),
            new Info(1002, "Bob Johnson", "Inactive", 3000),
            new Info(1003, "Charlie Brown", "Active", 4500),
            new Info(1004, "Diana Ross", "Graduated", 2500),
            new Info(1005, "Evan Wright", "Suspended", 1500)
        );

        // Set the data to the table
        Table_View.setItems(data);
    }

 private Stage stage;
 private Scene scene;
 private Parent root;
 
 public void switchToScene1(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("StuGui.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  scene.getStylesheets().add("/style.css");
  stage.setScene(scene);
  stage.show();
 }
 
 public void switchToScene2(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("fundGui.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  scene.getStylesheets().add("/style.css");
  stage.setScene(scene);
  stage.show();
 }
  public void switchToScene0(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  scene.getStylesheets().add("/style.css");
  stage.setScene(scene);
  stage.show();
 }
}


