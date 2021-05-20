package br.com.zupacademy.gleydson.casadocodigo.books;

import java.util.List;
import java.util.stream.Collectors;

public class ListBookDTO {

    private Long id;
    private String title;

    @Deprecated
    public ListBookDTO() {}

    public ListBookDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static List<ListBookDTO> convert(List<Book> books) {
        return books.stream().map(book -> new ListBookDTO(book.getId(), book.getTitle())).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
