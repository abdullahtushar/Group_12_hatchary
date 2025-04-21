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
import java.time.LocalDate;
import java.util.ArrayList;

public class BreedingHatchingRecords {
    @javafx.fxml.FXML
    private TableView breedingTableVIew;
    @javafx.fxml.FXML
    private ComboBox<String> breadingComboBox;
    @javafx.fxml.FXML
    private TableColumn<BreedingRecord, LocalDate> breedingDateColumn;
    @javafx.fxml.FXML
    private DatePicker breadingDatePicker;
    @javafx.fxml.FXML
    private TableColumn<BreedingRecord,String> BreedingFishColumn;
    @javafx.fxml.FXML
    private Label labelBreading;

    @javafx.fxml.FXML
    public void initialize() {
    breadingComboBox.getItems().addAll("Telapia", "Rohita", "Pangas", "Silver Carp");
    BreedingFishColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
    breedingDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    ArrayList<BreedingRecord> breedingRecordArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void breedingSubmitButton(ActionEvent actionEvent) {
        if (breadingComboBox.getValue()==null||breadingDatePicker.getValue()==null){
            labelBreading.setText("Please select a fish and date");
            return;
        }if (breadingDatePicker.getValue().isAfter(LocalDate.now())){
            labelBreading.setText("date cant be future");
            return;
        }
        BreedingRecord breedingRecord= new BreedingRecord(breadingComboBox.getValue(),breadingDatePicker.getValue());
        breedingRecordArrayList.add(breedingRecord);
        breedingTableVIew.getItems().clear();
        breedingTableVIew.getItems().addAll(breedingRecordArrayList);

    }

    @javafx.fxml.FXML
    public void BreedingHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("farmManagerGoals.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}