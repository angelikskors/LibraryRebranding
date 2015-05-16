package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

    private String image;
    private String commentary;
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty author = new SimpleStringProperty("");
    private SimpleStringProperty genre = new SimpleStringProperty("");
    private SimpleIntegerProperty year = new SimpleIntegerProperty();
    private SimpleIntegerProperty page = new SimpleIntegerProperty();
    private SimpleStringProperty description = new SimpleStringProperty("");
    private SimpleIntegerProperty popularity = new SimpleIntegerProperty();

    public Book(String genre, String name, String author, int year, int page, String commentary) {
        setGenre(genre);
        setName(name);
        setAuthor(author);
        setYear(year);
        setPage(page);
        setCommentary(commentary);
    }

    public Book(String genre, String name, String author, int year, int page, String commentary, String description) {
        this(genre, name, author, year, page, commentary);
        setDescription(description);
    }

    public Book(String genre, String name, String author, int year, int page, String commentary, String description, String image) {
        this(genre, name, author, year, page, commentary, description);
        setImage(image);
    }

    public int getPage() {
        return page.get();
    }

    public void setPage(int page) {
        this.page.set(page);
    }

    public SimpleIntegerProperty pageProperty() {
        return page;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public int getPopularity() {
        return popularity.get();
    }

    public void setPopularity(int popularity) {
        this.popularity.set(popularity);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public SimpleIntegerProperty yearProperty() {

        return year;
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public SimpleIntegerProperty popularityProperty() {

        return popularity;
    }


}
