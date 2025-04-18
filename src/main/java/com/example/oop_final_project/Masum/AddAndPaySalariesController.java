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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddAndPaySalariesController {

    @javafx.fxml.FXML
    private TableColumn<AddSalaries, String> positionColumn;
    @javafx.fxml.FXML
    private TableView<AddSalaries> paySalaryTable;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,String > staffIdColumn;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,String > updateStatusColumn;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,String > staffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,Double> showAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,Double> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,String > showStaffIdColumn;
    @javafx.fxml.FXML
    private TextField positionTF;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,String > showPositionColumn;
    @javafx.fxml.FXML
    private TextField staffNameTF;
    @javafx.fxml.FXML
    private TableView<AddSalaries> addSalaryTable;
    @javafx.fxml.FXML
    private TextField staffIdTF;
    @javafx.fxml.FXML
    private Label designationColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<AddSalaries,String > showStaffNameColumn;
    public void initialize(){
//        private String staffId, name,position;
//        private double monthlySalary;
//        private String status = "Pending";

        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        showStaffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        showStaffNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        showPositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("monthlySalary"));
        showAmountColumn.setCellValueFactory(new PropertyValueFactory<>("monthlySalary"));
        updateStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    ArrayList<AddSalaries> salaryArrayList = new ArrayList<>();
    ArrayList<AddSalaries> paySalaryArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void addSalaryOnAction(ActionEvent actionEvent) {
        if (staffNameTF.getText().isEmpty()) {
            errorLabel.setText("Please enter staff name");
            return;
        }
        if (staffIdTF.getText().isEmpty()) {
            errorLabel.setText("Please enter Staff ID");
            return;
        }
        if (positionTF.getText().isEmpty()) {
            errorLabel.setText("Please enter designation");
            return;
        }
        try {
            Double.parseDouble(amountTF.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("Please input a valid amount");
            return;
        }

        for (AddSalaries ps:salaryArrayList){
            if (ps.getStaffId().equals(staffIdTF.getText())){
                errorLabel.setText("You can't add salary \nfor a staff two time");
                return;
            }
        }

        AddSalaries paySalary = new AddSalaries(staffIdTF.getText(),staffNameTF.getText(),
                positionTF.getText(),Double.parseDouble(amountTF.getText()),"Pending");
        salaryArrayList.add(paySalary);
        addSalaryTable.getItems().clear();
        addSalaryTable.getItems().addAll(salaryArrayList);

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void paySalaryOnAction(ActionEvent actionEvent) {
        String status;
        for (AddSalaries ps: salaryArrayList){
            if (ps.getStatus().equals("Pending")){
                ps.setStatus("Payment done");
                paySalaryArrayList.add(ps);
                errorLabel.setText("Payment Done");
            }

        }
        paySalaryTable.getItems().clear();
        paySalaryTable.getItems().addAll(paySalaryArrayList);
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
}
