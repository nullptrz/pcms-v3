package assignment.pcms.ui.user.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class ListUserController implements Initializable {



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> useridCol;

    @FXML
    private TableColumn<User, String> nameCol;

    @FXML
    private TableColumn<User, String> emailAddressCol;

    @FXML
    private TableColumn<User, String> loginNameCol;

    @FXML
    private TableColumn<User, String> userRoleCol;

    @FXML
    private TableColumn<User, String> statusCol;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() throws IOException {
        Collection<User> list = Files.readAllLines(new File("C:\\JavaDev\\pcms-v3\\data\\users.txt").toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split(",");
                    User user = new User();
                    user.setUserid(details[0]);
                    user.setName(details[1]);
                    user.setEmailAddress(details[2]);
                    user.setLoginName(details[3]);
                    user.setUserRole(details[4]);
                    user.setStatus(details[5]);
                    return user;
                })
                .collect(Collectors.toList());

        ObservableList<User> details = FXCollections.observableArrayList(list);

        useridCol.setCellValueFactory(new PropertyValueFactory<>("userid"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailAddressCol.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        loginNameCol.setCellValueFactory(new PropertyValueFactory<>("loginName"));
        userRoleCol.setCellValueFactory(new PropertyValueFactory<>("userRole"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.setItems(details);

    }

    public static class User{
        private final SimpleStringProperty userid = new SimpleStringProperty();
        private final SimpleStringProperty name = new SimpleStringProperty();
        private final SimpleStringProperty emailAddress = new SimpleStringProperty();
        private final SimpleStringProperty loginName = new SimpleStringProperty();
        private final SimpleStringProperty userRole = new SimpleStringProperty();
        private final SimpleStringProperty status = new SimpleStringProperty();

        public void setUserid(String userid) {
            this.userid.set(userid);
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress.set(emailAddress);
        }

        public void setLoginName(String loginName) {
            this.loginName.set(loginName);
        }

        public void setUserRole(String userRole) {
            this.userRole.set(userRole);
        }

        public void setStatus(String status) {
            this.status.set(status);
        }

        public String getUserid() {
            return userid.get();
        }

        public SimpleStringProperty useridProperty() {
            return userid;
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public String getEmailAddress() {
            return emailAddress.get();
        }

        public SimpleStringProperty emailAddressProperty() {
            return emailAddress;
        }

        public String getLoginName() {
            return loginName.get();
        }

        public SimpleStringProperty loginNameProperty() {
            return loginName;
        }

        public String getUserRole() {
            return userRole.get();
        }

        public SimpleStringProperty userRoleProperty() {
            return userRole;
        }

        public String getStatus() {
            return status.get();
        }

        public SimpleStringProperty statusProperty() {
            return status;
        }
    }

}
