package org.emmek.beu2w2d3.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.emmek.beu2w2d3.entities.Author;
import org.emmek.beu2w2d3.exceptions.NotFoundException;
import org.emmek.beu2w2d3.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @JsonFormat(pattern = "dd/MM/YYYY")

    public Author save(Author author) {
        authorRepository.save(author);
        return author;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author findById(int id) throws NotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        authorRepository.deleteById(id);
    }

    public Author findByIdAndUpdate(int id, Author author) throws NotFoundException {
        Author a = authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setEmail(author.getEmail());
        a.setBirthDate(author.getBirthDate());
        a.setAvatar(author.getAvatar());
        authorRepository.save(a);
        return a;
    }


}
