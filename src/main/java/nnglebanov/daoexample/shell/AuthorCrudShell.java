package nnglebanov.daoexample.shell;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.repositories.AuthorRepository;
import nnglebanov.daoexample.services.IOService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCrudShell {
    @NonNull
    private final AuthorRepository authorRepositoryJpa;
    @NonNull
    private final IOService ioService;

    @ShellMethod("insert author")
    public String authorInsert() {
        Author newAuthor = new Author();
        newAuthor.setFirstName(ioService.readLineWithMessage("input first name of new Author:"));
        newAuthor.setLastName(ioService.readLineWithMessage("input last name of new Author"));
        authorRepositoryJpa.save(newAuthor);
        return "new Author correctly added";
    }

    @ShellMethod("update author")
    public String authorUpdate() {
        Author newAuthor = new Author();
        newAuthor.setId(ioService.readIntWithMessage("input id of Author which you want to update"));
        newAuthor.setFirstName(ioService.readLineWithMessage("input first name of new Author:"));
        newAuthor.setLastName(ioService.readLineWithMessage("input last name of new Author"));
        authorRepositoryJpa.save(newAuthor);
        return newAuthor.toString();
    }

    @ShellMethod("get author by id")
    public String authorGet() {
        return authorRepositoryJpa.findById(ioService.readIntWithMessage("input id of Author")).toString();
    }

    @ShellMethod("get all authors")
    public String authorGetAll() {
        return authorRepositoryJpa.findAll().stream().map(Author::toString).collect(Collectors.joining("/n"));
    }

    @ShellMethod("delete Author by id")
    public String authorDelete() {
        authorRepositoryJpa.deleteById(ioService.readIntWithMessage("input id of Author you want to delete"));
        return "author succesfully deleted";
    }
}
