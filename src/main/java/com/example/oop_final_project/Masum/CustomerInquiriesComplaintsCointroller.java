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

import static com.example.oop_final_project.Masum.InquiriesComplaintsController.inquiriesComplaintArrayList;

public class CustomerInquiriesComplaintsCointroller {
    @javafx.fxml.FXML
    private ComboBox<String> inquiriesComplaintsCB;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint, String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint, String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint, String> responseColumn;
    @javafx.fxml.FXML
    private TextField responseToCustomerTF;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint, String> contentColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private Button saveOnAction;
    @javafx.fxml.FXML
    private TableView<InquiriesComplaint> showInquiriesAndComplantTable;
    @javafx.fxml.FXML
    private Button addOnAction;

    public void initialize() {
        //name,content,response,status;
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        responseColumn.setCellValueFactory(new PropertyValueFactory<>("response"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        inquiriesComplaintsCB.getItems().addAll("Inquiries", "Complaint");
    }

    ArrayList<InquiriesComplaint> inquiriesComplaintList = new ArrayList<>();
    ArrayList<InquiriesComplaint> readList = new ArrayList<>();

    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalesAndDistributionOfficerDashboard-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void showContentOnAction(ActionEvent actionEvent) {
        InquiriesComplaint ic = showInquiriesAndComplantTable.getSelectionModel().getSelectedItem();
        if (ic != null && ic.getStatus().equals("Pending") && ic.getResponse().equals("N/A")) {
            errorLabel.setText(ic.getContent());
        }else {
        errorLabel.setText("Please add a response");}
    }

    @javafx.fxml.FXML
    public void addResponsOnAction(ActionEvent actionEvent) {
        InquiriesComplaint ic = showInquiriesAndComplantTable.getSelectionModel().getSelectedItem();
        if (ic != null && ic.getStatus().equals("Pending") && ic.getResponse().equals("N/A")) {
            ic.setResponse(responseToCustomerTF.getText());
            ic.setStatus("Responded");
            showInquiriesAndComplantTable.refresh();
            inquiriesComplaintList.add(ic);
        } else {
            errorLabel.setText("Select a item from table to add response");
        }

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
    public void saveDataOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Responded.bin"))) {
            os.writeObject(inquiriesComplaintList);
            errorLabel.setText("File saved Successfully");
        } catch (IOException e) {
            errorLabel.setText("File could not save");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void loadDataOnAction(ActionEvent actionEvent) {
        try(ObjectInputStream ob  = new ObjectInputStream(new FileInputStream("InquireComplaint.bin"))){
            readList = (ArrayList<InquiriesComplaint>) ob.readObject();
        } catch (IOException e) {
            errorLabel.setText("Could not load file");
        } catch (ClassNotFoundException e) {
            errorLabel.setText("Invalid file");
        }
        showInquiriesAndComplantTable.getItems().clear();
        showInquiriesAndComplantTable.getItems().addAll(readList);
    }
}

