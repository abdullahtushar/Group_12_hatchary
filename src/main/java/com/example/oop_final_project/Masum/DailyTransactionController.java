package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DailyTransactionController {
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction,String> sourceOrPurposeColumn;
    @javafx.fxml.FXML
    private Label errorLabe;
    @javafx.fxml.FXML
    private TextField sourcePurposeTF;
    @javafx.fxml.FXML
    private TextField noteTF;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction,String> incomeOrExpanceColumn;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction,String> noteColumn;
    @javafx.fxml.FXML
    private DatePicker addDP;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction,Integer> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private ComboBox<String> incomeOrExpanceCB;
    @javafx.fxml.FXML
    private TableView<DailyTransaction> dailyTransactionTable;
    public void initialize(){
        incomeOrExpanceCB.getItems().addAll("Income","Expance");
        incomeOrExpanceColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        sourceOrPurposeColumn.setCellValueFactory(new PropertyValueFactory<>("sourceOrPurpose"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
    }
    ArrayList<DailyTransaction>dailyTransactionsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void addTransactionOnAction(ActionEvent actionEvent) {
        if (incomeOrExpanceCB.getItems() == null) {
            errorLabe.setText("Select type");
            return;
        }
        if (amountTF.getText().isEmpty()) {
            errorLabe.setText("Enter type");
            return;
        }
        if (noteTF.getText().isEmpty()) {
            errorLabe.setText("Enter note");
            return;
        }
        if (addDP.getValue() == null) {
            errorLabe.setText("Enter date");
            return;
        }
        if (sourcePurposeTF.getText().isEmpty()) {
            errorLabe.setText("Enter Source or purpose");
            return;
        }
        DailyTransaction dailyTransaction = new DailyTransaction(incomeOrExpanceCB.getValue(),
                sourcePurposeTF.getText(), Double.parseDouble(amountTF.getText()),
                noteTF.getText(), addDP.getValue());
//        dailyTransactionsList.add(dailyTransaction);
//        dailyTransactionTable.getItems().clear();
//        dailyTransactionTable.getItems().setAll(dailyTransactionsList);
        errorLabe.setText("Transaction added successfully");
        for (DailyTransaction dt: dailyTransactionsList){
            if (dt.getDate().isEqual(addDP.getValue())){
                if (dt.getNotes().equals(noteTF.getText())||dt.getSourceOrPurpose().equals(sourcePurposeTF.getText())){
                    errorLabe.setText("Transaction already exist exist");
                    return;
                }
            }
        }
        dailyTransactionsList.add(dailyTransaction);
        dailyTransactionTable.getItems().clear();
        dailyTransactionTable.getItems().setAll(dailyTransactionsList);
        errorLabe.setText("Transaction added  successfully");



    }
}
