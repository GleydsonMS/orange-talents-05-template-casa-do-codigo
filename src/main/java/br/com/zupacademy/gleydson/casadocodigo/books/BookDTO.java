package br.com.zupacademy.gleydson.casadocodigo.books;

import br.com.zupacademy.gleydson.casadocodigo.authors.Author;
import br.com.zupacademy.gleydson.casadocodigo.categories.Category;
import br.com.zupacademy.gleydson.casadocodigo.validators.ExistId;
import br.com.zupacademy.gleydson.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDTO {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotBlank
    @Size(max = 500)
    private String resume;

    @NotBlank
    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer pages;

    @NotBlank
    @ISBN(type = ISBN.Type.ANY)
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @ExistId(domainClass = Author.class, fieldName = "id")
    private Long authorId;

    @NotNull
    @ExistId(domainClass = Category.class, fieldName = "id")
    private Long categoryId;

    public BookDTO(@NotBlank String title,
                   @NotBlank @Size(max = 500) String resume,
                   String summary,
                   @NotNull @Min(20) BigDecimal price,
                   @NotNull @Min(100) Integer pages,
                   @NotBlank @ISBN(type = ISBN.Type.ANY) String isbn,
                   @Future LocalDate publicationDate,
                   @NotNull Long authorId,
                   @NotNull Long categoryId) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    @Deprecated
    public BookDTO() {}

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

    public Long getAuthorId() {
        return authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", authorId=" + authorId +
                ", categoryId=" + categoryId +
                '}';
    }

    public Book toModel(EntityManager em) {
        Author author = em.find(Author.class, authorId);
        Category category = em.find(Category.class, categoryId);

        Assert.state(author!=null, "Autor não encontrado. " + authorId);
        Assert.state(category!=null, "Categoria não encontrada. " + categoryId);

        Book book = new Book(title, resume, summary, price, pages, isbn, publicationDate, author, category);

        return book;
    }
}
