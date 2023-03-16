import client.ServerThread;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLClientGUIController implements Initializable {

    private ParamServer paramServer;
    @FXML
    private AnchorPane anchor;

    @FXML
    private TextArea mess;

    private ServerThread serverThread;

    @FXML
    private void getStatus(){
        setMessage("запрос статуса от устройства");
        if(!ConnectToServer.connectToServer(serverThread, paramServer)) {
            setMessage("Не удалось подключиться к серверу");
            return;
        }

        Integer[] buf = {0xAA, 0x55, 1, 0, 0, 0, 0};
        int len = buf[3] | ((int)buf[4] << 8);
        Integer[] crc = CrcModbus.calculationCRC(buf, len);
        buf[5] = crc[0];
        buf[6] = crc[1];
        serverThread.setDataServer(buf, buf.length);
    }
    @FXML
    private void getLog(){
        setMessage("запрос логов");
        if(!ConnectToServer.connectToServer(serverThread, paramServer)) {
            setMessage("Не удалось подключиться к серверу");
            return;
        }
    }

    @FXML
    private void setAnalogOutput(){
        setMessage("выбор аналоговых входов");
        new AnalogGUI(serverThread).init();

    }

    @FXML
    private void setDigitalOutput(){


    }

    @FXML
    private void setFrequencyOutput(){


    }

    @FXML
    private void setNetwork(){


    }

    @FXML
    private void getNetwork(){


    }

    @FXML
    private void updata(){

    }

    public void setMessage(String str){
        SwingUtilities.invokeLater(()->{
            mess.appendText(str + "\n");
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setServerThread(ServerThread serverThread){
        this.serverThread = serverThread;
    }

    public void setParamServer(ParamServer paramServer){
        this.paramServer = paramServer;
    }

}
