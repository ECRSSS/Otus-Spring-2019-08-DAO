package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Comment
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.jdbc.Sql
import java.util.*

@DisplayName("Репозиторий Comment")
@DataJpaTest
@Sql(scripts = ["classpath:test-data.sql"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CommentRepositoryTest {

    @Autowired
    var commentRepository: CommentRepository? = null

    @Autowired
    var bookRepository: BookRepository? = null

    @Autowired
    internal var em: TestEntityManager? = null

    @Test
    internal fun returnAllCommentsTest() {
        val comments = commentRepository!!.findAll()
        assertThat(comments.size).isEqualTo(3)
    }

    @Test
    internal fun returnOneGenreTest() {
        val comment = commentRepository!!.findById(1).get()
        assertThat(commentRepository!!.findById(1).get().commentText).isEqualTo("comment1")
    }

    @Test
    internal fun deleteOneCommentTest() {
        commentRepository!!.deleteById(1)
        val comment = commentRepository!!.findById(1)
        assertThat(comment).isEqualTo(Optional.empty<Any>())
    }

    @Test
    internal fun saveGenreTest() {
        val comment = Comment(book = bookRepository?.findById(1)?.get(), commentText = "comment4")
        commentRepository!!.save(comment)
        val savedComment = commentRepository!!.findAll().stream()
                .filter { x -> x.commentText == "comment4" }.findFirst().get()
        assertThat(savedComment).isNotEqualTo(null)
    }


}
