package nnglebanov.daoexample.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.domain.Book;
import nnglebanov.daoexample.repositories.BookRepository;
import nnglebanov.daoexample.rest.dto.AuthorDto;
import nnglebanov.daoexample.rest.dto.BookDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BookController {

    @NonNull
    private final BookRepository bookRepository;

    @GetMapping("/api/books")
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(BookDto::toDto).collect(Collectors.toList());
    }

    @PostMapping("/api/books")
    public Book newBook(@RequestBody BookDto newBook) {
        return bookRepository.save(BookDto.toEntity(newBook));
    }

    @PutMapping("/api/books/{id}")
    public Book editBook(@RequestBody BookDto bookToEdit, @PathVariable Integer id) {
        return bookRepository.findById(id).map(book -> {
            book.setBookTitle(bookToEdit.getBookTitle());
            book.setAuthors(bookToEdit.getAuthors().stream().map(AuthorDto::toEntity).collect(Collectors.toList()));
            return bookRepository.save(book);
        }).orElseGet(()-> bookRepository.save(BookDto.toEntity(bookToEdit)));
    }

    @Transactional
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Integer id){
        System.out.println(id);
        bookRepository.deleteById(id);
    }

}
