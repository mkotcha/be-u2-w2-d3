package org.emmek.beu2w2d3.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.emmek.beu2w2d3.entities.Author;
import org.emmek.beu2w2d3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @JsonFormat(pattern = "dd/MM/YYYY")
    public Author postAuthors(@RequestBody Author author) {
        return authorService.save(author);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Author getAuthorById(@PathVariable int id) {
        try {
            return authorService.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author author) {
        return authorService.findByIdAndUpdate(id, author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        authorService.findByIdAndDelete(id);
    }

}
