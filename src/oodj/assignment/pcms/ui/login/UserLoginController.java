package assignment.pcms.ui.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton loginButton;

    @FXML
    void login(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        if(user.equals("admin") && pass.equals("admin")){
            System.out.println("Welcome admin");
        }
        else {
            System.out.println("Wrong username or password");
        }
    }

    @FXML
    void initialize() {

    }
}
