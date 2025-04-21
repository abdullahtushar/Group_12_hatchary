package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class RecordsOfSupplierTransactions
{
    @javafx.fxml.FXML
    private TextField supplierNameTF;
    @javafx.fxml.FXML
    private TableView<SupplierTransaction> transactionTableView;
    @javafx.fxml.FXML
    private TableColumn<SupplierTransaction, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<SupplierTransaction, String> itemOrderedCol;
    @javafx.fxml.FXML
    private TextArea itemOrderedTA;
    @javafx.fxml.FXML
    private TableColumn<SupplierTransaction, Integer> quantityCol;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private TableColumn<SupplierTransaction, String> supplierNameCol;
    @javafx.fxml.FXML
    private TextField costTF;
    @javafx.fxml.FXML
    private Label validationMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<SupplierTransaction, Double> costCol;

    @javafx.fxml.FXML
    public void initialize() {
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        supplierNameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        itemOrderedCol.setCellValueFactory(new PropertyValueFactory<>("itemOrdered"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveTransactionButton(ActionEvent actionEvent) {
    }
}