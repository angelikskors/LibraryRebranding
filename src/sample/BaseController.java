package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

 public class BaseController implements Initializable {
     private final ObservableList<Book> books = FXCollections.observableArrayList();
    @FXML
    private TableView<Book> booksView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image=new Image("file:book1.jpg");
books.add(new Book ("Biography","James Roosevelt Starks and Ida Marie Bowers"," J. Harker",0,46,null,"The journal of James Roosevelt Starks and his devoted wife, Ida Marie Bowers",image));
booksView.setItems(books);
    }
     public void handleDeleteAction(ActionEvent actionEvent) {


     }

     public void handleCreateAction(ActionEvent actionEvent) {


     }

     public void handleUpdateAction(ActionEvent actionEvent) {

     }

     private void showNewWindow(String title, Parent root) {
         Stage stage = new Stage();
         stage.setTitle(title);
         stage.setScene(new Scene(root));
         stage.show();
     }
 }


