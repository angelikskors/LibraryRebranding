package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Window;
import sample.Book;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class BookEstimaterController implements Initializable {
    public Book book;
    public Label firstCriteria;
    public ComboBox chooser;
    public ComboBox chooser2;
    public ComboBox chooser3;
    public ComboBox chooser4;
    public ComboBox chooser5;

    public Label thirdCriteria;
    public Label forthCriteria;
    public Label fifthCriteria;
    public Label secondCriteria;
    ArrayList<Integer> scores = new ArrayList<>();

    public static double averageCount(ArrayList<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            sum += value;

        }
        return sum / 5;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstCriteria.setText("The main idea/plot ");
        secondCriteria.setText("The implementation of the main idea(integrity,logic) ");
        thirdCriteria.setText("Language-style ");
        forthCriteria.setText("Literacy");
        fifthCriteria.setText("Your feeling after reading this book ");
        chooser.getItems().addAll("1", "2", "3", "4", "5");
        chooser.setPromptText("Choose suitable score");
        chooser2.setItems(chooser.getItems());
        chooser2.setPromptText(chooser.getPromptText());
        chooser3.setItems(chooser.getItems());
        chooser3.setPromptText(chooser.getPromptText());

        chooser4.setItems(chooser.getItems());
        chooser4.setPromptText(chooser.getPromptText());

        chooser5.setItems(chooser.getItems());
        chooser5.setPromptText(chooser.getPromptText());


    }

    public void handleOk(ActionEvent actionEvent) {
        scores.add(Integer.parseInt(chooser.getValue().toString()));
        scores.add(Integer.parseInt(chooser2.getValue().toString()));
        scores.add(Integer.parseInt(chooser3.getValue().toString()));
        scores.add(Integer.parseInt(chooser4.getValue().toString()));
        scores.add(Integer.parseInt(chooser5.getValue().toString()));
        book.setPopularity(averageCount(scores));
        Window window = chooser5.getScene().getWindow();
        window.hide();


    }

    public void addToList(Book book) {
        this.book = book;


    }


}
