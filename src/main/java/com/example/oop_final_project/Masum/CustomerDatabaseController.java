package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class CustomerDatabaseController {

    @FXML
    private TableColumn<Customer, String> fishNameColumn;
    @FXML
    private TableColumn<Customer, String> customerLocationColumn;
    @FXML
    private TableColumn<Customer, String> customerPhoneColumn;
    @FXML
    private TableColumn<Customer, Double> fishAmountColumn;
    @FXML
    private TableColumn<Customer, Double> pricePerKgColumn;
    @FXML
    private TableColumn<Customer, String> customerNameColumn;
    @FXML
    private TableColumn<Customer, Double> totalCostCoumn;
    @FXML
    private Label errorLabel;

    static ArrayList<Customer> loadCustomerList = new ArrayList<>();
    @FXML
    private TableView customerDatabaseTabeView;

    public void initialize() {

        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        fishAmountColumn.setCellValueFactory(new PropertyValueFactory<>("orderAmount"));
        pricePerKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerkg"));
        totalCostCoumn.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalesAndDistributionOfficerDashboard-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void logoutAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadDataOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.bin"))) {
            loadCustomerList = (ArrayList<Customer>) in.readObject();
            errorLabel.setText("Customer data loaded successfully.");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            errorLabel.setText("Could not load data from file.");
            e.printStackTrace();
            return;
        }
        customerDatabaseTabeView.getItems().clear();
        customerDatabaseTabeView.getItems().addAll(loadCustomerList);
    }


    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerAddOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
