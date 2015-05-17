package sample.views;

import javafx.scene.control.ListCell;
import sample.Book;

public class BookListCell extends ListCell<Book> {

    private BookListItemView bookListItemView;

    public BookListCell() {
        bookListItemView = new BookListItemView();
    }

    @Override
    protected void updateItem(Book item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            bookListItemView.setBook(item);
            setGraphic(bookListItemView);
        }
    }
}
