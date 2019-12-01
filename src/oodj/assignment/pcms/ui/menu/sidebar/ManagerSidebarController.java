package assignment.pcms.ui.menu.sidebar;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerSidebarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton productButton;

    @FXML
    private JFXButton categoryButton;

    @FXML
    private JFXButton catalogButton;

    @FXML
    private JFXButton profileButton;

    @FXML
    private JFXButton logoutButton;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void showCatalogs(ActionEvent event) {

    }

    @FXML
    void showCategories(ActionEvent event) {

    }

    @FXML
    void showProducts(ActionEvent event) {

    }

    @FXML
    void showProfile(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert productButton != null : "fx:id=\"productButton\" was not injected: check your FXML file 'manager_sidebar.fxml'.";
        assert categoryButton != null : "fx:id=\"categoryButton\" was not injected: check your FXML file 'manager_sidebar.fxml'.";
        assert catalogButton != null : "fx:id=\"catalogButton\" was not injected: check your FXML file 'manager_sidebar.fxml'.";
        assert profileButton != null : "fx:id=\"profileButton\" was not injected: check your FXML file 'manager_sidebar.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'manager_sidebar.fxml'.";

    }
}
