package assignment.pcms.ui.user;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import assignment.pcms.backend.FileAccess;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserMenuController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField userid;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField emailAddress;

    @FXML
    private JFXComboBox<String> roleCombo;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXComboBox<String> statusCombo;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton cancelButton;


    @FXML
    private StackPane stackPane;

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
    private TableColumn<User, String> roleCol;

    @FXML
    private TableColumn<User, String> statusCol;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userid.setText(generateUserID());
        roleCombo.setItems(roleList);
        statusCombo.setItems(statusList);
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
        roleCol.setCellValueFactory(new PropertyValueFactory<>("userRole"));
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


    @FXML
    void cancel(ActionEvent event) {
        // Testing
        System.out.println("Cancel Button Pressed");
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        String userid = generateUserID();
        String name = this.name.getText();
        String emailAddress = this.emailAddress.getText();
        String role = this.roleCombo.getValue();
        String username = this.username.getText();
        String password = this.password.getText();
        String status = this.statusCombo.getValue();

        String line = userid + "," + name + "," + emailAddress + "," + username + "," + role  + "," + status + "," + password ;

        if(name.isEmpty() || emailAddress.isEmpty() || role.isEmpty() || username.isEmpty() || password.isEmpty() || status.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }

        else if(saveUserFile(line)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("User Details Saved Successfully");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Adding User Details Failed");
            alert.showAndWait();
        }
        // Testing
        loadData();
        System.out.println("Save Button Pressed");
    }

    private boolean saveUserFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\JavaDev\\pcms-v3\\data\\users.txt", true))) {
            bw.write(line);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateUserID(){
        Random random = new Random();
        int num = random.nextInt(9999);
        return "U" + num;
    }

    ObservableList<String> roleList = FXCollections.observableArrayList("Administrator", "Product Manager");
    ObservableList<String> statusList = FXCollections.observableArrayList("Active", "Inactive");

    @FXML
    void setUserStatus(ActionEvent event) throws IOException {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if(selectedUser == null){
            // display error message
        }
        else
            {
                try{
                    FileAccess fa = new FileAccess();
                    fa.setFileName("C:\\JavaDev\\pcms-v3\\data\\users.txt");
                    ArrayList<String> oldData = fa.readFile();
                    PrintWriter newData = new PrintWriter(new FileWriter("C:\\JavaDev\\pcms-v3\\data\\users.txt"));
                    for (String oldLine : oldData) {
                        String[] split = oldLine.split(",");
                        if (split[0].equals(selectedUser.userid.getValue())) {
                            if(selectedUser.status.getValue().equals("Inactive")){

                                newData.println(oldLine.replace("Inactive", "Active"));
                            }
                            else if (selectedUser.status.getValue().equals("Active")) {
                                newData.println(oldLine.replace("Active", "Inactive"));
                            }
                        } else {
                            newData.println(oldLine);
                        }
                    }
                    newData.close();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
        }
        loadData();
    }
}
