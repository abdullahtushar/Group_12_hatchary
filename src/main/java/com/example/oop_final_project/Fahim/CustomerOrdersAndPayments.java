package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerOrdersAndPayments
{
    @javafx.fxml.FXML
    private ComboBox<String> PaymentMethodCB;
    @javafx.fxml.FXML
    private ComboBox<String> productTypeCB;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private TableColumn<OrderAndPayment,Float> costCol;
    @javafx.fxml.FXML
    private TableColumn<OrderAndPayment,Integer> contactCol;
    @javafx.fxml.FXML
    private TableView<OrderAndPayment> newOrderTableView;
    @javafx.fxml.FXML
    private TableColumn<OrderAndPayment,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<OrderAndPayment,Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<OrderAndPayment,String> paymentCol;
    @javafx.fxml.FXML
    private Label confirmationMessageLabel;
    @javafx.fxml.FXML
    private Label totalCostLabel;
    @javafx.fxml.FXML
    private TableColumn<OrderAndPayment,String> productTypeCol;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private Label validationMessageLabel;
    @javafx.fxml.FXML
    private TextField costTF;

    @javafx.fxml.FXML
    public void initialize() {
        productTypeCB.getItems().addAll("");
        PaymentMethodCB.getItems().addAll("Visa Card","Bank");

        paymentCol.setCellValueFactory(new PropertyValueFactory<>("payment"));
        productTypeCol.setCellValueFactory(new PropertyValueFactory<>("productType"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));

    }

    @javafx.fxml.FXML
    public void submitOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mainMenuButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmPaymentButton(ActionEvent actionEvent) {
    }
}