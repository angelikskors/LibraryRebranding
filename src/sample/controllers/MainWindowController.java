package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Book;
import sample.Main;
import sample.utils.FXMLHelper;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController {
    @FXML
    private ImageView img;


    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("file: bookInCloud.png");
        img = new ImageView();
        img.setImage(image);


    }

    @FXML
    public void handleAddNew() {
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader fxmlLoader = FXMLHelper.loader("fxml/book_add.fxml", resources);

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
        FXMLLoader loader = FXMLHelper.loader("fxml/books_window.fxml", resources);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showNewWindow("Base ", root);

    }

    public void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        Scene scene = new Scene(root, 660, 520);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleService(ActionEvent actionEvent) {
        //TODO add new function , which gives user an opportunity to make choice faster

    }

    @FXML
    public void handleContactUs(ActionEvent actionEvent) {
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader loader = FXMLHelper.loader("fxml/email.fxml", resources);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showNewWindow("Send us a message", root);
    }

    public void handleUpdateBase(ActionEvent actionEvent) {
        System.out.println("Started");
        String str = "D://text.txt";
        File base = new File(str);
        ObjectOutputStream out = null;
        try {
            FileOutputStream fos = new FileOutputStream(base, false);

            out = new ObjectOutputStream(fos);
            out.writeInt(Main.books.size());
            for (Book book : Main.books) {
                out.writeObject(book);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Finished");
    }
}