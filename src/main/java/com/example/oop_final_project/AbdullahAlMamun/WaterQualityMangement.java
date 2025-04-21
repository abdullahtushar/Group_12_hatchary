package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class WaterQualityMangement
{
    @javafx.fxml.FXML
    private TableColumn phColumn;
    @javafx.fxml.FXML
    private TableColumn waterQulityCulumn;
    @javafx.fxml.FXML
    private TableView tableWaterQuality;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitWaterQualityButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void aquacultureDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AquacultureDashboard .fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }
}