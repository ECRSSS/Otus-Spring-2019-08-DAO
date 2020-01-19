package nnglebanov.daoexample.repositories;

import lombok.val;
import nnglebanov.daoexample.domain.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий Genre")
@DataJpaTest
@Sql(scripts = {"classpath:test-data.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GenreRepositoryTest {

    @Autowired
    GenreRepository repository;

    @Autowired
    TestEntityManager em;

    @Test
    void returnAllGenresTest() {
        val genres = repository.findAll();
        assertThat(genres.size()).isEqualTo(3);
    }

    @Test
    void returnOneGenreTest() {
        val author = repository.findById(1).get();
        assertThat(author.getGenreName()).isEqualTo("romantical");
    }

    @Test
    void deleteOneAuthorTest() {
        repository.deleteById(1);
        val genre = repository.findById(1);
        assertThat(genre).isEqualTo(Optional.empty());
    }

    @Test
    void saveGenreTest() {
        val genre = new Genre();
        genre.setGenreName("newGenre");
        repository.save(genre);
        val savedGenre = repository.findAll().stream()
                .filter(x -> x.getGenreName()
                        .equals("newGenre")).findFirst().get();
        assertThat(savedGenre).isNotEqualTo(null);
    }


}
