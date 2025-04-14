package com.example.oop_final_project;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeCB;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private Label loginErrorLabel;

    public void initialize(){
        userTypeCB.getItems().addAll("Farm Manager", "Aquaculture Specialist",
                "Finance Officer", "Sales and Distribution Officer",
                "Inventory and Supply Manager", "Customer service representative",
                "Technical Support Officer", "Social Media Manager");
    }
    @javafx.fxml.FXML
    public void loginOnAction(Event event) throws IOException {
        String username = usernameTF.getText();
        String password = passwordPF.getText();
        String usertype = userTypeCB.getValue();
        if (username.trim().isEmpty()||password.trim().isEmpty()||usertype==null){
            loginErrorLabel.setText("Please select all fields");
        }
        else if("masum".equals(username.trim())&&"1122".equals(password.trim())&&"Finance Officer".equals(usertype)){
            loginErrorLabel.setText("Login Successful");
            //SceneSwitcher.switchTo("Masum/FinanceOfficerDashboard.fxml");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Masum/FinanceOfficerDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTF.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }else {
            loginErrorLabel.setText("Incorrect username, password, or user type");
        }

    }
}
