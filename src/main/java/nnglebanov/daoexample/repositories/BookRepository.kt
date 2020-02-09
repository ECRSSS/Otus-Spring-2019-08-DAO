package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

@Transactional
interface BookRepository : JpaRepository<Book, Int> {
    @Query("select b from Book b join b.comments c where c.commentText like %:comment%")
    fun selectBooksWhithCommentLike(@Param("comment") comment: String): List<Book>
}
