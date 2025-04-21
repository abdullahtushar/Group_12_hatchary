package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewStockItemInventory {
    @javafx.fxml.FXML
    private TextField unitTF;
    @javafx.fxml.FXML
    private TextField reorderThresholdTF;
    @javafx.fxml.FXML
    private TextField initialQuantityTF;
    @javafx.fxml.FXML
    private TextField itemNameTF;
    @javafx.fxml.FXML
    private TextField categoryTF;
    @javafx.fxml.FXML
    private TableColumn<StockItem, Float> unitCol;
    @javafx.fxml.FXML
    private TableColumn<StockItem, Integer> initialQuantityCol;
    @javafx.fxml.FXML
    private TableColumn<StockItem,Integer> reorderThresholdCol;
    @javafx.fxml.FXML
    private TableView<StockItem> tableVIew;
    @javafx.fxml.FXML
    private TableColumn<StockItem, String> categoryCol;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TableColumn<StockItem, String> itemNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        reorderThresholdCol.setCellValueFactory(new PropertyValueFactory<>("reorderThreshold"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        initialQuantityCol.setCellValueFactory(new PropertyValueFactory<>("initialQuantity"));
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveItemOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventoryandSupplyManagerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}