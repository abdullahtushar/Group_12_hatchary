package com.example.oop_final_project.Masum;

import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceOfficerDashboardController {
    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void manageBudgetOnAction(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("ManageBudget.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
}
