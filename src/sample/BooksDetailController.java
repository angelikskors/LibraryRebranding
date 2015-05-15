package sample;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class BooksDetailController {


     @FXML
    private Label genre;
    @FXML
    private Label name;
    @FXML
    private Label year;
    @FXML
    private Label author;
    @FXML
    private Label page;


    @FXML
    private TextArea description;
    private Book  book;
    private ChangeListener<String> listener;

    public void setBook(Book book) {
        if (this.book != null) {
            unhookListener();
        }
        this.book = book;
       hookTo(book);
    }

    private void unhookListener() {
        description.textProperty().removeListener(listener);
    }

    private void hookTo(Book book) {
        if (book == null) {
            genre.setText("");
            name.setText("");
            description.setText("");
            listener = null;
        } else {
            genre.setText(book.getGenre());
            name.setText(book.getName());
            description.setText(book.getDescription());
            listener = (observable, oldValue, newValue) ->
                    book.setDescription(newValue);
            description.textProperty().addListener(listener);
        }
    }
}
