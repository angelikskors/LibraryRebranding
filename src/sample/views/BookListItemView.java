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
import sample.DownloadFile;
import sample.Main;
import sample.controllers.BookEditController;
import sample.controllers.BooksController;
import sample.utils.FXMLHelper;

import java.io.IOException;

public class BookListItemView extends HBox {

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
    private TextArea descriptionArea;
    @FXML
    private ImageView coverView;

    private Book currentBook;

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
        descriptionArea.textProperty().bindBidirectional(book.descriptionProperty());

        if(currentBook.getImage()!=null){
            Image image = new Image(currentBook.getImage());
            coverView = new ImageView();
            coverView.setFitWidth(150);
            coverView.setFitHeight(170);
            coverView.setImage(image);
            setPadding(new Insets(10, 10, 10, 10));
            getChildren().add(coverView);
        }

    }

    @FXML
    public void handleEdit(ActionEvent actionEvent) {
        if (currentBook != null) {
            try {
                FXMLLoader fxmlLoader = FXMLHelper.loader("views/book_edit.fxml");
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

        new DownloadFile(new BooksController().booksView.getSelectionModel().getSelectedItem().getPath());
    }

    @FXML
    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


}
