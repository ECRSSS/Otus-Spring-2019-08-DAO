package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepositoryJpa {

    int count();

    Genre save(Genre genre);

    void deleteById(int id);

    Optional<Genre> findById(int id);

    List<Genre> findAll();


}
