package nnglebanov.daoexample.services.business

import nnglebanov.daoexample.repositories.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.stream.Collectors

@Service
class ObjectsPrintService(val bookRepository: BookRepository) {

    private val DELIMITER = "-----------------"
    @Transactional
    fun outAllBooks() {
        println(DELIMITER)
        bookRepository.findAll().subscribe {
            println("Book number: " + it.id + "\n" +
                    "Book title: " + it.bookTitle + "\n" +
                    "Book authors: " + it.authors?.stream()
                    ?.map { y -> y.firstName + " " + y.lastName }
                    ?.collect(Collectors.joining(","))
            + "\n" + DELIMITER)
        }
    }
}
