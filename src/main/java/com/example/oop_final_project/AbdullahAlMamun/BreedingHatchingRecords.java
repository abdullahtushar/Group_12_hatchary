package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class BreedingHatchingRecords
{
    @javafx.fxml.FXML
    private TableView breedingTableVIew;
    @javafx.fxml.FXML
    private ComboBox breadingComboBox;
    @javafx.fxml.FXML
    private TableColumn breedingDateColumn;
    @javafx.fxml.FXML
    private DatePicker breadingDatePicker;
    @javafx.fxml.FXML
    private TableColumn BreedingSeletedFishColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void breedingSubmitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BreedingHome(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BreedingPrevious(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("farmManagerGoals.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();;
    }
}