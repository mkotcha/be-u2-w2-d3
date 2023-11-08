package org.emmek.beu2w2d3.repositories;

import org.emmek.beu2w2d3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByEmail(String email);
    
}
