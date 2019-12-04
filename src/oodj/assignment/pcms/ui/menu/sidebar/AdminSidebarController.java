package assignment.pcms.ui.menu.sidebar;

import assignment.pcms.ui.gui.TableProducts;
import assignment.pcms.ui.gui.TableSupplier;
import assignment.pcms.ui.session.Session;
import assignment.pcms.util.WindowLoader;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminSidebarController implements Initializable {

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

    private void closeWindow(){
        Stage closeStage = (Stage) logoutButton.getScene().getWindow();
        closeStage.close();
    }

    @FXML
    void logout(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/login/user_login.fxml"), "Product And Catalog Management System", null);
        Session.destroySession();
        closeWindow();
    }

    @FXML
    void showProducts(ActionEvent event) {
        TableProducts tblProd = new TableProducts();
        tblProd.setVisible(true);
        //WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/user/user_menu.fxml"), "User Menu", null);
    }

    @FXML
    void showProfile(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/user/user_menu.fxml"), "User Menu", null);
    }

    @FXML
    void showSession(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/user/user_menu.fxml"), "User Menu", null);
    }

    @FXML
    void showSuppliers(ActionEvent event) {
        TableSupplier tblSup = new TableSupplier();
        tblSup.setVisible(true);
        //WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/user/user_menu.fxml"), "User Menu", null);
    }

    @FXML
    private void showUser(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/user/user_menu.fxml"), "User Menu", null);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }
}
