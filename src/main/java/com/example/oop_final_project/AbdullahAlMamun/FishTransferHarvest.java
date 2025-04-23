package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

public class FishTransferHarvest
{
    @javafx.fxml.FXML
    private ComboBox speciesCombobox;
    @javafx.fxml.FXML
    private DatePicker datePickerFishTransfer;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void homeButtonFishTransfer(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

    @javafx.fxml.FXML
    public void submitButtonFishtransfer(ActionEvent actionEvent) {
    }
}