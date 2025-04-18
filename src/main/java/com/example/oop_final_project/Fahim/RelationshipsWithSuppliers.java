package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class RelationshipsWithSuppliers {
    @javafx.fxml.FXML
    private TableColumn<RelationshipSupplier,String> pricingTermCol;
    @javafx.fxml.FXML
    private DatePicker expiryDateDP;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private ComboBox<String> contactMethodCB;
    @javafx.fxml.FXML
    private TextField supplierNameTF;
    @javafx.fxml.FXML
    private TableColumn<RelationshipSupplier,String> productCategoriesCol;
    @javafx.fxml.FXML
    private TableColumn<RelationshipSupplier, LocalDate> expiryDateCol;
    @javafx.fxml.FXML
    private TextField productCategoriesTF;
    @javafx.fxml.FXML
    private TableColumn<RelationshipSupplier,Integer> contactCol;
    @javafx.fxml.FXML
    private TextArea contractTermsTA;
    @javafx.fxml.FXML
    private TableColumn<RelationshipSupplier,String> supplierNameCol;
    @javafx.fxml.FXML
    private TextField pricingTermsTF;
    @javafx.fxml.FXML
    private TextArea contactMethodTA;
    @javafx.fxml.FXML
    private TableView<RelationshipSupplier> TableView;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private DatePicker DateDP;

    @javafx.fxml.FXML
    public void initialize() {
        contactMethodCB.getItems().addAll("Phone","Email");

        supplierNameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        productCategoriesCol.setCellValueFactory(new PropertyValueFactory<>("productCategories"));
        expiryDateCol.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        pricingTermCol.setCellValueFactory(new PropertyValueFactory<>("pricingTerm"));
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void initiateCommunicationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveTermButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendEmailButton(ActionEvent actionEvent) {
    }
}