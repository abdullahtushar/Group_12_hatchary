package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class DeliveryManagementViewController {
    @javafx.fxml.FXML
    private TableColumn<Customer,String> deliveryCustomerPhoneColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,String > deliveryCustomerLocationColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,String > deliveryCustomerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> deliveryFishNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,Double> deliveryPricePerKgColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> updateStutasCoumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> deliveryFishAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,Double> totalColumn;
    @javafx.fxml.FXML
    private TableView<Customer> deliveryTableView;

    public void initialize(){
        deliveryCustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        deliveryCustomerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        deliveryCustomerLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        deliveryFishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        deliveryFishAmountColumn.setCellValueFactory(new PropertyValueFactory<>("orderAmount"));
        deliveryPricePerKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerkg"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        updateStutasCoumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    ArrayList<Customer> loadConfirmedOrder = new ArrayList<>();
    ArrayList<Customer> deliveryOrderList = new ArrayList<>();

    @javafx.fxml.FXML
    public void saveDeliveryAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Delivered.bin"))) {
            out.writeObject(deliveryOrderList);
            errorLabel.setText("Confirmed list saved successfully.");
        } catch (IOException e) {
            errorLabel.setText("Failed to save overtime list.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalesAndDistributionOfficerDashboard-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void deliveryOnAction(ActionEvent actionEvent) {
        Customer select = deliveryTableView.getSelectionModel().getSelectedItem();
        if (select != null && select.getStatus().equals("Confirmed")) {
            select.setStatus("Delivered");
            deliveryTableView.refresh();
            deliveryOrderList.add(select);
        } else {
            errorLabel.setText("Select a pending request to approve");
        }
//        for (Customer c : deliveryTableView.getSelectionModel().getSelectedItems()){
//            if (c.getStatus().equals("Confirmed")){
//                deliveryOrderList.add(c);
//            }
// }
    }

    @javafx.fxml.FXML
    public void loadDeliveryAction(ActionEvent actionEvent) {
        deliveryTableView.getItems().clear();
        if (deliveryOrderList.isEmpty()){
            errorLabel.setText("Update is is empty");
            return;
        }
        deliveryTableView.getItems().addAll(deliveryOrderList);
    }

    @FXML
    public void loadCorfirmedOrderAction(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ConfirmedOrder.bin"))) {
            loadConfirmedOrder = (ArrayList<Customer>) in.readObject();
            errorLabel.setText("Confirmed Orders loaded successfully.");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            errorLabel.setText("Could not load data from file.");
            e.printStackTrace();
            return;
        }
        deliveryTableView.getItems().clear();
        deliveryTableView.getItems().addAll(loadConfirmedOrder);

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
}
