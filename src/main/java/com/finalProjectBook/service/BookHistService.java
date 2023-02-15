package com.finalProjectBook.service;

import com.finalProjectBook.dao.BookHistDAO;
import com.finalProjectBook.model.Book;
import com.finalProjectBook.model.BookHist;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@Service
public class BookHistService {

    private final BookHistDAO bookHistDAO;

    public BookHistService(BookHistDAO bookHistDAO) {
        this.bookHistDAO = bookHistDAO;
    }

    public BookHist findBookByTitle(String title) {
        return bookHistDAO.findBookByTitle(title);
    }

    public List<BookHist> findBookByAuthor(String author) {
        return bookHistDAO.findBookByAuthor(author);
    }

    public List<BookHist> findBookByPublicationDate(String date) throws ParseException {
        return bookHistDAO.findBookByPublicationDate(date);
    }

    public List<BookHist> findBookByPublisher(String publisher) {
        return bookHistDAO.findBookByPublisher(publisher);
    }

    public List<BookHist> findBookByPrice(BigDecimal price) {
        return bookHistDAO.findBookByPrice(price);
    }
}
