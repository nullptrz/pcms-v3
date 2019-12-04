package assignment.pcms.ui.catalog;

import assignment.pcms.ui.other.Items;
import assignment.pcms.util.PDFMaker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class CatalogController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane stackPane;


    @FXML
    private JFXButton addButton;

    @FXML
    private JFXButton removeButton;

    @FXML
    private TableView<Items> tableSelProd;

    @FXML
    private TableColumn<Items, String> itemNameCol;

    @FXML
    private TableColumn<Items, String> itemBrandCol;

    @FXML
    private TableColumn<Items, Double> priceCol;

    @FXML
    private TableView<Items> tableCatProd;

    @FXML
    private TableColumn<Items, String> itemNameCatCol;

    @FXML
    private TableColumn<Items, String> itemBrandCatCol;

    @FXML
    private TableColumn<Items, Double> priceCatCol;

    @FXML
    private JFXComboBox<String> occasionCombo;

    @FXML
    private JFXComboBox<String> discountCombo;

    @FXML
    private JFXTextField searchText;

    @FXML
    private TableView<?> tableCat;

    @FXML
    private TableColumn<Catalog, ?> refNumCol;

    @FXML
    private TableColumn<Catalog, String> catTitleCol;

    @FXML
    private TableColumn<Catalog, String> catDescCol;

    @FXML
    private TableColumn<Catalog, String> seasonPeriodCol;

    @FXML
    private TableColumn<Catalog, String> creatorCol;

    @FXML
    private TableColumn<Catalog, String> dateCreatedCol;

    @FXML
    private TableColumn<Catalog, String> timeCreatedCol;

    public CatalogController() throws IOException {
    }

    ArrayList<Items> catItem = new ArrayList<>();
    ObservableList<Items> itemList = FXCollections.observableArrayList();
    ObservableList<Items> prodList = FXCollections.observableArrayList();
    @FXML
    void createCatalog(ActionEvent event) {
        if(catItem.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.getDialogPane();
            alert.setContentText("There are no products added to catalog table!");
            alert.showAndWait();

        }
        else {
            String catalogFile = occasionCombo.getSelectionModel().getSelectedItem() + ".pdf";;
            PDFMaker.createPDF(catalogFile, catItem, discountCombo.getSelectionModel().getSelectedItem());

        }

    }


    @FXML
    void removeProduct(ActionEvent event) {
        Items selectedItem = tableCatProd.getSelectionModel().getSelectedItem();
        //prodList.add(selectedItem);
        //itemList.remove(selectedItem);
        catItem.remove(selectedItem);



        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemBrandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));

        tableSelProd.getItems().add(selectedItem);
        tableCatProd.getItems().remove(selectedItem);

    }


    @FXML
    void addProduct(ActionEvent event) {
       Items selectedItem = tableSelProd.getSelectionModel().getSelectedItem();
       //itemList.add(selectedItem);
       //prodList.remove(selectedItem);

        itemNameCatCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemBrandCatCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        priceCatCol.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));

        catItem.add(selectedItem);
        tableSelProd.getItems().remove(selectedItem);
        //tableCatProd.setItems(itemList);
        tableCatProd.getItems().add(selectedItem);
    }



    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        List<String> occasionList = null;
        List<String> discountList = null;
        prodList.addAll(tableSelProd.getItems());

        try {
            loadData();
            occasionList = Files.lines(Paths.get("C:\\JavaDev\\pcms-v3\\data\\occasion.txt")).collect(Collectors.toList());
            occasionCombo.setItems(FXCollections.observableArrayList(occasionList));
            discountList = Files.lines(Paths.get("C:\\JavaDev\\pcms-v3\\data\\discount.txt")).collect(Collectors.toList());
            discountCombo.setItems(FXCollections.observableArrayList(discountList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() throws IOException {
        Collection<Items> list = Files.readAllLines(new File("C:\\JavaDev\\pcms-v3\\Items.txt").toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split("\\|");
                    Items item = new Items();
                    double price = Double.parseDouble(details[4]);
                    item.setName(details[1]);
                    item.setBrand(details[2]);
                    item.setRetailPrice(price);
                    return item;
                })
                .collect(Collectors.toList());

        ObservableList<Items> details = FXCollections.observableArrayList(list);


        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemBrandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));


        tableSelProd.setItems(details);

    }
}
