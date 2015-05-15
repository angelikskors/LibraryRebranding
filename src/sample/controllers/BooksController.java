package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.Book;
import sample.views.BookListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    @FXML
    private ListView<Book> booksView;

    private final ObservableList<Book> books = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        books.add(new Book("aaa", "aaa", "aaa", 1000));
        books.add(new Book("bbb", "bbb", "bbb", 1000));
        booksView.setCellFactory(new Callback<ListView<Book>, ListCell<Book>>() {
            @Override
            public ListCell<Book> call(ListView<Book> param) {
                return new BookListCell();
            }
        });
        booksView.setItems(books);
    }
}
