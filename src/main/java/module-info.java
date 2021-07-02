module projectap2021 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens Graphic to javafx.fxml;
    exports Graphic.view;

}