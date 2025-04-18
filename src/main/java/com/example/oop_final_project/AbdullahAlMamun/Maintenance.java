package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Maintenance
{
    @javafx.fxml.FXML
    private TableColumn taskNameColumn;
    @javafx.fxml.FXML
    private TableColumn AssignedDateColumn;
    @javafx.fxml.FXML
    private TextField MantenanceTextField;
    @javafx.fxml.FXML
    private TableColumn AssignedUserColumn;
    @javafx.fxml.FXML
    private ComboBox AssignedUserCombo;
    @javafx.fxml.FXML
    private DatePicker assignedDatePicker;
    @javafx.fxml.FXML
    private TableView tableAssignMantenance;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void AssignedButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AquacultureDashButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("farmManagerGoals.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void FarmManagerDashButton(ActionEvent actionEvent) {
    }
}