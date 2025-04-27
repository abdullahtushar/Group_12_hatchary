package com.example.oop_final_project.Fahim;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class TransportationSchedules
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableView<Transportation> tableView;
    @javafx.fxml.FXML
    private ComboBox<String> supplierFilterCB;
    @javafx.fxml.FXML
    private ComboBox<String> supplierCB;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn<Transportation,String> supplierTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<Transportation, LocalDate> arrivalDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Transportation,LocalDate> departureDateColumn;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private DatePicker departureDateDP;
    @javafx.fxml.FXML
    private DatePicker arrivalDateDP;

    @javafx.fxml.FXML
    public void initialize() {
        statusCB.getItems().addAll("Pending", "Completed", "Cancelled");
        supplierCB.getItems().addAll("Oceanic Supplies Ltd", "AquaFeed Co", "FreshWater Equipment Inc");
        supplierFilterCB.getItems().addAll("All", "Oceanic Supplies Ltd", "AquaFeed Co", "FreshWater Equipment Inc");


        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplierTypeColumn.setCellValueFactory(new PropertyValueFactory<>("supplierType"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
    }

    @javafx.fxml.FXML
    public void addScheduleButton(ActionEvent actionEvent) {
        String name = nameTF.getText();
        String supplier = supplierCB.getValue();
        LocalDate arrivalDate = arrivalDateDP.getValue();
        LocalDate departureDate = departureDateDP.getValue();
        String status = statusCB.getValue();

        if (name.isEmpty() || supplier == null || departureDate == null || status == null) {
            errorMessageLabel.setText("All fields are required!");
            return;
        }

        Transportation transportation = new Transportation(name, supplier, arrivalDate, departureDate, status);
        tableView.getItems().add(transportation);

        nameTF.clear();
        supplierCB.getSelectionModel().clearSelection();
        statusCB.getSelectionModel().clearSelection();
        departureDateDP.setValue(null);
    }


    @javafx.fxml.FXML
    public void mainMenuButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventoryandSupplyManagerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) {
        String selectedSupplier = supplierFilterCB.getValue();

        if (selectedSupplier == null || selectedSupplier.equals("All")) {
            tableView.setItems(tableView.getItems());
            return;
        }

        var filteredList = tableView.getItems().filtered(item -> item.getSupplierType().equals(selectedSupplier));
        tableView.setItems(filteredList);
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}