import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    private static Stage stg;
    
    @Override
    public void start(Stage primaryStage) {

  Parent root;

    try {
        stg = primaryStage;
        primaryStage.setResizable(false);
        root = FXMLLoader.load(getClass().getResource("ApplicantGUI.fxml"));
        Scene scene = new Scene(root, 1280, 720);
          primaryStage.setScene(scene);
          primaryStage.show();

} 

    catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
 
    public void changeScene(String fxml, String name) throws IOException {
        //Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        //Black magic to get a variable across scenes

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = (Parent) loader.load();

        stg.getScene().setRoot(root);
        ApplicationCreationSceneController controller = loader.getController();
        controller.setScholarshipName(name);

    }


 public static void main(String[] args) {
        launch(args);
    }
}
