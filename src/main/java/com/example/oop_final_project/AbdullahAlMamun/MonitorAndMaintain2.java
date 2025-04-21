package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MonitorAndMaintain2
{
    @javafx.fxml.FXML
    private Label StatusLabelMOnitor;
    @javafx.fxml.FXML
    private DatePicker datepickMonitor;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void AquacultureDashboardButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void SubmitButtonMonitor(ActionEvent actionEvent) {
        if (datepickMonitor.getValue()==null)
        {StatusLabelMOnitor.setText("please enter date");
        return;}
        if (datepickMonitor.getValue().isAfter(LocalDate.now())
        ||datepickMonitor.getValue().isBefore(LocalDate.now())){
            StatusLabelMOnitor.setText("date cant be past or future");
            return;
        }
        if (datepickMonitor.getValue().equals(LocalDate.now())){
            StatusLabelMOnitor.setText("Monitor Date Successfully submitted");
        }
    }
}