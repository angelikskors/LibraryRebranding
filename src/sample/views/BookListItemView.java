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
import sample.Book;
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
        genreField.textProperty().bindBidirectional(book.genreProperty());
        yearField.textProperty().unbindBidirectional(book.yearProperty());
        pagesField.textProperty().unbindBidirectional(book.pageProperty());
        descriptionArea.textProperty().bindBidirectional(book.descriptionProperty());
        Image image = new Image(book.getImage());
        coverView = new ImageView();
        coverView.setFitWidth(150);
        coverView.setFitHeight(160);
        coverView.setImage(image);
        setPadding(new Insets(10, 10, 10, 10));
        getChildren().add(coverView);
    }

    @FXML
    public void handleEdit(ActionEvent actionEvent) {

    }

    @FXML
    public void handleAddComment(ActionEvent actionEvent) {


    }

    @FXML
    public void handleDownload(ActionEvent actionEvent) {


    }

    @FXML
    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


}
