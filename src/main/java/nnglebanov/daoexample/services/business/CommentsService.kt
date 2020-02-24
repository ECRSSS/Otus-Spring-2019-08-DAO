package nnglebanov.daoexample.services.business


import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.domain.Comment
import nnglebanov.daoexample.repositories.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import java.util.*

@Service
class CommentsService {
    private val bookRepository: BookRepository? = null

    @Transactional
    fun addCommentForBookById(id: String, commentMessage: String): Mono<Book> {
        return bookRepository!!.findById(id)
                .map {
                    addComment(it, Comment(it,commentMessage,Date()))
                }
                .publish { bookRepository.save(it) }
    }

    private fun addComment(book: Book, comment: Comment): Book {
        book.addComment(comment)
        return book
    }
}
