package assignment.pcms.ui.catalog;

import assignment.pcms.ui.other.Product;
import assignment.pcms.util.PDFMaker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

public class CatalogController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane stackPane;

    @FXML
    private TableView<Product> tableSelProd;

    @FXML
    private TableColumn<Product, String> itemNameCol;

    @FXML
    private TableColumn<Product, String> itemBrandCol;

    @FXML
    private TableColumn<Product, String> quantityCol;

    @FXML
    private TableView<Product> tableCatProd;

    @FXML
    private TableColumn<Product, String> itemNameCatCol;

    @FXML
    private TableColumn<Product, String> itemBrandCatCol;

    @FXML
    private TableColumn<Product, String> quantityCatCol;

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

    @FXML
    void createCatalog(ActionEvent event) {

        String catalogFile = null;
        PDFMaker.createPDF("");
    }



    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        List<String> occasionList = null;
        List<String> discountList = null;
        try {
            occasionList = Files.lines(Paths.get("C:\\JavaDev\\pcms-v3\\data\\occasion.txt")).collect(Collectors.toList());
            occasionCombo.setItems(FXCollections.observableArrayList(occasionList));
            discountList = Files.lines(Paths.get("C:\\JavaDev\\pcms-v3\\data\\discount.txt")).collect(Collectors.toList());
            discountCombo.setItems(FXCollections.observableArrayList(discountList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
