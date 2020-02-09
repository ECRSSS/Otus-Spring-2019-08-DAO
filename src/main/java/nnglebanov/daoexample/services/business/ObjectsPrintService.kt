package nnglebanov.daoexample.services.business

import nnglebanov.daoexample.repositories.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ObjectsPrintService(
        private val bookRepository: BookRepository?
) {
    private val DELIMITER = "-----------------"

    @Transactional
    fun outAllBooks() {
        println(DELIMITER)
        bookRepository!!.findAll().forEach { x ->
            println(
                    "Book number: " + x.id + "\n" +
                            "Book title: " + x.bookTitle + "\n" +
                            "Book authors: " + x.authors!!
                            .map { y -> y.firstName + " " + y.lastName }
                            .joinToString(",")
                            + "\n" + DELIMITER
            )
        }
    }
}
