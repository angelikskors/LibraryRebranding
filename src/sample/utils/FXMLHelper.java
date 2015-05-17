package sample.utils;

import javafx.fxml.FXMLLoader;
import sample.Main;
import sample.UTF8Control;

import java.util.Locale;
import java.util.ResourceBundle;

public class FXMLHelper {

    private static final String LOCALE_RESOURCE = "res/string";

    private static final String LANGUAGE = "ru";
    private static final String COUNTRY = "RU";

    public static FXMLLoader loader(String xmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(xmlPath),
                resources());
        return fxmlLoader;
    }

    public static FXMLLoader loader(String xmlPath, ResourceBundle bundle) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(xmlPath),
                bundle);
        return fxmlLoader;
    }

    public static ResourceBundle resources() {
        return ResourceBundle.getBundle(
                "res/string",
  new UTF8Control());
    }
}
