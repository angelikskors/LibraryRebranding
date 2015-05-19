package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.utils.JavaMail;

import java.net.URL;
import java.util.ResourceBundle;


public class BookEmailController implements Initializable {
    @FXML
    private TextField nameUser;
    @FXML
    private TextField emailField;
    @FXML
    private TextArea messageArea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleSend(ActionEvent actionEvent) {
        if (nameUser != null & emailField != null & messageArea != null) {
            JavaMail javaMail = new JavaMail(nameUser.getText(), emailField.getText(), messageArea.getText());
        }
    }
}
