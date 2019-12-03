package assignment.pcms.ui.user;

import assignment.pcms.backend.FileAccess;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditUserController {

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
    private JFXTextField loginName;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        // Testing
        System.out.println("Cancel Button Pressed");
    }

    @FXML
    void saveUser(ActionEvent event) {
        try{
            FileAccess fa = new FileAccess();
            fa.setFileName("C:\\JavaDev\\pcms-v3\\data\\users.txt");
            ArrayList<String> oldData = fa.readFile();
            PrintWriter newData = new PrintWriter(new FileWriter("C:\\JavaDev\\pcms-v3\\data\\users.txt"));
            for (String oldLine : oldData) {
                String[] split = oldLine.split(",");
                if (split[0].equals(userid.getText())) {
                    String newLine = userid.getText() + "," + name.getText() + "," + emailAddress.getText() + "," + loginName.getText() + ","  + split[4] + "," + split[5] + ","  + split[6];
                    newData.println(newLine);
                } else {
                    newData.println(oldLine);
                }
            }
            newData.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {


    }

    ObservableList<String> roleList = FXCollections.observableArrayList("Administrator", "Product Manager");

    public void setFields(User user){
        name.setText(user.getName());
        emailAddress.setText(user.getEmailAddress());
        loginName.setText(user.getLoginName());
        userid.setText(user.getUserid());
    }
}
