package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrackFishSalesController {
    @javafx.fxml.FXML
    private TableColumn<FishSale, String> fishNameColumn;
    @javafx.fxml.FXML
    private DatePicker endDateDp;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> profitColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, String> areaColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> salesAmountColumn;
    @javafx.fxml.FXML
    private TableView<FishSale> trackSaleTable;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> priceKgColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private DatePicker startDateDp;
    @javafx.fxml.FXML
    private Label errorLabel;

    public void initialize() {
        fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        priceKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerKg"));
        salesAmountColumn.setCellValueFactory(new PropertyValueFactory<>("soldAmount"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<>("profit"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    ArrayList<FishSale> fishSalesFilteredList = new ArrayList<>();
    ArrayList<FishSale> loadSalesList = new ArrayList<>();


    @javafx.fxml.FXML
    public void saveDataAction(ActionEvent actionEvent) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TrackSale.bin"))) {
            objectOutputStream.writeObject(loadSalesList);
            errorLabel.setText("File save successfully");
        } catch (IOException e) {
            errorLabel.setText("Failed to save");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadDataOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FishSale.bin"))) {
            loadSalesList = (ArrayList<FishSale>) objectInputStream.readObject();
        } catch (IOException e) {
            errorLabel.setText("Could not load data");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format");
            e.printStackTrace();
        }
        trackSaleTable.getItems().clear();
        trackSaleTable.getItems().addAll(loadSalesList);
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
    public void filterDataAction(ActionEvent actionEvent) {
        if (startDateDp.getValue().isAfter(LocalDate.now())) {
            errorLabel.setText("Start date can't be a future data");
            return;
        }
        if (startDateDp.getValue() == null) {
            errorLabel.setText("Please select start date");
            return;
        }
        if (endDateDp.getValue() == null) {
            errorLabel.setText("Please enter end date");
            return;
        }
        for (FishSale fishSale : loadSalesList) {
            if ((fishSale.getDate().equals(startDateDp.getValue()) || fishSale.getDate().isAfter(startDateDp.getValue())) &&
                    (fishSale.getDate().equals(endDateDp.getValue()) || fishSale.getDate().isBefore(endDateDp.getValue()))) {
                fishSalesFilteredList.add(fishSale);
            }

        }trackSaleTable.getItems().clear();
        trackSaleTable.getItems().addAll(fishSalesFilteredList);

    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        trackSaleTable.getItems().clear();
    }
}
