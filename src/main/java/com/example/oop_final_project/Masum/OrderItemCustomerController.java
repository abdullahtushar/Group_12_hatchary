package com.example.oop_final_project.Masum;

import com.example.oop_final_project.AkkhorikAzad.CustomerMessages;
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderItemCustomerController {

    @FXML private TextField fishAmountTF;
    @FXML private TableColumn<Customer, String> fishNameColumn;
    @FXML private TextField customerPhoneTF;
    @FXML private TableColumn<Customer, String> customerLocationColumn;
    @FXML private Label showPricePerKgLabel;
    @FXML private ComboBox<String> fishTypeCB;
    @FXML private TextField customerNameTF;
    @FXML private DatePicker showOrderDateDPicker;
    @FXML private TableColumn<Customer, String> customerPhoneColumn;
    @FXML private TableColumn<Customer, Double> fishAmountColumn;
    @FXML private TableColumn<Customer, Double> pricePerKgColumn;
    @FXML private TableView<Customer> OrderTableView;
    @FXML private Label showFishAmountTF;
    @FXML private TableColumn<Customer, String> customerNameColumn;
    @FXML private TableColumn<Customer, Double> totalCostCoumn;
    @FXML private Label errorLabel;
    @FXML private TextField customerLocationTF;

    private ArrayList<Customer> placedOrdersList = new ArrayList<>();
    static ArrayList<FishStock> fishStockList = new ArrayList<>();
    static ArrayList<FishSaleSummary> saleSummariesList = new ArrayList<>();

    public void initialize() {
        fishTypeCB.getItems().setAll("Telapia", "Rohita", "Pangas", "Silver Cuff");

        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        fishAmountColumn.setCellValueFactory(new PropertyValueFactory<>("orderAmount"));
        pricePerKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerkg"));
        totalCostCoumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        showOrderDateDPicker.setValue(LocalDate.now());
        showOrderDateDPicker.setDisable(true);
    }

    @FXML
    public void submitOrderOnAction(ActionEvent actionEvent) {
        double fishPrice;

        if (customerNameTF.getText().isEmpty() || customerPhoneTF.getText().isEmpty() ||
                customerLocationTF.getText().isEmpty() || fishAmountTF.getText().isEmpty() ||
                fishTypeCB.getValue() == null) {
            errorLabel.setText("Please fill all field and Combobox");
            return;
        }

        if (fishTypeCB.getValue().equals("Telapia")) {
            fishPrice = 150;
            showPricePerKgLabel.setText("150");
        } else if (fishTypeCB.getValue().equals("Rohita")) {
            fishPrice = 250;
            showPricePerKgLabel.setText("250");
        } else if (fishTypeCB.getValue().equals("Pangas")) {
            fishPrice = 100;
            showPricePerKgLabel.setText("100");
        } else if (fishTypeCB.getValue().equals("Silver Cuff")) {
            fishPrice = 200;
            showPricePerKgLabel.setText("200");
        } else {
            fishPrice = 0;
            showPricePerKgLabel.setText("N/A");
        }

        try {
            Double.parseDouble(fishAmountTF.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("Enter valid amount");
            return;
        }

        double fishAmount = Double.parseDouble(fishAmountTF.getText());
        double total = fishPrice * fishAmount;

        for (Customer cr : placedOrdersList) {
            if (cr.getFishName().equals(fishTypeCB.getValue())) {
                errorLabel.setText("You can place same fish order in a day");
                return;
            }
        }

        Customer customer = new Customer(
                customerNameTF.getText(),
                customerPhoneTF.getText(),
                customerLocationTF.getText(),
                fishTypeCB.getValue(),
                "Pending",
                fishAmount,
                fishPrice,
                total,
                LocalDate.now()
        );


        placedOrdersList.add(customer);
        OrderTableView.getItems().clear();
        OrderTableView.getItems().addAll(placedOrdersList);
        errorLabel.setText("Order placed successfully.");



    }
    @FXML
    public void generateInvoiceOnAction(ActionEvent actionEvent) {
    }


    @FXML
    public void backonAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logoutOnaction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void saveOrderOnAction(ActionEvent actionEvent) {
        if (placedOrdersList.isEmpty()){
            errorLabel.setText("Please enter order!");
            return;
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("PlaceOrder.bin"))) {
            out.writeObject(placedOrdersList);
            errorLabel.setText("Place order list saved successfully.");
        } catch (IOException e) {
            errorLabel.setText("Failed to save overtime list.");
            e.printStackTrace();
        }
    }
}
