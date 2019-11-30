package assignment.pcms.ui.user.controllers;

import java.net.URL;
import java.util.ResourceBundle;

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

    ObservableList<User> list = FXCollections.observableArrayList();

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
        initCol();
    }

    private void initCol(){
        useridCol.setCellValueFactory(new PropertyValueFactory<>("userid"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailAddressCol.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        loginNameCol.setCellValueFactory(new PropertyValueFactory<>("loginName"));
        userRoleCol.setCellValueFactory(new PropertyValueFactory<>("userRole"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void loadData(){

    }

    public static class User{
        private final SimpleStringProperty userid;
        private final SimpleStringProperty name;
        private final SimpleStringProperty emailAddress;
        private final SimpleStringProperty loginName;
        private final SimpleStringProperty userRole;
        private final SimpleStringProperty status;



        User(String userid, String name, String emailAddress, String loginName, String userRole, String status){
            this.userid = new SimpleStringProperty(userid);
            this.name = new SimpleStringProperty(name);
            this.emailAddress = new SimpleStringProperty(emailAddress);
            this.loginName = new SimpleStringProperty(loginName);
            this.userRole = new SimpleStringProperty(userRole);
            this.status = new SimpleStringProperty(status);

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
