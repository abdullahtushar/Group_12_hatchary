package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryandSupplyManagerDashboard {
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void warehouseManagementButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void inventorySystemButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void supplierTransactionsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void receiveProductsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void transportationSchedulesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewSupplierListButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewStockDetailsButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TrackStockLevels.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void newStockitemButton(ActionEvent actionEvent) {
    }
}