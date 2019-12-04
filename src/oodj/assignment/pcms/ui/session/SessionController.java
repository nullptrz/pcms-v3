package assignment.pcms.ui.session;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import assignment.pcms.ui.user.User;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SessionController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<SessionData> tableView;

    @FXML
    private TableColumn<SessionData, String> sessionidCol;

    @FXML
    private TableColumn<SessionData, String> loginNameCol;

    @FXML
    private TableColumn<SessionData, String> dateCol;

    @FXML
    private TableColumn<SessionData, String> loginCol;

    @FXML
    private TableColumn<SessionData, String> logoutCol;


    @FXML
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() throws IOException {
        Collection<SessionData> list = Files.readAllLines(new File("C:\\JavaDev\\pcms-v3\\data\\session.txt").toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split(",");
                    SessionData session = new SessionData();
                    session.setSessionID(details[0]);
                    session.setLoginName(details[1]);
                    session.setDate(details[2]);
                    session.setLoginTime(details[3]);
                    session.setLogoutTime(details[4]);
                    return session;
                })
                .collect(Collectors.toList());

        ObservableList<SessionData> details = FXCollections.observableArrayList(list);


        sessionidCol.setCellValueFactory(new PropertyValueFactory<>("sessionID"));
        loginNameCol.setCellValueFactory(new PropertyValueFactory<>("loginName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        loginCol.setCellValueFactory(new PropertyValueFactory<>("loginTime"));
        logoutCol.setCellValueFactory(new PropertyValueFactory<>("logoutTime"));

        tableView.setItems(details);
    }


}
