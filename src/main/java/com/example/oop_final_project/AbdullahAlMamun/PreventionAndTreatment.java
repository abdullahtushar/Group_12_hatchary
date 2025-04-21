package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PreventionAndTreatment
{
    @javafx.fxml.FXML
    private TableColumn fishNameColumn;
    @javafx.fxml.FXML
    private TableView TreatmentTableView;
    @javafx.fxml.FXML
    private TableColumn DatePickerCulumn;
    @javafx.fxml.FXML
    private DatePicker RecordDatePicker;
    @javafx.fxml.FXML
    private TextField fishNameTextBox;
    @javafx.fxml.FXML
    private ComboBox RecordDiseaseComboBOx;
    @javafx.fxml.FXML
    private TableColumn DiseasesCulumn;

    @javafx.fxml.FXML
    public void initialize() {
    }



    @javafx.fxml.FXML
    public void SubmitButtonTreatment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AquacultureHomeButtonn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();



    }
}