package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EnsureQualitycontrolReceivedproducts
{
    @javafx.fxml.FXML
    private TableColumn<Quality, String> supplierCol;
    @javafx.fxml.FXML
    private CheckBox expiryDateCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Quality, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableView<Quality> tableView;
    @javafx.fxml.FXML
    private TextField supplierTF;
    @javafx.fxml.FXML
    private TableColumn<Quality, String> shipmentConditionCol;
    @javafx.fxml.FXML
    private DatePicker expiryDateVerifiedDP;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private ComboBox<String> shipmentConditionCB;

    @javafx.fxml.FXML
    public void initialize() {
        shipmentConditionCB.getItems().addAll("Good", "Damaged");

        shipmentConditionCol.setCellValueFactory(new PropertyValueFactory<>("shipmentCondition"));
        supplierCol.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    @javafx.fxml.FXML
    public void receiveProductButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveButton(ActionEvent actionEvent) {
    }
}