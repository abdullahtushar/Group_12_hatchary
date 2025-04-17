package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ShowCustomerOrdersViewController {
    @javafx.fxml.FXML
    private TableColumn<Customer, String> fishNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> customerLocationColumn;
    @javafx.fxml.FXML
    private Label showPricePerKgLabel;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> customerPhoneColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, Double> fishAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, Double> pricePerKgColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> customerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> statusColumn;
    @javafx.fxml.FXML
    private Label updateStatusErrorLabel;
    @javafx.fxml.FXML
    private Label showFishNameTF;
    @javafx.fxml.FXML
    private TableColumn<Customer, Double> totalCostCoumn;
    @javafx.fxml.FXML
    private TableView<Customer> orderTableView;

    @javafx.fxml.FXML
    public void initialize() {
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        fishAmountColumn.setCellValueFactory(new PropertyValueFactory<>("orderAmount"));
        pricePerKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerkg"));
        totalCostCoumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    ArrayList<Customer> loadOrderList = new ArrayList<>();
    ArrayList<Customer> updateOrderList = new ArrayList<>();


    @javafx.fxml.FXML
    public void generateInvoiceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOrderOnAction(ActionEvent actionEvent) {
        Customer select = orderTableView.getSelectionModel().getSelectedItem();
        if (select != null && select.getStatus().equals("Pending")) {
            select.setStatus("Confirmed");
            orderTableView.refresh();
            //orderTableView.getItems().add(select);
            updateStatusErrorLabel.setText("Selected request Confirmed.");
        } else {
            updateStatusErrorLabel.setText("Select a pending request to approve.");
        }
        for (Customer c : orderTableView.getSelectionModel().getSelectedItems()){
            if (c.getStatus().equals("Confirmed")){
                updateOrderList.add(c);
            }
        }
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
    public void saveOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ConfirmedOrder.bin"))) {
            out.writeObject(updateOrderList);
            updateStatusErrorLabel.setText("Confirmed list saved successfully.");
        } catch (IOException e) {
            updateStatusErrorLabel.setText("Failed to save overtime list.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void loadConfirmedOrder(ActionEvent actionEvent) {
        orderTableView.getItems().clear();
        if (updateOrderList.isEmpty()){
            updateStatusErrorLabel.setText("Update is is empty");
            return;
        }
        orderTableView.getItems().addAll(updateOrderList);
    }

    @javafx.fxml.FXML
    public void loadPendingOrder(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("PlaceOrder.bin"))) {
           loadOrderList = (ArrayList<Customer>) in.readObject();
            updateStatusErrorLabel.setText("Orders loaded successfully.");
        } catch (ClassNotFoundException e) {
            updateStatusErrorLabel.setText("Invalid data format.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            updateStatusErrorLabel.setText("Could not load data from file.");
            e.printStackTrace();
            return;
        }
        orderTableView.getItems().clear();
        orderTableView.getItems().addAll(loadOrderList);

    }

}