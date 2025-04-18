package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpansionPlan
{
    @javafx.fxml.FXML
    private TableView expansionTable;
    @javafx.fxml.FXML
    private TableColumn expansionPlanColumn;
    @javafx.fxml.FXML
    private DatePicker expansionDatePIck;
    @javafx.fxml.FXML
    private TableColumn expansionDatePick;
    @javafx.fxml.FXML
    private TextArea expansionTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void expansionHomeButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveExpansionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void expansionPreviousButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("farmManagerGoals.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}