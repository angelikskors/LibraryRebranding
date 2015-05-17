package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;
import sample.utils.FXMLHelper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private ImageView img;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("file: bookInCloud.png");
        img = new ImageView();
        img.setImage(image);


    }
    @FXML
    public void handleAddNew(){
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader fxmlLoader = FXMLHelper.loader("views/book_edit.fxml",resources);

        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        showNewWindow("Add new book", root1);
    }

    @FXML
    public void handleBase(ActionEvent actionEvent) {
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader loader = FXMLHelper.loader("views/books_window.fxml", resources);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle("Base");
        Scene scene = new Scene(root, 820, 400);
        stage.setScene(scene);
        stage.show();
    }
    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        Scene scene = new Scene(root, 820, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleService(ActionEvent actionEvent) {

    }

    @FXML
    public void handleContactUs(ActionEvent actionEvent) {
    }
}