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

public class InquiriesComplaintsController {
    @javafx.fxml.FXML
    private ComboBox<String> inquiriesComplaintsCB;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint,String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint,String > statusColumn;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint,String > responseColumn;
    @javafx.fxml.FXML
    private TableColumn<InquiriesComplaint,String> contentColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableView<InquiriesComplaint> induiriesAndComplantTable;
    @javafx.fxml.FXML
    private Button addOnAction;
    @javafx.fxml.FXML
    private TextField contentTF;
    @javafx.fxml.FXML
    private TextField nameTF;

    public void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        responseColumn.setCellValueFactory(new PropertyValueFactory<>("response"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        inquiriesComplaintsCB.getItems().addAll("Inquiries","Complaint");
    }
    static ArrayList<InquiriesComplaint> inquiriesComplaintArrayList =new ArrayList<>();
    ArrayList<InquiriesComplaint> loadUpdate = new ArrayList<>();

    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addInquiriesOnAction(ActionEvent actionEvent) {
        if (nameTF.getText().isEmpty()){
            errorLabel.setText("Please enter name");
            return;
        }
        if (inquiriesComplaintsCB.getValue()==null){
            errorLabel.setText("Please select a inquiries or Complaints");
            return;
        }
        if (contentTF.getText().isEmpty()){
            errorLabel.setText("Please enter you complaint or inquiries");
            return;
        }
        for (InquiriesComplaint ic: inquiriesComplaintArrayList) {
            if (ic.getContent().equals(contentTF.getText())) {
                errorLabel.setText("This content already exist");
                return;
            }
        }
        InquiriesComplaint inquiriesComplaint =new InquiriesComplaint(nameTF.getText(),contentTF.getText(),"N/A","Pending");
        inquiriesComplaintArrayList.add(inquiriesComplaint);
        induiriesAndComplantTable.getItems().clear();
        induiriesAndComplantTable.getItems().addAll(inquiriesComplaintArrayList);
        errorLabel.setText("Inquiry or Complaint added success fully");
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
    public void showRespons(ActionEvent actionEvent) {
        InquiriesComplaint ic = induiriesAndComplantTable.getSelectionModel().getSelectedItem();
        if (ic!= null&&ic.getStatus().equals("Responded")){
            errorLabel.setText(ic.getResponse());
        }


    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("InquireComplaint.bin")) ){
            out.writeObject(inquiriesComplaintArrayList);
        } catch (FileNotFoundException e) {
            errorLabel.setText("File not fount");
        } catch (IOException e) {
            errorLabel.setText("Failed to save file");
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void loadRespondedOnAction(ActionEvent actionEvent) throws IOException {
        try (ObjectInputStream oi =new ObjectInputStream(new FileInputStream("Responded.bin"))) {
            loadUpdate= (ArrayList<InquiriesComplaint>) oi.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e){
            errorLabel.setText("Invalid File");
            e.printStackTrace();
        }catch(IOException e) {
            errorLabel.setText("Could not load data from file");
            e.printStackTrace();
        }
        induiriesAndComplantTable.getItems().clear();
        induiriesAndComplantTable.getItems().addAll(loadUpdate);
    }
}
