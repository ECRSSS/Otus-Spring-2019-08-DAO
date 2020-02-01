package nnglebanov.daoexample.shell

import org.h2.tools.Console
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

import java.sql.SQLException

@ShellComponent
class ToolsCommandsShell {

    @ShellMethod("Open h2 console")
    @Throws(SQLException::class)
    fun console(): String {
        Console.main()
        return "console opened"
    }
}
