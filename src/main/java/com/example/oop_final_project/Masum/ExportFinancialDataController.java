package com.example.oop_final_project.Masum;

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

import static com.example.oop_final_project.Masum.DailyTransactionController.dailyTransactionsList;

public class ExportFinancialDataController {
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction, String> sourceOrPurposeColumn;
    @javafx.fxml.FXML
    private TableView<DailyTransaction> finantialDataTable;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction, String> incomeOrExpanceColumn;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction, String> noteColumn;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction, Double> amountColumn;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCb;
    @javafx.fxml.FXML
    private TableColumn<DailyTransaction, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private Label errorLabel;

    public void initialize() {
        categoryCb.getItems().addAll("All", "Income", "Expanse");
        incomeOrExpanceColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        sourceOrPurposeColumn.setCellValueFactory(new PropertyValueFactory<>("sourceOrPurpose"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
    }

    ArrayList<DailyTransaction> dailyTransactionArrayList = new ArrayList<>();
    ArrayList<DailyTransaction> incomeList = new ArrayList<>();
    ArrayList<DailyTransaction> expanseList = new ArrayList<>();

    @javafx.fxml.FXML
    public void showButtonOnAction(ActionEvent actionEvent) {
        finantialDataTable.getItems().clear();
        dailyTransactionArrayList.clear();
        incomeList.clear();
        expanseList.clear();

        String selectedCategory = categoryCb.getValue();

        if (selectedCategory == null) {
            errorLabel.setText("Please select Type");
            return;
        }

        for (DailyTransaction dt : dailyTransactionsList) {
            dailyTransactionArrayList.add(dt);

            if (selectedCategory.equals("Income") && dt.getType().equals("Income")) {
                incomeList.add(dt);
            } else if (selectedCategory.equals("Expanse") && dt.getType().equals("Expanse")) {
                expanseList.add(dt);
            }
        }
        if (selectedCategory.equals("All")) {
            finantialDataTable.getItems().addAll(dailyTransactionArrayList);
        } else if (selectedCategory.equals("Income")) {
            finantialDataTable.getItems().addAll(incomeList);
        } else if (selectedCategory.equals("Expanse")) {
            finantialDataTable.getItems().addAll(expanseList);
        }
    }


    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void LoadDataOnAction(ActionEvent actionEvent) {
        if (categoryCb.getValue() == null) {
            errorLabel.setText("Please Select Category");
        } else if (categoryCb.getValue().equals("All")) {
            dailyTransactionArrayList.clear();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("All.bin"))) {
                dailyTransactionArrayList = (ArrayList<DailyTransaction>) in.readObject();
                errorLabel.setText("All transactions loaded successfully.");
            } catch (ClassNotFoundException e) {
                errorLabel.setText("Invalid data format.");
                e.printStackTrace();
                return;
            } catch (IOException e) {
                errorLabel.setText("Could not load data from file.");
                e.printStackTrace();
                return;
            }
            finantialDataTable.getItems().setAll(dailyTransactionArrayList);

        } else if (categoryCb.getValue().equals("Income")) {
            incomeList.clear();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Income.bin"))) {
                incomeList = (ArrayList<DailyTransaction>) in.readObject();
                errorLabel.setText("Income transactions loaded successfully.");
            } catch (ClassNotFoundException e) {
                errorLabel.setText("Invalid data format.");
                e.printStackTrace();
                return;
            } catch (IOException e) {
                errorLabel.setText("Could not load data from file.");
                e.printStackTrace();
                return;
            }
            finantialDataTable.getItems().setAll(incomeList);

        } else if (categoryCb.getValue().equals("Expanse")) {
            expanseList.clear();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Expanse.bin"))) {
                expanseList = (ArrayList<DailyTransaction>) in.readObject();
                errorLabel.setText("Expanse transactions loaded successfully.");
            } catch (ClassNotFoundException e) {
                errorLabel.setText("Invalid data format.");
                e.printStackTrace();
                return;
            } catch (IOException e) {
                errorLabel.setText("Could not load data from file.");
                e.printStackTrace();
                return;
            }
            finantialDataTable.getItems().setAll(expanseList);
        }

    }

    @javafx.fxml.FXML
    public void saveDataOnAction(ActionEvent actionEvent) {
        if (categoryCb.getValue() == null) {
            errorLabel.setText("Please Select Category");
        } else if (categoryCb.getValue().equals("All")) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("All.bin"))) {
                out.writeObject(dailyTransactionArrayList);
                errorLabel.setText("Data saved successfully.");
            } catch (IOException e) {
                errorLabel.setText("Failed to save data list.");
                e.printStackTrace();
            }
        } else if (categoryCb.getValue().equals("Income")) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Income.bin"))) {
                out.writeObject(incomeList);
                errorLabel.setText("Data saved successfully.");
            } catch (IOException e) {
                errorLabel.setText("Failed to save data list.");
                e.printStackTrace();
            }
        } else if (categoryCb.getValue().equals("Expanse")) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Expanse.bin"))) {
                out.writeObject(expanseList);
                errorLabel.setText("Data saved successfully.");
            } catch (IOException e) {
                errorLabel.setText("Failed to save data list.");
                e.printStackTrace();
            }
        }

    }

    @javafx.fxml.FXML
    public void logoutAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
