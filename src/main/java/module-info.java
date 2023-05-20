module com.employees {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.employees to javafx.fxml;
    exports com.employees;
    exports com.employees.controllers;
    opens com.employees.controllers to javafx.fxml;
    exports com.employees.model;
    opens com.employees.model to javafx.fxml;
}