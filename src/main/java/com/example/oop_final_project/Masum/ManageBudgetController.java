package com.example.oop_final_project.Masum;

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

public class ManageBudgetController {
    @javafx.fxml.FXML
    private TextField feefBudgetTF;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> feefBudgetTFColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget, LocalDate> endDateColumn;
    @javafx.fxml.FXML
    private TableView<Budget> addBudgetTable;
    @javafx.fxml.FXML
    private TableColumn<Budget, LocalDate> startDateColumn;
    @javafx.fxml.FXML
    private TextField utilityTF;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> utilityColumn;
    @javafx.fxml.FXML
    private DatePicker startDateDP;
    @javafx.fxml.FXML
    private DatePicker endDateTF;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> staffSalariesColumn;
    @javafx.fxml.FXML
    private TextField staffSalariesTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> totalColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> medicineBudgetColumn;
    @javafx.fxml.FXML
    private TextField medicineTF;

    public void initialize(){
        feefBudgetTFColumn.setCellValueFactory(new PropertyValueFactory<>("feed"));
        medicineBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("medicine"));
        utilityColumn.setCellValueFactory(new PropertyValueFactory<>("utility"));
        staffSalariesColumn.setCellValueFactory(new PropertyValueFactory<>("salaries"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

    }
    ArrayList<Budget> budgetList =new ArrayList<>();

    @javafx.fxml.FXML
    public void backonAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @javafx.fxml.FXML
    public void addBudgetButtonOnAction(ActionEvent actionEvent) {
        double feed = Double.parseDouble(feefBudgetTF.getText());
        double medicine = Double.parseDouble(medicineTF.getText());
        double utility = Double.parseDouble(utilityTF.getText());
        double salaries = Double.parseDouble(staffSalariesTF.getText());
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
