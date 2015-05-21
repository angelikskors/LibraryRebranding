package sample.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import sample.Book;
import sample.Main;
import sample.controllers.BookEditController;
import sample.utils.DownloadFile;
import sample.utils.FXMLHelper;

import java.io.*;

public class BookListItemView extends HBox {

    private static Book currentBook;
    @FXML
    private TextField nameField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;
    @FXML
    private ImageView coverView;
    @FXML
    private TextArea descriptionArea;
    private PathScreen pathScreen;

    public BookListItemView() {
        FXMLLoader fxmlLoader = FXMLHelper.loader("fxml/book_list_item.fxml");
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void download(String name) {
        new DownloadFile(currentBook.getPath(), name);
    }

    public void setBook(Book book) {


        currentBook = book;
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
        if (currentBook.getImage() != null) {
            addImage(currentBook);
        }
        descriptionArea.textProperty().bindBidirectional(book.descriptionProperty());

    }

    private synchronized void addImage(Book currentBook) {


        Image image = new Image(currentBook.getImage());

        coverView.setFitWidth(150);
        coverView.setFitHeight(170);
        coverView.setImage(image);
        setPadding(new Insets(10, 10, 10, 10));


    }

    @FXML
    public void handleEdit(ActionEvent actionEvent) {
        if (currentBook != null) {
            try {
                FXMLLoader fxmlLoader = FXMLHelper.loader("fxml/book_edit.fxml");
                Parent root = fxmlLoader.load();
                BookEditController controller =
                        fxmlLoader.getController();
                controller.setBook(currentBook);

                showNewWindow("Edit", root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void handleAddRate(ActionEvent actionEvent) {


    }

    @FXML
    public void handleDownload(ActionEvent actionEvent) {

        if (currentBook.getPath() == null) {
            Image image = new Image("file:questions.jpg");
            ErrorScreen root = new ErrorScreen("Nothing to download!", image);
            showNewWindow("Error", root);
        } else {
            pathScreen = new PathScreen("Please, enter the name for file");
            showNewWindow("Info", pathScreen);
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
