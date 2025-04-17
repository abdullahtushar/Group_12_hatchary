package com.example.oop_final_project.Masum;

import com.example.oop_final_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.oop_final_project.Masum.OvertimeController.overtimeList;

public class PayOvertimeController {
    @javafx.fxml.FXML
    private TableColumn<Overtime,String> showStatusColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime, LocalDate> showDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String > showEmployeeIdColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,Integer> showHourlyRateColumn;
    @javafx.fxml.FXML
    private TableView<Overtime> showOvertimeTable;
    @javafx.fxml.FXML
    private TableColumn<Overtime,Integer> showEtraHourColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String > showDepartmentColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<Overtime,Integer> showtotalColumn;
    @javafx.fxml.FXML
    private TableColumn<Overtime,String > showStaffNameColumn;
    public void initialize(){
        showStaffNameColumn.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        showEmployeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        showDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        showHourlyRateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        showEtraHourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
        showStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        showDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        showtotalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        showOvertimeTable.getItems().addAll(overtimeList);
    }
    ArrayList<Overtime> updateOverTimeList= new ArrayList<>();

    @javafx.fxml.FXML
    public void approveAction(ActionEvent actionEvent) {
        Overtime select = showOvertimeTable.getSelectionModel().getSelectedItem();
        if (select != null && select.getStatus().equals("Pending")) {
            select.setStatus("Approved");
            showOvertimeTable.refresh();
            updateOverTimeList.add(select);
            errorLabel.setText("Selected request approved.");
        } else {
            errorLabel.setText("Select a pending request to approve.");
        }
    }
    @javafx.fxml.FXML
    public void approveAllOnAction(ActionEvent actionEvent) {
        for (Overtime item : showOvertimeTable.getItems()) {
            if (item.getStatus().equals("Pending")) {
                item.setStatus("Approved");
                if (!updateOverTimeList.contains(item)) {
                    updateOverTimeList.add(item);
                }
            }
        }
        showOvertimeTable.refresh();
        errorLabel.setText("All pending requests approved.");
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
    public void saveOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("updatedOvertimeRequests.bin"))) {
            out.writeObject(updateOverTimeList);
            errorLabel.setText("Overtime list saved successfully.");
        } catch (IOException e) {
            errorLabel.setText("Failed to save overtime list.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void rejectAction(ActionEvent actionEvent) {
        Overtime select = showOvertimeTable.getSelectionModel().getSelectedItem();
        if (select != null && select.getStatus().equals("Pending")) {
            select.setStatus("Reject");
            showOvertimeTable.refresh();
            updateOverTimeList.add(select);
            errorLabel.setText("Selected request reject.");
        } else {
            errorLabel.setText("Select a pending request to approve.");
        }
    }
    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Overtime.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
