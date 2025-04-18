package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CustomerServiceDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void farmInformationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void promotionsAndOffersButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerFeedbackButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerInquiriesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerComplaintsButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("trackCustomerComplaints.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void customerDatabaseButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ordersAndPaymentsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void farmVisitButton(ActionEvent actionEvent) {
    }
}