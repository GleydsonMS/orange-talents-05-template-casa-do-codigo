package br.com.zupacademy.gleydson.casadocodigo.booksdetails;

import br.com.zupacademy.gleydson.casadocodigo.authors.Author;

public class AuthorDetailsDTO {

    private String name;
    private String description;

    public AuthorDetailsDTO(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
