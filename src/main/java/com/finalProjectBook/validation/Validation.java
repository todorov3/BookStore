package com.finalProjectBook.validation;

import com.finalProjectBook.dao.BookDAO;
import com.finalProjectBook.dao.BookHistDAO;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    private final BookDAO bookDAO;
    private final BookHistDAO bookHistDAO;

    public Validation(BookDAO bookDAO, BookHistDAO bookHistDAO) {
        this.bookDAO = bookDAO;
        this.bookHistDAO = bookHistDAO;
    }

    public boolean isExistBookWithTitle(String title) {
        return bookDAO.findBookByTitle(title).isPresent();
    }

    public boolean isExistingBookWithAuthor(String author) {
        return !bookDAO.findBookByAuthor(author).isEmpty();
    }
}
