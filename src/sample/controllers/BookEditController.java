package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Book;
import sample.Main;
import sample.views.BookListItemView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookEditController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;
    @FXML
    private TextArea descriptionArea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void handleEdit(ActionEvent actionEvent) {
        Book selectedBook = new BooksController().booksView.getSelectionModel().getSelectedItem();

        if (selectedBook != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("book_edit.fxml"));
                Parent root = fxmlLoader.load();

                new BookListItemView().setBook(selectedBook);
                showNewWindow("Edit", root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @FXML
    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}


