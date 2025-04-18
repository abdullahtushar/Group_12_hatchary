package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FarmManagerGoals {
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void maintenanceOnActiion(ActionEvent actionEvent) throws IOException {
        //maintenance.fxml
        Parent root = FXMLLoader.load(getClass().getResource("maintenance.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void budgetButtonOnAction(ActionEvent actionEvent) throws IOException {
        //BudgetApproval.fxml
        Parent root = FXMLLoader.load(getClass().getResource("BudgetApproval.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ExpansionPlanOnAction(ActionEvent actionEvent) throws IOException {
        //expansionPlan.fxml
        Parent root = FXMLLoader.load(getClass().getResource("expansionPlan.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void inventoryButtonOnAction(ActionEvent actionEvent) throws IOException {
        //invantoryApproval.fxml
        Parent root = FXMLLoader.load(getClass().getResource("invantoryApproval.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void breadAndHatchOnAction(ActionEvent actionEvent) throws IOException {
        // BreedingHatchingRecords.fxml
        Parent root = FXMLLoader.load(getClass().getResource("BreedingHatchingRecords.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void backToLoginButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}