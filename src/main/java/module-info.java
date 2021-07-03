module projectap2021 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.junit.jupiter.api;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires com.google.gson;
    opens Graphic to javafx.fxml;
    exports Graphic.view;

}