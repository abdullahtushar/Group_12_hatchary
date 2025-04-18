package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StorageAndWarehouseConditions
{
    @javafx.fxml.FXML
    private TableColumn<WarehouseManagement, Float> oxygenLevelCol;
    @javafx.fxml.FXML
    private TextField temperatureTF;
    @javafx.fxml.FXML
    private Label labelText;
    @javafx.fxml.FXML
    private TextField humidityTF;
    @javafx.fxml.FXML
    private TableView<WarehouseManagement> tableView;
    @javafx.fxml.FXML
    private TextField oxygenLevelTF;
    @javafx.fxml.FXML
    private TableColumn<WarehouseManagement, Float> temperatureCol;
    @javafx.fxml.FXML
    private TableColumn<WarehouseManagement, Float> HumidityCol;

    @javafx.fxml.FXML
    public void initialize() {
        temperatureCol.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        HumidityCol.setCellValueFactory(new PropertyValueFactory<>("Humidity"));
        oxygenLevelCol.setCellValueFactory(new PropertyValueFactory<>("oxygenLevel"));

    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sensorDataOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void storageConditionOnAction(ActionEvent actionEvent) {
    }
}