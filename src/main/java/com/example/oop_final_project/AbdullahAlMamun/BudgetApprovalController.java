package com.example.oop_final_project.AbdullahAlMamun;


import com.example.oop_final_project.Masum.Budget;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BudgetApprovalController {
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> feefBudgetTFColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget,LocalDate> endDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> medicineBudgetColumn;
    @javafx.fxml.FXML
    private AnchorPane e;
    @javafx.fxml.FXML
    private TableColumn<Budget, LocalDate> startDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget,String > statusColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> totalColumn;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> utilityColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<Budget,Double> staffSalariesColumn;
    @javafx.fxml.FXML
    private TableView<Budget> budgetTable;

public void initialize(){
    feefBudgetTFColumn.setCellValueFactory(new PropertyValueFactory<>("feed"));
    medicineBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("medicine"));
    utilityColumn.setCellValueFactory(new PropertyValueFactory<>("utility"));
    staffSalariesColumn.setCellValueFactory(new PropertyValueFactory<>("salaries"));
    totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
    startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
    endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
}

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    budgetTable.getItems().clear();
    }

    @javafx.fxml.FXML
    public void backonAction(ActionEvent actionEvent) throws IOException {
        //farmManagerGoals.fxml
        Parent root = FXMLLoader.load(getClass().getResource("farmManagerGoals.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

ArrayList<Budget> loadBudgetArrayList = new ArrayList<>();
ArrayList<Budget>approvedlist = new ArrayList<>();
    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveApprovedBudgetAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Delivered.bin"))) {
            out.writeObject(approvedlist);
            errorLabel.setText("Budget approved list save successfully.");
        } catch (IOException e) {
            errorLabel.setText("Failed to save budget approved list.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void loadRequestedBudget(ActionEvent actionEvent) {
        try(ObjectInputStream ob  = new ObjectInputStream(new FileInputStream("Budget.bin"))){
            loadBudgetArrayList = (ArrayList<Budget>) ob.readObject();
        } catch (IOException e) {
            errorLabel.setText("Could not load file");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid file");
        }
        budgetTable.getItems().clear();
        budgetTable.getItems().addAll(loadBudgetArrayList);
    }

    @javafx.fxml.FXML
    public void approveBudgetButtonOnAction(ActionEvent actionEvent) {
        Budget selected = budgetTable.getSelectionModel().getSelectedItem();
        if (selected!=null&&selected.getStatus().equals("Pending")){
            selected.setStatus("Approved");
            budgetTable.refresh();
            approvedlist.add(selected);
        }
    }

    @javafx.fxml.FXML
    public void loadApprovedBudgetAction(ActionEvent actionEvent) {
        budgetTable.getItems().clear();
        budgetTable.getItems().addAll(approvedlist);
    }
}
