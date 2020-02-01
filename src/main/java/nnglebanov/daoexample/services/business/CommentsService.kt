package nnglebanov.daoexample.services.business


import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.domain.Comment
import nnglebanov.daoexample.repositories.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CommentsService {
    private val bookRepository: BookRepository? = null

    @Transactional
    fun addCommentForBookById(id: String, commentMessage: String): Book? {
        val optionalBook = bookRepository!!.findById(id)
        return if (optionalBook.isPresent()) {
            val book = optionalBook.get()
            val comment = Comment(
                    book,
                    commentMessage,
                    Date()
            )
            book.addComment(comment)
            book
        } else {
            null
        }
    }
}
