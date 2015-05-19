package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.Book;
import sample.Main;
import sample.views.BookListCell;
import sample.views.BookListItemView;

import java.net.URL;
import java.util.ResourceBundle;

public class BooksController implements Initializable {

    @FXML
    public ListView<Book> booksView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        booksView.setCellFactory(new Callback<ListView<Book>, ListCell<Book>>() {
            @Override
            public ListCell<Book> call(ListView<Book> param) {

                return new BookListCell();
            }
        });

        booksView.setItems(Main.books);
    }
}







