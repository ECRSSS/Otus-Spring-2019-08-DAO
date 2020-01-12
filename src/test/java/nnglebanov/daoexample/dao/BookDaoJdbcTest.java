package nnglebanov.daoexample.dao;

import nnglebanov.daoexample.dao.jdbc.AuthorDaoJdbc;
import nnglebanov.daoexample.dao.jdbc.BookDaoJdbc;
import nnglebanov.daoexample.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({BookDaoJdbc.class,AuthorDaoJdbc.class})
@DisplayName("DAO для работы с книгой")
public class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    @Test
    void selectOne() {
        assertThat(bookDaoJdbc.findById(1)).isEqualTo(new Book(1, "book-1", 1,1));
    }

    @Test
    void createNew() {
        Book newBook = new Book(3, "boook", 1,1);
        bookDaoJdbc.insert(newBook);
        assertThat(bookDaoJdbc.findById(3)).isEqualTo(newBook);
    }

    @Test void delete(){
        bookDaoJdbc.deleteById(1);
        assertThat(bookDaoJdbc.findAll().size()).isEqualTo(0);
    }



}
