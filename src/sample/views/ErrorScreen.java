package sample.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by PC Kors on 19.05.2015.
 */


public class ErrorScreen extends VBox {
    private String msg;
    private VBox vBox;
    private Image image;

    public ErrorScreen(String msg, Image image) {
        this.msg = msg;
        this.image = image;
        VBox uiError = buildError();
    }

    ErrorScreen(Image image) {

        this.image = image;
        VBox uiError = buildError();
    }

    private VBox buildError() {

        setPadding(new Insets(10, 10, 10, 10));
        //vBox = new VBox();
        HBox stringsBox = new HBox();

        ImageView newImageView = new ImageView();
        newImageView.setImage(image);
        newImageView.setFitHeight(150);
        newImageView.setFitWidth(150);
        newImageView.setLayoutX(0);
        Label newLabel = new Label();
        newLabel.setText(msg);

        newLabel.setAlignment(Pos.BASELINE_LEFT);

        newLabel.setGraphic(newImageView);
        stringsBox.getChildren().add(newLabel);
        getChildren().add(stringsBox);

        return vBox;
    }

}


