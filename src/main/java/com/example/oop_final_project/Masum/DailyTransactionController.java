package com.example.oop_final_project.Masum;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class DailyTransactionController {
    @javafx.fxml.FXML
    private TableColumn sourceOrPurposeColumn;
    @javafx.fxml.FXML
    private Label errorLabe;
    @javafx.fxml.FXML
    private TextField sourcePurposeTF;
    @javafx.fxml.FXML
    private TextField noteTF;
    @javafx.fxml.FXML
    private TableColumn incomeOrExpanceColumn;
    @javafx.fxml.FXML
    private TableColumn noteColumn;
    @javafx.fxml.FXML
    private DatePicker addDP;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private ComboBox incomeOrExpanceCB;
    @javafx.fxml.FXML
    private TableView dailyTransactionTable;

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addTransactionOnAction(ActionEvent actionEvent) {
    }
}
