package com.example.oop_final_project.Fahim;

import com.example.oop_final_project.LoginApplication;
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
    private TableColumn<CustomerComplaints, String> resolutionNoteCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaints, String> statusCol;

    @javafx.fxml.FXML
    public void initialize() {
        complainStatusCB.getItems().addAll("New","Resolved","Closed");

        complaintCol.setCellValueFactory(new PropertyValueFactory<>("complaint"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        resolutionNoteCol.setCellValueFactory(new PropertyValueFactory<>("resolutionNote"));

    }
    ArrayList<CustomerComplaints> complaintList = new ArrayList<>();

    @javafx.fxml.FXML
    public void updateComplaintButton(ActionEvent actionEvent) {
        CustomerComplaints selected = complaintDeteilsTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            validationLabel.setText("No complaint selected to update.");
            return;
        }

        String name = customerNameTF.getText();
        String complaint = complaintDetailsTA.getText();
        String contactStr = contactTF.getText();
        LocalDate date = dateDP.getValue();
        String status = complainStatusCB.getValue();
        String resolution = resolutionNoteTA.getText();

        if (name.isEmpty() || complaint.isEmpty() || contactStr.isEmpty() || date == null || status == null) {
            validationLabel.setText("Please fill all fields before updating.");
            return;
        }

        try {
            int contact = Integer.parseInt(contactStr);

            selected.setName(name);
            selected.setComplaint(complaint);
            selected.setContact(contact);
            selected.setDate(date);
            selected.setStatus(status);
            selected.setResolutionNote(resolution);

            complaintDeteilsTableView.refresh();
            validationLabel.setText("Complaint updated successfully!");
            customerNameTF.clear();
            complaintDetailsTA.clear();
            contactTF.clear();
            dateDP.setValue(null);
            complainStatusCB.setValue(null);
            resolutionNoteTA.clear();
        } catch (NumberFormatException e) {
            validationLabel.setText("Contact must be a number.");
        }
    }

    @javafx.fxml.FXML
    public void submitComplainButton(ActionEvent actionEvent) {
        String name = customerNameTF.getText();
        String complaint = complaintDetailsTA.getText();
        String contactStr = contactTF.getText();
        LocalDate date = dateDP.getValue();
        String status = complainStatusCB.getValue();
        String resolution = resolutionNoteTA.getText();

        if (name.isEmpty() || complaint.isEmpty() || contactStr.isEmpty() || date == null || status == null) {
            validationLabel.setText("Please fill in all required fields!");
            return;
        }

        try {
            int contact = Integer.parseInt(contactStr);
            CustomerComplaints newComplaint = new CustomerComplaints(name, complaint, contact, date, status, resolution);

            complaintList.add(newComplaint);

            complaintDeteilsTableView.getItems().add(newComplaint);
            validationLabel.setText("Complaint submitted successfully!");

            customerNameTF.clear();
            complaintDetailsTA.clear();
            contactTF.clear();
            dateDP.setValue(null);
            complainStatusCB.setValue(null);
            resolutionNoteTA.clear();
        } catch (NumberFormatException e) {
            validationLabel.setText("Contact must be a number.");
        }
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}