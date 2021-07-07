package model;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.Event;

import java.io.IOException;

public class Model {
    private double xOffset = 0;
    private double yOffset = 0;

    public boolean performLogin(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    public void openNewWindow(String file, Event e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(file));
        Parent mainUi = (Parent) fxmlLoader.load();
        Stage main = new Stage();
        Scene scene = new Scene(mainUi);
//        scene.getStylesheets().add(getClass().getResource())
        main.initStyle(StageStyle.UNDECORATED);

        mainUi.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        mainUi.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                main.setX(mouseEvent.getSceneX() - xOffset);
                main.setY(mouseEvent.getSceneY() - yOffset);
            }
        });

        main.setScene(scene);
        main.show();
//        ((Node) e.get) todo check javafx


    }
}
