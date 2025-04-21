package com.example.oop_final_project.Fahim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PromotionsAndOffers {
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<Promotion,Float> discountColumn;
    @javafx.fxml.FXML
    private TableColumn<Promotion,LocalDate> startDateColumn;
    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private Label messsageLabel;
    @javafx.fxml.FXML
    private TextField discountTF;
    @javafx.fxml.FXML
    private DatePicker endDateDP;
    @javafx.fxml.FXML
    private TableColumn<Promotion,String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<Promotion,String> titleColumn;
    @javafx.fxml.FXML
    private TableView<Promotion> promotionTableView;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private TableColumn<Promotion, String> descriptionColumn;
    @javafx.fxml.FXML
    private TextArea inputViaTA;
    @javafx.fxml.FXML
    private DatePicker startDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> confirmationCB;
    @javafx.fxml.FXML
    private TableColumn<Promotion, LocalDate> endDateColumn;

    @javafx.fxml.FXML
    public void initialize() {
        confirmationCB.getItems().addAll("Email","Phone");

        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
    }

    @javafx.fxml.FXML
    public void savePromotionButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendNotificationButton(ActionEvent actionEvent) {
    }
}