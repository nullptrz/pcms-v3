package assignment.pcms.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class WindowLoader {
    public static void loadWindow(URL loc, String title, Stage parentStage){
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if(parentStage != null){
                stage = parentStage;
            }
            else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
