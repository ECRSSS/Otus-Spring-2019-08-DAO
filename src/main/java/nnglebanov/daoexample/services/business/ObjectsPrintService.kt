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
        bookRepository!!.findAll().forEach { x ->
            System.out.println(
                    "Book number: " + x.id + "\n" +
                            "Book title: " + x.bookTitle + "\n" +
                            "Book authors: " + x.authors?.stream()
                            ?.map({ y -> y.firstName + " " + y.lastName })
                            ?.collect(Collectors.joining(","))
                            + "\n" + DELIMITER
            )
        }
    }
}
