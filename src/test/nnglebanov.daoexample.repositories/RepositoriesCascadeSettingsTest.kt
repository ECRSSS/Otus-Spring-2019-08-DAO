package nnglebanov.daoexample.repositories

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.jdbc.Sql

@DisplayName("Тестирование интеграции репозиториев")
@DataJpaTest
@Sql(scripts = ["classpath:test-data.sql"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RepositoriesCascadeSettingsTest {

    @Autowired
    internal var authorRepository: AuthorRepository? = null
    @Autowired
    internal var bookRepository: BookRepository? = null
    @Autowired
    internal var genreRepository: GenreRepository? = null
    @Autowired
    internal var commentRepository: CommentRepository? = null

    @Autowired
    internal var em: TestEntityManager? = null

    @Test
    fun deleteBookTest() {
        assertThat(authorRepository!!.findAll().size).isEqualTo(3)
        assertThat(bookRepository!!.findAll().size).isEqualTo(3)
        assertThat(genreRepository!!.findAll().size).isEqualTo(3)
        bookRepository!!.deleteById(1)
        assertThat(bookRepository!!.findAll().size).isEqualTo(2)
        assertThat(commentRepository!!.findAll().size).isEqualTo(0)
        assertThat(genreRepository!!.findAll().size).isEqualTo(3)
        assertThat(authorRepository!!.findAll().size).isEqualTo(3)
    }

    @Test
    fun deleteAuthorTest() {
        assertThat(authorRepository!!.findAll().size).isEqualTo(3)
        assertThat(bookRepository!!.findAll().size).isEqualTo(3)
        assertThat(genreRepository!!.findAll().size).isEqualTo(3)
        authorRepository!!.deleteById(1)
        assertThat(authorRepository!!.findAll().size).isEqualTo(2)
        assertThat(bookRepository!!.findAll().size).isEqualTo(1)
        assertThat(genreRepository!!.findAll().size).isEqualTo(3)
        assertThat(commentRepository!!.findAll().size).isEqualTo(0)
    }

    @Test
    fun deleteGenreTest() {
        assertThat(authorRepository!!.findAll().size).isEqualTo(3)
        assertThat(bookRepository!!.findAll().size).isEqualTo(3)
        assertThat(genreRepository!!.findAll().size).isEqualTo(3)
        genreRepository!!.deleteById(1)
        assertThat(genreRepository!!.findAll().size).isEqualTo(2)
        assertThat(authorRepository!!.findAll().size).isEqualTo(3)
        assertThat(bookRepository!!.findAll().size).isEqualTo(3)
    }

}
