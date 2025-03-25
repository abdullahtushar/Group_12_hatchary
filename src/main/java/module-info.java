module com.example.oop_final_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_final_project to javafx.fxml;
    exports com.example.oop_final_project;
}