module com.example.demorpion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demorpion to javafx.fxml;
    exports com.example.demorpion;
}