package nnglebanov.daoexample.dao;

import nnglebanov.daoexample.domain.Genre;

import java.util.List;

public interface GenreDao {

    int count();

    void insert(Genre genre);

    void update(Genre genre);

    void deleteById(int id);

    Genre findById(int id);

    List<Genre> findAll();


}
