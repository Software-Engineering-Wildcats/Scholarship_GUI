import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class fundController {
    App m = new App();
    @FXML
    private Button Submit;

    @FXML
    private TextField accNumber;

    @FXML
    private TextField amtDis;

    @FXML
    private TextField amtSel;

    @FXML
    private Label errorMsg;

    @FXML
    void switchToScene1(ActionEvent event) throws IOException {
        if (accNumber.getText().isEmpty() || amtDis.getText().isEmpty() || amtSel.getText().isEmpty()) {
            errorMsg.setText("Please enter all the fields");
        } else {
            m.changeScene("StuGUI.fxml", "style.css", 1);
        }

    }

    @FXML
    void switchToScene2(ActionEvent event) throws IOException {
        m.changeScene("StuGUI.fxml", "style.css", 1);
    }

}