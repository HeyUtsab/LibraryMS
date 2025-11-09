package com.library.library.Controllers;

import com.library.library.Model.Book;
import com.library.library.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return new ResponseEntity<>("Book added to the library ✅", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
            @RequestParam(value = "author", required = false) String author) {

        List<Book> bookList = bookService.getBooks(genre, available, author);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
