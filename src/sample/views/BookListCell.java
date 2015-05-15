package sample.views;

import javafx.scene.control.ListCell;
import sample.Book;

public class BookListCell extends ListCell<Book> {

    @Override
    protected void updateItem(Book item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            BookListItemView bookListItemView = new BookListItemView();
            bookListItemView.setBook(item);
            setGraphic(bookListItemView);
        }
    }
}
