
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class StewardGUI extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) {
  
        Parent root;
        try {
            stg = primaryStage;
            primaryStage.setResizable(false);
            root = FXMLLoader.load(getClass().getResource("StuGui.fxml"));
            Scene scene = new Scene(root, 1280, 720);
            scene.getStylesheets().add("/style.css");
              primaryStage.setScene(scene);
              primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
 
 public static void main(String[] args) {  
        launch(args);
    }
}