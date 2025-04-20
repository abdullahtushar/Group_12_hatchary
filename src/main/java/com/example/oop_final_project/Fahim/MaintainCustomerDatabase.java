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
    public void searchButton(ActionEvent event) {
        String selectedFilter = viewCustomerCB.getValue();
        String searchInput = customerDetailsTF.getText();

        if (selectedFilter == null || searchInput.isEmpty()) {
            validationLabel.setText("Select a filter and enter a search term.");
            return;
        }

        for (CustomerDatabase customer : CustomerTableView.getItems()) {
            if (selectedFilter.equals("Email") && customer.getEmail().equalsIgnoreCase(searchInput)) {
                nameTF.setText(customer.getName());
                emailTF.setText(customer.getEmail());
                phoneTF.setText(customer.getPhone().toString());
                statusCB.setValue(customer.getStatus());
                validationLabel.setText("Customer found.");
                return;
            } else if (selectedFilter.equals("Phone") && customer.getPhone().toString().equals(searchInput)) {
                nameTF.setText(customer.getName());
                emailTF.setText(customer.getEmail());
                phoneTF.setText(customer.getPhone().toString());
                statusCB.setValue(customer.getStatus());
                validationLabel.setText("Customer found.");
                return;
            }
        }

        validationLabel.setText("No customer found.");
    }


    @javafx.fxml.FXML
    public void customerButton(ActionEvent event) {
        String name = nameTF.getText();
        String email = emailTF.getText();
        String phoneText = phoneTF.getText();
        String status = statusCB.getValue();

        if (name.isEmpty() || email.isEmpty() || phoneText.isEmpty() || status == null) {
            validationLabel.setText("Please fill all fields.");
            return;
        }

        try {
            Integer phone = Integer.parseInt(phoneText);

            CustomerDatabase newCustomer = new CustomerDatabase(name, email, phone, status);
            CustomerTableView.getItems().add(newCustomer);

            validationLabel.setText("Customer added successfully!");

            // Clear fields
            nameTF.clear();
            emailTF.clear();
            phoneTF.clear();
            statusCB.setValue(null);
        } catch (NumberFormatException e) {
            validationLabel.setText("Invalid phone number.");
        }
    }


    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent event) {
        CustomerDatabase selectedCustomer = CustomerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null) {
            validationLabel.setText("Please select a customer from the table to update.");
            return;
        }

        String newName = nameTF.getText();
        String newEmail = emailTF.getText();
        String newPhoneText = phoneTF.getText();
        String newStatus = statusCB.getValue();

        if (newName.isEmpty() || newEmail.isEmpty() || newPhoneText.isEmpty() || newStatus == null) {
            validationLabel.setText("All fields are required.");
            return;
        }

        try {
            Integer newPhone = Integer.parseInt(newPhoneText);
            selectedCustomer.setName(newName);
            selectedCustomer.setEmail(newEmail);
            selectedCustomer.setPhone(newPhone);
            selectedCustomer.setStatus(newStatus);

            CustomerTableView.refresh();
            validationLabel.setText("Customer updated successfully.");
        } catch (NumberFormatException e) {
            validationLabel.setText("Invalid phone number.");
        }
    }

}