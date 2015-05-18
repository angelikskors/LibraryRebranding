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
import javafx.stage.Window;
import javafx.util.StringConverter;
import sample.Book;
import sample.Main;
import sample.views.BookListItemView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookEditController implements Initializable {
    @FXML
    public TextField authorField;
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


    public void setBook(Book book) {
        nameField.textProperty().bindBidirectional(book.nameProperty());
        authorField.textProperty().bindBidirectional(book.authorProperty());
        genreField.textProperty().bindBidirectional(book.genreProperty());

        yearField.textProperty().bindBidirectional(book.yearProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        });

        pagesField.textProperty().bindBidirectional(book.pageProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        });
        descriptionArea.textProperty().bindBidirectional(book.descriptionProperty());
    }

    public void handleEdit(ActionEvent actionEvent) {
        Window window = descriptionArea.getScene().getWindow();
        window.hide();

    }
}


