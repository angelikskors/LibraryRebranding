package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceBundle resources = ResourceBundle.getBundle(
                "res/string",
                new Locale("ru", "RU"),
                new UTF8Control());
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"),
                resources);
        primaryStage.setTitle(resources.getString("key_title"));
        primaryStage.setScene(new Scene(root, 650, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);

    }
}
