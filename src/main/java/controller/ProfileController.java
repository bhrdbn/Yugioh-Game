package controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;


import javax.imageio.ImageIO;

public class ProfileController implements Initializable {
    @FXML
    public TextField txtCurrentPassword;
    @FXML
    public TextField txtNewPassword;
    @FXML
    public Label warn;
    @FXML
    public TextField txtNickname;
    @FXML
    public ImageView img;

    byte[] person_image = null;

    private static ProfileController profileController = null;

    public static ProfileController getInstance() {
        if (profileController == null)
            profileController = new ProfileController();

        return profileController;
    }
    @FXML
    public void back(javafx.scene.input.MouseEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/onBoard.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void HandleEvents(javafx.scene.input.MouseEvent event) {
        //check if not empty
        if (txtCurrentPassword.getText().isEmpty() || txtNewPassword.getText().isEmpty()) {
            warn.setVisible(true);
            warn.setStyle("-fx-text-fill: white;-fx-background-color: red;-fx-padding: 10 10 10 10;");
            warn.setText("fill the blanks");
        } else {
            String s = changePassword(txtNewPassword.getText(), txtCurrentPassword.getText());
            warn.setVisible(true);
            if (s != null) {
                warn.setStyle("-fx-text-fill: white;-fx-background-color: red;-fx-padding: 10 10 10 10;");
                warn.setText(s);
            } else {
                warn.setStyle("-fx-text-fill: white;-fx-background-color: green;-fx-padding: 10 10 10 10;");
                warn.setText("the password changed");
            }
        }
    }

    @FXML
    private void uploadImageActionPerformed(javafx.scene.input.MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            img.setImage(image);
            img.setFitWidth(200);
            img.setFitHeight(200);
            img.scaleXProperty();
            img.scaleYProperty();
            img.setSmooth(true);
            img.setCache(true);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fin.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum);
            }
            person_image = bos.toByteArray();

        } catch (IOException ex) {
        }
    }

    @FXML
    private void handleEventsNick(javafx.scene.input.MouseEvent event) {
        changeNickName(txtNickname.getText());
    }


    public void changeNickName(String nickname) {
        GlobalVariable.getPlayer().setNickname(nickname);
    }

    public String changePassword(String newPassword, String currentPassword) {
        if (!GlobalVariable.getPlayer().getPassword().equals(currentPassword))
            return "current password is wrong";
        if (GlobalVariable.getPlayer().getPassword().equals(newPassword))
            return "please enter a new password";
        else {
            GlobalVariable.getPlayer().setPassword(newPassword);
            return null;
        }
    }


    public boolean checkNickName(String nickname) {
        for (Player player : Player.getAllPlayers()) {
            if (!player.getNickname().equals(nickname))
                return true;
        }
        return false;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
