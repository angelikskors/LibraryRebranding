package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.utils.FXMLHelper;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    public static final ObservableList<Book> books = FXCollections.observableArrayList();

    static {
        books.add(new Book("Psychological thriller novel", "The Talented Mr. Ripley", "Patricia Highsmith", 1955, 400, "https://raw.githubusercontent.com/angelikskors/LibraryRebranding/master/The_Talented_Mr_Ripley-Patricia_Highsmith.txt", "The detectives by Patricia Highsmith is more than just ordinary investigation stories. They more like psychological novels with detective component. Tom Ripley is 25-years man, who was grown up without parents by hateful aunt. He is quite poor and lives in poverty all his life. That�s why he dreams of a luxury life with travelling and buying expensive things every day so much. But because he isn�t good educated, have no skills nor genius ideas he just can�t became rich not breaking the law. His actions are disgusting and have no borders. After scrolling accounting frauds during some time, Tom becomes beware of police. So when a famous financier Herbert Greenleaf proposing a job in London Tom agrees immediately.", "file:TheTalented.jpg"));

        books.add(new Book("Novel", "Kim ", "Rudyard Kipling", 1901, 365, "https://raw.githubusercontent.com/angelikskors/LibraryRebranding/master/Kim-Rudyard_Kipling.txt", "This all happened in the late of nineteen century. Young boy named Kim the son of the dead British officer, was earning for the life by begging, and was working for the horse-seller Mahbub Ali. Later it was clear that Ali is connected with the British agency. Ali told to Kim about the �Big Game� that were playing by British and Russian governments. The aim of game is inside Asia. According to Kim�s knowledge about Hindu, their customs and habits, and because he had been living among them for a long time but indeed was the British � Englishmen decided make him a British spy. Kim had to break plans of England enemies.", "file:Kipling.jpg"));
        books.add(new Book("Novel", "Treasure Island", "Robert Louis Stevenson", 1911, 365, "https://raw.githubusercontent.com/angelikskors/LibraryRebranding/master/Treasure_Island-Robert_Louis_Stevenson.txt", "This book is a classic pirate�s adventure novel. It�s fascinating story about the search of treasure which has been hidden by the captain Flint on a desert island. A young boy Jim accidentally involved in this story and later played a very significant role. It began when an old seaman had arrived to the inn, owned by the boy�s father. It was immediately clear that this man accustomed to command. He introduced himself as Capitan and was a cad and drank constantly. He tried to avoid any society, but when he was drunk, he told his sea stories for all around. Captain was paying Jim Hawkins for watching the emergence of seaman with one leg, it seemed he was very afraid to meet one-legged sailor for some reason. Soon, Jim�s routine life was turned upside-down by terrible and unexpected accidents.", "file:Treasure_Island.jpg"));
        books.add(new Book("Crime", "Logan's Choice", "Richard MacAndrew", 2006, 300, "https://raw.githubusercontent.com/angelikskors/LibraryRebranding/master/Logan_Choice-Richard_MacAndrew.txt", "In Edinburgh, a son of a wealthy tycoon has died. His body was found by his wife on the bathroom floor. When she woke up alone in the middle of the night, she was anxious by missing her husband, so she started a search. Finally, she found a locked door in the bath.\n" +
                "Wife called his brother for help and he knocked out the door. Everything was very simple at first glance � it�s just another accident. The victim slipped on a wet floor, brake a knee and hit by a head. At the crime scene were some strange things and Inspector Logan intuition said to her that it�s not so simple as it�s seems. During the interviewing, the wife and her brother clearly said not the whole truth, so Logan�s suspicions only increased. So was it an accident or cold-blooded murder?", "file:Logan_Choice.jpg"));
        books.add(new Book("Thriller", "A Tangled Web", "L. M. Montgomery", 1931, 324, "https://raw.githubusercontent.com/angelikskors/LibraryRebranding/master/A_Tangled_Web-Alan_Maley.txt", "Dan was dismissed from MI6 after the failure of an important operation in the United States. He and survived members of the operation had to disappear from the country. He divorced his wife left his daughter from that marriage, but their relationship is bad because of his work. He regrets that he was a bad father but nothing he could do, he better do not build close relationship with his daughter � this was one of the conditions for withdrawal from MI6 � their old personality with all the connections had to disappear, and new people will appear in several other countries. Formers do not know about each other location and such they fill safe. But suddenly Dan is attacked by someone from his past life.", "file:A_Tangled.jpg"));
        books.add(new Book("Fairy tale", "Beauty and the Beast", "Jeanne-Marie Leprince de Beaumont", 1756, 50, null, "It�s a charming fairy-tale for the little ones. Once upon a time in the city by the sea lived a rich merchant with his big falimy. He had three sons and three daughters. One of the children, daughter Beauty, was very special. She had a kind heart and was so beautiful, that everybody loved her. One day when merchant went back home across the forest the weather got worse and he had lost his way. Suddenly the man had found a castle and hoped for survive there. The castle was empty, but he had found there a food, warm bed and clothes. The next day, when the weather got better, old merchant went out to the garden and took one most beautiful rose for his Beauty. It was a terrible mistake because it angered the owner of this castle. Now old man had to pay by his death", "file:The_Beautyt.jpg"));

    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("", ""));
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader loader = FXMLHelper.loader("fxml/MainWindow.fxml");
        Parent root = loader.load();
        primaryStage.setTitle(resources.getString("key_title"));
        root.getStyleClass().add("sample.css.style.css");
        primaryStage.setScene(new Scene(root, 730, 420));
        primaryStage.show();
    }
}
