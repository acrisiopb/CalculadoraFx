module com.javafxx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javafxx to javafx.fxml;
    exports com.javafxx;
}
