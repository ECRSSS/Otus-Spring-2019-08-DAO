package nnglebanov.daoexample.rest.dto

import nnglebanov.daoexample.domain.Book
import java.util.*

class BookDto(var id: String? = null,
              var bookTitle: String? = null,
              var authors: List<AuthorDto>? = null) {


    companion object {


        fun toDto(book: Book): BookDto {
            return BookDto().apply {
                id = book.id
                bookTitle = book.bookTitle
                authors = book.authors?.map { author -> AuthorDto.toDto(author) }?.toList() ?: listOf()
            }
        }

        fun toEntity(bookDto: BookDto): Book {
            return Book(
                    bookTitle = bookDto.bookTitle,
                    authors = bookDto.authors?.map { authorDto -> AuthorDto.toEntity(authorDto) }?.toMutableList(),
                    genres = mutableListOf(),
                    comments = mutableListOf(),
                    dateTime = Date()
            )

        }
    }
}