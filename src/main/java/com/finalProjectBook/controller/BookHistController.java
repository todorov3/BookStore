package com.finalProjectBook.controller;

import com.finalProjectBook.model.BookHist;
import com.finalProjectBook.service.BookHistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/bookHist")
public class BookHistController {
    private final BookHistService bookHistService;

    public BookHistController(BookHistService bookHistService) {
        this.bookHistService = bookHistService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title")
    public BookHist findByTitle(@RequestParam String title) {
        return bookHistService.findBookByTitle(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/author")
    public List<BookHist> findBookByAuthor(@RequestParam String author) {
        return bookHistService.findBookByAuthor(author);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/date")
    public List<BookHist> findBookByPublicationDate(@RequestParam String date) throws ParseException {
        return bookHistService.findBookByPublicationDate(date);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/publisher")
    public List<BookHist> findBookByPublisher(@RequestParam String publisher){
        return bookHistService.findBookByPublisher(publisher);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public List<BookHist> findBookByPrice(@RequestParam BigDecimal price){
        return bookHistService.findBookByPrice(price);
    }
}
