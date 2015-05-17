package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Book;
import sample.views.BookListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    private final ObservableList<Book> books = FXCollections.observableArrayList();
    @FXML
    public ListView<Book> booksView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        books.add(new Book("aaasfsf", "saaa", "aaa", 11, 11, "dfgdg"));
        books.add(new Book("aaasfsf", "saaa", "aaa", 11, 11, "dfgdf"));
        booksView.setCellFactory(new Callback<ListView<Book>, ListCell<Book>>() {
            @Override
            public ListCell<Book> call(ListView<Book> param) {
                return new BookListCell();
            }
        });
        booksView.setItems(books);
    }

    @FXML
    private void handleEdit() {

    }

    @FXML
    private void handleDownload() {

    }

    @FXML
    private void handleAddComment() {

    }


    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


}
