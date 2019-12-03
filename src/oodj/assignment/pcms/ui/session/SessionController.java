package assignment.pcms.ui.session;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SessionController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Session> tableView;

    @FXML
    private TableColumn<Session, String> sessionidCol;

    @FXML
    private TableColumn<Session, String> loginNameCol;

    @FXML
    private TableColumn<Session, String> dateCol;

    @FXML
    private TableColumn<Session, String> loginCol;

    @FXML
    private TableColumn<Session, String> logoutCol;

    @FXML
    private TableColumn<Session, String> durationCol;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }
}
