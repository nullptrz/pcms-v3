package assignment.pcms.ui.menu.sidebar;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class AdminSidebarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton userButton;

    @FXML
    private JFXButton supplierButton;

    @FXML
    private JFXButton productButton;

    @FXML
    private ImageView showProducts;

    @FXML
    private JFXButton sessionButton;

    @FXML
    private JFXButton profileButton;

    @FXML
    private JFXButton logoutButton;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void showProducts(ActionEvent event) {

    }

    @FXML
    void showProfile(ActionEvent event) {

    }

    @FXML
    void showSession(ActionEvent event) {

    }

    @FXML
    void showSuppliers(ActionEvent event) {

    }

    @FXML
    void showUser(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert userButton != null : "fx:id=\"userButton\" was not injected: check your FXML file 'admin_sidebar.fxml'.";
        assert supplierButton != null : "fx:id=\"supplierButton\" was not injected: check your FXML file 'admin_sidebar.fxml'.";
        assert productButton != null : "fx:id=\"productButton\" was not injected: check your FXML file 'admin_sidebar.fxml'.";
        assert showProducts != null : "fx:id=\"showProducts\" was not injected: check your FXML file 'admin_sidebar.fxml'.";
        assert sessionButton != null : "fx:id=\"sessionButton\" was not injected: check your FXML file 'admin_sidebar.fxml'.";
        assert profileButton != null : "fx:id=\"profileButton\" was not injected: check your FXML file 'admin_sidebar.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'admin_sidebar.fxml'.";

    }
}
