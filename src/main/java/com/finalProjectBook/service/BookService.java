package com.finalProjectBook.service;

import com.finalProjectBook.dao.BookDAO;
import com.finalProjectBook.exception.ResourceNotFound;
import com.finalProjectBook.model.Book;
import com.finalProjectBook.validation.Validation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.finalProjectBook.validation.Message.*;

@Service
public class BookService {

    private final BookDAO bookDAO;

    private final Validation validation;

    public BookService(BookDAO bookDAO, Validation validation) {
        this.bookDAO = bookDAO;
        this.validation = validation;
    }

    public void addBook(Book book) {
        if (!bookDAO.findBookByTitle(book.getTitle()).isPresent()) {
            bookDAO.addBook(book);
        } else{

        }
    }

    public Book findBookByTitle(String title) {

        if (!validation.isExistBookWithTitle(title)) {
            throw new ResourceNotFound(THE_BOOK_YOU_ARE_LOOKING_FOR_WAS_NOT_FOUND);
        }
        return bookDAO.findBookByTitle(title).get();
    }

    public List<Book> findBookByAuthor(String author) {
        if (!validation.isExistingBookWithAuthor(author)) {
            throw new ResourceNotFound(NO_BOOKS_FOUND_BY_THIS_AUTHOR);
        }
        return bookDAO.findBookByAuthor(author);
    }

    public List<Book> findBookByPublicationDate(LocalDate date) {
        return bookDAO.findBookByPublicationDate(date);
    }

    public List<Book> findBookByPublisher(String publisher) {
        return bookDAO.findBookByPublisher(publisher);
    }

    public List<Book> findBookByPrice(BigDecimal price) {
        return bookDAO.findBookByPrice(price);
    }

    public List<Book> findBookByQuantity(int quantity) {
        return bookDAO.findBookByQuantity(quantity);
    }

    public void sellBook(int id) {
        if (isBookExist(id) && checkBookQuantity(id) > 0) {
            decreaseQuantity(id);
        }
    }

    private void deleteById(int id) {
        if (isBookExist(id) && checkBookQuantity(id) == 0) {
            bookDAO.deleteBook(id);
        } else{
            throw new ResourceNotFound(NO_BOOKS_FOUND_BY_THIS_ID);
        }
    }

    private Integer checkBookQuantity(int id) {
        return bookDAO.getBookQuantity(id);
    }

    public void decreaseQuantity(int id) {

        if (checkBookQuantity(id) >= 1) {
            bookDAO.updateQuantity(id, checkBookQuantity(id) - 1);
        }
        if (checkBookQuantity(id) == 0) {
            bookDAO.addToFbookHist(bookDAO.getBookById(id).get());
            deleteById(id);
        }
    }

    private boolean isBookExist(int id) {
        boolean isBookExist = false;
        if (bookDAO.getBookById(id).isPresent()) {
            isBookExist = true;
        }
        return isBookExist;
    }

}