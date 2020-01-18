package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.repositories.impl.AuthorRepositoryJpaImpl;
import nnglebanov.daoexample.repositories.impl.BookRepositoryJpaImpl;
import nnglebanov.daoexample.repositories.impl.GenreRepositoryJpaImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование интеграции репозиториев")
@DataJpaTest
@Import({GenreRepositoryJpaImpl.class, BookRepositoryJpaImpl.class, AuthorRepositoryJpaImpl.class})
@Sql(scripts = {"classpath:test-data.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RepositoriesCascadeSettingsTest {

    @Autowired
    AuthorRepositoryJpaImpl authorRepository;
    @Autowired
    BookRepositoryJpaImpl bookRepository;
    @Autowired
    GenreRepositoryJpaImpl genreRepository;

    @Autowired
    TestEntityManager em;

    @Test
    public void deleteBookTest() {
        assertThat(authorRepository.findAll().size()).isEqualTo(3);
        assertThat(bookRepository.findAll().size()).isEqualTo(3);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
        bookRepository.deleteById(1);
        assertThat(bookRepository.findAll().size()).isEqualTo(2);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
        assertThat(authorRepository.findAll().size()).isEqualTo(3);
    }

    @Test
    public void deleteAuthorTest() {
        assertThat(authorRepository.findAll().size()).isEqualTo(3);
        assertThat(bookRepository.findAll().size()).isEqualTo(3);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
        authorRepository.deleteById(1);
        assertThat(authorRepository.findAll().size()).isEqualTo(2);
        assertThat(bookRepository.findAll().size()).isEqualTo(3);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
    }

    @Test
    public void deleteGenreTest() {
        assertThat(authorRepository.findAll().size()).isEqualTo(3);
        assertThat(bookRepository.findAll().size()).isEqualTo(3);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
        genreRepository.deleteById(1);
        assertThat(genreRepository.findAll().size()).isEqualTo(2);
        assertThat(authorRepository.findAll().size()).isEqualTo(3);
        assertThat(bookRepository.findAll().size()).isEqualTo(3);
    }

}
