package nnglebanov.daoexample.repositories;

import lombok.val;
import nnglebanov.daoexample.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Репозиторий Books")
@DataJpaTest
@Sql(scripts = {"classpath:test-data.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryTest {

    @Autowired
    BookRepository repository;

    @Autowired
    TestEntityManager em;

    @DisplayName("Все книги")
    @Test
    void returnAllAuthorsTest() {
        val books = repository.findAll();
        assertThat(books.size()).isEqualTo(3);
    }

    @DisplayName("Найти книгу по id")
    @Test
    void returnOneAuthorTest() {
        val book = repository.findById(1).get();
        assertThat(book.getBookTitle()).isEqualTo("book-1");
    }

    @DisplayName("Удалить книгу по id")
    @Test
    void deleteOneAuthorTest() {
        repository.deleteById(1);
        val book = repository.findById(1);
        assertThat(book).isEqualTo(Optional.empty());
    }

    @DisplayName("Сохранить новую книгу")
    @Test
    void saveAuthorTest() {
        Book newBook = new Book();
        newBook.setBookTitle("newBookTitle");
        repository.save(newBook);
        Book savedBook = repository.findAll().stream()
                .filter(x -> x.getBookTitle()
                        .equals("newBookTitle")).findFirst().get();
        assertNotNull(savedBook);
    }

    @Test
    void selectByComment() {
        assertThat(repository.selectBooksWhithCommentLike("1").size())
                .isEqualTo(1);
    }


}
