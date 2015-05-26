package sample.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by PC Kors on 26.05.2015.
 */
public class BookChoiceController implements Initializable {

    public Label nameOfTheBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setNameOfThebook(String name) {
        nameOfTheBook.setText(name);

    }


}
