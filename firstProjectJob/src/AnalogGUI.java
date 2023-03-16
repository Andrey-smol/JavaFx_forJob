import client.ServerThread;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AnalogGUI extends Stage {

    private ServerThread serverThread;

    public AnalogGUI(ServerThread serverThread) {
        this.serverThread = serverThread;
    }



    public void init(){
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAnalogGUI.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);

            setScene(scene);
            setTitle("Установка аналогового входа");
            initModality(Modality.APPLICATION_MODAL);
            showAndWait();
        }
        catch (IOException e){

        }

    }
}
