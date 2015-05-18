package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Book;
import sample.views.BookListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    private final ObservableList<Book> books = FXCollections.observableArrayList();
    @FXML
    public ListView<Book> booksView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        books.add(new Book( "Psychological thriller novel", "The Talented Mr. Ripley","Patricia Highsmith", 1955,400, null,"The detectives by Patricia Highsmith is more than just ordinary investigation stories. They more like psychological novels with detective component. Tom Ripley is 25-years man, who was grown up without parents by hateful aunt. He is quite poor and lives in poverty all his life. That’s why he dreams of a luxury life with travelling and buying expensive things every day so much. But because he isn’t good educated, have no skills nor genius ideas he just can’t became rich not breaking the law. His actions are disgusting and have no borders. After scrolling accounting frauds during some time, Tom becomes beware of police. So when a famous financier Herbert Greenleaf proposing a job in London Tom agrees immediately.","file:TheTalented.jpg"));
        books.add(new Book("aaasfsf", "saaa", "aaa", 11, 11, "dfgdf"));
        booksView.setCellFactory(new Callback<ListView<Book>, ListCell<Book>>() {
            @Override
            public ListCell<Book> call(ListView<Book> param) {
                return new BookListCell();
            }
        });
        booksView.setItems(books);
    }




    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


}
