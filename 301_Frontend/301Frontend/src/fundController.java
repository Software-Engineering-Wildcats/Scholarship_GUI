import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class fundController {
private Stage stage;
 private Scene scene;
 private Parent root;
    @FXML
    private Button Submit;

    @FXML
    void switchToScene1(ActionEvent event) {
        
 try {
    root = FXMLLoader.load(getClass().getResource("StuGui.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  scene.getStylesheets().add("/style.css");
  stage.setScene(scene);
  stage.show();
} catch (IOException e) {
    
    e.printStackTrace();
}

    }

}