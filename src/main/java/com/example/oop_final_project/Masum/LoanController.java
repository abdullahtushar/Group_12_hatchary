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

public class LoanController {
    @javafx.fxml.FXML
    private TextField loanAmountTF;
    @javafx.fxml.FXML
    private TableView<Loan> loanTableView;
    @javafx.fxml.FXML
    private DatePicker returnDateDP;
    @javafx.fxml.FXML
    private TableColumn<Loan, String> loanPurposeColumn;
    @javafx.fxml.FXML
    private TableColumn<Loan, String> statusColumn;
    @javafx.fxml.FXML
    private TextField loanPurposeTF;
    @javafx.fxml.FXML
    private TableColumn<Loan, Double> loanAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<Loan, LocalDate> loanApplyDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Loan, LocalDate> loanReturnDateColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private DatePicker applyDateDP;

    public void initialize() {
        loanAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        loanPurposeColumn.setCellValueFactory(new PropertyValueFactory<>("purposeOfLoan"));
        loanApplyDateColumn.setCellValueFactory(new PropertyValueFactory<>("applyDate"));
        loanReturnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        applyDateDP.setValue(LocalDate.now());
        applyDateDP.setEditable(false);
        //applyDateDP.setDisable(true);
    }

    ArrayList<Loan> loanArrayList = new ArrayList<>();


    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinanceOfficerDashboard.fxml"));
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
    public void applyLoanOnAction(ActionEvent actionEvent) {

        if (loanPurposeTF.getText().isEmpty()) {
            errorLabel.setText("Enter loan purpose");
            return;
        }
         else if (returnDateDP.getValue() == null) {
            errorLabel.setText("Enter return date");
            return;
        }
        try {
            Double.parseDouble(loanAmountTF.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("Please input valid amount");
            return;
        }
        for (Loan l : loanArrayList) {
            if (l.getPurposeOfLoan().equalsIgnoreCase(loanPurposeTF.getText()) &&
                    l.getApplyDate().equals(applyDateDP.getValue())) {
                errorLabel.setText("Loan already applied for same purpose on this date.");
                return;
            }
        }
        Loan loan = new Loan(Double.parseDouble(loanAmountTF.getText()), loanPurposeTF.getText(), "Pending", applyDateDP.getValue(), returnDateDP.getValue());
        loanArrayList.add(loan);
        loanTableView.getItems().clear();
        loanTableView.getItems().addAll(loanArrayList);
        errorLabel.setText("Loan request successful");
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Loan Request.bin"))) {
            ArrayList<Loan> loadedLoanList  = (ArrayList<Loan>) inputStream.readObject();
            loanArrayList = new ArrayList<>(loadedLoanList );

            loanTableView.getItems().clear();
            loanTableView.getItems().addAll(loadedLoanList );

        } catch (IOException e) {
            errorLabel.setText("Could not load data from file");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid Format");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) throws FileNotFoundException {
        ArrayList<Loan> saveLoanList = new ArrayList<>();
        for (Loan loan : loanTableView.getItems()) {
            saveLoanList.add(loan);
        }
        //loanArrayList = new ArrayList<>(saveLoanList);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Loan Request.bin"))) {
            objectOutputStream.writeObject(saveLoanList);
            errorLabel.setText("Save file successfully");
        } catch (IOException e) {
            errorLabel.setText("Could not write to file");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        loanTableView.getItems().clear();
    }
}
