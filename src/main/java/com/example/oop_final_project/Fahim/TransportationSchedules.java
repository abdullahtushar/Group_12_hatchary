package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class TransportationSchedules
{
    @javafx.fxml.FXML
    private DatePicker departureDP;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private AnchorPane arrivalDP;
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
    public void initialize() {
        statusCB.getItems().addAll("");
        supplierCB.getItems().addAll("");
        supplierFilterCB.getItems().addAll("");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplierTypeColumn.setCellValueFactory(new PropertyValueFactory<>("supplierType"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
    }

    @javafx.fxml.FXML
    public void addScheduleButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mainMenuButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) {
    }
}