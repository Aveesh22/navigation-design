module com.order.navigationdesign {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.order.navigationdesign to javafx.fxml;
    exports com.order.navigationdesign;
}