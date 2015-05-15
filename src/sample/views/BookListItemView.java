package sample.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.Book;
import sample.utils.FXMLHelper;

import java.io.IOException;

public class BookListItemView extends HBox {

    @FXML
    private TextField nameField;
    @FXML
    private TextField authorField;

    public BookListItemView() {
        FXMLLoader fxmlLoader = FXMLHelper.loader("views/book_list_item.fxml");
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBook(Book book) {
        nameField.textProperty().bindBidirectional(book.nameProperty());
        authorField.textProperty().bindBidirectional(book.authorProperty());
    }
}
