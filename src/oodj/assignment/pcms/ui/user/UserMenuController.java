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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UserMenuController implements Initializable {

    final ObservableList<User> data = FXCollections.observableArrayList();

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
    private JFXTextField searchField;


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

        data.addAll(list);

        useridCol.setCellValueFactory(new PropertyValueFactory<>("userid"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailAddressCol.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        loginNameCol.setCellValueFactory(new PropertyValueFactory<>("loginName"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("userRole"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.setItems(details);

    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
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
                        if (split[0].equals(selectedUser.getUserid())) {
                            if(selectedUser.getStatus().equals("Inactive")){

                                newData.println(oldLine.replace("Inactive", "Active"));
                            }
                            else if (selectedUser.getStatus().equals("Active")) {
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

    @FXML
    void searchUser(KeyEvent event) {
        FilteredList<User> filteredData = new FilteredList<>(data, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue ) -> {
            filteredData.setPredicate(user -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(user.getEmailAddress().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(user.getLoginName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });

        SortedList<User> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }


    @FXML
    void showEdit(ActionEvent event) {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if(selectedUser == null) {
            //display error
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource( "/assignment/pcms/ui/user/edit_user.fxml"));
            Parent parent = loader.load();
            EditUserController controller = (EditUserController) loader.getController();
            assert selectedUser != null;
            controller.setFields(selectedUser);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit User Details");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
