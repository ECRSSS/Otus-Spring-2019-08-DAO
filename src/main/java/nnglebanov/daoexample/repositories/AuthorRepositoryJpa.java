package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepositoryJpa {

    Author save(Author author);

    void deleteById(int id);

    Optional<Author> findById(int id);

    List<Author> findAll();


}
