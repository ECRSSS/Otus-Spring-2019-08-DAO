package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
