package org.emmek.beu2w2d3.repositories;

import org.emmek.beu2w2d3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
