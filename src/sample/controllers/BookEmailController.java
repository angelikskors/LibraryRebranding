package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class BookEmailController implements Initializable {
    private final String serviceAddress = "servcie@gmail.com";
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
        String subject = nameUser.getText();
        String text = messageArea.getText();
        if (subject.length() != 0 && text.length() != 0) {
            String command = "cmd.exe /c start \"\" \"" + mailToString(subject, text) + "\"";
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String mailToString(String subject, String body) {
        StringBuilder builder = new StringBuilder("mailto:");
        builder.append(serviceAddress);
        builder.append("?");
        builder.append("subject=").append(subject.replaceAll(" ", "%20"));
        builder.append("&");
        builder.append("body=").append(body.replaceAll(" ", "%20"));
        return builder.toString();
    }
}
