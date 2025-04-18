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
import java.util.ArrayList;

public class PartnershipsController {

    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TableColumn<Partnership,String> addressColumn;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableView<Partnership> parthnerTable;
    @javafx.fxml.FXML
    private TableColumn<Partnership,String> parthnerColumn;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private TextField addressTF;
    @javafx.fxml.FXML
    private TableColumn<Partnership,String> typeColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<Partnership,String> phoneColumn;
    public void initialize(){
        typeCB.getItems().addAll("Vendor","Restaurant");
        parthnerColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    ArrayList<Partnership> partnershipArrayList = new ArrayList<>();
    ArrayList<Partnership> loadPartnershipsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        parthnerTable.getItems().clear();
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Partnership.bin"))) {
            loadPartnershipsList = (ArrayList<Partnership>) in.readObject();
            errorLabel.setText("Partnership loaded successfully.");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid data format.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            errorLabel.setText("Could not load data from file.");
            e.printStackTrace();
            return;
        }
        parthnerTable.getItems().clear();
        parthnerTable.getItems().addAll(loadPartnershipsList);
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
    public void saveAllOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Partnership.bin"))) {
            out.writeObject(partnershipArrayList);
            errorLabel.setText("Confirmed list saved successfully.");
        } catch (IOException e) {
            errorLabel.setText("Failed to save delivery list.");
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void addPartnerOnAction(ActionEvent actionEvent) {
        if (typeCB.getValue() == null || nameTF.getText().isEmpty() ||
                phoneTF.getText().isEmpty() || addressTF.getText().isEmpty()) {
            errorLabel.setText("Please fill up all fields");
            return;
        }
        for (Partnership partnership : partnershipArrayList) {
            if (partnership.getName().equals(nameTF.getText()) && partnership.getType().equals(typeCB.getValue()) &&
                    partnership.getPhone().equals(phoneTF.getText()) && partnership.getAddress().equals(addressTF.getText())) {
                errorLabel.setText("Partnership already exists");
                return;
            }
        }
        Partnership partnership = new Partnership(nameTF.getText(),typeCB.getValue(),phoneTF.getText(),addressTF.getText());
        partnershipArrayList.add(partnership);
        parthnerTable.getItems().clear();
        parthnerTable.getItems().addAll(partnershipArrayList);


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
