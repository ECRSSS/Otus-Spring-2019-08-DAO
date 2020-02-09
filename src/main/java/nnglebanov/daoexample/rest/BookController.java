package nnglebanov.daoexample.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.repositories.BookRepository;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookController {
    @NonNull
    private final BookRepository bookRepository;


}
