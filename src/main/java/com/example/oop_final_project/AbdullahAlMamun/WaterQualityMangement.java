package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class WaterQualityMangement {
    @javafx.fxml.FXML
    private TableColumn<WaterQualityRecord, String> waterQulityCulumn;
    @javafx.fxml.FXML
    private TableView<WaterQualityRecord> tableWaterQuality;
    @javafx.fxml.FXML
    private TextField pHLevelTextBox;
    @javafx.fxml.FXML
    private ComboBox<String> waterQualityCombo;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<WaterQualityRecord,String> pHColumn;

    @javafx.fxml.FXML
    public void initialize() {
        waterQualityCombo.getItems().addAll("Best", "Good", "Bad");
        waterQulityCulumn.setCellValueFactory(new PropertyValueFactory<>("waterQuality"));
        pHColumn.setCellValueFactory(new PropertyValueFactory<>("pHlevel"));
    }

    ArrayList<WaterQualityRecord> waterQualityRecordArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitWaterQualityButton(ActionEvent actionEvent) {
        if (waterQualityCombo.getValue() == null) {
            statusLabel.setText("Please select water quality");
            return;
        }
        if (pHLevelTextBox.getText().isEmpty()) {
            statusLabel.setText("Input pH level");
            return;
        }
        WaterQualityRecord waterQualityRecordObject = new WaterQualityRecord(pHLevelTextBox.getText(), waterQualityCombo.getValue());
        waterQualityRecordArrayList.add(waterQualityRecordObject);
        statusLabel.setText("Submitted successfully");
        tableWaterQuality.getItems().clear();
        tableWaterQuality.getItems().addAll(waterQualityRecordArrayList);

    }

//    @Deprecated
//    public void aquacultureDashboard(ActionEvent actionEvent) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//
//
//    }

    @javafx.fxml.FXML
    public void aquacultureDashboardButton(ActionEvent actionEvent) {
    }
}