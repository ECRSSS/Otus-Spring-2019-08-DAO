package nnglebanov.daoexample.shell;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.repositories.AuthorRepositoryJpa;
import nnglebanov.daoexample.services.IOService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCrudShell {
    @NonNull
    private final AuthorRepositoryJpa authorRepositoryJpa;
    @NonNull
    private final IOService ioService;

    @ShellMethod("count of authors")
    public String authorCount() {
        return null;//String.valueOf(authorDaoJdbc.count());
    }

    @ShellMethod("insert author")
    public String authorInsert() {
      /*  Author newAuthor = new Author(
                ioService.readLineWithMessage("input first name of new Author:"),
                ioService.readLineWithMessage("input last name of new Author"));
        authorDaoJdbc.insert(newAuthor);
        return "new Author correctly added";*/
      return null;
    }

    @ShellMethod("update author")
    public String authorUpdate() {
        /*Author newAuthor = new Author(
                ioService.readIntWithMessage("input id of Author which you want to update"),
                ioService.readLineWithMessage("input first name of new Author:"),
                ioService.readLineWithMessage("input last name of new Author"));
        authorDaoJdbc.update(newAuthor);
        return newAuthor.toString();*/
        return null;
    }

    @ShellMethod("get author by id")
    public String authorGet(){
        return null;//authorDaoJdbc.findById(ioService.readIntWithMessage("input id of Author")).toString();
    }

    @ShellMethod("get all authors")
    public String authorGetAll(){
        return authorRepositoryJpa.findAll().stream().map(Author::toString).collect(Collectors.joining("/n"));
    }

    @ShellMethod("delete Author by id")
    public String authorDelete(){
        //authorDaoJdbc.deleteById(ioService.readIntWithMessage("input id of Author you want to delete"));
        return "author succesfully deleted";
    }
}
