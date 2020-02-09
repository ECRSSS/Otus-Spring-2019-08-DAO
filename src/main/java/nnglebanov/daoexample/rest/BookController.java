package nnglebanov.daoexample.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.repositories.BookRepository;
import nnglebanov.daoexample.rest.dto.BookDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BookController {
    @NonNull
    private final BookRepository bookRepository;

    @GetMapping("/api/books")
    public List<BookDto> getAllBooks(){
        return bookRepository.findAll().stream().map(BookDto::toDto).collect(Collectors.toList());
    }


}
