package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Book;
import sample.Main;
import sample.views.BookListItemView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookEditController implements Initializable {
    @FXML
    public TextField authorField;
    @FXML
    private TextField nameField;

    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;
    @FXML
    private TextArea descriptionArea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }






}


