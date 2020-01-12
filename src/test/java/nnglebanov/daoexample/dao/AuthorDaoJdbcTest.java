package nnglebanov.daoexample.dao;

import nnglebanov.daoexample.dao.jdbc.AuthorDaoJdbc;
import nnglebanov.daoexample.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(AuthorDaoJdbc.class)
@DisplayName("DAO для работы с автором")
public class AuthorDaoJdbcTest {
    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    @Test
    void selectOne() {
        authorDaoJdbc.findAll().stream().forEach(x -> System.out.println(x));
        assertThat(authorDaoJdbc.findById(1)).isEqualTo(new Author(1, "author", "one"));
    }


    @Test
    void findAll() {
        List<Author> authors = Arrays.asList(
                new Author(1, "author", "one"),
                new Author(2, "author", "two"),
                new Author(3,"author","three")
        );
        authors.stream().filter(x->x.getId()!=1).forEach(x->authorDaoJdbc.insert(x));
        assertThat(authorDaoJdbc.findAll()).isEqualTo(authors);
    }

    @Test void delete(){
        authorDaoJdbc.deleteById(1);
        assertThat(authorDaoJdbc.findAll().size()).isEqualTo(0);
    }

    @Test void count(){
        assertThat(authorDaoJdbc.count()).isEqualTo(1);
    }



}
