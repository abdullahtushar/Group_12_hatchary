package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerInquiries
{
    @javafx.fxml.FXML
    private TableColumn<Inquiries,String> messageCol;
    @javafx.fxml.FXML
    private ComboBox<String> inquiryTypeCB;
    @javafx.fxml.FXML
    private TableColumn<Inquiries,Integer> contactCol;
    @javafx.fxml.FXML
    private TableColumn<Inquiries,String> inquiryTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Inquiries,String> customerNameCol;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> replyMethodCB;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private TextArea responseTA;
    @javafx.fxml.FXML
    private TextArea messageTA;
    @javafx.fxml.FXML
    private TableView<Inquiries> viewInquiryTableView;

    @javafx.fxml.FXML
    public void initialize(){
        inquiryTypeCB.getItems().addAll("Complaint", "Visit Request");
        replyMethodCB.getItems().addAll("Email", "SMS");

        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        inquiryTypeCol.setCellValueFactory(new PropertyValueFactory<>("inquiryType"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
    }

    @javafx.fxml.FXML
    public void sendResponseButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewInquiryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeInquiryButton(ActionEvent actionEvent) {
    }
}