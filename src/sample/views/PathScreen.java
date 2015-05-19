package sample.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

/**
 * Created by PC Kors on 19.05.2015.
 */
public class PathScreen extends VBox {
    private String msg;
    private VBox vBox;

    public PathScreen(String msg) {
        this.msg = msg;
        VBox little = buildBox(msg);
    }

    private VBox buildBox(String msg) {
        VBox vBox = new VBox();
        setPadding(new Insets(10, 10, 10, 10));
        HBox hBox = new HBox();
        Label label = new Label();

        label.setText(msg);
        hBox.getChildren().add(label);
        getChildren().add(hBox);
        HBox hBox1 = new HBox();
        TextField textField = new TextField();
        hBox1.getChildren().add(textField);
        getChildren().add(hBox1);
        HBox hBox2 = new HBox();

        Button ok = new Button();
        hBox2.getChildren().add(ok);
        getChildren().add(hBox2);
        ok.setText("OK ");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textField.getText() != null) {
                    if (textField.getText().contains(".txt")) {
                        BookListItemView.download(textField.getText());
                    } else {
                        BookListItemView.download(textField.getText() + ".txt");
                    }
                    Window window = textField.getScene().getWindow();
                    window.hide();
                } else {
                    System.out.println("Nothing entered");
                }
            }
        });

        return vBox;
    }
}
