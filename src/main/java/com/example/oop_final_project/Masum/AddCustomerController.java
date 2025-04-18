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

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.oop_final_project.Masum.CustomerDatabaseController.loadCustomerList;

public class AddCustomerController {
    @javafx.fxml.FXML
    private TableColumn<Customer, String> customerLocationColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> customerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> customerPhoneColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableView<Customer> addCustomerTable;
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField areaTF;

    public void initialize() {

        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    ArrayList<Customer> newCustomer = new ArrayList<>();

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        addCustomerTable.getItems().clear();
    }

    @javafx.fxml.FXML
    public void logoutonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerDataBase.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadDataOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.bin"))) {
            newCustomer = (ArrayList<Customer>) in.readObject();
            errorLabel.setText("Customer data loaded successfully.");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            errorLabel.setText("Could not load data from file.");
            e.printStackTrace();
            return;
        }
        addCustomerTable.getItems().clear();
        addCustomerTable.getItems().addAll(newCustomer);

    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Customer.bin"))) {
            out.writeObject(loadCustomerList);
            errorLabel.setText("Customer list saved successfully.");
        } catch (IOException e) {
            errorLabel.setText("Failed to save customer list.");
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void addCustomerOnAction(ActionEvent actionEvent) {
        if (nameTF.getText().isEmpty() || areaTF.getText().isEmpty() || phoneTF.getText().isEmpty()) {
            errorLabel.setText("Please enter all field");
            return;
        }
        for (Customer customer : loadCustomerList) {
            if (customer.getPhone().equals(phoneTF.getText())) {
                errorLabel.setText("This customer already exist");
                return;
            }
        }
        Customer customer = new Customer(nameTF.getText(), phoneTF.getText(), areaTF.getText(),
                "N/A", "N/A", 0, 0, 0, LocalDate.parse("N/A"));
        loadCustomerList.add(customer);
        newCustomer.add(customer);
        addCustomerTable.getItems().clear();
        addCustomerTable.getItems().addAll(newCustomer);

    }
}
