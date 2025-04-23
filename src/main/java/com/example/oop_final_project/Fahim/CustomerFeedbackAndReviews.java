package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class CustomerFeedbackAndReviews
{
    @javafx.fxml.FXML
    private TextField ratingTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<CustomerFeedback,String> commentsCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TextArea replyTA;
    @javafx.fxml.FXML
    private TableColumn<CustomerFeedback, String> ratingCol;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn<CustomerFeedback, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerFeedback,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerFeedback, String> nameCol;
    @javafx.fxml.FXML
    private TableView<CustomerFeedback> feedbackTableView;
    @javafx.fxml.FXML
    private TextArea commentsTA;
    @javafx.fxml.FXML
    private ComboBox<String> selectActionCB;

    @javafx.fxml.FXML
    public void initialize() {
        selectActionCB.getItems().addAll("Respond", "Mark as Reviewed", "Delete");
        statusCB.getItems().addAll("Pending", "Reviewed", "Resolved", "Not Applicable");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        commentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void respondButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) {
    }
}