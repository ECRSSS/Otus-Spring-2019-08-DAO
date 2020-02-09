package nnglebanov.daoexample.services.business

import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.domain.Comment
import nnglebanov.daoexample.repositories.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentsService(
        private val bookRepository: BookRepository?
) {

    @Transactional
    fun addCommentForBookById(id: Int, commentMessage: String): Book? {
        val optionalBook = bookRepository!!.findById(id)
        return if (optionalBook.isPresent) {
            val book = optionalBook.get()
            book.addComment(Comment(book = book, commentText = commentMessage))
            book
        } else {
            null
        }
    }
}
