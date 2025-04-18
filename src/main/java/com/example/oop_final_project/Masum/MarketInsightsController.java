package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static com.example.oop_final_project.Masum.OrderItemCustomerController.fishSaleArrayList;

public class
MarketInsightsController {
    @javafx.fxml.FXML
    private TableColumn<FishSale, String> fishNameColumn;
    @javafx.fxml.FXML
    private TextField areaTF;
    @javafx.fxml.FXML
    private TableView<FishSale> marketDemundTableView;
    @javafx.fxml.FXML
    private TableColumn<FishSale, String> areaColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> salesAmountColumn;
    @javafx.fxml.FXML
    private ComboBox<String> fishTypeCB;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> priceKgColumn;
    @javafx.fxml.FXML
    private DatePicker startDateDP;
    @javafx.fxml.FXML
    private Label errorLabel;

    public void initialize() {
        fishTypeCB.getItems().setAll("Telapia", "Rohita", "Pangas", "Silver Cuff");
        fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        priceKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerKg"));
        salesAmountColumn.setCellValueFactory(new PropertyValueFactory<>("soldAmount"));
    }

    ArrayList<FishSale> fishSaleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void setFishPriceOnAction(ActionEvent actionEvent) throws IOException {//SetPrice.fxml
        Parent root = FXMLLoader.load(getClass().getResource("SetPrice.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

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
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FishSale.bin"))) {
            fishSaleList = (ArrayList<FishSale>) objectInputStream.readObject();
            errorLabel.setText("File Loaded");
        } catch (IOException e) {
            errorLabel.setText("Could not load data");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format");
            e.printStackTrace();
        }
        marketDemundTableView.getItems().clear();
        marketDemundTableView.getItems().addAll(fishSaleList);
    }

    @javafx.fxml.FXML
    public void filterOnAction(ActionEvent actionEvent) {

        marketDemundTableView.getItems().clear();
        String selectedFish = fishTypeCB.getValue();
        String area = areaTF.getText().trim();
        var selectedDate = startDateDP.getValue();

        if (selectedFish == null || selectedDate == null || area.isEmpty()) {
            errorLabel.setText("Please select all fields");
            return;
        }
        for (FishSale fishSale : fishSaleList) {
            if (fishSale.getFishName().equals(selectedFish) &&
                    fishSale.getArea().contains(area) &&
                    (fishSale.getDate().equals(selectedDate) || fishSale.getDate().isAfter(selectedDate))
            ) {
                marketDemundTableView.getItems().add(fishSale);
            }
            if (marketDemundTableView.getItems().isEmpty()) {
                errorLabel.setText("No data found for the given filters.");
            }
        }
    }
}

