package assignment.pcms.ui.login;

import assignment.pcms.ui.other.FileAccess;
import assignment.pcms.ui.user.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        String userlogin = username.getText().trim();
        String pass = password.getText().trim();
        FileAccess fa = new FileAccess();
        fa.setFileName("C:\\JavaDev\\pcms-v3\\data\\users.txt");
        ArrayList<String> userdata = fa.readFile();

        for (String line:userdata) {
            User user = new User();
            String[] tokens = line.split(",");
            user.setLoginName(tokens[3]);
            user.setPassword(tokens[6]);
            user.setUserRole(tokens[4]);
            user.setStatus(tokens[5]);

            if(user.getLoginName().equals(userlogin) && user.getPassword().equals(pass)){
                if(user.getStatus().equals("Active")){
                    if(user.getUserRole().toLowerCase().equals("administrator")) {
                        closeWindow();
                        loadAdmin();
                    }
                    else {
                        closeWindow();
                        loadProductManager();
                    }
                }
            }
        }

    }

    private void loadAdmin(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../menu/fxml/admin_menu.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Administrator Dashboard");
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void closeWindow(){
        Stage closeStage = (Stage) loginButton.getScene().getWindow();
        closeStage.close();
    }

    private void loadProductManager(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../menu/fxml/manager_menu.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Product Manager Dashboard");
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    @FXML
    void initialize() {

    }
}
