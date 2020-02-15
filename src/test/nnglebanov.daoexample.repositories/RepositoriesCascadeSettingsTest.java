package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование интеграции репозиториев")
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RepositoriesCascadeSettingsTest {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TestEntityManager em;

    @Test
    public void saveBook(){
        authorRepository.findById(1);
        genreRepository.findById(1);
        Book newBook = new Book();
        newBook.setBookTitle("newBookTitle");
        newBook.setAuthors(authorRepository.findAll());
        newBook.setGenres(genreRepository.findAll());
        bookRepository.save(newBook);
    }

    @Test
    public void deleteBookTest() {
        assertThat(authorRepository.findAll().size()).isEqualTo(3);
        assertThat(bookRepository.findAll().size()).isEqualTo(3);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
        bookRepository.deleteById(1);
        assertThat(bookRepository.findAll().size()).isEqualTo(2);
        assertThat(commentRepository.findAll().size()).isEqualTo(0);
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
        assertThat(bookRepository.findAll().size()).isEqualTo(1);
        assertThat(genreRepository.findAll().size()).isEqualTo(3);
        assertThat(commentRepository.findAll().size()).isEqualTo(0);
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
