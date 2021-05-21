package br.com.zupacademy.gleydson.casadocodigo.booksdetails;

import br.com.zupacademy.gleydson.casadocodigo.books.Book;

import java.math.BigDecimal;

public class BookDetailsDTO {

    private String title;
    private BigDecimal price;
    private String resume;
    private String summary;
    private Integer pages;
    private String isbn;

    private AuthorDetailsDTO author;

    @Deprecated
    public BookDetailsDTO(){}

    public BookDetailsDTO(Book book) {
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.resume = book.getResume();
        this.summary = book.getSummary();
        this.pages = book.getPages();
        this.isbn = book.getIsbn();
        this.author = new AuthorDetailsDTO(book.getAuthor());
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public AuthorDetailsDTO getAuthor() {
        return author;
    }
}
