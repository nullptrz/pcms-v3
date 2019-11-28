package assignment.pcms.ui.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserLogin extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/user_login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Product And Catalog Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args);}
}
