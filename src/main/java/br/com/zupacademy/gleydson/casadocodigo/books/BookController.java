package br.com.zupacademy.gleydson.casadocodigo.books;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid BookDTO bookDTO) {
        Book book = bookDTO.toModel(em);
        em.persist(book);
        return book.toString();
    }
}
