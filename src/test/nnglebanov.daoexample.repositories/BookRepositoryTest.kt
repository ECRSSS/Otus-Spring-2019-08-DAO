package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Book
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.jdbc.Sql
import java.util.*

@DisplayName("Репозиторий Books")
@DataJpaTest
@Sql(scripts = ["classpath:test-data.sql"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BookRepositoryTest {

    @Autowired
    internal var repository: BookRepository? = null

    @Autowired
    internal var em: TestEntityManager? = null

    @DisplayName("Все книги")
    @Test
    internal fun returnAllAuthorsTest() {
        val books = repository!!.findAll()
        assertThat(books.size).isEqualTo(3)
    }

    @DisplayName("Найти книгу по id")
    @Test
    internal fun returnOneAuthorTest() {
        val book = repository!!.findById(1).get()
        assertThat(book.bookTitle).isEqualTo("book-1")
    }

    @DisplayName("Удалить книгу по id")
    @Test
    internal fun deleteOneAuthorTest() {
        repository!!.deleteById(1)
        val book = repository!!.findById(1)
        assertThat(book).isEqualTo(Optional.empty<Any>())
    }

    @DisplayName("Сохранить новую книгу")
    @Test
    internal fun saveAuthorTest() {
        val newBook = Book(bookTitle = "newBookTitle")
        repository!!.save(newBook)
        val savedBook = repository!!.findAll().stream()
                .filter { x -> x.bookTitle == "newBookTitle" }.findFirst().get()
        assertNotNull(savedBook)
    }

    @Test
    internal fun selectByComment() {
        assertThat(repository!!.selectBooksWhithCommentLike("1").size)
                .isEqualTo(1)
    }


}
