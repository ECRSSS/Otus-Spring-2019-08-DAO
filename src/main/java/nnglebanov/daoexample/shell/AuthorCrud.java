package nnglebanov.daoexample.shell;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.dao.jdbc.AuthorDaoJdbc;
import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.services.IOService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCrud {
    @NonNull
    private final AuthorDaoJdbc authorDaoJdbc;
    @NonNull
    private final IOService ioService;

    @ShellMethod("count of authors")
    public String authorCount() {
        return String.valueOf(authorDaoJdbc.count());
    }

    @ShellMethod("insert author")
    public String authorInsert() {
        Author newAuthor = new Author(
                ioService.readLineWithMessage("input first name of new Author:"),
                ioService.readLineWithMessage("input last name of new Author"));
        authorDaoJdbc.insert(newAuthor);
        return "new Author correctly added";
    }

    @ShellMethod("update author")
    public String authorUpdate() {
        Author newAuthor = new Author(
                ioService.readIntWithMessage("input id of Author which you want to update"),
                ioService.readLineWithMessage("input first name of new Author:"),
                ioService.readLineWithMessage("input last name of new Author"));
        authorDaoJdbc.update(newAuthor);
        return newAuthor.toString();
    }

    @ShellMethod("get author by id")
    public String authorGet(){
        return authorDaoJdbc.findById(ioService.readIntWithMessage("input id of Author")).toString();
    }

    @ShellMethod("get all authors by id")
    public String authorGetAll(){
        return authorDaoJdbc.findAll().stream().map(Author::toString).collect(Collectors.joining("/n"));
    }

    @ShellMethod("delete Author by id")
    public String authorDelete(){
        authorDaoJdbc.deleteById(ioService.readIntWithMessage("input id of Author you want to delete"));
        return "author succesfully deleted";
    }
}
