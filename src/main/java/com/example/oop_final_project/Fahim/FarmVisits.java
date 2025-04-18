package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FarmVisits
{
    @javafx.fxml.FXML
    private TableColumn<Visit, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Visit> farmVisitTableView;
    @javafx.fxml.FXML
    private TableColumn<Visit, Integer> contactCol;
    @javafx.fxml.FXML
    private TextField visitorTF;
    @javafx.fxml.FXML
    private TableColumn<Visit, Integer> visitorCol;
    @javafx.fxml.FXML
    private TableColumn<Visit, String> nameCol;
    @javafx.fxml.FXML
    private ComboBox<String> confirmationCB;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private Label errorMessagesLabel;
    @javafx.fxml.FXML
    private TextArea confirmationMessageTA;

    @javafx.fxml.FXML
    public void initialize() {
        confirmationCB.getItems().addAll("Email","Phone SMS");

        visitorCol.setCellValueFactory(new PropertyValueFactory<>("visitor"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
    }
}