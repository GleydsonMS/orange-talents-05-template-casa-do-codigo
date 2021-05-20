package br.com.zupacademy.gleydson.casadocodigo.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class ListBooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<ListBookDTO>> listBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return ResponseEntity.ok().body(ListBookDTO.convert(books));
    }
}
