package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleStringProperty name=new SimpleStringProperty("");
    private SimpleStringProperty author=new SimpleStringProperty("");
    private SimpleStringProperty genre=new SimpleStringProperty("");
    private SimpleIntegerProperty year=new SimpleIntegerProperty();
    private SimpleStringProperty description=new SimpleStringProperty("");

    public Book(String genre, String name, String author, int year) {
        setGenre(genre);
        setName(name);
        setAuthor(author);
        setYear(year);
    }

    public Book(String genre, String name, String author, int year,String description) {
        this(genre,name,author,year);
       setDescription( description);
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
        this.genre.set( genre);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year.set(year);
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



}
