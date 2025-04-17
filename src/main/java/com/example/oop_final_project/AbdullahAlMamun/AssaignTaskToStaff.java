package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AssaignTaskToStaff
{
    @javafx.fxml.FXML
    private ComboBox employeeComboBox;
    @javafx.fxml.FXML
    private TableColumn taskTypeColumn;
    @javafx.fxml.FXML
    private Button assignTaskButton;
    @javafx.fxml.FXML
    private TableColumn employeeColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TableView bidgetTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleLogoutAction(ActionEvent actionEvent) {
    }
}