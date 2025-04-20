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

public class FarmVisits
{
    @javafx.fxml.FXML
    private TableColumn<Visit, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Visit> farmVisitTableView;
    @javafx.fxml.FXML
    private TableColumn<Visit, Integer> contactCol;
    @javafx.fxml.FXML
    private TextField visitorTF;
    @javafx.fxml.FXML
    private TableColumn<Visit, Integer> visitorCol;
    @javafx.fxml.FXML
    private TableColumn<Visit, String> nameCol;
    @javafx.fxml.FXML
    private ComboBox<String> confirmationCB;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private Label errorMessagesLabel;
    @javafx.fxml.FXML
    private TextArea confirmationMessageTA;

    @javafx.fxml.FXML
    public void initialize() {
        confirmationCB.getItems().addAll("Email","Phone SMS");

        visitorCol.setCellValueFactory(new PropertyValueFactory<>("visitor"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        errorMessagesLabel.setText("");

        String name = customerNameTF.getText();
        String contactStr = contactTF.getText();
        String visitorStr = visitorTF.getText();
        LocalDate date = dateDP.getValue();

        if (name.isEmpty() || contactStr.isEmpty() || visitorStr.isEmpty() || date == null) {
            errorMessagesLabel.setText("All fields are required!");
            return;
        }

        try {
            int contact = Integer.parseInt(contactStr);
            int visitors = Integer.parseInt(visitorStr);

            Visit visit = new Visit(name, visitors, contact, date);
            farmVisitTableView.getItems().add(visit);

            customerNameTF.clear();
            contactTF.clear();
            visitorTF.clear();
            dateDP.setValue(null);
            confirmationCB.getSelectionModel().clearSelection();

            errorMessagesLabel.setText("Submission successful");

        } catch (NumberFormatException e) {
            errorMessagesLabel.setText("Contact and visitors must be numbers!");
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

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
        String selectedMethod = confirmationCB.getSelectionModel().getSelectedItem();
        if (selectedMethod == null) {
            confirmationMessageTA.setText("Please select a confirmation method.");
            return;
        }

        String name = customerNameTF.getText();
        if (name.isEmpty()) {
            confirmationMessageTA.setText("Please enter customer name to send confirmation.");
            return;
        }

        String message = "Dear " + name + ", your farm visit has been confirmed via " + selectedMethod + ".";
        confirmationMessageTA.setText(message);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("customerServiceDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

