package nnglebanov.daoexample.dao.genre;

import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.domain.Genre;

import java.util.List;

public interface GenreDao {

    int count();

    void insert(Genre genre);

    void update(Genre genre);

    void deleteById(int id);

    Author findById(int id);

    List<Genre> findAll();


}
