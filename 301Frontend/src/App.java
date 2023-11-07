import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) {
  
        Parent root;
        try {
            stg = primaryStage;
            primaryStage.setResizable(false);
            root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene scene = new Scene(root, 600, 400);
              primaryStage.setTitle("Login Page");
              primaryStage.setScene(scene);
              primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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