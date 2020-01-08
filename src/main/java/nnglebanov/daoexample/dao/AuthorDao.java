package nnglebanov.daoexample.dao;

import nnglebanov.daoexample.domain.Author;

import java.util.List;

public interface AuthorDao {

    int count();

    void insert(Author author);

    void update(Author author);

    void deleteById(int id);

    Author findById(int id);

    List<Author> findAll();


}
