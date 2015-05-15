package sample;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BooksTreeController  implements Initializable{

 @FXML
 private TreeTableView<Book> treeTableView;

 @FXML
 private TreeTableColumn<Book, String> genre;
    @FXML
    private TreeTableColumn<Book, String> name;

    @FXML
    private VBox details;

    @FXML
    private IncludeExampleDetailController detailsController;

    public void initialize(URL location, ResourceBundle resources) {

       Book books[]=new Book[101];
        for (int i = 0; i <= 100; i++) {
            books[i] = new Book("Biography", "James Roosevelt Starks and Ida Marie Bowers", " J. Harker", 0, 46, null, "The journal of James Roosevelt Starks and his devoted wife, Ida Marie Bowers");
            }

   TreeItem<Book> root = new TreeItem<>(books[100]);
        root.setExpanded(true);
       for (int i = 0; i <100; i++) {
            TreeItem<Book> firstLevel =
                    new TreeItem<>(books[i]);
            firstLevel.setExpanded(true);
           for (int j = 0; j < 10; j++) {
               TreeItem<Book> secondLevel =
                        new TreeItem<>(books[j]);
               secondLevel.setExpanded(true);
                firstLevel.getChildren().add(secondLevel);}

    root.getChildren().add(firstLevel);}


       genre.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Book, String> param) {
               return param.getValue().getValue().genreProperty();
           }
       });
    name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Book, String> param) {
            return param.getValue().getValue().nameProperty();
            }
        });


        treeTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue)

                        ->

                {
                    Book book = null;
                    if (newValue != null) {
                        book = newValue.getValue();
        }
        detailsController.setBook(book);
    });
    }


}
