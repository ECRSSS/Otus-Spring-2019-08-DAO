package nnglebanov.daoexample.dao.book;

import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    void update(Book book);

    void deleteById(int id);

    Author findById(int id);

    List<Book> findAll();


}
