package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Author
import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.domain.Comment
import nnglebanov.daoexample.domain.Genre
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertNotNull
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import java.util.*

@DisplayName("Репозиторий Books")
@DataMongoTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BookRepositoryTest {

    @Autowired
    internal var repository: BookRepository? = null


    @DisplayName("Все книги")
    @Test
    internal fun returnAllAuthorsTest() {
        val books = repository!!.findAll()
        assertThat(books.size).isEqualTo(3)
    }

    @DisplayName("Найти книгу по id")
    @Test
    internal fun returnOneAuthorTest() {
        val book = repository!!.findAll().get(0)
        assertThat(book.bookTitle).isEqualTo("book-1")
    }

    @DisplayName("Удалить книгу по id")
    @Test
    internal fun deleteOneAuthorTest() {
        val book = repository?.findAll()?.get(0)
        repository!!.deleteById(book?.id)
        assertThat(book).isEqualTo(null)
    }

    @DisplayName("Сохранить новую книгу")
    @Test
    internal fun saveAuthorTest() {
        val newBook = Book(
                bookTitle = "newBookTitle",
                authors = mutableListOf(Author("PAVLIC","PETROV",books = null, dateTime = Date())),
                comments = mutableListOf(Comment(null,"message",Date())),
                genres = mutableListOf(Genre("nauka",null,Date())),
                dateTime = Date()
        )
        repository!!.save(newBook)
        val savedBook = repository!!.findAll().stream()
                .filter({ x ->
                    x.bookTitle.equals("newBookTitle")
                }).findFirst().get()
        assertNotNull(savedBook)
    }



}
