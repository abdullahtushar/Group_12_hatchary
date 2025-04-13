package com.example.oop_final_project.Masum;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ExportFinancialDataController {
    @javafx.fxml.FXML
    private TableColumn sourceOrPurposeColumn;
    @javafx.fxml.FXML
    private TableView finantialDataTable;
    @javafx.fxml.FXML
    private DatePicker endDateDP;
    @javafx.fxml.FXML
    private TableColumn incomeOrExpanceColumn;
    @javafx.fxml.FXML
    private TableColumn noteColumn;
    @javafx.fxml.FXML
    private DatePicker startDateColumn;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private ComboBox categoryCb;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void showButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) {
    }
}
