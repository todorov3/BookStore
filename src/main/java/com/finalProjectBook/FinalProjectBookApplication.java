package com.finalProjectBook;

import com.finalProjectBook.dao.BookDAO;
import com.finalProjectBook.dao.BookHistDAO;
import com.finalProjectBook.model.Book;
import com.finalProjectBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FinalProjectBookApplication implements CommandLineRunner {

	@Autowired
	BookDAO bookDAO;
	@Autowired
	BookService bookService;
	@Autowired
	BookHistDAO bookHistDAO;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectBookApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println(bookDAO.getBookById(3));
//		System.out.println(bookDAO.findBookByTitle("Legend"));
//		System.out.println(bookDAO.findBookByAuthor("Sarah J Maas"));
//		System.out.println(bookDAO.findBookByPublicationDate("16/04/2013"));
//		Book book = new Book(0, "Jack Reacher", "Lee Child", LocalDate.of(2004, 05, 11), "Bloomsbury", new BigDecimal("25.00"), 2);
//		bookDAO.addBook(book);
//		System.out.println(bookDAO.findBookByPublisher("Penguin"));
//		System.out.println(bookDAO.findBookByPrice(new BigDecimal("29.99")));
//		System.out.println(bookDAO.findBookByQuantity(3));
//      System.out.println(bookDAO.getBookQuantity(4));
//        System.out.println(bookDAO.getBookId("Jack Reacher", "Lee Child"));
//		bookService.sellBook(21);
//        bookService.sellBook(5);
//		System.out.println(bookHistDAO.findBookByTitle("Jack Reacher"));
//		System.out.println(bookHistDAO.findBookByAuthor("Lee Child"));
	}
}
