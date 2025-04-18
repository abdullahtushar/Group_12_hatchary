package com.example.oop_final_project.AbdullahAlMamun;

import com.example.oop_final_project.LoginApplication;
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
        // Optional: remove if unused
    }

    @javafx.fxml.FXML
    public void maintenanceOnActiion(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("maintenance.fxml"));
        switchScene(actionEvent, root);
    }

    @javafx.fxml.FXML
    public void budgetButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BudgetApproval.fxml"));
        switchScene(actionEvent, root);
    }

    @javafx.fxml.FXML
    public void ExpansionPlanOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("expansionPlan.fxml"));
        switchScene(actionEvent, root);
    }

    @javafx.fxml.FXML
    public void inventoryButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("invantoryApproval.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void breadAndHatchOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(" BreedingHatchingRecords.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();;
    }


    @javafx.fxml.FXML
    public void backToLoginButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // ✅ Utility method to switch scenes
    private void switchScene(ActionEvent actionEvent, Parent root) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void EmployeeListOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();;

    }
}
