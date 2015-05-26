package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Book;
import sample.Main;
import sample.utils.FXMLHelper;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.TreeSet;

class MyComp implements Comparator<Double> {


    @Override
    public int compare(Double a, Double b) {
        return b.compareTo(a);
    }


}


public class BookServiceController implements Initializable {
    public Book currentBook;
    public TextField bookFirst;
    public TextField bookSecond;
    public TextField bookThird;
    public TextField bookForth;

    double rate1;
    double rate2;
    double rate3;
    double rate4;
    private TreeMap<Double, String> tm = new TreeMap<>(new MyComp());

    public void handleMakeChoice(ActionEvent actionEvent) {

        for (Book book : Main.books) {
  
            if (bookFirst.getText().equals(book.getName())) {
                rate1 = book.getPopularity();

                tm.put(rate1, book.getName());
            }
            if (bookSecond.getText().equals(book.getName())) {
                rate2 = book.getPopularity();
                System.out.println(rate2);
                tm.put(rate2, book.getName());
            }

        }
        if (tm.firstKey() != 0) {
            try {
                FXMLLoader fxmlLoader = FXMLHelper.loader("fxml/book_choice.fxml");
                Parent root = fxmlLoader.load();
                BookChoiceController controller =
                        fxmlLoader.getController();
                controller.setNameOfThebook(tm.get(tm.firstKey()));
                showNewWindow("Choice", root);
            } catch (IOException e) {
                e.printStackTrace();
        }
            System.out.println(tm.get(tm.firstKey()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    private void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
