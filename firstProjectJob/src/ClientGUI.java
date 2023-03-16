import client.ServerThread;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientGUI extends Stage {
    private Stage mainStage;

    private ServerThread serverThread;

    private ParamServer paramServer;


    public ClientGUI(Stage mainStage, ServerThread serverThread, ParamServer paramServer) {
        this.mainStage = mainStage;
        this.serverThread = serverThread;
        this.paramServer = paramServer;
    }

    public void init(){
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLClientGUI.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);
            setScene(scene);
            setTitle("Обмен данными с сервером");
            FXMLClientGUIController controller = loader.getController();
            controller.setServerThread(serverThread);
            controller.setParamServer(paramServer);
            mainStage.close();
            //new LinkServer(serverThread).start();
            show();
        }
        catch (IOException e){

        }
    }
}
