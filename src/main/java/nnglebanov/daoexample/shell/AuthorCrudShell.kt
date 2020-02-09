package nnglebanov.daoexample.shell

import nnglebanov.daoexample.domain.Author
import nnglebanov.daoexample.repositories.AuthorRepository
import nnglebanov.daoexample.services.IOService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class AuthorCrudShell(
        private val authorRepositoryJpa: AuthorRepository?,
        private val ioService: IOService?
) {

    @ShellMethod("insert author")
    fun authorInsert(): String {
        authorRepositoryJpa!!.save(Author(
                firstName = ioService!!.readLineWithMessage("input first name of new Author:"),
                lastName = ioService.readLineWithMessage("input last name of new Author")
        ))
        return "new Author correctly added"
    }

    @ShellMethod("update author")
    fun authorUpdate(): String {
        return authorRepositoryJpa?.save(Author(
                firstName = ioService?.readLineWithMessage("input first name of new Author:"),
                lastName = ioService?.readLineWithMessage("input last name of new Author")
        )).toString()
    }

    @ShellMethod("get author by id")
    fun authorGet(): String {
        return authorRepositoryJpa!!.findById(ioService!!.readIntWithMessage("input id of Author")!!).toString()
    }

    @ShellMethod("get all authors")
    fun authorGetAll(): String? {
        return authorRepositoryJpa?.findAll()?.joinToString(",", transform = Author::toString)
    }

    @ShellMethod("delete Author by id")
    fun authorDelete(): String {
        authorRepositoryJpa!!.deleteById(ioService!!.readIntWithMessage("input id of Author you want to delete")!!)
        return "author succesfully deleted"
    }
}
