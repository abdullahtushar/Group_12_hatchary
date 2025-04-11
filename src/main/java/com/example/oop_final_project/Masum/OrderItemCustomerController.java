package com.example.oop_final_project.Masum;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class OrderItemCustomerController {

    @javafx.fxml.FXML
    private TextField fishAmountTF;
    @javafx.fxml.FXML
    private TableColumn<FishData,String > fishNameColumn;
    @javafx.fxml.FXML
    private TextField customerPhoneTF;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> customerLocationColumn;
    @javafx.fxml.FXML
    private Label showPricePerKgLabel;
    @javafx.fxml.FXML
    private ComboBox<String> fishTypeCB;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private DatePicker showOrderDateDPicker;
    @javafx.fxml.FXML
    private Label showTotalCostTF;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> customerPhoneColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> fishAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<FishData,Double> pricePerKgColumn;
    @javafx.fxml.FXML
    private TableView<Customer> OrderTableView;
    @javafx.fxml.FXML
    private Label showFishAmountTF;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> customerNameColumn;
    @javafx.fxml.FXML
    private Label showFishNameTF;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> totalCostCoumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField customerLocationTF;
    public void initialize(){
        fishTypeCB.getItems().setAll("Telapia","Rohita","Pangas");
        totalCostCoumn.setCellValueFactory(new PropertyValueFactory<>(""));
       // totalCostCoumn customerNameColumn OrderTableView fishAmountColumn;customerPhoneColumn pricePerKgColumn

    }
    @javafx.fxml.FXML
    public void submitOrderOnAction(ActionEvent actionEvent) {

    }
}
