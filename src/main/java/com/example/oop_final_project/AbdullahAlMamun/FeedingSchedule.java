package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedingSchedule
{
    @javafx.fxml.FXML
    private TableView feedingScheduleTable;
    @javafx.fxml.FXML
    private DatePicker feedingTimeDate;
    @javafx.fxml.FXML
    private TextField feedingQuantityTextBox;
    @javafx.fxml.FXML
    private TableColumn FeedingQuantityColumn;
    @javafx.fxml.FXML
    private TableColumn feedingTimeColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void AquacultureDashboardd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}