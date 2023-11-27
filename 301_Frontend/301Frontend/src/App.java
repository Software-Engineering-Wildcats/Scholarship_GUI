import java.io.IOException;

import Backend.UserTest;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    private static Stage stg;
    private Scene scene;
    @Override
    public void start(Stage primaryStage) {
  
        Parent root;
        try {
            stg = primaryStage;
            primaryStage.setResizable(false);
            root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene scene = new Scene(root, 1280, 720);
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
    public void changeScene(String fxml, UserTest users) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = (Parent) loader.load();

        Login controller = loader.getController();
        controller.setUser(users);
        stg.getScene().setRoot(root);
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
    public void changeScene(String fxml, String css, int num) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(pane);

        // Add the CSS file to the new scene
        newScene.getStylesheets().add(css);

        // Set the new scene as the root of the stage
        stg.setScene(newScene);
    }

 public static void main(String[] args) {  
        launch(args);
    }
}