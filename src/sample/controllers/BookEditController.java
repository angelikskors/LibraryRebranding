package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.StringConverter;
import sample.Book;
import sample.Main;
import sample.views.ErrorScreen;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class BookEditController implements Initializable {
    @FXML
    public TextField authorField;
    @FXML
    public TextField pathFieldForImage;
    @FXML
    private TextField nameField;

    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;
    @FXML
    private TextField pathField;
    @FXML
    private TextArea descriptionArea;
    private File currentOpenFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        yearField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent t) {
                char ar[] = t.getCharacter().toCharArray();
                char ch = ar[t.getCharacter().toCharArray().length - 1];
                if (!(ch >= '0' && ch <= '9')) {
                    System.out.println("The char you entered is not a number");
                    t.consume();
                } else if (yearField.getText().length() >= 4) {
                    System.out.println("Year string to long");
                    t.consume();
                }
            }
        });

        pagesField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent t) {
                char ar[] = t.getCharacter().toCharArray();
                char ch = ar[t.getCharacter().toCharArray().length - 1];
                if (!(ch >= '0' && ch <= '9')) {
                    System.out.println("The char you entered is not a number");
                    t.consume();
                }
            }
        });
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
                return parseInt(string);
            }
        });

        pagesField.textProperty().bindBidirectional(book.pageProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return parseInt(string);
            }
        });
        descriptionArea.textProperty().bindBidirectional(book.descriptionProperty());
        pathFieldForImage.textProperty().bindBidirectional(book.imageProperty());
    }

    public void handleEdit(ActionEvent actionEvent) {
        Window window = descriptionArea.getScene().getWindow();
        window.hide();

    }

    public void handleAdd(ActionEvent actionEvent) {


        if (yearField.getText() == null | pagesField.getText() == null) {
            Image img = new Image("file:questions.jpg");
            ErrorScreen screen = new ErrorScreen("Invalid Format", img);
            new MainWindowController().showNewWindow("Error", screen);

        } else {
            Book book = new Book(nameField.getText(), authorField.getText(), genreField.getText(), parseInt(yearField.getText()), parseInt(pagesField.getText()), pathField.getText(), descriptionArea.getText(), pathFieldForImage.getText());

            Main.books.add(book);

            Window window = descriptionArea.getScene().getWindow();
            window.hide();
            System.out.println("Finished");
        }
    }

    private boolean openFile() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
        currentOpenFile = fileChooser.showOpenDialog(stage);
        if (currentOpenFile != null) {
            pathField.setText(currentOpenFile.getPath());

        }
        return false;
    }

    public void handleChoose(ActionEvent actionEvent) {
        openFile();


    }

    @FXML
    public void handleChooseImage(ActionEvent actionEvent) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.gif", "*.png"));
        currentOpenFile = fileChooser.showOpenDialog(stage);
        if (currentOpenFile != null) {
            File absoluteFile = currentOpenFile.getAbsoluteFile();
            pathFieldForImage.setText(absoluteFile.toURI().toString());

        }
    }


}


