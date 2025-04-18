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

import static com.example.oop_final_project.Masum.DailyTransactionController.summaryList;

public class FinancialReportsController {

    @javafx.fxml.FXML
    private TableColumn<Summary,Double> incomeColumn;
    @javafx.fxml.FXML
    private TableColumn<Summary,Double> netProfitOrLossColumn;
    @javafx.fxml.FXML
    private ComboBox<String> dateRangeCB;
    @javafx.fxml.FXML
    private TableColumn<Summary,Double> expenseColumn;
    @javafx.fxml.FXML
    private TableColumn<Summary, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableView<Summary> reportTable;
    @javafx.fxml.FXML
    private DatePicker endDateDP;
    @javafx.fxml.FXML
    private DatePicker startDateDP;

    public void initialize(){
        incomeColumn.setCellValueFactory(new PropertyValueFactory<>("totalIncome"));
        expenseColumn.setCellValueFactory(new PropertyValueFactory<>("totalExpense"));
        netProfitOrLossColumn.setCellValueFactory(new PropertyValueFactory<>("netProfitOrLoss"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateRangeCB.getItems().addAll("Weekly", "Monthly", "Annually", "Custom");
    }
    @javafx.fxml.FXML
    public void generateOnAction(ActionEvent actionEvent) {
        if (dateRangeCB.getValue().equals("Custom")) {
            if (startDateDP.getValue()==null || endDateDP.getValue()==null) {
                errorLabel.setText("You have to select start and end date");
                return;
            }
        }

        LocalDate now = LocalDate.now();
        LocalDate start = null;
        LocalDate end = now;

        if (dateRangeCB.getValue().equals("Weekly")) {
            startDateDP.setDisable(true);
            endDateDP.setDisable(true);
            start = now.minusDays(7);
        } else if (dateRangeCB.getValue().equals("Monthly")) {
            startDateDP.setDisable(true);
            endDateDP.setDisable(true);
            start = now.minusMonths(1);
        } else if (dateRangeCB.getValue().equals("Annually")) {
            startDateDP.setDisable(true);
            endDateDP.setDisable(true);
            start = now.minusYears(1);

        }else if (dateRangeCB.getValue().equals("Custom")) {
            if (startDateDP.getValue() == null || endDateDP.getValue() == null) {
                errorLabel.setText("You have to select both start and end dates");
                return;
            }
            start = startDateDP.getValue();
            end = endDateDP.getValue();
            startDateDP.setDisable(false);
            endDateDP.setDisable(false);
        }
        ArrayList<Summary> filtered = new ArrayList<>();
        for (Summary s : summaryList) {
            if (!s.getDate().isBefore(start) && !s.getDate().isAfter(end)) {
                filtered.add(s);
            }
        }
        reportTable.getItems().clear();
        reportTable.getItems().setAll(filtered);
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
