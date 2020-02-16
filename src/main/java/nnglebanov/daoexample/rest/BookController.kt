package nnglebanov.daoexample.rest

import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.repositories.BookRepository
import nnglebanov.daoexample.rest.dto.AuthorDto
import nnglebanov.daoexample.rest.dto.BookDto
import org.springframework.web.bind.annotation.*


@RestController
class BookController(private val bookRepository: BookRepository) {


    @GetMapping("/api/books")
    fun getAllBooks(): List<BookDto> {
        return bookRepository.findAll().map { book -> BookDto.toDto(book) }.toList()
    }

    @PostMapping("/api/books")
    fun newBook(@RequestBody newBook: BookDto): Book {
        return bookRepository.save(BookDto.toEntity(newBook))
    }

    @PutMapping("/api/books/{id}")
    fun editBook(@RequestBody bookToEdit: BookDto, @PathVariable id: String?): Book? {
        return bookRepository.save(bookRepository.findById(id).get().also {
            it.bookTitle = bookToEdit.bookTitle
            it.authors = bookToEdit.authors?.map { authorDto -> AuthorDto.toEntity(authorDto) }?.toMutableList()
        })
    }

    @DeleteMapping("/api/books/{id}")
    fun deleteBook(@PathVariable id: String?) {
        bookRepository.deleteById(id!!)
    }

}