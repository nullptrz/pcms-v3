package assignment.pcms.ui.menu.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ProductManagerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initDrawer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDrawer() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../sidebar/manager_sidebar.fxml"));
            VBox managerSideBar = loader.load();
            drawer.setSidePane(managerSideBar);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> drawer.toggle());
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.toFront();
        });
        drawer.setOnDrawerClosing((event) -> {
            drawer.toBack();
            task.setRate(task.getRate() * -1);
            task.play();
        });
    }

    void loadWindow(String loc, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
