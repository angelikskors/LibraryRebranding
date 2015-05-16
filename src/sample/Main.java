package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.utils.FXMLHelper;

import java.io.*;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader loader = FXMLHelper.loader("views/MainWindow.fxml");
        Parent root = loader.load();
        primaryStage.setTitle(resources.getString("key_title"));
        root.getStyleClass().add("sample.views.style.css");
        primaryStage.setScene(new Scene(root, 700, 380));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);

    }
}
