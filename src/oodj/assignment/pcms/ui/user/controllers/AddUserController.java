package assignment.pcms.ui.user.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private JFXComboBox<String> roleCombo;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXComboBox<String> statusCombo;

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
        String userid = generateUserID();
        String name = this.name.getText();
        String emailAddress = this.emailAddress.getText();
        String role = this.roleCombo.getValue();
        String username = this.username.getText();
        String password = this.password.getText();
        String status = this.statusCombo.getValue();

        String line = userid + "," + name + "," + emailAddress + "," + role + "," + username + "," + password + "," + status;

        saveUserFile(line);
                // Testing
        System.out.println("Save Button Pressed");
    }

    private void saveUserFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\JavaDev\\pcms-v3\\data\\users.txt", true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private String generateUserID(){
        Random random = new Random();
        int num = random.nextInt(9999);
        String userid = "U" + num;
        return userid;

    }

    ObservableList<String> roleList = FXCollections.observableArrayList("Administrator", "Product Manager");
    ObservableList<String> statusList = FXCollections.observableArrayList("Active", "Inactive");

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        userid.setText(generateUserID());
        roleCombo.setItems(roleList);
        statusCombo.setItems(statusList);
    }
}
