package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepositoryJpa {

    Comment save(Comment comment);

    void deleteById(int id);

    Optional<Comment> findById(int id);

    List<Comment> findAll();


}
