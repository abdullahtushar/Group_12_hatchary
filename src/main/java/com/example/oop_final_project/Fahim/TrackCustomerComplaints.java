package com.example.oop_final_project.Fahim;

import com.example.oop_final_project.Masum.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class TrackCustomerComplaints {
    @javafx.fxml.FXML
    private TableView<CustomerComplaints> complaintDeteilsTableView;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaints, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaints,Integer> contactCol;
    @javafx.fxml.FXML
    private TextArea complaintDetailsTA;
    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaints,String> nameCol;
    @javafx.fxml.FXML
    private ComboBox<String> complainStatusCB;
    @javafx.fxml.FXML
    private TextArea resolutionNoteTA;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaints,String> complaintCol;
    @javafx.fxml.FXML
    private TextField contactTF;

    @javafx.fxml.FXML
    public void initialize() {
        complainStatusCB.getItems().addAll("New","Resolved","Closed");

        complaintCol.setCellValueFactory(new PropertyValueFactory<>("complaint"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void updateComplaintButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitComplainButton(ActionEvent actionEvent) {

    }
}