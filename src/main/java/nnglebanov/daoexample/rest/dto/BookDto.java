package nnglebanov.daoexample.rest.dto;

import lombok.Data;
import nnglebanov.daoexample.domain.Book;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BookDto {
    private Integer id;
    private String bookTitle;
    private List<AuthorDto> authors;


    public static BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookTitle(book.getBookTitle());
        bookDto.setAuthors(
                book.getAuthors().stream()
                        .map(AuthorDto::toDto)
                        .collect(Collectors.toList())
        );
        return bookDto;
    }

    public static Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setBookTitle(bookDto.getBookTitle());
        book.setAuthors(bookDto.getAuthors().stream().map(AuthorDto::toEntity).collect(Collectors.toList()));
        return book;
    }
}
