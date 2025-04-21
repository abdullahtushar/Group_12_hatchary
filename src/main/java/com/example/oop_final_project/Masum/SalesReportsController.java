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

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalesReportsController {
    @javafx.fxml.FXML
    private TableColumn<FishSale, String> fishNameColumn;
    @javafx.fxml.FXML
    private TableView<FishSale> fishSaleTable;
    @javafx.fxml.FXML
    private ComboBox<String> dataRangeCB;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> profitColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, String> areaColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, Double> salesAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, DailyTransaction> priceKgColumn;
    @javafx.fxml.FXML
    private TableColumn<FishSale, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private ComboBox<String> filterDataRangeCB;

    public void initialize() {
        fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("fishName"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        priceKgColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerKg"));
        salesAmountColumn.setCellValueFactory(new PropertyValueFactory<>("soldAmount"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<>("profit"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dataRangeCB.getItems().addAll("Daily Sales", "Weekly Sales", "Custom");
        filterDataRangeCB.getItems().addAll("Daily Sales", "Weekly Sales", "Custom");
    }


    @javafx.fxml.FXML
    public void topSelllingFish(ActionEvent actionEvent) {
        fishSaleTable.getItems().clear();
        ArrayList<FishSale> dailyList = new ArrayList<>();
        ArrayList<FishSale> weeklyList = new ArrayList<>();
        String select = filterDataRangeCB.getValue();
        if (select==null){
            errorLabel.setText("Please select date");
            return;
        }

        if (select.equals("Daily Sales")) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("DailySales.bin"))) {
                dailyList = (ArrayList<FishSale>) objectInputStream.readObject();
                errorLabel.setText("Daily data loaded successfully!");
            } catch (IOException e) {
                errorLabel.setText("Daily data could not loaded successfully!");
            } catch (ClassNotFoundException e) {
                errorLabel.setText("Not found any data");
            }

            if (!dailyList.isEmpty()) {
                FishSale topSale = dailyList.get(0);
                for (FishSale fishSale : dailyList) {
                    if (fishSale.getSoldAmount() > topSale.getSoldAmount()) {
                        topSale = fishSale;
                    }
                    errorLabel.setText("Best selling fish in the day shown in table");

                }
                fishSaleTable.getItems().add(topSale);
            } else {
                errorLabel.setText("No data found for daily sales!");
            }

        } else if (select.equals("Weekly Sales")) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("weeklySales.bin"))) {
                weeklyList = (ArrayList<FishSale>) objectInputStream.readObject();
                errorLabel.setText("Weekly data loaded successfully!");
            } catch (IOException e) {
                errorLabel.setText("Weekly data could not loaded successfully!");
            } catch (ClassNotFoundException e) {
                errorLabel.setText("Not found any data");
            }

            if (!weeklyList.isEmpty()) {
                FishSale topSale = weeklyList.get(0);
                for (FishSale fishSale : weeklyList) {
                    if (fishSale.getSoldAmount() > topSale.getSoldAmount()) {
                        topSale = fishSale;
                    }
                    errorLabel.setText("Best selling fish in the day shown in table");


                }
                fishSaleTable.getItems().add(topSale);
            } else {
                errorLabel.setText("No data found for weekly sales!");
            }
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

    ArrayList<FishSale> fishSaleArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void loadDataOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FishSale.bin"))) {
            fishSaleArrayList = (ArrayList<FishSale>) objectInputStream.readObject();
        } catch (IOException e) {
            errorLabel.setText("File couldn't load");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format");
        }
        fishSaleTable.getItems().clear();
        fishSaleTable.getItems().addAll(fishSaleArrayList);
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
    public void dateRangeCBOnAction(ActionEvent actionEvent) {
        if (dataRangeCB.getValue().equals("Daily Sales") || dataRangeCB.getValue().equals("Weekly Sales")) {

        } else if (dataRangeCB.getValue().equals("Custom")) {

            errorLabel.setText("Please enter start date and end date");
        }

        LocalDate now = LocalDate.now();
        LocalDate start = null;
        LocalDate end = now;

        if (dataRangeCB.getValue().equals("Daily Sales")) {
            start = now.minusDays(1);
        } else if (dataRangeCB.getValue().equals("Weekly Sales")) {
            start = now.minusWeeks(1);
        } else if (dataRangeCB.getValue().equals("Custom")) {

        }

        ArrayList<FishSale> filterList = new ArrayList<>();
        for (FishSale fishSale : fishSaleArrayList) {
            if (!fishSale.getDate().isBefore(start) && !fishSale.getDate().isAfter(end)) {
                filterList.add(fishSale);
            }
        }

        fishSaleTable.getItems().clear();
        if (filterList.isEmpty()) {
            errorLabel.setText("No data found for the selected date range!");
        } else {
            fishSaleTable.getItems().addAll(filterList);
            try {
                if (dataRangeCB.getValue().equals("Daily Sales")) {
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("DailySales.bin"))) {
                        objectOutputStream.writeObject(filterList);
                        errorLabel.setText("Daily sales data saved successfully");
                    } catch (IOException e) {
                        errorLabel.setText("Failed to save daily sales data");
                        e.printStackTrace();
                    }
                } else if (dataRangeCB.getValue().equals("Weekly Sales")) {
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("weeklySales.bin"))) {
                        objectOutputStream.writeObject(filterList);
                        errorLabel.setText("Weekly sales data saved successfully");
                    } catch (IOException e) {
                        errorLabel.setText("Failed to save weekly sales data");
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                errorLabel.setText("Unexpected error occurred while saving data.");
                e.printStackTrace();
            }
        }
    }

}

