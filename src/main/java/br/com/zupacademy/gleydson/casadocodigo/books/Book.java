package br.com.zupacademy.gleydson.casadocodigo.books;

import br.com.zupacademy.gleydson.casadocodigo.authors.Author;
import br.com.zupacademy.gleydson.casadocodigo.categories.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String title;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    @Size(max = 500)
    private String resume;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer pages;

    @NotBlank
    @ISBN(type = ISBN.Type.ANY)
    @Column(unique = true)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @ManyToOne
    @Valid
    private Author author;

    @NotNull
    @ManyToOne
    @Valid
    private Category category;

    @Deprecated
    public Book(){}

    public Book(@NotBlank String title,
                @NotBlank @Size(max = 500) String resume,
                String summary,
                @NotNull @Min(20)BigDecimal price,
                @NotNull @Min(100)Integer pages,
                @NotBlank @ISBN(type = ISBN.Type.ANY) String isbn,
                @Future LocalDate publicationDate,
                @NotNull @Valid Author author,
                @NotNull @Valid Category category) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.author = author;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", author=" + author +
                ", category=" + category +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }
}
