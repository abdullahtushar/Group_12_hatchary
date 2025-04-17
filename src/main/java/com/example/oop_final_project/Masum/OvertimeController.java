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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class OvertimeController {
    @javafx.fxml.FXML
    private TableColumn<Overtime,String> staffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,Integer> totalColumn;
    @javafx.fxml.FXML
    private TextField hourlyRateTF;
    @javafx.fxml.FXML
    private DatePicker dateDp;
    @javafx.fxml.FXML
    private TableView<Overtime> overtimeable;
    @javafx.fxml.FXML
    private TextField employeeIdTF;
    @javafx.fxml.FXML
    private TableColumn<Overtime,Integer> etraHourColumn;
    @javafx.fxml.FXML
    private TextField employeeNameTF;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String> employeeIdColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String> statusColumn;
    @javafx.fxml.FXML
    private TextField extraHourTF;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String> departmentColumn;
    @javafx.fxml.FXML
    private Label employeeNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> departmentCB;
    @javafx.fxml.FXML
    private TableColumn<Overtime, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String> hourlyRateColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    public void initialize() {
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        etraHourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
        hourlyRateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        departmentCB.getItems().addAll("Sales", "HR", "Finance", "Production", "IT");

    }
    static ArrayList<Overtime> overtimeList = new ArrayList<>();
    ArrayList<Overtime>pendingList = new ArrayList<>();


    @javafx.fxml.FXML
    public void showProcessingOnAction(ActionEvent actionEvent) {
        overtimeable.getItems().clear();
        overtimeable.getItems().addAll(pendingList);

    }
    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        String name = employeeNameTF.getText().trim();
        String id = employeeIdTF.getText().trim();
        String department = departmentCB.getValue();
        String status = "Pending";
        LocalDate date = dateDp.getValue();
        if (name.isEmpty() || id.isEmpty() || department == null || date == null ||
                extraHourTF.getText().isEmpty() || hourlyRateTF.getText().isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
            return;
        } int hour, rate;
        try {
            hour = Integer.parseInt(extraHourTF.getText());
            rate = Integer.parseInt(hourlyRateTF.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("Hours and Rate must be valid numbers.");
            return;
        }
        for (Overtime ot: overtimeList){
            if (ot.getId().equals(id)&&ot.getDate().equals(date)){
                errorLabel.setText("Request already exists for this staff on this date");
                return;
            }
        }
        Overtime overtime = new Overtime(name, id, department, status, hour, rate,hour*rate, date);
        overtimeList.add(overtime);
        overtimeable.getItems().clear();
        overtimeable.getItems().addAll(overtimeList);
        errorLabel.setText("Overtime request added successfully");
        pendingList.clear();
        for (Overtime oe : overtimeable.getItems()) {
            if (oe.getStatus().equals("Pending")) {
                pendingList.add(oe);
            }
        }
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
    public void payOverTimeOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PayOvertime.fxml"));
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

    @javafx.fxml.FXML
    public void confirmedRejectOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("updatedOvertimeRequests.bin"))) {
            ArrayList<Overtime> loadedOvertimeList = (ArrayList<Overtime>) in.readObject();
            overtimeable.getItems().clear();
            overtimeable.getItems().setAll(loadedOvertimeList);
            errorLabel.setText("Load data from file");

        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid Format");
        } catch (IOException e) {
            errorLabel.setText("Could not load data from file");
        }
    }
}
