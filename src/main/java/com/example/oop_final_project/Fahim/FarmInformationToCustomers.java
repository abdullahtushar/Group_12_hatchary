package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class FarmInformationToCustomers
{
    @javafx.fxml.FXML
    private ComboBox<String> fishSpeciesCB;
    @javafx.fxml.FXML
    private TableColumn<FarmInformation,Integer> workingHourCol;
    @javafx.fxml.FXML
    private TableColumn<FarmInformation,String> locationCol;
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private TextArea inputInformationTA;
    @javafx.fxml.FXML
    private TableView<FarmInformation> farmInformationTableView;
    @javafx.fxml.FXML
    private TextArea farmTA;
    @javafx.fxml.FXML
    private TableColumn<FarmInformation,String> farmHistoryCol;
    @javafx.fxml.FXML
    private TextField hourTF;
    @javafx.fxml.FXML
    private ComboBox<String> informationViaCB;
    @javafx.fxml.FXML
    private TableColumn<FarmInformation,String> fishSpeciesCol;

    @javafx.fxml.FXML
    public void initialize() {
        informationViaCB.getItems().addAll("Email","Phone","SMS");
        fishSpeciesCB.getItems().addAll("");

        farmHistoryCol.setCellValueFactory(new PropertyValueFactory<>("farmHistory"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        fishSpeciesCol.setCellValueFactory(new PropertyValueFactory<>("fishSpecies"));
        workingHourCol.setCellValueFactory(new PropertyValueFactory<>("workingHour"));
    }

    @javafx.fxml.FXML
    public void saveChangeButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
    }
}