package br.com.zupacademy.gleydson.casadocodigo.booksdetails;

import br.com.zupacademy.gleydson.casadocodigo.books.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/book-details")
public class BookDetailsController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> listDetails(@PathVariable Long id) {
        Book book = em.find(Book.class, id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }

        BookDetailsDTO bookDetailsDTO = new BookDetailsDTO(book);

        return ResponseEntity.ok().body(bookDetailsDTO);
    }
}
