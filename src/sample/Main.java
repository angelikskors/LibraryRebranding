package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
 //       ResourceBundle resources = ResourceBundle.getBundle(
//                "res/string",
//              new Locale(""),
//                new UTF8Control());
//        Parent root = FXMLLoader.load(getClass().getResource("books.fxml"),
//                resources);
//        primaryStage.setTitle(resources.getString("key_title"));
//        primaryStage.setScene(new Scene(root, 650, 275));
//        primaryStage.show();
                FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(
                Main.class.getResource("BookTree.fxml"));


         BorderPane borderPane = fxmlLoader.load();
        Scene scene = new Scene(borderPane, 600, 500);
        primaryStage.setTitle("Book Base");
        primaryStage.setScene(scene);
        primaryStage.show();}
        public static void main(String[] args) {
            launch(args);
        }
    }
