package com.library.library.Controllers;

import com.library.library.Model.Author;
import com.library.library.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @GetMapping("/hello")
    public String helloAuthor(){
        return "Hello Author";
    }

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return new ResponseEntity<>("Author created successfully ✅", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
        return new ResponseEntity<>("Author updated successfully ✅", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam("id") int id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author deleted successfully 🗑️", HttpStatus.OK);
    }
}
