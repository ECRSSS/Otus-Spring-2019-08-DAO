package nnglebanov.daoexample.dao;

import nnglebanov.daoexample.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    void update(Book book);

    void deleteById(int id);

    Book findById(int id);

    List<Book> findAll();


}
