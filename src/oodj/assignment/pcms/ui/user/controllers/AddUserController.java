package assignment.pcms.ui.user.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AddUserController implements Initializable {

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
    public void initialize(URL url, ResourceBundle rb) {

    }
}
