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

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class ManageBudgetController {
    @javafx.fxml.FXML
    private TextField feefBudgetTF;
    @javafx.fxml.FXML
    private TableColumn<Budget, Double> feefBudgetTFColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget, LocalDate> endDateColumn;
    @javafx.fxml.FXML
    private TableView<Budget> addBudgetTable;
    @javafx.fxml.FXML
    private TableColumn<Budget, LocalDate> startDateColumn;
    @javafx.fxml.FXML
    private TextField utilityTF;
    @javafx.fxml.FXML
    private TableColumn<Budget, Double> utilityColumn;
    @javafx.fxml.FXML
    private DatePicker startDateDP;
    @javafx.fxml.FXML
    private TableColumn<Budget, Double> staffSalariesColumn;
    @javafx.fxml.FXML
    private TextField staffSalariesTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<Budget, Double> totalColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget, Double> medicineBudgetColumn;
    @javafx.fxml.FXML
    private TextField medicineTF;
    @javafx.fxml.FXML
    private DatePicker endDateDP;

    public void initialize() {
        feefBudgetTFColumn.setCellValueFactory(new PropertyValueFactory<>("feed"));
        medicineBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("medicine"));
        utilityColumn.setCellValueFactory(new PropertyValueFactory<>("utility"));
        staffSalariesColumn.setCellValueFactory(new PropertyValueFactory<>("salaries"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

    }

    ArrayList<Budget> budgetList = new ArrayList<>();
    ArrayList<Budget> budgetArrayList = new ArrayList<>();

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
        if (medicineTF.getText().isEmpty()) {
            errorLabel.setText("Please input medicine budget");
            return;
        }
        if (feefBudgetTF.getText().isEmpty()) {
            errorLabel.setText("Please input feed budget");
            return;
        }
        if (utilityTF.getText().isEmpty()) {
            errorLabel.setText("Please input utility budget");
            return;
        }
        if (staffSalariesTF.getText().isEmpty()) {
            errorLabel.setText("Please input salaries budget");
            return;
        }
        if (startDateDP.getValue() == null || startDateDP.getValue().isAfter(endDateDP.getValue())) {
            errorLabel.setText("Start date can't be empty or after end date");
            return;
        }
        if (endDateDP.getValue() == null || endDateDP.getValue().isBefore(startDateDP.getValue())) {
            errorLabel.setText("End date can't be empty or before end date");
            return;
        }

        double feed = Double.parseDouble(feefBudgetTF.getText());
        double medicine = Double.parseDouble(medicineTF.getText());
        double utility = Double.parseDouble(utilityTF.getText());
        double salaries = Double.parseDouble(staffSalariesTF.getText());
        double total = feed + medicine + utility + salaries;
        LocalDate startDate = startDateDP.getValue();
        LocalDate endDate = endDateDP.getValue();
//        for (Budget budget1:budgetList){
//            if (budget1.getStartDate().isEqual(startDate)||budget1.getEndDate().isEqual(endDate)){
//                errorLabel.setText("Budget already exist");
//                return;
//            }
//        }
        for (Budget existBudget : budgetList) {
            boolean overlap = existBudget.getStartDate().isEqual(startDate) ||
                    existBudget.getEndDate().isEqual(endDate);
            if (overlap) {
                errorLabel.setText("Budget already exists for the selected period.");
                return;
            }
        }

        Budget budget = new Budget(feed, medicine, utility, salaries, total, startDate, endDate,"Pending");
        budgetList.add(budget);
        addBudgetTable.getItems().clear();
        addBudgetTable.getItems().addAll(budgetList);
        errorLabel.setText("Budget created successfully");

    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadBudget(ActionEvent actionEvent) {
        try(ObjectInputStream ob  = new ObjectInputStream(new FileInputStream("Budget.bin"))){
            budgetArrayList = (ArrayList<Budget>) ob.readObject();
        } catch (IOException e) {
            errorLabel.setText("Could not load file");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid file");
        }
        addBudgetTable.getItems().clear();
        addBudgetTable.getItems().addAll(budgetArrayList);
    }




    @javafx.fxml.FXML
    public void saveBudgetAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Budget.bin"))) {
            out.writeObject(budgetList);
            errorLabel.setText("File save successfully");
        } catch (IOException e) {
            errorLabel.setText("Failed to save file");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        addBudgetTable.getItems().clear();
    }
}
