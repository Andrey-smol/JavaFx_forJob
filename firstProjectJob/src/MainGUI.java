

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage stage) {
        Parent parent = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMainGUI.fxml"));
            parent = loader.load();

            Scene scene = new Scene(parent);
            stage.setTitle("Connect Server");
            stage.setScene(scene);
            FXMLMainGUIController controller = loader.getController();
            controller.setStage(stage);
            stage.show();

        }
        catch(IOException e){
            System.out.println("Error----" + e.getMessage());
        }

    }

    public static void main(String... args){
        launch(args);
    }
}
