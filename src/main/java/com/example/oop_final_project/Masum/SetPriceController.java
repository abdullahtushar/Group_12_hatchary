package com.example.oop_final_project.Masum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.geom.Arc2D;
import java.io.IOException;

import static com.example.oop_final_project.Masum.OrderItemCustomerController.fishSaleArrayList;

public class SetPriceController {
    @javafx.fxml.FXML
    private ComboBox<String > fishNameCB;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField setPriceTF;
    public void initialize(){
        fishNameCB.getItems().setAll("Telapia", "Rohita", "Pangas", "Silver Cuff");
    }
    @javafx.fxml.FXML
    public void updatePriceOnAction(ActionEvent actionEvent) {
        if (fishNameCB.getValue()==null||setPriceTF.getText().isEmpty()){
            errorLabel.setText("Select all field");
            return;
        }
        for (FishSale fishSale:fishSaleArrayList){
            if (fishNameCB.getValue().equals("Telapia")){
                fishSale.setPricePerKg(Double.parseDouble(setPriceTF.getText()));
                errorLabel.setText("Price of Telapia is updated");
            } else if (fishNameCB.getValue().equals("Rohita")){
                fishSale.setPricePerKg(Double.parseDouble(setPriceTF.getText()));
                errorLabel.setText("Price of Rohita is updated");
            } else if (fishNameCB.getValue().equals("Pangas")) {
                fishSale.setPricePerKg(Double.parseDouble(setPriceTF.getText()));
                errorLabel.setText("Price of Pangas is updated");
            } else if (fishNameCB.getValue().equals("Silver Cuff")) {
                fishSale.setPricePerKg(Double.parseDouble(setPriceTF.getText()));
                errorLabel.setText("Price of Silver Cuff is updated");

            }
        }

    }//Market Insights.fxml

    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Market Insights.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
