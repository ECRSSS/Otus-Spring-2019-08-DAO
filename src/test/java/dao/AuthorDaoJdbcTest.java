package dao;

import nnglebanov.daoexample.dao.jdbc.AuthorDaoJdbc;
import nnglebanov.daoexample.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(AuthorDaoJdbc.class)
@DisplayName("DAO для работы с автором")
public class AuthorDaoJdbcTest {
    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    @Test void selectOne(){
        assertThat(authorDaoJdbc.findById(1)).isEqualTo(new Author(1,"author","one"));
    }

    @Test void createNew(){
        Author newAuthor = new Author("author","two");
        authorDaoJdbc.insert(newAuthor);
        assertThat(authorDaoJdbc.findById(2)).isEqualTo(newAuthor);
    }

}
