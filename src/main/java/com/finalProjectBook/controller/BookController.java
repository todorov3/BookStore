package com.finalProjectBook.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finalProjectBook.model.Book;
import com.finalProjectBook.service.BookService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookStore")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/book")
    public void addBook(@RequestBody Book book){
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setPublicationDate(book.getPublicationDate());
        book.setPublisher(book.getPublisher());
        book.setPrice(book.getPrice());
        book.setQuantity(book.getQuantity());
        bookService.addBook(book);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title")
    public Book findBookByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/author")
    public List<Book> findBookByAuthor(@RequestParam String author){
        return bookService.findBookByAuthor(author);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/date")
    public List<Book> findBookByPublicationDate(@RequestParam @JsonFormat(pattern = "yyyy-MM-dd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
        return bookService.findBookByPublicationDate(date);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/publisher")
    public List<Book> findBookByPublisher(@RequestParam String publisher){
        return bookService.findBookByPublisher(publisher);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public List<Book> findBookByPrice(@RequestParam BigDecimal price){
        return bookService.findBookByPrice(price);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/quantity")
    public List<Book> findBookByQuantity(@RequestParam int quantity){
        return bookService.findBookByQuantity(quantity);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/qty")
    public void sellBook(@RequestParam int id) {
        bookService.sellBook(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/id")
    public void deleteById(@RequestParam int id){
        bookService.sellBook(id);
    }
}
