package nnglebanov.daoexample.repositories;

import lombok.val;
import nnglebanov.daoexample.domain.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий Comment")
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CommentRepositoryTest {

    @Autowired
    CommentRepository repository;

    @Autowired
    TestEntityManager em;

    @Test
    void returnAllCommentsTest() {
        val comments = repository.findAll();
        assertThat(comments.size()).isEqualTo(3);
    }

    @Test
    void returnOneGenreTest() {
        val comment = repository.findById(1).get();
        assertThat(repository.findById(1).get().getCommentText()).isEqualTo("comment1");
    }

    @Test
    void deleteOneCommentTest() {
        repository.deleteById(1);
        val comment = repository.findById(1);
        assertThat(comment).isEqualTo(Optional.empty());
    }

    @Test
    void saveGenreTest() {
        val comment = new Comment();
        comment.setCommentText("comment4");
        repository.save(comment);
        val savedComment = repository.findAll().stream()
                .filter(x -> x.getCommentText()
                        .equals("comment4")).findFirst().get();
        assertThat(savedComment).isNotEqualTo(null);
    }


}
