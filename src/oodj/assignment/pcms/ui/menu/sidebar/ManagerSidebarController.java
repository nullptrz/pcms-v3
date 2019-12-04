package assignment.pcms.ui.menu.sidebar;

import assignment.pcms.ui.gui.TableCategory;
import assignment.pcms.ui.gui.TableProducts;
import assignment.pcms.util.WindowLoader;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ManagerSidebarController implements Initializable {

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

    private void closeWindow(){
        Stage closeStage = (Stage) logoutButton.getScene().getWindow();
        closeStage.close();
    }

    @FXML
    void logout(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/login/user_login.fxml"), "Product And Catalog Management System", null);
        closeWindow();
    }

    @FXML
    void showCatalogs(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/catalog/catalog_menu.fxml"), "Product And Catalog Management System", null);
    }

    @FXML
    void showCategories(ActionEvent event) {
        //WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/login/user_login.fxml"), "Product And Catalog Management System", null);
        TableCategory tblCat = new TableCategory();
        tblCat.setVisible(true);
    }

    @FXML
    void showProducts(ActionEvent event) {
        TableProducts tblProducts = new TableProducts();
        tblProducts.setVisible(true);
        //WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/login/user_login.fxml"), "Product And Catalog Management System", null);
    }

    @FXML
    void showProfile(ActionEvent event) {
        WindowLoader.loadWindow(getClass().getResource("/assignment/pcms/ui/login/user_login.fxml"), "Product And Catalog Management System", null);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }
}

