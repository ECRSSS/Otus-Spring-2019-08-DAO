package nnglebanov.daoexample.repositories;

import lombok.val;
import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.repositories.impl.AuthorRepositoryJpaImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий Authors")
@DataJpaTest
@Import({AuthorRepositoryJpaImpl.class})
@Sql(scripts = {"classpath:test-data.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepositoryJpaImpl repository;

    @Autowired
    TestEntityManager em;

    @DisplayName("Все авторы")
    @Test
    void returnAllAuthorsTest() {
        val authors = repository.findAll();
        assertThat(authors.size()).isEqualTo(3);
    }

    @DisplayName("Найти автора по id")
    @Test
    void returnOneAuthorTest() {
        val author = repository.findById(1).get();
        assertThat(author.getFirstName()).isEqualTo("author1");
        assertThat(author.getLastName()).isEqualTo("one");
        assertThat(author.getBooks().size()).isEqualTo(2);
    }

    @DisplayName("Удалить автора по id")
    @Test
    void deleteOneAuthorTest() {
        repository.deleteById(1);
        val author = repository.findById(1);
        assertThat(author).isEqualTo(Optional.empty());
    }

    @DisplayName("Сохранить нового автора по id")
    @Test
    void saveAuthorTest() {
        Author newAuthor = new Author();
        newAuthor.setFirstName("newAuthorFirst");
        newAuthor.setLastName("newAuthorLast");
        repository.save(newAuthor);
        Author savedAuthor = repository.findAll().stream()
                .filter(x -> x.getFirstName()
                        .equals("newAuthorFirst")).findFirst().get();
        assertThat(savedAuthor.getLastName()).isEqualTo(newAuthor.getLastName());
    }


}
