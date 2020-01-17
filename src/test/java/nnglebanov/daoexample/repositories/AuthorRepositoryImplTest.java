package nnglebanov.daoexample.repositories;

import lombok.val;
import nnglebanov.daoexample.repositories.impl.AuthorRepositoryJpaImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@DisplayName("Репозиторий Authors")
@DataJpaTest
@Import({AuthorRepositoryJpaImpl.class})
@Sql(scripts = {"classpath:schema.sql","classpath:test-data.sql"})
public class AuthorRepositoryImplTest {

    @Autowired
    AuthorRepositoryJpaImpl repository;

    @Autowired
    TestEntityManager em;

    @DisplayName(" должен получать автора по заданному id из базы данных")
    @Test
    void shouldReturnAuthorById() {
        val actualAuthor = repository.findAll();
        System.out.println(actualAuthor);
    }

}
