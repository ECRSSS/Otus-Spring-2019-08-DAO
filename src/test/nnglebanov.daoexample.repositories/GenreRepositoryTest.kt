package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Genre
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.jdbc.Sql
import java.util.*

@DisplayName("Репозиторий Genre")
@DataJpaTest
@Sql(scripts = ["classpath:test-data.sql"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GenreRepositoryTest {

    @Autowired
    internal var repository: GenreRepository? = null

    @Autowired
    internal var em: TestEntityManager? = null

    @Test
    internal fun returnAllGenresTest() {
        val genres = repository!!.findAll()
        assertThat(genres.size).isEqualTo(3)
    }

    @Test
    internal fun returnOneGenreTest() {
        val author = repository!!.findById(1).get()
        assertThat(author.genreName).isEqualTo("romantical")
    }

    @Test
    internal fun deleteOneAuthorTest() {
        repository!!.deleteById(1)
        val genre = repository!!.findById(1)
        assertThat(genre).isEqualTo(Optional.empty<Any>())
    }

    @Test
    internal fun saveGenreTest() {
        val genre = Genre(genreName = "newGenre")
        genre.genreName = "newGenre"
        repository!!.save(genre)
        val savedGenre = repository!!.findAll().stream()
                .filter { x -> x.genreName == "newGenre" }.findFirst().get()
        assertThat(savedGenre).isNotEqualTo(null)
    }


}
