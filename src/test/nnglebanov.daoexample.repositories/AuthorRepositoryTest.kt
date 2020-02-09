package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Author
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.jdbc.Sql
import java.util.*

@DisplayName("Репозиторий Authors")
@DataJpaTest
@Sql(scripts = ["classpath:test-data.sql"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AuthorRepositoryTest(

) {

    @Autowired
    internal var repository: AuthorRepository? = null

    @Autowired
    internal var em: TestEntityManager? = null

    @DisplayName("Все авторы")
    @Test
    internal fun returnAllAuthorsTest() {
        val authors = repository!!.findAll()
        assertThat(authors.size).isEqualTo(3)
    }

    @DisplayName("Найти автора по id")
    @Test
    internal fun returnOneAuthorTest() {
        val author = repository!!.findById(1).get()
        assertThat(author.firstName).isEqualTo("author1")
        assertThat(author.lastName).isEqualTo("one")
        assertThat(author.books!!.size).isEqualTo(2)
    }

    @DisplayName("Удалить автора по id")
    @Test
    internal fun deleteOneAuthorTest() {
        repository!!.deleteById(1)
        val author = repository!!.findById(1)
        assertThat(author).isEqualTo(Optional.empty<Any>())
    }

    @DisplayName("Сохранить нового автора по id")
    @Test
    internal fun saveAuthorTest() {
        val newAuthor = Author(firstName = "newAuthorFirst", lastName = "newAuthorLast")
        repository!!.save(newAuthor)
        val savedAuthor = repository!!.findAll().stream()
                .filter { x -> x.firstName == "newAuthorFirst" }.findFirst().get()
        assertThat(savedAuthor.lastName).isEqualTo(newAuthor.lastName)
    }


}
