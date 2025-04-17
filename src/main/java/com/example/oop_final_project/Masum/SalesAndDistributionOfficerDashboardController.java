package com.example.oop_final_project.Masum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesAndDistributionOfficerDashboardController {
    @javafx.fxml.FXML
    public void inquiriesAndComplaintsOnAction(ActionEvent actionEvent) throws IOException {
//        CustomerInquiries&Complaints.fxml
        Parent root = FXMLLoader.load(getClass().getResource("CustomerInquiries&Complaints.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
 }

    @javafx.fxml.FXML
    public void partnershipsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void marketInsightsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerAndSalesRecordOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("", actionEvent);
    }

    @javafx.fxml.FXML
    public void promotionsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void salesReportsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void deliveryManagementOnAction(ActionEvent actionEvent) throws IOException {
        //DeliveryManagement-view.fxml
        Parent root = FXMLLoader.load(getClass().getResource("DeliveryManagement-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void customerOrdersOnAction(ActionEvent actionEvent) throws IOException {
    //
        Parent root = FXMLLoader.load(getClass().getResource("ShowCustomerOrders-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
}
