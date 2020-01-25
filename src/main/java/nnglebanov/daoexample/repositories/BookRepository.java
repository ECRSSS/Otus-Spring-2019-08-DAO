package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b join b.comments c where c.commentText like %:comment%")
    List<Book> selectBooksWhithCommentLike(@Param("comment") String comment);
}
