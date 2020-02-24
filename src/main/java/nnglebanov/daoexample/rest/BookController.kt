package nnglebanov.daoexample.rest

import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.repositories.BookRepository
import nnglebanov.daoexample.rest.dto.AuthorDto
import nnglebanov.daoexample.rest.dto.BookDto
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@CrossOrigin
@RestController
class BookController(private val bookRepository: BookRepository) {


    @GetMapping("/api/books")
    fun getAllBooks(): Flux<BookDto> = bookRepository.findAll().map { book -> BookDto.toDto(book) }

    @PostMapping("/api/books")
    fun newBook(@RequestBody newBook: Mono<BookDto>): Mono<Book> = bookRepository.save(newBook.map { x -> BookDto.toEntity(x) })

    @PutMapping("/api/books/{id}")
    fun editBook(@RequestBody bookToEdit: Mono<BookDto>, @PathVariable id: String): Mono<Book> {
        return bookRepository.findById(id).transform {
            Mono.zip(bookToEdit, it, this::setNewBookTitleAndAuthorsToBook)
        }.publish { bookRepository.save(it) }
    }

    private fun setNewBookTitleAndAuthorsToBook(book: BookDto, oldBook: Book): Book {
        return oldBook.also {
            it.bookTitle = book.bookTitle
            it.authors = book.authors?.map { authorDto -> AuthorDto.toEntity(authorDto) }?.toMutableList()
        }
    }

    @DeleteMapping("/api/books/{id}")
    fun deleteBook(@PathVariable id: String?): Mono<Void> = bookRepository.deleteById(id!!)

}