package nnglebanov.daoexample.services.business;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import nnglebanov.daoexample.repositories.BookRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ObjectsPrintService {
    @NonNull
    private final BookRepositoryJpa bookRepositoryJpa;
    private final String DELIMITER = "-----------------";

    public void outAllBooks() {
        System.out.println(DELIMITER);
        bookRepositoryJpa.findAll().forEach(
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
