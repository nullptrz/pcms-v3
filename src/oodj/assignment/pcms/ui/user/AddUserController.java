package assignment.pcms.ui.user;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField userid;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField emailAddress;

    @FXML
    private JFXComboBox<?> roleCombo;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    void cancel(ActionEvent event) {
        // Testing
        System.out.println("Cancel Button Pressed");
    }

    @FXML
    void save(ActionEvent event) {
        // Testing
        System.out.println("Save Button Pressed");
    }

    @FXML
    void initialize() {
        assert userid != null : "fx:id=\"userid\" was not injected: check your FXML file 'add_user.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'add_user.fxml'.";
        assert emailAddress != null : "fx:id=\"emailAddress\" was not injected: check your FXML file 'add_user.fxml'.";
        assert roleCombo != null : "fx:id=\"roleCombo\" was not injected: check your FXML file 'add_user.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'add_user.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'add_user.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'add_user.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'add_user.fxml'.";

    }
}
