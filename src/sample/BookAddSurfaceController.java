package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;


public class BookAddSurfaceController implements Initializable{
    @FXML
    private TextField name;
    @FXML
    private TextField author;

    @FXML
    private TextField genre;
    @FXML
    private TextField year;
    @FXML
    private TextArea description;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleSaveAction(ActionEvent actionEvent) {
        closeCurrentWindow();
    }

    private void closeCurrentWindow() {
        Window window = author.getScene().getWindow();
        window.hide();
    }

    public void setUser(Book book) {
        name.textProperty().bindBidirectional(book.authorProperty());
        author.textProperty().bindBidirectional(book.genreProperty());
        genre.textProperty().bindBidirectional(book.genreProperty());
        year.textProperty();
        description.textProperty().bindBidirectional(book.descriptionProperty());
    }
}


