package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJpa {

    int count();

    Book save(Book book);

    void deleteById(int id);

    Optional<Book> findById(int id);

    List<Book> findAll();


}
