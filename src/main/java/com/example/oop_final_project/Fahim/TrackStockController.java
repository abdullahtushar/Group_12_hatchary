package com.example.oop_final_project.Fahim;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TrackStockController {
    @javafx.fxml.FXML
    private TextField reorderThresholdTF;
    @javafx.fxml.FXML
    private TableView<TrackStock> viewStockDetailsTV;
    @javafx.fxml.FXML
    private TextField itemNameTF;
    @javafx.fxml.FXML
    private TextField currentQuantityTF;
    @javafx.fxml.FXML
    private DatePicker lastUpdatedDP;
    @javafx.fxml.FXML
    private Label filterLabel;
    @javafx.fxml.FXML
    private TableColumn<TrackStock, LocalTime> lastUpdatedCol;
    @javafx.fxml.FXML
    private TableColumn<TrackStock,Float> currentQuantityCol;
    @javafx.fxml.FXML
    private TableColumn<TrackStock, Integer> reorderThresholdCol;
    @javafx.fxml.FXML
    private TableColumn<TrackStock, String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<TrackStock, String> itemNameCol;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCB;

    @javafx.fxml.FXML
    public void initialize() {
        categoryCB.getItems().addAll("Medicine","Fish Feed"," Equipment");

        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        currentQuantityCol.setCellValueFactory(new PropertyValueFactory<>("currentQuantity"));
        reorderThresholdCol.setCellValueFactory(new PropertyValueFactory<>("reorderThreshold"));
        lastUpdatedCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));


    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void stockLevelOnAction(ActionEvent actionEvent) {
        try {
            String itemName = itemNameTF.getText();
            String category = categoryCB.getValue();
            float currentQuantity = Float.parseFloat(currentQuantityTF.getText());
            int reorderThreshold = Integer.parseInt(reorderThresholdTF.getText());
            LocalDate lastUpdated = lastUpdatedDP.getValue();

            if (itemName.isEmpty() || category == null || lastUpdated == null) {
                filterLabel.setText("Please fill all fields.");
                return;
            }

            TrackStock newItem = new TrackStock(itemName, category, currentQuantity, lastUpdated, reorderThreshold);
            viewStockDetailsTV.getItems().add(newItem);

            itemNameTF.clear();
            categoryCB.getSelectionModel().clearSelection();
            currentQuantityTF.clear();
            reorderThresholdTF.clear();
            lastUpdatedDP.setValue(null);
            filterLabel.setText("Stock item added!");
        } catch (NumberFormatException e) {
            filterLabel.setText("Invalid number format.");
        }
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("inventoryandSupplyManagerDashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

