package uk.codingplayroom.bls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.codingplayroom.bls.model.Book;
import uk.codingplayroom.bls.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookForId(int id) {
        return ResponseEntity.ok(bookService.returnBookById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.returnAllBooks());
    }

    @GetMapping("/all/{genre}")
    public ResponseEntity<List<Book>> getAllBooksForGenre(@PathVariable("genre") String genre) {
        return ResponseEntity.ok(bookService.returnBooksByGenre(genre));
    }

    @GetMapping("/{bookTitle}")
    public ResponseEntity<Book> getABook(@PathVariable("bookTitle") String requestedTitle) {
        return ResponseEntity.ok(bookService.returnBookByTitle(requestedTitle.toLowerCase()));
    }

    @GetMapping("/all/{author}")
    public ResponseEntity<List<Book>> getAllBookForAuthor(@PathVariable("author") String author) {
        return ResponseEntity.ok(bookService.returnBooksByAuthor(author));
    }
}
