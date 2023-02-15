package com.finalProjectBook.dao;

import com.finalProjectBook.model.BookHist;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class BookHistDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public BookHistDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public BookHist findBookByTitle(String title) {

        return namedParameterJdbcTemplate.queryForObject("select * from fbook_hist where title = :title",
                new MapSqlParameterSource("title", title), BeanPropertyRowMapper.newInstance(BookHist.class));
    }

    public List<BookHist> findBookByAuthor(String author) {
        String sql = "select * from fbook_hist where author = :author";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("author", author);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> {
            BookHist bookHist = new BookHist();
            bookHist.setId(rs.getInt("id"));
            bookHist.setTitle(rs.getString("title"));
            bookHist.setAuthor(rs.getString("author"));
            bookHist.setPublicationDate(rs.getDate("publicationDate").toLocalDate());
            bookHist.setPublisher(rs.getString("publisher"));
            bookHist.setPrice(rs.getBigDecimal("price"));

            return bookHist;

        });
    }

    public List<BookHist> findBookByPublicationDate(String date) throws ParseException {
        format = new SimpleDateFormat("dd/MM/yyyy");
        String sql = "select * from fbook_hist where publicationDate = :publicationDate";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("publicationDate", format.parse(date));
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> {
            BookHist bookHist = new BookHist();
            bookHist.setId(rs.getInt("id"));
            bookHist.setTitle(rs.getString("title"));
            bookHist.setAuthor(rs.getString("author"));
            bookHist.setPublicationDate(rs.getDate("publicationDate").toLocalDate());
            bookHist.setPublisher(rs.getString("publisher"));
            bookHist.setPrice(rs.getBigDecimal("price"));

            return bookHist;

        });
    }

    public List<BookHist> findBookByPublisher(String publisher) {
        String sql = "select * from fbook_hist where publisher = :publisher";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("publisher", publisher);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> {
            BookHist bookHist = new BookHist();
            bookHist.setId(rs.getInt("id"));
            bookHist.setTitle(rs.getString("title"));
            bookHist.setAuthor(rs.getString("author"));
            bookHist.setPublicationDate(rs.getDate("publicationDate").toLocalDate());
            bookHist.setPublisher(rs.getString("publisher"));
            bookHist.setPrice(rs.getBigDecimal("price"));

            return bookHist;

        });
    }

    public List<BookHist> findBookByPrice(BigDecimal price) {
        String sql = "select * from fbook_hist where price = :price";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("price", price);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> {
            BookHist bookHist = new BookHist();
            bookHist.setId(rs.getInt("id"));
            bookHist.setTitle(rs.getString("title"));
            bookHist.setAuthor(rs.getString("author"));
            bookHist.setPublicationDate(rs.getDate("publicationDate").toLocalDate());
            bookHist.setPublisher(rs.getString("publisher"));
            bookHist.setPrice(rs.getBigDecimal("price"));

            return bookHist;

        });
    }
}
