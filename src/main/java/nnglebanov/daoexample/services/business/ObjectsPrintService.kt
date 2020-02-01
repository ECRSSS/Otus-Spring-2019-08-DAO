package nnglebanov.daoexample.services.business;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import nnglebanov.daoexample.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ObjectsPrintService {
    @NonNull
    private final BookRepository bookRepository;
    private final String DELIMITER = "-----------------";

    @Transactional
    public void outAllBooks() {
        System.out.println(DELIMITER);
        bookRepository.findAll().forEach(
                x -> System.out.println(
                        "Book number: " + x.getId() + "\n" +
                                "Book title: " + x.getBookTitle() + "\n" +
                                "Book authors: " + x.getAuthors().stream()
                                .map(y -> y.getFirstName() + " " + y.getLastName())
                                .collect(Collectors.joining(","))
                                + "\n" + DELIMITER
                )
        );
    }
}
