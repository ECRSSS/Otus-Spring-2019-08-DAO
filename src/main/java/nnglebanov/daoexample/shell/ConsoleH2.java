package nnglebanov.daoexample.shell;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.dao.author.AuthorDaoJdbc;
import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.SQLException;

@ShellComponent
@RequiredArgsConstructor
public class ConsoleH2 {
    @NonNull
    private final AuthorDaoJdbc authorDaoJdbc;

    @ShellMethod("Open h2 console")
    public String console() throws SQLException {
        Console.main();
        return "console opened";
    }
    @ShellMethod("count of authors")
    public String count(){
        return String.valueOf(authorDaoJdbc.count());
    }
}
