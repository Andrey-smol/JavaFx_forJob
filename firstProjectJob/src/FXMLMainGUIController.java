import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainGUIController implements Initializable {

    @FXML
    javafx.scene.control.TextField ipHostText;

    @FXML
    TextField portHostText;

    @FXML
    javafx.scene.control.Button signIn;

    @FXML
    private void clearMessage(){}

    @FXML
    private void connectServer(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
