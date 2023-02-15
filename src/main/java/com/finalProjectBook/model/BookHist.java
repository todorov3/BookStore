package com.finalProjectBook.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class BookHist {
    private int id;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String publisher;
    private BigDecimal price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publishingDate) {
        this.publicationDate = publishingDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookHist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingDate=" + publicationDate +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}
