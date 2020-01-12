package nnglebanov.daoexample.shell;

import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.SQLException;

@ShellComponent
public class ToolsCommands {

    @ShellMethod("Open h2 console")
    public String console() throws SQLException {
        Console.main();
        return "console opened";
    }
}
