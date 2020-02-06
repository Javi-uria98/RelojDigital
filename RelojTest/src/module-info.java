module RelojTest {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires RelojDigital;
    exports com.javier.test.fxml;
    exports com.javier.test;
    opens com.javier.test.fxml to javafx.fxml;
}