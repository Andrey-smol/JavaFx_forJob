import client.ServerThread;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainGUIController implements Initializable {

    @FXML
    private TextField ipHostText;

    @FXML
    private TextField portHostText;

    @FXML
    private Button signIn;

    @FXML
    private Text message;

    private Stage stage;

    private ServerThread serverThread;

    @FXML
    private void clearMessage(){
        message.setText("");
    }

    @FXML
    private void connectServer(){
        if(ipHostText.getText().isEmpty()){
            setMessage("Не введён ip адрес", Message.ERROR);
            return;
        }
        if(portHostText.getText().isEmpty()){
            setMessage("Не определён порт подключения", Message.ERROR);
            return;
        }

        try{
            serverThread = new ServerThread(ipHostText.getText(), portHostText.getText());
            serverThread.start();
        }
        catch (IOException e){
            setMessage("Не удалось подключиться к серверу", Message.ERROR);
            serverThread = null;
            return;
        }

        new ClientGUI(stage, serverThread, new ParamServer(ipHostText.getText(), portHostText.getText())).init();
    }

    public void setMessage(String mess, Message value){
        SwingUtilities.invokeLater(()-> {
            message.setText(mess);
            if (value == Message.ERROR) message.setFill(javafx.scene.paint.Color.RED);
            if (value == Message.WARNING) message.setFill(Color.YELLOW);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

}
