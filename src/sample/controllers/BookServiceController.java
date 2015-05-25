package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Book;
import sample.Main;

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

        Book[] bookss = new Book[Main.books.toArray().length];
        for (int i = 0; i < bookss.length; i++) {
            bookss[i] = (Book) Main.books.toArray()[i];
        }
        for (int i = 0; i < bookss.length; i++) {
            if (bookFirst.getText().equals(bookss[i].getName())) {
                rate1 = new BookEstimaterController().averages.get(bookss[i].getName().hashCode());
                tm.put(rate1, bookss[i].getName());
            } else {
                System.out.println("Not found book");
            }
            if (bookSecond.getText().equals(bookss[i].getName())) {
                rate2 = new BookEstimaterController().averages.get(bookss[i].getName().hashCode());
                tm.put(rate2, bookss[i].getName());
            } else {
                System.out.println("Not found book");
            }
            if (bookThird.getText().equals(bookss[i].getName())) {
                rate3 = new BookEstimaterController().averages.get(bookss[i].getName().hashCode());
                tm.put(rate3, bookss[i].getName());
            } else {
                System.out.println("Not found book");
            }
            if (bookForth.getText().equals(bookss[i].getName())) {
                rate4 = new BookEstimaterController().averages.get(bookss[i].getName().hashCode());
                tm.put(rate4, bookss[i].getName());
            } else {
                System.out.println("Not found book");
            }
        }

        System.out.println(tm.get(tm.firstKey()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
