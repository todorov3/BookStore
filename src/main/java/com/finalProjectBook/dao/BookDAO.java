package com.finalProjectBook.dao;

import com.finalProjectBook.model.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void addBook(Book book) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("author", book.getAuthor())
                .addValue("publicationDate", book.getPublicationDate())
                .addValue("publisher", book.getPublisher())
                .addValue("price", book.getPrice())
                .addValue("quantity", book.getQuantity());
        String sql = "insert into fbook (" +
                "title, " +
                "author, " +
                "publicationDate, " +
                "publisher, " +
                "price, " +
                "quantity) " +
                "values(" +
                ":title, " +
                ":author, " +
                ":publicationDate, " +
                ":publisher, " +
                ":price, " +
                ":quantity)";
        namedParameterJdbcTemplate.update(sql, params);

    }

    public Optional<Book> findBookByTitle(String title) {

        try{
        return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject("select * from fbook where title = :title",
                new MapSqlParameterSource("title", title), BeanPropertyRowMapper.newInstance(Book.class)));
        } catch(EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    public List<Book> findBookByAuthor(String author) {
        String sql = "select * from fbook where author = :author";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("author", author);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> getBook(rs));
    }

    public List<Book> findBookByPublicationDate(LocalDate date) {

        String sql = "select * from fbook where publicationDate = :publicationDate";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("publicationDate", date);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> getBook(rs));
    }

    public List<Book> findBookByPublisher(String publisher) {
        String sql = "select * from fbook where publisher = :publisher";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("publisher", publisher);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> getBook(rs));
    }



    public List<Book> findBookByPrice(BigDecimal price) {
        String sql = "select * from fbook where price = :price";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("price", price);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> getBook(rs));
    }

    public List<Book> findBookByQuantity(int quantity) {
        String sql = "select * from fbook where quantity = :quantity";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("quantity", quantity);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> getBook(rs));
    }

    public Integer getBookQuantity(int id) {
        String sql = "select quantity from fbook where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, mapSqlParameterSource, Integer.class);
    }

    public Integer getBookId(String title, String author){
        String sql = "select id from fbook where (title = :title) and (author = :author)";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("title", title)
                .addValue("author", author);
        return namedParameterJdbcTemplate.queryForObject(sql, mapSqlParameterSource, Integer.class);
    }

    public List<Book> getAllBooks(){
        String sql = "select * from fbook";
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> getBook(rs));
    }

    public void updateQuantity(int id, int quantity) {

        String sql = "update fbook set quantity = :quantity where id = :id";

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("quantity", quantity);
        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);
    }

    public Optional<Book> getBookById(int id) {
        String sql = "select id, title, author, publicationDate, publisher, price, quantity from fbook where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);
        try {
            return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(sql, mapSqlParameterSource, (rs, rowNum) -> getBook(rs)));

        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    public void addToFbookHist(Book book) {
        String sql = "insert into fbook_hist (title, author, publicationDate, publisher, price) values(:title, :author, :publicationDate, :publisher, :price)";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("author", book.getAuthor())
                .addValue("publicationDate", book.getPublicationDate())
                .addValue("publisher", book.getPublisher())
                .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);
    }

    public void deleteBook(int id) {
        String sql = "delete from fbook where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);
        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);
    }
    private Book getBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublicationDate(rs.getObject(("publicationDate"), LocalDate.class));
        book.setPublisher(rs.getString("publisher"));
        book.setPrice(rs.getBigDecimal("price"));
        book.setQuantity(rs.getInt("quantity"));
        return book;
    }
}
