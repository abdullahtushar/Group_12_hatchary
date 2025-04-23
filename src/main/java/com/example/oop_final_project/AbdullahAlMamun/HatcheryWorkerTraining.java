package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HatcheryWorkerTraining
{
    @javafx.fxml.FXML
    private TextField TrainingTopicTextBox;
    @javafx.fxml.FXML
    private ComboBox selectWorkerCombo;
    @javafx.fxml.FXML
    private DatePicker TrainingDatePicker;
    @javafx.fxml.FXML
    private Label StatusUpdateLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void BackToDashboardButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void ScheduleSessionButton(ActionEvent actionEvent) {
    }
}