package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MaintainCustomerDatabase
{
    @javafx.fxml.FXML
    private TableColumn<CustomerDatabase,Integer> phoneCol;
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<CustomerDatabase, String> StatusCol;
    @javafx.fxml.FXML
    private ComboBox<String> viewCustomerCB;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField customerDetailsTF;
    @javafx.fxml.FXML
    private TableColumn<CustomerDatabase,String> nameCol;
    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<CustomerDatabase, String> emailCol;
    @javafx.fxml.FXML
    private TableView<CustomerDatabase> CustomerTableView;

    @javafx.fxml.FXML
    public void initialize() {
        viewCustomerCB.getItems().addAll("Email","Phone");
        statusCB.getItems().addAll("Scheduled","Requested");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}