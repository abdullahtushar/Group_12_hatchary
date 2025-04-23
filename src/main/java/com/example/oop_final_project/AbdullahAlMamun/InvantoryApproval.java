package com.example.oop_final_project.AbdullahAlMamun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class InvantoryApproval
{
    @javafx.fxml.FXML
    private TextField requstTextField;
    @javafx.fxml.FXML
    private TableColumn itemColumnIvantory;
    @javafx.fxml.FXML
    private TableView invantoryApprovalTable;
    @javafx.fxml.FXML
    private TableColumn quantityColumnInvantory;
    @javafx.fxml.FXML
    private TableColumn UserColumnInvantory;

    @javafx.fxml.FXML
    public void initialize() {
    }



    @javafx.fxml.FXML
    public void ApproveButtonInvantory(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void homeDashboard(ActionEvent actionEvent)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("farmManagerGoals.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}